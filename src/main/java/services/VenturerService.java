package services;

import entities.Task;
import entities.Venturer;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.QueryParam;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

@RequestScoped
public class VenturerService {

    @PersistenceContext
    EntityManager em;

    public Venturer getVenturer(int id) {
        return em.find(Venturer.class, id);
    }

    public Venturer getVenturer(String email) {
        Query query = em.createNamedQuery("findVenturerByEmail");
        String encodedMail = "";
        try{
            encodedMail = java.net.URLDecoder.decode(email, StandardCharsets.UTF_8.name());
        }catch (Exception e ){
            System.out.println(e);
        }
        query.setParameter("email", encodedMail);
        return (Venturer)query.getResultList().get(0);
    }

    public List<Venturer> getVenturers() {
        Query query = em.createNamedQuery("findAllVenturers");
        return query.getResultList();
    }

    public Set<Task> getTasks(int id){
        Venturer v = em.find(Venturer.class, id);
        return v.getTasks();
    }

    public List<Venturer> otherFellows(int venturer_id){
        Venturer this_venturer = em.find(Venturer.class, venturer_id);
        List<Venturer> otherVenturers = this.getVenturers();
        otherVenturers.remove(this_venturer);
        return otherVenturers;
    }
}