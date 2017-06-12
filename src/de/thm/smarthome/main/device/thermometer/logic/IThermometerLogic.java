package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.global.transfer.ThermometerTransferObject;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IThermometerLogic {
    String getLogicName();
        //void setCurrentTemperature();
    ThermometerTransferObject getThermometerData();
}
