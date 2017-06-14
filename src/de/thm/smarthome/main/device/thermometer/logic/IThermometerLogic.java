package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IThermometerLogic {
    public MeasureBean getTemperature();
    public ModelVariantBean getModelVariant();
    public ManufacturerBean getManufacturer();
    public String getGenericName();
    public String getSerialnumber();
    public ThermometerTransferObject getThermometerData();
    IThermometerModel getModel();
    IThermometer getAdapter();
}
