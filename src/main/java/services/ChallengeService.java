package services;

import entities.Challenge;
import entities.Tag;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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

    //TODO sollten wir hier ausschließen, dass ein User eine Challenge ein zweites mal bekommt?
    //gets three challenges for daily
    public List<Challenge> getDaily(List<Tag> tags) {
        List<Challenge> personalChallenges = getChallengesByTags(tags);
        Collections.shuffle(personalChallenges);
        return personalChallenges.stream().limit(3).collect(Collectors.toList());
    }

    public Challenge createChallenge(String title,
                                     String description,
                                     List<Tag> tags,
                                     int sportScore,
                                     int nutritionScore,
                                     int mentalScore) {
        //TODO validierung der parameter
        Challenge c = new Challenge(title, description, tags, sportScore, nutritionScore, mentalScore);
        em.merge(c);
        return c;
    }

    public Challenge createChallenge(Challenge challenge) {
        em.merge(challenge);
        return challenge;
    }

}
