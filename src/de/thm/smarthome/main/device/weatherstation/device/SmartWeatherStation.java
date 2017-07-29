package de.thm.smarthome.main.device.weatherstation.device;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.WeatherStationTransferObject;
import de.thm.smarthome.main.device.weatherstation.adapter.IWeatherStation;
import de.thm.smarthome.main.device.weatherstation.logic.IWeatherStationLogic;
import de.thm.smarthome.main.device.weatherstation.logic.WeatherStationLogicAngloAmerican;
import de.thm.smarthome.main.device.weatherstation.logic.WeatherStationLogicMaintenanceMode;
import de.thm.smarthome.main.device.weatherstation.logic.WeatherStationLogicMetric;
import de.thm.smarthome.main.device.weatherstation.model.IWeatherStationModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartWeatherStation extends AObservable implements IObserver{
    private IWeatherStationLogic logic;

    public SmartWeatherStation(IWeatherStationLogic logic) {
        this.logic = logic;
        this.logic.attach(this);
    }

    @Override
    public void update(AObservable o, Object change) {
        //TODO: Observer-Pattern
        SmartHomeLogger.log("SmartWeatherStation: Detected a change! [" + o.toString() + "]");
    }

    public MeasureBean getTemperature() {
        return logic.getTemperature();
    }

    public MeasureBean getWindVelocity(){ return logic.getWindVelocity(); }

    public MeasureBean getRainfallAmount(){ return logic.getRainfallAmount(); }

    public MeasureBean getAirHumidity(){ return logic.getAirHumidity(); }

    public MeasureBean getAirPressure(){ return logic.getAirPressure(); }

    public ModelVariantBean getModelVariant() {
        return logic.getModelVariant();
    }

    public ManufacturerBean getManufacturer() {
        return logic.getManufacturer();
    }

    public String getGenericName() {
        return logic.getGenericName();
    }

    public String getSerialnumber() {
        return logic.getSerialnumber();
    }

    public WeatherStationTransferObject getWeatherStationData(){
        return logic.getWeatherStationData();
    }

    public ActionModeBean getActionMode() { return logic.getActionMode(); }

    public void setActionMode(ActionModeBean actionMode)
    {
        IWeatherStationModel model = logic.getModel();
        IWeatherStation adapter    = logic.getAdapter();

        switch (actionMode.getActionMode_Enum())
        {
            case METRIC:
                logic = new WeatherStationLogicMetric(model, adapter);
                break;
            case ANGLO_AMERICAN:
                logic = new WeatherStationLogicAngloAmerican(model, adapter);
                break;
            case MAINTENANCEMODE:
                logic = new WeatherStationLogicMaintenanceMode(model, adapter);
                break;
            case NA:
                break;
        }
    }


}
