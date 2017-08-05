package de.thm.smarthome.main.manager.controller.devicemanager;

import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EModelVariant;
import de.thm.smarthome.global.factory.*;
import de.thm.smarthome.global.helper.ParameterCollector;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.weatherstation.device.SmartWeatherStation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 28.01.2017.
 */
public class DeviceManager extends AObservable implements IDeviceManager, IObserver{
    private static DeviceManager    ourInstance             = new DeviceManager();
    private SmartHeating            smartHeating            = EmptyDeviceFactory.getEmptyHeating();

    //private SmartHeating            smartHeating            = HeatingFactory.createHeating(EDeviceManufacturer.BUDERUS, EModelVariant.HEATING_1000, "443k4o34ko3", "Heating");
    private SmartWeatherStation     smartWeatherStation     = EmptyDeviceFactory.getEmptyWeatherStation();
    private SmartThermometer        smartThermometer        = EmptyDeviceFactory.getEmptyThermometer();
    private List<SmartShutter>      smartShutters           = new ArrayList<>();

    private DeviceManager(){}

    public static DeviceManager getInstance() {
        return ourInstance;
    }

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("DeviceManager: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
    }

    private ParameterCollector checkParameters(String smartDevice, ParameterCollector parameterCollector) {
        ModelVariantBean modelVariantBean = new ModelVariantBean(parameterCollector.getModelVariant());
        ManufacturerBean manufacturerBean = new ManufacturerBean(parameterCollector.getManufacturer());
        String serialnumber = parameterCollector.getSerialnumber();

        if(modelVariantBean.getModelVariant_Enum() == EModelVariant.NA){
            SmartHomeLogger.log(smartDevice + ": Unbekannte Modellvariante");
            parameterCollector.setProceed(false);
            return parameterCollector;
        }

        if(manufacturerBean.getDeviceManufacturer_Enum() == EDeviceManufacturer.NA){
            SmartHomeLogger.log(smartDevice + "SmartHeating: Unbekannter Gerätehersteller");
            parameterCollector.setProceed(false);
            return parameterCollector;
        }

        if(serialnumber.length()<2){
            SmartHomeLogger.log(smartDevice + ": Ungültige Seriennummer");
            parameterCollector.setProceed(false);
            return parameterCollector;
        }

        parameterCollector.setManufacturerBean(manufacturerBean);
        parameterCollector.setModelVariantBean(modelVariantBean);

        parameterCollector.setProceed(true);

        return parameterCollector;
    }

    @Override
    public MessageBean createSmartHeating(String modelVariant, String manufacturer, String genericName, String serialnumber) {
        ParameterCollector parameterCollector = new ParameterCollector(modelVariant, manufacturer, serialnumber);
        parameterCollector = checkParameters("SmartHeating", parameterCollector);

        if(parameterCollector.isProceed())
        {
            try {
                smartHeating = HeatingFactory.createHeating(
                        parameterCollector.getManufacturerBean().getDeviceManufacturer_Enum(),
                        parameterCollector.getModelVariantBean().getModelVariant_Enum(),
                        serialnumber,
                        genericName);

                //smartHeating.attach(this); TODO: DeviceManager attach wieder einfügen
            }
            catch (Exception e)
            {
                SmartHomeLogger.log(e);
                return new MessageBean(false);
            }
        }

        return new MessageBean(parameterCollector.isProceed());
    }

    @Override
    public SmartHeating getSmartHeating() {
        return smartHeating;
    }

    @Override
    public MessageBean deleteSmartHeating() {
        smartHeating.detach(this);
        smartHeating = EmptyDeviceFactory.getEmptyHeating();

        //TODO: Alle Objekte in der Observer-Kette müssen voneinander abgemeldet werden

        return new MessageBean(true);
    }

    @Override
    public MessageBean createSmartShutter(String modelVariant, String manufacturer, String genericName, String serialnumber) {
        ParameterCollector parameterCollector = new ParameterCollector(modelVariant, manufacturer, serialnumber);
        parameterCollector = checkParameters("SmartShutter", parameterCollector);

        if(parameterCollector.isProceed())
        {
            try {
                SmartShutter smartShutter = ShutterFactory.createShutter(
                                                    parameterCollector.getManufacturerBean(),
                                                    parameterCollector.getModelVariantBean(),
                                                    genericName,
                                                    serialnumber
                                            );

                smartShutters.add(smartShutter);
                smartShutter.attach(this);
            }
            catch (Exception e)
            {
                SmartHomeLogger.log(e);
                return new MessageBean(false);
            }
        }

        return new MessageBean(parameterCollector.isProceed());
    }

    @Override
    public SmartShutter getSmartShutter(String serialnumber) {
        for(SmartShutter smartShutter : smartShutters)
        {
            if(smartShutter.getSerialnumber().equals(serialnumber))
                return smartShutter;
        }

        return EmptyDeviceFactory.getEmptyShutter();
    }

    @Override
    public List<SmartShutter> getSmartShutters() {
        return smartShutters;
    }

    @Override
    public MessageBean deleteSmartShutter(SmartShutter smartShutter) {
        return new MessageBean(smartShutters.remove(smartShutter));
    }

    @Override
    public MessageBean createSmartThermometer(String modelVariant, String manufacturer, String genericName, String serialnumber) {
        ParameterCollector parameterCollector = new ParameterCollector(modelVariant, manufacturer, serialnumber);
        parameterCollector = checkParameters("SmartThermometer", parameterCollector);

        if(parameterCollector.isProceed())
        {
            try {
                smartThermometer = ThermometerFactory.createThermometer(
                        parameterCollector.getManufacturerBean(),
                        parameterCollector.getModelVariantBean(),
                        serialnumber,
                        genericName);

                smartThermometer.attach(this);
            }
            catch (Exception e)
            {
                SmartHomeLogger.log(e);
                return new MessageBean(false);
            }
        }

        return new MessageBean(parameterCollector.isProceed());
    }

    @Override
    public SmartThermometer getSmartThermometer() {
        return smartThermometer;
    }

    @Override
    public MessageBean deleteSmartThermometer() {
        smartThermometer.detach(this);
        smartThermometer = EmptyDeviceFactory.getEmptyThermometer();

        //TODO: Alle Objekte in der Observer-Kette müssen voneinander abgemeldet werden

        return new MessageBean(true);
    }

    @Override
    public MessageBean createSmartWeatherStation(String modelVariant, String manufacturer, String genericName, String serialnumber) {
        ParameterCollector parameterCollector = new ParameterCollector(modelVariant, manufacturer, serialnumber);
        parameterCollector = checkParameters("SmartWeatherstation", parameterCollector);

        if(parameterCollector.isProceed())
        {
            try {
                smartWeatherStation = WeatherStationFactory.createWeatherStation(
                        parameterCollector.getManufacturerBean(),
                        parameterCollector.getModelVariantBean(),
                        serialnumber,
                        genericName);

                smartWeatherStation.attach(this);
            }
            catch (Exception e)
            {
                SmartHomeLogger.log(e);
                return new MessageBean(false);
            }
        }

        return new MessageBean(parameterCollector.isProceed());
    }

    @Override
    public SmartWeatherStation getSmartWeatherStation() {
        return smartWeatherStation;
    }

    @Override
    public MessageBean deleteSmartWeatherStation() {
        smartWeatherStation.detach(this);
        smartWeatherStation = EmptyDeviceFactory.getEmptyWeatherStation();

        //TODO: Alle Objekte in der Observer-Kette müssen voneinander abgemeldet werden

        return new MessageBean(true);
    }
}
