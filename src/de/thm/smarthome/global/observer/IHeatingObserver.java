package de.thm.smarthome.global.observer;

import de.thm.smarthome.global.transfer.HeatingTransferObject;

/**
 * Created by Nils on 21.04.2017.
 */
public interface IHeatingObserver {
    void updateMeWithNewHeatingData(HeatingTransferObject heatingTransferObject);
}
