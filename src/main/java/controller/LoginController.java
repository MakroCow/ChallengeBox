package controller;

import entities.User;
import entities.Venturer;
import services.JWTService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
        if (login.getUsername().equals("demo") && login.getPassword().equals("secret")) {
            return Response.status(200).entity(jwtService.generateJWTToken(login.getUsername())).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}
