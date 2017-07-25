package de.thm.smarthome.main.manager.main;

import de.thm.smarthome.global.connection.wsprovider.SmartHomeManagerWebServiceProvider;
import de.thm.smarthome.global.logging.SmartHomeLogger;

import java.io.IOException;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartHomeManagerMainClass {
    public static void main(String args[]) throws InterruptedException {
        SmartHomeLogger.log("Hello World! I´m a SmartHomeManager :)");

        SmartHomeManagerWebServiceProvider wsProvider = new SmartHomeManagerWebServiceProvider();
        try {
            wsProvider.startProviding();
        } catch (IOException e) {
            SmartHomeLogger.log(e);
        }

        SmartHomeLogger.log("WebServices are up an running..");

        while(true){
            Thread.sleep(1000);
        }
    }

    public void initSmartHomeManager(){}
}
