package de.thm.smarthome.main.manager.controller.devicemanager;

import de.thm.smarthome.global.enumeration.ResponseCode;
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
    private List<SmartShutter> smartShutters;

    private DeviceManager(){}


    public static DeviceManager getInstance() {
        return ourInstance;
    }

    @Override
    public SmartHeating getSmartHeating() {
        return null;
    }

    @Override
    public void setSmartHeating(SmartHeating smartHeating) {
        this.smartHeating = smartHeating;
    }

    @Override
    public ResponseCode createSmartHeating(HeatingTransferObject heatingTransferObject) {
        return null;
    }

    public SmartShutter getSmartShutter(String name) {
        for(int i = 0; i < smartShutters.size(); i++){
            if(name.equals(smartShutters.get(i).getName())){
                return smartShutters.get(i);
            }
        }
        return null;
    }

    @Override
    public void addSmartShutter(SmartShutter smartShutter) {
        smartShutters.add(smartShutter);
    }

    @Override
    public void removeSmartShutter(SmartShutter smartShutter) {
        smartShutters.remove(smartShutter);
    }

    @Override
    public int createSmartShutter(ShutterTransferObject shutterTransferObject) {
        return 0;
    }

    @Override
    public SmartThermometer getSmartThermometer() {
        return smartThermometer;
    }

    @Override
    public void setSmartThermometer(SmartThermometer smartThermometer) {
        this.smartThermometer = smartThermometer;
    }

    @Override
    public int createSmartThermometer(ThermometerTransferObject thermometerTransferObject) {
        return 0;
    }

    @Override
    public SmartWeatherStation getSmartWeatherStation() {
        return smartWeatherStation;
    }

    @Override
    public void setSmartWeatherStation(SmartWeatherStation smartWeatherStation) {
        this.smartWeatherStation = smartWeatherStation;
    }

    @Override
    public int createSmartWeatherStation(WeatherStationTransferObject weatherStationTransferObject) {
        return 0;
    }

    @Override
    public ResponseCode deleteSmartHeating() {
        return null;
    }

    @Override
    public void update(AObservable o, Object change) {

        eventManager.update(o,change);
    }

}
