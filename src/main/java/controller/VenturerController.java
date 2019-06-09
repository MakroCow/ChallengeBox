package controller;

import entities.Challenge;
import entities.Tag;
import entities.Task;
import entities.Venturer;
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

    @Path("/all")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Venturer> findAllVenturer() {
        return ventService.getVenturers();
    }

    @Path("/{id}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Venturer findAllVenturer(@PathParam("id") int id) {
        return ventService.getVenturer(id);
    }

    @Path("/{id}/tasks")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Task> getVenturersTasks(@PathParam("id") int id ) {
        return ventService.getTasks(id);
    }

}
