package services;

import entities.Task;
import entities.Venturer;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Set;

@RequestScoped
public class VenturerService {

    @PersistenceContext
    EntityManager em;

    public Venturer getVenturer(int id) {
        return em.find(Venturer.class, id);
    }

    public List<Venturer> getVenturers() {
        Query query = em.createNamedQuery("findAllVenturers");
        return query.getResultList();
    }

    public Set<Task> getTasks(int id){
        Venturer v = em.find(Venturer.class, id);
        return v.getTasks();
    }


}
