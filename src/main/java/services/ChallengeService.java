package services;

import entities.Challenge;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("challenge")
public class ChallengeService {

    @PersistenceContext
    EntityManager em;

    @Path("/all")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getAllChallenges() {
        Query query = em.createNamedQuery("findAllChallenges");
        return query.getResultList();
    }

}
