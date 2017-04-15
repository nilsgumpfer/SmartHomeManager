package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.enumeration.ResponseCode;

/**
 * Created by Nils on 05.02.2017.
 */
public class HeatingTransferObject {
    public HeatingTransferObject(ResponseCode code){

    }

    public HeatingTransferObject(double temperature){}

    public HeatingTransferObject(String name, double temperature) {
    }

    public double getTemperature() {
        return 0;
    }
}
