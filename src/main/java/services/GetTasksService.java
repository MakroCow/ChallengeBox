package services;

import entities.Challenge;
import entities.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("/task")
public class GetTasksService {

    @PersistenceContext
    EntityManager em;

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTasks(@PathParam("id") int id) {
        return em.find(Task.class, id);
    }


    //TODO Auch den User in den Task einspeichern
    @Path("/createTask")
    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Task createTask(@FormParam("challenge_id") int challengeId
                           //@FormParam("user_id")int userId
                            ){
        Task t = new Task();
        t.accepted = new Date();
        // t.user = ...
        return t;
    }


    //TODO umschreiben, sodass nur tasks eines users zurückkommen.
    // alle unten aufgeführten Endpoints sollten nur die Tasks eines Users ausgeben. Es gibt aber noch keine Usertabelle, daher später...
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getChallenges() {
        Query query = em.createNamedQuery("findAllTasks");
        return query.getResultList();
    }

    @Path("/allDone")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getDoneChallenges() {
        Query query = em.createNamedQuery("findDoneTasks");
        return query.getResultList();
    }

    @Path("/allFailed")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getOpenChallenges() {
        Query query = em.createNamedQuery("findOpenTasks");
        return query.getResultList();
    }

    @Path("/allTerminated")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getTerminatedTasks() {
        Query query = em.createNamedQuery("findTerminatedTasks");
        return query.getResultList();
    }
}
