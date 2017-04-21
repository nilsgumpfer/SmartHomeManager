package de.thm.smarthome.main.manager.controller.devicemanager;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.factory.HeatingFactory;
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
import de.thm.smarthome.main.manager.controller.requestmanager.RequestManager;

import java.util.ArrayList;
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
    public void update(AObservable o, Object change) {
        eventManager.update(o,change);
    }

    @Override
    public SmartHeating getSmartHeating() {
        return smartHeating;
    }

    @Override
    public ResponseCode setSmartHeating(SmartHeating smartHeating) {
        if(smartHeating!=null){
            this.smartHeating = smartHeating;
            return ResponseCode.Success;
        } else {
            return ResponseCode.Fail;
        }
    }

    @Override
    public ResponseCode setSmartHeating(HeatingTransferObject heatingTransferObject) {
        if(heatingTransferObject!=null){
            //TODO: implement this
            return ResponseCode.Fail;
        } else {
            return ResponseCode.Fail;
        }
    }

    @Override
    public ResponseCode createSmartHeating(HeatingTransferObject heatingTransferObject) {
        if(heatingTransferObject!=null){
            //TODO: implement this
            return ResponseCode.Fail;
        } else {
            return ResponseCode.Fail;
        }
    }

    @Override
    public ResponseCode deleteSmartHeating() {
        if(smartHeating==null){
            //TODO: implement this
            return ResponseCode.Fail;
        } else {
            return ResponseCode.Fail;
        }
    }

    @Override
    public SmartShutter getSmartShutter(String name) {
        for(int i = 0; i < smartShutters.size(); i++) {
            if (name.equals(smartShutters.get(i).getName())) {
                return smartShutters.get(i);
            }
        }
        return null;
    }

    @Override
    public ResponseCode addSmartShutter(SmartShutter smartShutter) {
        if(smartShutter!=null){
            smartShutters.add(smartShutters.size(), smartShutter);
            return ResponseCode.Success;
        } else {
            return ResponseCode.Fail;
        }
    }

    @Override
    public ResponseCode deleteSmartShutter(SmartShutter smartShutter) {
        return null;
    }

    @Override
    public SmartShutter getSmartShutter(ShutterTransferObject shutterTransferObject) {
return null;
    }

    @Override
    public ResponseCode addSmartShutter(ShutterTransferObject shutterTransferObject) {
        return null;
    }

    @Override
    public ResponseCode deleteSmartShutter(ShutterTransferObject shutterTransferObject) {
        return null;
    }

    @Override
    public ResponseCode createSmartShutter(ShutterTransferObject shutterTransferObject) {
        return null;
    }

    @Override
    public SmartThermometer getSmartThermometer() {
        return smartThermometer;
    }

    @Override
    public ResponseCode setSmartThermometer(SmartThermometer smartThermometer) {
        return null;
    }

    @Override
    public ResponseCode setSmartThermometer(ThermometerTransferObject thermometerTransferObject) {
        return null;
    }

    @Override
    public ResponseCode createSmartThermometer(ThermometerTransferObject thermometerTransferObject) {
        return null;
    }

    @Override
    public SmartWeatherStation getSmartWeatherStation() {
        return smartWeatherStation;
    }

    @Override
    public ResponseCode setSmartWeatherStation(SmartWeatherStation smartWeatherStation) {
        return null;
    }

    @Override
    public ResponseCode createSmartWeatherStation(WeatherStationTransferObject weatherStationTransferObject) {
        return null;
    }

    @Override
    public List<SmartShutter> getSmartShutters() {
        return smartShutters;
    }

    @Override
    public ResponseCode deleteSmartWeatherStation() {
        return null;
    }

    @Override
    public ResponseCode deleteSmartThermometer() {
        return null;
    }
}
