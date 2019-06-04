package controller;

import entities.Challenge;
import services.ChallengeService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/challenge")
public class ChallengeController {

    @Inject
    ChallengeService challengeService;

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getChallenges() {
        return challengeService.getChallenges();
    }

    @Path("/id/{id}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Challenge getChallengesById(@PathParam("id") int id) {
        return challengeService.getChallengesById(id);
    }

    @Path("/tag")
    @POST
    @Produces({"application/json"})
    public List<Challenge> getChallengsByTags(@FormParam("tags") List<String> tagNames) {
        return challengeService.getChallengesByTags(tagNames);
    }

    @Path("/daily")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getDaily() {
        return challengeService.getDaily();
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