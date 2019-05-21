package services;

import entities.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tag")
public class TagService {

    @PersistenceContext
    private EntityManager em;

    @Path("/all")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tag> helloWorld1() {
        Query query = em.createNamedQuery("findAllTags");
        return (List<Tag>) query.getResultList();
    }

    @Path("/id/{id}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Tag helloWorld2(@PathParam("id") int id) {
        return em.find(Tag.class, id);
    }

    @Path("/name/{tagName}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Tag helloWorld2(@PathParam("tagName") String tagName) {
        Query query = em.createNamedQuery("findTagByTagName");
        query.setParameter("tagName", tagName);
        // return query.getResultList(); // Hier kommt immer eine Liste raus, die dann erst ausgepackt werden muss. Wie ist der richtige Ansatz?
        return (Tag) query.getSingleResult(); //Hier könnten auch mehrere Ergebnisse zurückkommen, sofern Datenbank nicht sauber ist und ich weiß nicht, wie ich das vernünftig abprüfen kann
    }

}
