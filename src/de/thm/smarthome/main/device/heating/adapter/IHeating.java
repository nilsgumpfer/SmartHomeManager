package de.thm.smarthome.main.device.heating.adapter;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created on 27.01.2017.
 */
public interface IHeating  // So kann die Logik herstellerunabhängig implementiert werden, ohne auf deren Eigenschaften zu berücksichtigen.

    //Methoden im Adapter
        // werden ins Model übertragen
{
    MeasureBean getCurrentTemperature();
    MeasureBean getDesiredTemperature();
    ModelVariantBean getModelVariant();
    ManufacturerBean getManufacturer();
    PowerStateBean getPowerState();

    MessageBean setDesiredTemperature(MeasureBean temperature);
    MessageBean setPowerState(PowerStateBean powerState);
        //Observer anmelden
    void attach(Object observer);
}
