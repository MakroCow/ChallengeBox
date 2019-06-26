package controller;

import entities.User;
import security.JWTAuthed;
import services.JWTService;
import services.LoginService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Controller der die REST API für den Login implemntiert
 */

@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public class LoginController {


    @Inject
    LoginService loginService;


    /**
     *
     * @param login
     * @return gültigen jwt;
     * bei falschen credentials wird der HTTP Code unauthorized zurückgegeben
     */

    @Path("/")
    @POST
    @Consumes("application/json")
    public Response login(User login) {
        return loginService.login(login);
    }

    /**
     * testet ob der der aktuelle jwt gültig ist bzw. ein jwt vorliegt
     */

    @Path("/authenticate")
    @GET
    @JWTAuthed
    public void authenticate(){

    }

}
