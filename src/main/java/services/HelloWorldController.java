package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/helloworld")
public class HelloWorldController {

    @GET
    public String helloWorld() {
        return "Hello World";
    }
}