package services;

import entities.Challenge;
import entities.Tag;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class ChallengeService {

    @PersistenceContext
    EntityManager em;

    public List<Challenge> getChallenges() {
        Query query = em.createNamedQuery("findAllChallenges");
        return query.getResultList();
    }

    public Challenge getChallengesById(int id) {
        return em.find(Challenge.class, id);
    }

    /**
     * Returns all Challenges, that satisfy all of the chosen tags
     */
    //TODO geht das auch einfacher? Brauch mal hilfe
    //TODO Funktioniert nicht, wenn der Client die Informationen nicht mit UTF-8 versendet! In Postman beim Testen den Header Content-Type auf application/x-www-form-urlencoded;charset=UTF-8 setzen!
    public List<Challenge> getChallengesByTags(List<String> tagNames) {
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
    public List<Challenge> getDaily() {
        List<Challenge> personalChallenges = getChallengesByTags(new ArrayList<>(Arrays.asList("Dauer bis 1h"))); //TODO hardcoded tags über post holen
        Collections.shuffle(personalChallenges);
        return personalChallenges.stream().limit(3).collect(Collectors.toList());
    }

    public Challenge createChallenge(String title,
                                     String description,
                                     int sportScore,
                                     int nutritionScore,
                                     int mentalScore) {
        //TODO validierung der parameter
        Challenge c = new Challenge();
        c.setTitle(title);
        c.setDescription(description);
        c.setMentalPoints(mentalScore);
        c.setNutritionPoints(nutritionScore);
        c.setSportPoints(sportScore);
        em.persist(c);
        return c;
    }

}
