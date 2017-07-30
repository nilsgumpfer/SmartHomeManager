package de.thm.smarthome.main.manager.main;

import de.thm.smarthome.global.connection.wsprovider.SmartHomeManagerWebServiceProvider;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.metadata.MetaDataManager;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartHomeManagerMainClass {
    private static SmartHomeManagerWebServiceProvider webServiceProvider;

    public static void main(String args[]) throws InterruptedException {

        startSmartHomeServer();

        Thread.sleep(1000);

        stopSmartHomeServer();

        while(true){
            Thread.sleep(1000);
        }
    }

    public static void startSmartHomeServer(){
        try
        {
            SmartHomeLogger.log("Hello World! I am a SmartHomeManager :)");

            webServiceProvider = new SmartHomeManagerWebServiceProvider();
            webServiceProvider.startProviding();

            MetaDataManager.setSuffixREST("ws");

            SmartHomeLogger.log("WebServices are up an running..");
            //MetaDataManager.setHostStatus("Server is running in ws_provide mode");

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
                //MetaDataManager.setHostStatus("Server is running in idle mode");

                SmartHomeLogger.log(MetaDataManager.getHostInfo());
            }
            catch (Exception e)
            {
                SmartHomeLogger.log(e);
            }
        }

    }
}
