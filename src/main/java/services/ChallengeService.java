package services;

import entities.Challenge;
import entities.Tag;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service zum anlegen und abfragen von Challenges
 */
@RequestScoped
public class ChallengeService {

    @PersistenceContext
    EntityManager em;

    /**
     *
     * @return alle Challenges
     */

    public List<Challenge> getChallenges() {
        Query query = em.createNamedQuery("findAllChallenges");
        return query.getResultList();
    }


    /**
     *
     * @param id
     * @return Challenge mit der id
     */
    public Challenge getChallengesById(int id) {
        return em.find(Challenge.class, id);
    }

    /**
     *
     * @param tags
     * @return Challenges mit dem tag
     */
    public List<Challenge> getChallengesByTags(List<Tag> tags) {
        List<Challenge> challenges = getChallenges();
        List<Challenge> fittingChallenges = new ArrayList<>();
        if (tags.size() == 0) return challenges;
        for (Challenge c : challenges) {
            if (c.getTags().containsAll(tags)) {
                fittingChallenges.add(c);
            }
        }
        return fittingChallenges;
    }

    /**
     *
     * @param tags
     * @return drei Challenges die diesen Tag haben für die tägliche Herausforderung
     */
    public List<Challenge> getDaily(List<Tag> tags) {
        List<Challenge> personalChallenges = getChallengesByTags(tags);
        Collections.shuffle(personalChallenges);
        return personalChallenges.stream().limit(3).collect(Collectors.toList());
    }

    /**
     * Challenge anlegen
     * @param title
     * @param description
     * @param tags
     * @param sportScore
     * @param nutritionScore
     * @param mentalScore
     * @return angelegt Challenge
     */

    public Challenge createChallenge(String title,
                                     String description,
                                     List<Tag> tags,
                                     int sportScore,
                                     int nutritionScore,
                                     int mentalScore) {
        Challenge c = new Challenge(title, description, tags, sportScore, nutritionScore, mentalScore);
        em.merge(c);
        return c;
    }

    /**
     *
     * @param challenge
     * @return angelegte challenge
     */

    public Challenge createChallenge(Challenge challenge) {
        em.merge(challenge);
        return challenge;
    }

}
