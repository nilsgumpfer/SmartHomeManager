package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.beans.*;

/**
 * Created by Nils on 05.02.2017.
 */
public class WeatherStationTransferObject {
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
    private MessageBean         message;

    public WeatherStationTransferObject(MeasureBean temperature, MeasureBean windVelocity, MeasureBean rainfallAmount, MeasureBean airPressure, MeasureBean airHumidity, ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber, MessageBean message) {
        this.temperature    = temperature;
        this.windVelocity   = windVelocity;
        this.rainfallAmount = rainfallAmount;
        this.airPressure    = airPressure;
        this.airHumidity    = airHumidity;
        this.modelVariant   = modelVariant;
        this.manufacturer   = manufacturer;
        this.actionMode     = actionMode;
        this.genericName    = genericName;
        this.serialnumber   = serialnumber;
        this.message        = message;
    }

    public WeatherStationTransferObject(MeasureBean temperature, MeasureBean windVelocity, MeasureBean rainfallAmount, MeasureBean airPressure, MeasureBean airHumidity, ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber) {
        this.temperature    = temperature;
        this.windVelocity   = windVelocity;
        this.rainfallAmount = rainfallAmount;
        this.airPressure    = airPressure;
        this.airHumidity    = airHumidity;
        this.modelVariant   = modelVariant;
        this.manufacturer   = manufacturer;
        this.actionMode     = actionMode;
        this.genericName    = genericName;
        this.serialnumber   = serialnumber;
    }

    public MeasureBean getTemperature() {
        return temperature;
    }

    public void setTemperature(MeasureBean temperature) {
        this.temperature = temperature;
    }

    public MeasureBean getWindVelocity() {
        return windVelocity;
    }

    public void setWindVelocity(MeasureBean windVelocity) {
        this.windVelocity = windVelocity;
    }

    public MeasureBean getRainfallAmount() {
        return rainfallAmount;
    }

    public void setRainfallAmount(MeasureBean rainfallAmount) {
        this.rainfallAmount = rainfallAmount;
    }

    public MeasureBean getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(MeasureBean airPressure) {
        this.airPressure = airPressure;
    }

    public MeasureBean getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(MeasureBean airHumidity) {
        this.airHumidity = airHumidity;
    }

    public ModelVariantBean getModelVariant() {
        return modelVariant;
    }

    public void setModelVariant(ModelVariantBean modelVariant) {
        this.modelVariant = modelVariant;
    }

    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerBean manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ActionModeBean getActionMode() {
        return actionMode;
    }

    public void setActionMode(ActionModeBean actionMode) {
        this.actionMode = actionMode;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }
}
