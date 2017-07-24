package de.thm.smarthome.main.device.heating.adapter;

//import de.thm.smarthome.main.device.heating.memento.HeatingMemento;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.transfer.HeatingTransferObject;

import java.rmi.RemoteException;
import java.util.List;

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

    void setDesiredTemperature(MeasureBean temperature);
    void setPowerState(PowerStateBean powerState);
}
