package de.thm.smarthome.main.device.weatherstation.logic;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.factory.TransferObjectFactory;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.WeatherStationTransferObject;
import de.thm.smarthome.main.device.weatherstation.adapter.IWeatherStation;
import de.thm.smarthome.main.device.weatherstation.model.IWeatherStationModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class WeatherStationLogicMetric extends AObservable implements IWeatherStationLogic, IObserver
{
    private IWeatherStationModel    model;
    private IWeatherStation         device;
    private ActionModeBean          actionModeBean = new ActionModeBean(EActionMode.CELSIUS);

    public WeatherStationLogicMetric(IWeatherStationModel model, IWeatherStation adapter) {
        this.model  = model;
        device      = adapter;
    }

    @Override
    public void update(AObservable o, Object change) {
        //TODO: Observer-Pattern
        SmartHomeLogger.log("WeatherStationLogicMetric: Detected a change! [" + o.toString() + "]");
    }

    @Override
    public MeasureBean getTemperature() {
        return model.getTemperature();
    }

    @Override
    public MeasureBean getWindVelocity() {
        return model.getWindVelocity();
    }

    @Override
    public MeasureBean getRainfallAmount() {
        return model.getRainfallAmount();
    }

    @Override
    public MeasureBean getAirHumidity() {
        return model.getAirHumidity();
    }

    @Override
    public MeasureBean getAirPressure() {
        return model.getAirPressure();
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
    public ActionModeBean getActionMode() {
        return actionModeBean;
    }

    @Override
    public String getGenericName() {
        return model.getGenericName();
    }

    @Override
    public String getSerialnumber() {
        return model.getSerialnumber();
    }

    @Override
    public WeatherStationTransferObject getWeatherStationData() {
        return TransferObjectFactory.getWeatherStationTransferObject(model);
    }

    @Override
    public IWeatherStationModel getModel() {
        return model;
    }

    @Override
    public IWeatherStation getAdapter() {
        return device;
    }
}