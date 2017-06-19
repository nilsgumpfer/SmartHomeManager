package de.thm.smarthome.main.device.thermometer.adapter;

import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IThermometer
{
    ModelVariantBean getModelVariant();
    ManufacturerBean getManufacturer();
    MeasureBean getTemperature();
}
