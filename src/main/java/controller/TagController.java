package controller;

import entities.Challenge;
import entities.Tag;
import security.JWTAuthed;
import services.TagService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Controller der die REST APIs zum abfragen und anlegen von Tags implemntiert
 */

@JWTAuthed
@Path("/tag")
public class TagController {

    @Inject
    TagService tagService;


    /**
     *
     * @return alle Tags
     */
    @Path("/all")
    @GET
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tag> findAllTags() {
        return tagService.findAllTags();
    }


    /**
     *
     * @param id
     * @return Tag mit der id
     */
    @Path("/id/{id}")
    @GET
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tag findTagByID(@PathParam("id") int id) {
        return tagService.findTagByID(id);
    }


    /**
     *
     * @param tagName
     * @return tag mit dem Namen
     */
    @Path("/name/{tagName}")
    @GET
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tag findTagByName(@PathParam("tagName") String tagName) {
        return tagService.findTagByName(tagName);
    }

    /**
     *
     * @param tagName
     * @return angelegten tag
     */
    @Path("/")
    @POST
    @Transactional
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Tag createTag(@FormParam("tagName") String tagName) {
        return tagService.createTag(tagName);

    }


}
