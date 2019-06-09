package exampleServices;

import entities.Challenge;
import entities.Tag;
import entities.Task;
import entities.Venturer;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import security.JWTAuthed;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import java.util.*;

@Path("/helloworld")
public class HelloWorldController {

    @PersistenceContext
    private EntityManager em;

    @Path("/test")
    @GET
    @JWTAuthed
    public String getHello() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXIch bin da");
        return "I'm loged in";
    }

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

        String[] tags = {"Kürzer als 10 min", "Essen (inkl. Küche)", "Outdoor","Indoor", "Sport", "Geistig anspruchsvoll"};
        List<Tag> tagArray = new ArrayList<>();

        for (String k : tags) {
            Tag tag = new Tag();
            tag.setTagName(k);
            em.persist(tag);
            tagArray.add(tag);
        }

        for (int i = 0; i < challengetitels.length; i++) {
            Challenge c = new Challenge(
                    challengetitels[i],
                    challgedescriptions[i],
                    tagArray,
                    new Random().nextInt(100),
                    new Random().nextInt(100),
                    new Random().nextInt(100));
            em.persist(c);
        }

        String[] venturerNames = {"Hans", "Brunhilde", "Maxi"};
        String[] venturerFirstNames = {"Wurst", "Blabla", "Musterfrau"};
        String[] venturerEmail = {"hans@wurst.de", "b.blabla@hallo.de", "m.muster@frau.de"};
        String[] venturerPasswort = {"Ichbintoll", "ichmagkekse", "Vegan4Life"};

        for (int i = 0; i < venturerNames.length; i++) {
            em.persist(new Venturer(venturerNames[i], venturerFirstNames[i], venturerEmail[i], venturerPasswort[i]));
        }

        Query query = em.createNamedQuery("findAllVenturers");
        List<Venturer> venturers = query.getResultList();

        Query query1 = em.createNamedQuery("findAllChallenges");
        List<Challenge> challenges = query1.getResultList();

        for (int i = 0; i < venturers.size(); i++) {
            Task t = new Task(challenges.get(i), venturers.get(i), new Date(), null, null, null);
            em.persist(t);
        }
        return challenges;
    }
}