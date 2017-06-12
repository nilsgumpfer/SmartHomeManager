package de.thm.smarthome.main.manager.controller.devicemanager;

import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EMessageCode;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 28.01.2017.
 */
public class DeviceManagerMock implements IDeviceManager, IObserver{
    private static DeviceManagerMock ourInstance = new DeviceManagerMock();
    private IEventManager eventManager = EventManager.getInstance();
    private SmartHeating smartHeating;
    private SmartWeatherStation smartWeatherStation;
    private SmartThermometer smartThermometer;
    private List<SmartShutter> smartShutters;

    private DeviceManagerMock(){
        HeatingFactory heatingFactory = new HeatingFactory();
        //TODO: IP-Adresse & Heizungs-Name
        smartHeating = heatingFactory.createHeating(EDeviceManufacturer.VIESSMANN,"V374354343543","192.168.56.1","SAG");
    }

    public static DeviceManagerMock getInstance() {
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
        return this.setSmartHeating(smartHeating);
    }

    @Override
    public EMessageCode setSmartHeating(HeatingTransferObject heatingTransferObject) {
        return EMessageCode.Fail;
    }

    @Override
    public EMessageCode createSmartHeating(HeatingTransferObject heatingTransferObject) {
        return EMessageCode.Fail;
    }

    @Override
    public EMessageCode deleteSmartHeating() {
        return EMessageCode.Success;
    }

    @Override
    public SmartShutter getSmartShutter(String id) {
        return null;
    }

    @Override
    public EMessageCode addSmartShutter(SmartShutter smartShutter) {
        return null;
    }

    @Override
    public EMessageCode deleteSmartShutter(SmartShutter smartShutter) {
        return null;
    }

    @Override
    public SmartShutter getSmartShutter(ShutterTransferObject shutterTransferObject) {
        return null;
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
        return null;
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
        return null;
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
        return new ArrayList<>();
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
