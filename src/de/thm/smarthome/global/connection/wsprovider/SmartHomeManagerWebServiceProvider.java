package de.thm.smarthome.global.connection.wsprovider;

import javax.xml.ws.Endpoint;

public class SmartHomeManagerWebServiceProvider
{
    private Endpoint endpoint;

    public void startProviding(){

        this.endpoint = Endpoint.publish( "http://localhost:8080/services", new SmartHomeManagerWebServiceDescriptor() );
    }

    public void stopProviding(){

        endpoint.stop();
    }
}