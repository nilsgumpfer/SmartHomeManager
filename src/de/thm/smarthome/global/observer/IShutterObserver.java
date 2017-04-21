package de.thm.smarthome.global.observer;

import de.thm.smarthome.global.transfer.ShutterTransferObject;

/**
 * Created by Nils on 21.04.2017.
 */
public interface IShutterObserver {
    void updateMeWithNewShutterData(ShutterTransferObject shutterTransferObject);
}
