package controller;

import entities.User;
import entities.Venturer;
import security.JWTAuthed;
import services.JWTService;
import services.LoginService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public class LoginController {

    @Inject
    LoginService ls;

    @Path("/")
    @POST
    @Consumes("application/json")
    public Response login(User login) {
       return ls.login(login);
    }

    @Path("/authenticate")
    @GET
    @JWTAuthed
    public void authenticate(){
        
    }

}
