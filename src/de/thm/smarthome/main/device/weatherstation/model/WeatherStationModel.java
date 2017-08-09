package de.thm.smarthome.main.device.weatherstation.model;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.weatherstation.adapter.IWeatherStation;

/**
 * Created by Nils on 27.01.2017.
 */
public class WeatherStationModel extends AObservable implements IWeatherStationModel, IObserver
{
    private MeasureBean         temperature;
    private MeasureBean         windVelocity;
    private MeasureBean         rainfallAmount;
    private MeasureBean         airPressure;
    private MeasureBean         airHumidity;
    private ModelVariantBean    modelVariant;
    private ManufacturerBean    manufacturer;
    private ActionModeBean      actionMode;
    private String              genericName;
    private String              serialnumber;
    IWeatherStation             device;

    public WeatherStationModel(ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber) {
        this.modelVariant   = modelVariant;
        this.manufacturer   = manufacturer;
        this.actionMode     = actionMode;
        this.genericName    = genericName;
        this.serialnumber   = serialnumber;
        temperature         = new MeasureBean(0.0, EUnitOfMeasurement.NA);
        windVelocity        = new MeasureBean(0.0, EUnitOfMeasurement.NA);
        rainfallAmount      = new MeasureBean(0.0, EUnitOfMeasurement.NA);
        airHumidity         = new MeasureBean(0.0, EUnitOfMeasurement.NA);
        airPressure         = new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public MeasureBean getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(MeasureBean temperature) {
        this.temperature = temperature;
    }

    @Override
    public MeasureBean getWindVelocity() {
        return windVelocity;
    }

    @Override
    public void setWindVelocity(MeasureBean windVelocity) {
        this.windVelocity = windVelocity;
    }

    @Override
    public MeasureBean getRainfallAmount() {
        return rainfallAmount;
    }

    @Override
    public void setRainfallAmount(MeasureBean rainfallAmount) {
        this.rainfallAmount = rainfallAmount;
    }

    @Override
    public MeasureBean getAirPressure() {
        return airPressure;
    }

    @Override
    public void setAirPressure(MeasureBean airPressure) {
        this.airPressure = airPressure;
    }

    @Override
    public MeasureBean getAirHumidity() {
        return airHumidity;
    }

    @Override
    public void setAirHumidity(MeasureBean airHumidity) {
        this.airHumidity = airHumidity;
    }

    @Override
    public ModelVariantBean getModelVariant() {
        return modelVariant;
    }

    @Override
    public void setModelVariant(ModelVariantBean modelVariant) {
        this.modelVariant = modelVariant;
    }

    @Override
    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(ManufacturerBean manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public ActionModeBean getActionMode() {
        return actionMode;
    }

    @Override
    public void setActionMode(ActionModeBean actionMode) {
        this.actionMode = actionMode;
    }

    @Override
    public String getGenericName() {
        return genericName;
    }

    @Override
    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    @Override
    public String getSerialnumber() {
        return serialnumber;
    }

    @Override
    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public void setDevice(IWeatherStation device) {
        this.device = device;
    }

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("WeatherStationModel: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);

        setTemperature(device.getTemperature());
        setAirHumidity(device.getAirHumidity());
        setAirPressure(device.getAirPressure());
        setRainfallAmount(device.getRainfallAmount());
        setWindVelocity(device.getWindVelocity());
    }
}
