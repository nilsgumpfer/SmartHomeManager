package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.helper.TransferObjectFactory;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

import java.rmi.RemoteException;

/**
 * Created by Nils on 30.01.2017.
 */
public class HeatingLogicMaintenanceMode implements IHeatingLogic
{
    private IHeatingModel model;
    private IHeating device;

    @Override
    public MeasureBean getCurrentTemperature() {
        return model.getCurrentTemperature();
    }

    @Override
    public MeasureBean getDesiredTemperature() {
        return model.getDesiredTemperature();
    }

    @Override
    public ModelVariantBean getModelVariant() {
        return model.getModelVariant();
    }

    @Override
    public ManufacturerBean getManufacturer() {
        return model.getManufacturer();
    }

    @Override
    public PowerStateBean getPowerState() {
        return model.getPowerState();
    }

    @Override
    public MessageBean setDesiredTemperature(MeasureBean temperature) {
        return device.setDesiredTemperature(temperature);
    }

    @Override
    public MessageBean setPowerState(PowerStateBean powerState) {
        return device.setPowerState(powerState);
    }

    @Override
    public HeatingTransferObject getHeatingData() {
        return TransferObjectFactory.getHeatingTransferObject(model);
    }
}
