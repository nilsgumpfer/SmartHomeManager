package de.thm.smarthome.main.device.heating.adapter;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
//import de.thm.smarthome.main.device.heating.memento.HeatingMemento;
import de.vaillant.driver.heating.VaillantHeatingDriver;
import de.viessmann.driver.heating.ViessmannHeatingDriver;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 * Changed 28.01.2017
 */
public class VaillantHeatingAdapter extends AObservable implements IHeating, IObserver {

    VaillantHeatingDriver driver;

    public VaillantHeatingAdapter(String productSerialNumber, String heizungsIP, String heizungsname) {

        driver = new VaillantHeatingDriver(productSerialNumber, heizungsIP, heizungsname);
    }

    @Override
    public boolean setTemperature(double temperature) throws RemoteException{

        return driver.adjustTemperature(temperature);
    }

    @Override
    public double getTemperature(){
        return 0;
        //return driver.getCurrentTemperature();
    }

    @Override
    public void standby() throws RemoteException{

        driver.standby();
    }

    @Override
    public void wakeup() throws RemoteException{

        driver.wakeUp();
    }

    @Override
    public List<String> getLogs() {

        return driver.getLogs();
    }

    @Override
    public void update(AObservable o, Object change) {

    }

    @Override
    public boolean setMaxWaterLevel(double new_maxWL) throws RemoteException{
        return driver.setMaxWaterLevel(new_maxWL);
    }

    @Override
    public boolean setMinWaterLevel(double new_minWL) throws RemoteException{
        return driver.setMinWaterLevel(new_minWL);
    }

    @Override
    public boolean setMaxTemperature(double new_maxTemperature) throws RemoteException{
        return driver.setMaxTemperature(new_maxTemperature);
    }

    @Override
    public boolean setMinTemperature(double new_minTemperature) throws RemoteException{
        return driver.setMinTemperature(new_minTemperature);
    }

    @Override
    public double getMaxTemperature() throws RemoteException{
        return driver.getMaxTemperature();
    }

    @Override
    public double getMinTemperature() throws RemoteException{
        return driver.getMinTemperature();
    }

    @Override
    public double getMaxWaterLevel() throws RemoteException{
        return driver.getMaxWaterLevel();
    }

    @Override
    public double getMinWaterLevel() throws RemoteException{
        return driver.getMinWaterLevel();
    }

    @Override
    public ResponseCode switchOn() throws RemoteException{
        return driver.switchOn();
    }

    @Override
    public ResponseCode switchOff() throws RemoteException{
        return driver.switchOff();
    }

    @Override
    public String getStatus() throws RemoteException {
        return driver.getStatus();
    }
}