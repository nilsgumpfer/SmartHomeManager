package de.thm.smarthome.main.device.shutter.adapter;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IShutter {
    MessageBean setDesiredPosition(PositionBean desiredPosition);

    PositionBean getCurrentPosition();
    PositionBean getDesiredPosition();
    ModelVariantBean getModelVariant();
}
