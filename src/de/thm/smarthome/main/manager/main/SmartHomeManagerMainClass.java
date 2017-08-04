package de.thm.smarthome.main.manager.main;

import de.thm.smarthome.global.connection.wsprovider.SmartHomeManagerWebServiceProvider;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.metadata.MetaDataManager;
import de.thm.smarthome.main.manager.controller.devicemanager.DeviceManager;
import de.thm.smarthome.main.manager.controller.eventmanager.EventManager;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartHomeManagerMainClass {
    private static SmartHomeManagerWebServiceProvider webServiceProvider;

    public static void main(String args[]) throws InterruptedException
    {
        MetaDataManager.useOntology = false;
        startSmartHomeServer();

        while(true){
            Thread.sleep(1000);
        }
    }

    public static void startSmartHomeServer(){
        try
        {
            DeviceManager.getInstance().attach(EventManager.getInstance());

            SmartHomeLogger.log("Hello World! I am a SmartHomeManager :)");

            webServiceProvider = new SmartHomeManagerWebServiceProvider();
            webServiceProvider.startProviding();

            MetaDataManager.setSuffixREST("ws");

            SmartHomeLogger.log("WebServices are up an running..");

            MetaDataManager.setHostStatus("Gestartet");

            SmartHomeLogger.log(MetaDataManager.getHostInfo());
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
        }
    }

    public static void stopSmartHomeServer(){
        if(webServiceProvider != null) {
            try
            {
                SmartHomeLogger.log("Bye, bye, World!");

                webServiceProvider.stopProviding();

                SmartHomeLogger.log("WebServices are stopped and down..");

                MetaDataManager.setHostStatus("Gestoppt");

                SmartHomeLogger.log(MetaDataManager.getHostInfo());
            }
            catch (Exception e)
            {
                SmartHomeLogger.log(e);
            }
        }
    }
}
