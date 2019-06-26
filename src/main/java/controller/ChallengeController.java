package controller;

import entities.Challenge;
import entities.Tag;
import security.JWTAuthed;
import services.ChallengeService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

/**
 * Controller der die REST APIs zum abfragen und anlegen von Challenges implemntiert
 */

@JWTAuthed
@Path("/challenge")
public class ChallengeController {

    @Inject
    ChallengeService challengeService;

    /**
     *
     * @return alle Challenges
     */

    @Path("/all")
    @GET
    @Produces("application/json")
    public List<Challenge> getChallenges() {
        return challengeService.getChallenges();
    }

    /**
     *
     * @param id
     * @return Challenge mit der id
     */

    @Path("/id/{id}")
    @GET
    @Transactional
    @Produces("application/json")
    public Challenge getChallengesById(@PathParam("id") int id) {
        return challengeService.getChallengesById(id);
    }

    /**
     *
     * @param tagNames
     * @return Challenges mit diesem tag
     */

    @Path("/tag")
    @POST
    @Transactional
    @Consumes("application/json")
    @Produces({"application/json"})
    public List<Challenge> getChallengsByTags(List<Tag> tagNames) {
        return challengeService.getChallengesByTags(tagNames);
    }

    /**
     *
     * @param tags
     * @return drei Challenges passend zum Tag für die tägliche Herausforderung
     */

    @Path("/daily")
    @POST
    @Transactional
    @Consumes("application/json")
    @Produces("application/json")
    public List<Challenge> getDaily(List<Tag> tags) {
        return challengeService.getDaily(tags);
    }

    /**
     *
     * @param challenge
     * @return angelegte Challenge
     */
    @Path("/")
    @POST
    @Transactional
    @Consumes("application/json")
    @Produces("application/json")
    public Challenge createChallenge(Challenge challenge) {
        return challengeService.createChallenge(challenge);
    }
}
