package services;

import entities.User;
import entities.Venturer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@RequestScoped
public class LoginService {

    @Inject
    JWTService jwtService;

    @Inject
    VenturerService venturerService;

    public Response login(User login) {

        Venturer vent = venturerService.getVenturer(login.getUsername());

        if (vent.checkPW(login.getPassword())) {
            return Response.status(200).entity(jwtService.generateJWTToken(login.getUsername())).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}

