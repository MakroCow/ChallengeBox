package controller;

import entities.User;
import entities.Venturer;
import security.JWTAuthed;
import services.JWTService;

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
    JWTService jwtService;


    /**
     *
     * @param login
     * @return gültigen jwt
     * bei falschen credentials wird der HTTP Code unauthorized zurückgegeben
     */

    @POST
    @Consumes("application/json")
    public Response login(User login) {
        if (login.getUsername().equals("hans@wurst.de") && login.getPassword().equals("secret")) {
            return Response.status(200).entity(jwtService.generateJWTToken(login.getUsername())).build();
        } else {
            if (login.getUsername().equals("m.muster@frau.de") && login.getPassword().equals("musterpasswort")) {
                return Response.status(200).entity(jwtService.generateJWTToken(login.getUsername())).build();
            } else {

                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        }
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
