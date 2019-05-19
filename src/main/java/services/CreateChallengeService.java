package services;

import entities.Challenge;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/challenge")
public class CreateChallengeService {

    @PersistenceContext
    EntityManager em;

    @Path("/add")
    @POST
    @Transactional
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Challenge createChallenge(@FormParam("title") String title,
                                     @FormParam("description") String description,
                                     @FormParam("sportScore") int sportScore,
                                     @FormParam("nutritionScore") int nutritionScore,
                                     @FormParam("mentalScore") int mentalScore) {
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