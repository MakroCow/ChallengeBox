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

public class TaskService {

    @PersistenceContext
    EntityManager em;

    public Task getTasks(int id) {
        return em.find(Task.class, id);
    }


    //TODO Auch den User in den Task einspeichern
    public Task createTask(int challengeId
                           //@FormParam("user_id")int userId
    ) {
        Task t = new Task();
        t.accepted = new Date();
        // t.user = ...
        return t;
    }


    //TODO umschreiben, sodass nur tasks eines users zurückkommen.
    // alle unten aufgeführten Endpoints sollten nur die Tasks eines Users ausgeben. Es gibt aber noch keine Usertabelle, daher später...
    public List<Challenge> getTasks() {
        Query query = em.createNamedQuery("findAllTasks");
        return query.getResultList();
    }

    public List<Challenge> getDoneTasks() {
        Query query = em.createNamedQuery("findDoneTasks");
        return query.getResultList();
    }

    public List<Challenge> getOpenTasks() {
        Query query = em.createNamedQuery("findOpenTasks");
        return query.getResultList();
    }

    public List<Challenge> getTerminatedTasks() {
        Query query = em.createNamedQuery("findTerminatedTasks");
        return query.getResultList();
    }
}
