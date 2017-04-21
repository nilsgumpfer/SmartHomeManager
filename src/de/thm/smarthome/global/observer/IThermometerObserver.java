package de.thm.smarthome.global.observer;

import de.thm.smarthome.global.transfer.ThermometerTransferObject;

/**
 * Created by Nils on 21.04.2017.
 */
public interface IThermometerObserver {
    void updateMeWithNewThermometerData(ThermometerTransferObject thermometerTransferObject);
}
