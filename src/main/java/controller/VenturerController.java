package controller;

import entities.Challenge;
import entities.Tag;
import entities.Task;
import entities.Venturer;
import security.JWTAuthed;
import services.TagService;
import services.VenturerService;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;


@Path("/venturer")
public class VenturerController {

    @Inject
    VenturerService ventService;

    @JWTAuthed
    @Path("/all")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Venturer> findAllVenturer() {
        return ventService.getVenturers();
    }

    @JWTAuthed
    @Path("/{email}")
    @GET
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Venturer findVenturerByEMail(@PathParam("email") String email) {
        return ventService.getVenturer(email);
    }

    @JWTAuthed
    @Path("/{id}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Venturer findVenturerById(@PathParam("id") int id) {
        return ventService.getVenturer(id);
    }

    @JWTAuthed
    @Path("/{id}/tasks")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Task> getVenturersTasks(@PathParam("id") int id) {
        return ventService.getTasks(id);
    }

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
