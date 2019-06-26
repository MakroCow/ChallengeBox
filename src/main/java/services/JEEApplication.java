package services;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
/**
 * Application
 */

/**
 * Open API (früher swagger) Konfiguration
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Challenge Box",
                version = "1.0",
                description = "Challenge Box API",
                license = @License(name = "Apache 2.0", url = "http://localhost:8080/challengeBox"),
                contact = @Contact(name = "Chrocani", email = "beispielemail@beispiel.com")
        )
)
@ApplicationPath("api")
public class JEEApplication extends Application {

}