package services;

import entities.Icecream;

import javax.annotation.security.PermitAll;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("article")
@Singleton
public class icecreamTaster {

    @PersistenceContext
    private EntityManager em;

    @GET
    @PermitAll
    @Transactional
    @Path("all")
    public String getAllArticles() {
        System.out.println("HIERE I AM");
        Icecream ice = new Icecream();
        ice.setTaste("strawbelli");
        em.persist(ice);

        return "Hallo Welt";
    }
}


