package de.thm.smarthome.main.manager.main;

import de.thm.smarthome.global.connection.wsprovider.SmartHomeManagerWebServiceProvider;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartHomeManagerMainClass {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Hello World! I´m a SmartHomeManager :)");

        SmartHomeManagerWebServiceProvider wsProvider = new SmartHomeManagerWebServiceProvider();
        wsProvider.startProviding();

        System.out.println("WebServices are up an running..");

        while(true){
            Thread.sleep(1000);
        }
    }

    public void initSmartHomeManager(){}
}
