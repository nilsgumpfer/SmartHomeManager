package de.thm.smarthome.main.device.shutter.adapter;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 * Changed by Jenny on 28.07.2017.
 */
public interface IShutter {
    PositionBean getCurrentPosition();
    PositionBean getDesiredPosition();
    ModelVariantBean getModelVariant();

    /* PositionBean oder MessageBean?! Muss Message Bean sein, da es im Adapter so verarbeitet wird*/
    MessageBean setDesiredPosition(PositionBean desiredPosition);
    void attach(IObserver observer);

}
