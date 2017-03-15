package de.thm.smarthome.main.manager.controller;

import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
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
    private List<SmartShutter> smartShutters;

    private DeviceManager(){}

    public static DeviceManager getInstance() {
        return ourInstance;
    }

    public SmartHeating getSmartHeating(){ return null; }

    public List<SmartShutter> getSmartShutters() {
        return null;
    }

    public SmartThermometer getSmartThermometer(){ return null; }

    public int setSmartHeating(SmartHeating smartHeating){return 0;}

    public SmartWeatherStation getSmartWeatherStation(){return null;}

    public int setSmartWeatherStation(SmartWeatherStation smartWeatherStation){return 0;}

    public int setSmartThermometer(SmartThermometer smartThermometer){return 0;}

    public SmartShutter getSmartShutter(String id){return null;}

    public int addSmartShutter(SmartShutter smartShutter){return 0;}

    @Override
    public void update(AObservable o, Object change) {
        eventManager.update(o,change);
    }
}
