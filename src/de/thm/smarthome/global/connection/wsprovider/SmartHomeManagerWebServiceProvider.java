package de.thm.smarthome.global.connection.wsprovider;

import de.thm.smarthome.global.logging.SmartHomeLogger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class SmartHomeManagerWebServiceProvider
{
    private HttpServer httpServer = null;


    public void initServer(){
        if(httpServer == null) {
            URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
            ResourceConfig config = new ResourceConfig(SmartHomeManagerWebServiceDescriptor.class);
            httpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
        }
    }


    public void startProviding(){
        initServer();

        try {
            httpServer.start();
        } catch (IOException e) {
            SmartHomeLogger.log(e);
        }
    }

    public void stopProviding(){
        httpServer.shutdownNow();
    }
}