package services;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title = "Challenge Box",
                version = "1.0",
                description = "Challenge Box API",
                license = @License(name = "Apache 2.0", url = "http://localhost:8080/challengeBox"),
                contact = @Contact(name = "Chrocani", email = "beispielemail@beispiel.com")
        ),
        security = {
                @SecurityRequirement(name = "req 1", scopes = {"a", "b"}),
                @SecurityRequirement(name = "req 2", scopes = {"b", "c"})
        }
)
@ApplicationPath("api")
public class JEEApplication extends Application {

}