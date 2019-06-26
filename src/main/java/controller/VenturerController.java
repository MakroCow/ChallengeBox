package controller;

import entities.Task;
import entities.Venturer;
import security.JWTAuthed;
import services.VenturerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;


/**
 * Controller der die REST APIs zum abfragen und anlegen von Venturern implementiert
 */
@Path("/venturer")
public class VenturerController {

    @Inject
    VenturerService ventService;

    /**
     *
     * @return alle Venturer
     */
    @JWTAuthed
    @Path("/all")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Venturer> findAllVenturer() {
        return ventService.getVenturers();
    }

    @JWTAuthed
    /**
     *
     * @param email
     * @return Venturer mit der E-Mail
     */
    @Path("/{email}")
    @GET
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Venturer findVenturerByEMail(@PathParam("email") String email) {
        return ventService.getVenturer(email);
    }

    @JWTAuthed
    /**
     *
     * @param id
     * @return Venturer mit der id
     */
    @Path("/{id}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Venturer findVenturerById(@PathParam("id") int id) {
        return ventService.getVenturer(id);
    }

    /**
     *
     * @param id
     * @return alle Tasks eines Ventures
     */
    @JWTAuthed
    @Path("/{id}/tasks")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Task> getVenturersTasks(@PathParam("id") int id) {
        return ventService.getTasks(id);
    }

    /**
     *
     * @param venturer_id
     * @return alle Venturer außer der mit dieser id
     */

    @JWTAuthed
    @Path("/otherFellows/{vent_id}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Venturer> getOtherVenturers(@PathParam("vent_id") int venturer_id) {
        return ventService.otherFellows(venturer_id);
    }

    @Path("/register")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerVenturer(Venturer vent) {
        ventService.register(vent);
    }

}
