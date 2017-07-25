package de.thm.smarthome.global.connection.wsprovider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jakub Podlesak (jakub.podlesak at oracle.com)
 */
@Path("helloworld")
public class HelloWorldResource {
    public static final String CLICHED_MESSAGE = "Hello World!";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return CLICHED_MESSAGE;
    }

}
