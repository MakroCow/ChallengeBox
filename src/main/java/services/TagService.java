package services;

import entities.Tag;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Service zum anlegen und abfragen von Tags
 */
@RequestScoped
public class TagService {

    @PersistenceContext
    private EntityManager em;

    /**
     *
     * @return alle tags
     */
    public List<Tag> findAllTags() {
        Query query = em.createNamedQuery("findAllTags");
        return (List<Tag>) query.getResultList();
    }

    /**
     *
     * @param id
     * @return Tag mit der id
     */
    public Tag findTagByID(int id) {
        return em.find(Tag.class, id);
    }

    /**
     *
     * @param tagName
     * @return Tag mit diesem Namen
     */
    public Tag findTagByName(String tagName) {
        Query query = em.createNamedQuery("findTagByTagName");
        query.setParameter("tagName", tagName);
        Tag tag;
        try {
            tag = (Tag) query.getSingleResult();
        } catch (NoResultException e) {
            tag = null;
        }
        return tag;
    }

    /**
     * Tag anlegen
     * @param tagName
     * @return angelegter Tag
     */
    public Tag createTag(String tagName) {
        return new Tag();
    }

}
