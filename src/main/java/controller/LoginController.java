package controller;

import entities.User;
import entities.Venturer;
import security.JWTAuthed;
import services.JWTService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public class LoginController {

    @Inject
    JWTService jwtService;


    @POST
    @Consumes("application/json")
    public Response login(User login) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXJo Das klappt");
        if (login.getUsername().equals("hans@wurst.de") && login.getPassword().equals("secret")) {
            System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYJo Das klappt");
            return Response.status(200).entity(jwtService.generateJWTToken(login.getUsername())).build();
        } else {
            if (login.getUsername().equals("m.muster@frau.de") && login.getPassword().equals("musterpasswort")) {
                System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYJo Das klappt");
                return Response.status(200).entity(jwtService.generateJWTToken(login.getUsername())).build();
            } else {

                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        }
    }

    @Path("/authenticate")
    @GET
    @JWTAuthed
    public void authenticate(){
        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
    }

}
