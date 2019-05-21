package controller;

import entities.Challenge;
import entities.Tag;
import services.TagService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tag")
public class TagController {

    @Inject
    TagService tagService;

    @Path("/all")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tag> findAllTags() {
        return tagService.findAllTags();
    }

    @Path("/id/{id}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Tag findTagByID(@PathParam("id") int id) {
        return tagService.findTagByID(id);
    }

    @Path("/name/{tagName}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Tag findTagByName(@PathParam("tagName") String tagName) {
        return tagService.findTagByName(tagName);
    }

    @Path("/")
    @POST
    @Transactional
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Tag createTag(@FormParam("tagName") String tagName) {
        return tagService.createTag(tagName);

    }


}
