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

public class TagService {

    @PersistenceContext
    private EntityManager em;

    public List<Tag> findAllTags() {
        Query query = em.createNamedQuery("findAllTags");
        return (List<Tag>) query.getResultList();
    }

    public Tag findTagByID(int id) {
        return em.find(Tag.class, id);
    }

    public Tag findTagByName(String tagName) {
        Query query = em.createNamedQuery("findTagByTagName");
        query.setParameter("tagName", tagName);
        // return query.getResultList(); // Hier kommt immer eine Liste raus, die dann erst ausgepackt werden muss. Wie ist der richtige Ansatz?
        return (Tag) query.getSingleResult(); //Hier könnten auch mehrere Ergebnisse zurückkommen, sofern Datenbank nicht sauber ist und ich weiß nicht, wie ich das vernünftig abprüfen kann
    }

    public Tag createTag(String tagName){
        return new Tag();
    }

}
