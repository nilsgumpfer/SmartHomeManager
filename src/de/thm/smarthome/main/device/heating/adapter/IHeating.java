package de.thm.smarthome.main.device.heating.adapter;

//import de.thm.smarthome.main.device.heating.memento.HeatingMemento;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IHeating
{
    MeasureBean getCurrentTemperature();
    MeasureBean getDesiredTemperature();
    ModelVariantBean getModelVariant();
    ManufacturerBean getManufacturer();
    PowerStateBean getPowerState();

    MessageBean setDesiredTemperature(MeasureBean temperature);
    MessageBean setPowerState(PowerStateBean powerState);

    void attach(Object observer);
}
