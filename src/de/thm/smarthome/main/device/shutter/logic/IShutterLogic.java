package de.thm.smarthome.main.device.shutter.logic;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IShutterLogic
{
    //Setter-Methoden//
    MessageBean setDesiredPosition(PositionBean desiredPosition);

    //Getter-Methoden//
    PositionBean getCurrentPosition();
    PositionBean getDesiredPosition();
    ModelVariantBean getModelVariant();
    ManufacturerBean getManufacturer();
    ActionModeBean getActionMode();
    String getGenericName();
    String getSerialnumber();

    ShutterTransferObject getShutterData();
    IShutterModel getModel();
    IShutter getAdapter();
    void attach(Object observer);

}
