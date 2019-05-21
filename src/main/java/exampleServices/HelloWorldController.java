package exampleServices;

import entities.Challenge;
import entities.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/helloworld")
public class HelloWorldController {

    @PersistenceContext
    private EntityManager em;

    @Path("/1")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> helloWorld1() {
        Query query = em.createNamedQuery("findAllChallenges");
        List<Challenge> challenges = query.getResultList();
        return challenges;
    }

    @Path("/2/{id}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Challenge helloWorld2(@PathParam("id") int id) {
        Challenge c = em.find(Challenge.class, id);
        return c;
    }

    @Path("/fillWithExampleData")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> fillWithExampleData() {

        String[] challengetitels = {"Laufen", "Gehen", "Sprechen", "Schreien", "Kochen", "Kennenlernen"};
        String[] challgedescriptions = {"Gehe heute 10 Minuten länger laufen, als letztesmal", "Gehe nach dem Abendessen noch eine Runde und versuche dabei ein Tier zu sichten", "Sprich deinen Schwarm auf seine Frisur an - Sei es positiv oder negativ", "Kletter auf den höchsten Punkt im 2km Umkreis und schreie einen Tarzan Schrei", "Backe heute einen Kuchen mit mind. 2 grünen Zutaten", "Frag jemanden anch seiner Handynummer"};

        String[] tags = {"Kürzer als 10 min", "Benötigt Küche", "Dauer bis 1h", "Benötigt Computer", "Nicht krank"};
        List<Tag> tagArray = new ArrayList<>();

        for(String k: tags) {
            Tag tag = new Tag();
            tag.setTagName(k);
            em.persist(tag);
            tagArray.add(tag);
        }

        for (int i = 0; i < challengetitels.length; i++) {
            Challenge c = new Challenge();
            c.setTitle(challengetitels[i]);
            c.setDescription(challgedescriptions[i]);
            c.setTags(tagArray);
            c.setSportPoints(0);
            c.setNutritionPoints(0);
            c.setMentalPoints(0);
            System.out.println(c);
            em.persist(c);
        }

        Query query = em.createNamedQuery("findAllChallenges");
        List<Challenge> challenges = query.getResultList();
        //return challenges.stream().map(Challenge::toString).collect(Collectors.joining(", "));
        return challenges;
    }
}