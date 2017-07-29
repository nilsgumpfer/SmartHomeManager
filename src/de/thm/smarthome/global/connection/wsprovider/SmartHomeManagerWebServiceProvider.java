/*package de.thm.smarthome.global.connection.wsprovider;

public class SmartHomeManagerWebServiceProvider
{
    private HttpServer httpServer = null;


    public void initServer(){

    }


    public HttpServer startProviding() throws IOException {
        // create a new server listening at port 8080
        final HttpServer server = HttpServer.create(new InetSocketAddress(getBaseURI().getPort()), 0);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                server.stop(0);
            }
        }));

        // create a handler wrapping the JAX-RS application
        HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new JaxRsApplication(), HttpHandler.class);

        // map JAX-RS handler to the server root
        server.createContext(getBaseURI().getPath(), handler);

        // start the server
        server.start();

        return server;
    }

    public void stopProviding(){

    }

    private static int getPort(int defaultPort) {
        final String port = System.getProperty("jersey.config.test.container.port");
        if (null != port) {
            try {
                return Integer.parseInt(port);
            } catch (NumberFormatException e) {
                System.out.println("Value of jersey.config.test.container.port property"
                        + " is not a valid positive integer [" + port + "]."
                        + " Reverting to default [" + defaultPort + "].");
            }
        }
        return defaultPort;
    }

    public static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(getPort(8080)).build();
    }*/

package de.thm.smarthome.global.connection.wsprovider;

import com.sun.net.httpserver.HttpServer;
import de.thm.smarthome.global.metadata.MetaDataManager;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class SmartHomeManagerWebServiceProvider
{
    private HttpServer httpServer = null;


    public void initServer(){
        if(httpServer == null) {
            String protocol = "http";
            String uri = protocol +  "://localhost/";
            int port = 8080;

            URI baseUri = UriBuilder.fromUri(uri).port(port).build();
            ResourceConfig config = new ResourceConfig();
            config.register(CORSResponseFilter.class);
            config.register(SmartHomeManagerWebServiceDescriptor.class);
            httpServer = JdkHttpServerFactory.createHttpServer(baseUri, config);

            MetaDataManager.setProtocolREST(protocol);
            MetaDataManager.setPortREST(String.valueOf(port));
        }
    }


    public void startProviding(){
        initServer();
    }

    public void stopProviding(){
        httpServer.stop(0);
        httpServer = null;

        MetaDataManager.setProtocolREST("N/A");
        MetaDataManager.setPortREST("N/A");
    }
}
