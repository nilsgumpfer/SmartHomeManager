package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

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

    void attach(Object observer);
    void detach(Object observer);
}
