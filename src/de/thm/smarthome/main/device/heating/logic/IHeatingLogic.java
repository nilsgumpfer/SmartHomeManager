package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

import java.rmi.RemoteException;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IHeatingLogic {
    MeasureBean         getCurrentTemperature();
    MeasureBean         getDesiredTemperature();
    ModelVariantBean    getModelVariant();
    ManufacturerBean    getManufacturer();
    PowerStateBean      getPowerState();
    ActionModeBean      getActionMode();
    String              getGenericName();
    String              getSerialnumber();

    MessageBean setDesiredTemperature(MeasureBean temperature);
    MessageBean setPowerState(PowerStateBean powerState);

    HeatingTransferObject getHeatingData();

    IHeatingModel getModel();
    IHeating getAdapter();
}
