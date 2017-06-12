package de.thm.smarthome.main.manager.controller.devicemanager;

import de.thm.smarthome.global.enumeration.EMessageCode;
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
    public EMessageCode setSmartHeating(SmartHeating smartHeating) {
        if(smartHeating!=null){
            this.smartHeating = smartHeating;
            return EMessageCode.Success;
        } else {
            return EMessageCode.Fail;
        }
    }

    @Override
    public EMessageCode setSmartHeating(HeatingTransferObject heatingTransferObject) {
        if(heatingTransferObject!=null){
            //TODO: implement this
            return EMessageCode.Fail;
        } else {
            return EMessageCode.Fail;
        }
    }

    @Override
    public EMessageCode createSmartHeating(HeatingTransferObject heatingTransferObject) {
        if(heatingTransferObject!=null){
            //TODO: implement this
            return EMessageCode.Fail;
        } else {
            return EMessageCode.Fail;
        }
    }

    @Override
    public EMessageCode deleteSmartHeating() {
        if(smartHeating==null){
            //TODO: implement this
            return EMessageCode.Fail;
        } else {
            return EMessageCode.Fail;
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
    public EMessageCode addSmartShutter(SmartShutter smartShutter) {
        if(smartShutter!=null){
            smartShutters.add(smartShutters.size(), smartShutter);
            return EMessageCode.Success;
        } else {
            return EMessageCode.Fail;
        }
    }

    @Override
    public EMessageCode deleteSmartShutter(SmartShutter smartShutter) {
        return null;
    }

    @Override
    public SmartShutter getSmartShutter(ShutterTransferObject shutterTransferObject) {
return smartShutter;
    }

    @Override
    public EMessageCode addSmartShutter(ShutterTransferObject shutterTransferObject) {
        return null;
    }

    @Override
    public EMessageCode deleteSmartShutter(ShutterTransferObject shutterTransferObject) {
        return null;
    }

    @Override
    public EMessageCode createSmartShutter(ShutterTransferObject shutterTransferObject) {
        return null;
    }

    @Override
    public SmartThermometer getSmartThermometer() {
        return smartThermometer;
    }

    @Override
    public EMessageCode setSmartThermometer(SmartThermometer smartThermometer) {
        return null;
    }

    @Override
    public EMessageCode setSmartThermometer(ThermometerTransferObject thermometerTransferObject) {
        return null;
    }

    @Override
    public EMessageCode createSmartThermometer(ThermometerTransferObject thermometerTransferObject) {
        return null;
    }

    @Override
    public SmartWeatherStation getSmartWeatherStation() {
        return smartWeatherStation;
    }

    @Override
    public EMessageCode setSmartWeatherStation(SmartWeatherStation smartWeatherStation) {
        return null;
    }

    @Override
    public EMessageCode createSmartWeatherStation(WeatherStationTransferObject weatherStationTransferObject) {
        return null;
    }

    @Override
    public List<SmartShutter> getSmartShutters() {
        return smartShutters;
    }

    @Override
    public EMessageCode deleteSmartWeatherStation() {
        return null;
    }

    @Override
    public EMessageCode deleteSmartThermometer() {
        return null;
    }
}
