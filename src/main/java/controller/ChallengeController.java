package controller;

import entities.Challenge;
import entities.Tag;
import security.JWTAuthed;
import services.ChallengeService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@JWTAuthed
@Path("/challenge")
public class ChallengeController {

    @Inject
    ChallengeService challengeService;

    @Path("/all")
    @GET
    @Produces("application/json")
    public List<Challenge> getChallenges() {
        return challengeService.getChallenges();
    }

    @Path("/id/{id}")
    @GET
    @Transactional
    @Produces("application/json")
    public Challenge getChallengesById(@PathParam("id") int id) {
        return challengeService.getChallengesById(id);
    }

    @Path("/tag")
    @POST
    @Transactional
    @Consumes("application/json")
    @Produces({"application/json"})
    public List<Challenge> getChallengsByTags(List<Tag> tagNames) {
        return challengeService.getChallengesByTags(tagNames);
    }

    @Path("/daily")
    @POST
    @Transactional
    @Consumes("application/json")
    @Produces("application/json")
    public List<Challenge> getDaily(List<Tag> tags) {
        return challengeService.getDaily(tags);
    }

    @Path("/")
    @POST
    @Transactional
    @Consumes("application/json")
    @Produces("application/json")
    public Challenge createChallenge(Challenge challenge) {
        return challengeService.createChallenge(challenge);
    }
}
