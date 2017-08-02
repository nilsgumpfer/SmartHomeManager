package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IThermometerLogic
{
    MeasureBean getTemperature();
    ModelVariantBean getModelVariant();
    ManufacturerBean getManufacturer();
    ActionModeBean getActionMode();
    String getGenericName();
    String getSerialnumber();
    ThermometerTransferObject getThermometerData();

    IThermometerModel getModel();
    IThermometer getAdapter();

    void attach(Object observer);
}
