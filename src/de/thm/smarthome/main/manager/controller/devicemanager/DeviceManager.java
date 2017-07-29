package de.thm.smarthome.main.manager.controller.devicemanager;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.global.transfer.WeatherStationTransferObject;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.weatherstation.device.SmartWeatherStation;
import de.thm.smarthome.main.manager.controller.eventmanager.EventManager;
import de.thm.smarthome.main.manager.controller.eventmanager.IEventManager;

import java.util.List;

/**
 * Created by Nils on 28.01.2017.
 */
public class DeviceManager implements IDeviceManager, IObserver{
    private static DeviceManager ourInstance = new DeviceManager();
    private IEventManager eventManager = EventManager.getInstance();
    private SmartHeating smartHeating;
    private SmartWeatherStation smartWeatherStation;
    private SmartThermometer smartThermometer;
    private SmartShutter smartShutter;
    private List<SmartShutter> smartShutters;

    private DeviceManager(){}

    public static DeviceManager getInstance() {
        return ourInstance;
    }

    @Override
    public void update(AObservable o, Object change) {
        eventManager.update(o,change);
    }

    @Override
    public SmartHeating getSmartHeating() {
        return smartHeating;
    }

    @Override
    public MessageBean setSmartHeating(SmartHeating smartHeating) {
        if(smartHeating!=null){
            this.smartHeating = smartHeating;
            return new MessageBean(true);
        } else {
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean setSmartHeating(HeatingTransferObject heatingTransferObject) {
        if(heatingTransferObject!=null){
            //TODO: implement this
            return new MessageBean(true);
        } else {
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean createSmartHeating(HeatingTransferObject heatingTransferObject) {
        if(heatingTransferObject!=null){
            //TODO: implement this
            return new MessageBean(true);
        } else {
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean deleteSmartHeating() {
        if(smartHeating==null){
            //TODO: implement this
            return new MessageBean(true);
        } else {
            return new MessageBean(false);
        }
    }

    @Override
    public SmartShutter getSmartShutter(String serialnumber) {
        for(int i = 0; i < smartShutters.size(); i++) {
            if (serialnumber.equals(smartShutters.get(i).getSerialnumber())) {
                return smartShutters.get(i);
            }
        }
        return null;
    }

    @Override
    public MessageBean addSmartShutter(SmartShutter smartShutter) {
        if(smartShutter!=null){
            smartShutters.add(smartShutters.size(), smartShutter);
            return new MessageBean(true);
        } else {
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean deleteSmartShutter(SmartShutter smartShutter) {
        return null;
    }

    @Override
    public SmartShutter getSmartShutter(ShutterTransferObject shutterTransferObject) {
return smartShutter;
    }

    @Override
    public MessageBean addSmartShutter(ShutterTransferObject shutterTransferObject) {
        return null;
    }

    @Override
    public MessageBean deleteSmartShutter(ShutterTransferObject shutterTransferObject) {
        return null;
    }

    @Override
    public MessageBean createSmartShutter(ShutterTransferObject shutterTransferObject) {
        return null;
    }

    @Override
    public SmartThermometer getSmartThermometer() {
        return smartThermometer;
    }

    @Override
    public MessageBean setSmartThermometer(SmartThermometer smartThermometer) {
        return null;
    }

    @Override
    public MessageBean setSmartThermometer(ThermometerTransferObject thermometerTransferObject) {
        return null;
    }

    @Override
    public MessageBean createSmartThermometer(ThermometerTransferObject thermometerTransferObject) {
        return null;
    }

    @Override
    public SmartWeatherStation getSmartWeatherStation() {
        return smartWeatherStation;
    }

    @Override
    public MessageBean setSmartWeatherStation(SmartWeatherStation smartWeatherStation) {
        return null;
    }

    @Override
    public MessageBean createSmartWeatherStation(WeatherStationTransferObject weatherStationTransferObject) {
        return null;
    }

    @Override
    public List<SmartShutter> getSmartShutters() {
        return smartShutters;
    }

    @Override
    public MessageBean createSmartHeating(String modelVariant, String manufacturer, String genericName, String serialnumber) {
        return null;
    }

    @Override
    public MessageBean createSmartShutter(String modelVariant, String manufacturer, String genericName, String serialnumber) {
        return null;
    }

    @Override
    public MessageBean createSmartWeatherStation(String modelVariant, String manufacturer, String genericName, String serialnumber) {
        return null;
    }

    @Override
    public MessageBean deleteSmartWeatherStation() {
        return null;
    }

    @Override
    public MessageBean deleteSmartThermometer() {
        return null;
    }
}
