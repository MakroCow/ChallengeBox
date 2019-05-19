package services;

import entities.Challenge;
import entities.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Path("/challenge")
public class ChallengeService {

    @PersistenceContext
    EntityManager em;

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getChallenges() {
        Query query = em.createNamedQuery("findAllChallenges");
        return query.getResultList();
    }

    @Path("/id/{id}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Challenge getChallengesById(@PathParam("id") int id) {
        return em.find(Challenge.class, id);
    }

    /**
     * Returns all Challenges, that satisfy all of the chosen tags
     */
    //TODO geht das auch einfacher? Brauch mal hilfe
    //TODO Funktioniert nicht, wenn der Client die Informationen nicht mit UTF-8 versendet! In Postman beim Testen den Header Content-Type auf application/x-www-form-urlencoded;charset=UTF-8 setzen!
    @Path("/tag")
    @POST
    @Produces({"application/json"})
    public List<Challenge> getChallengesByTags(@FormParam("tags") List<String> tagNames) {
        System.out.println(tagNames);
        List<Challenge> challenges = new ArrayList<>();
        List<Challenge> allChallenges = getChallenges();
        for (Challenge c : allChallenges) {
            List<String> challengeTags = c.getTags().stream().map(Tag::getTagName).collect(Collectors.toCollection(ArrayList::new));
            boolean missing = false;
            for (int i = 0; i < tagNames.size() && !missing; i++) {
                if (!challengeTags.contains(tagNames.get(i))) {
                    missing = true;
                }
            }
//            for (String tagName : tagNames) {
//                if (!challengeTags.contains(tagName)) {
//                    missing = true;
//                }
//            }
            if (!missing) {
                challenges.add(c);
            }
        }
        return challenges;
    }

    //TODO sollten wir hier ausschließen, dass ein User eine Challenge ein zweites mal bekommt?
    //gets 3 challenges for daily
    @Path("/daily")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getDaily() {
        List<Challenge> personalChallenges = getChallengesByTags(new ArrayList<>(Arrays.asList("Sport", "Küche"))); //TODO hardcoded tags über post holen
        Collections.shuffle(personalChallenges);
        return personalChallenges.stream().limit(3).collect(Collectors.toList());
    }

}
