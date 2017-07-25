package de.thm.smarthome.global.connection.wsprovider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jakub Podlesak (jakub.podlesak at oracle.com)
 */
@Path("ws")
public class HelloWorldResource {

    @GET @Path( "info/karleparameter/{karleparameter}" ) @Produces( MediaType.TEXT_PLAIN )
    public String getHello(@PathParam( "karleparameter" ) String karleparameter) {
        return "Hello World, " + karleparameter;
    }

}
