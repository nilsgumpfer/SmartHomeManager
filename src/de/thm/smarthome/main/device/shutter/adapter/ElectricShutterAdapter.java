package de.thm.smarthome.main.device.shutter.adapter;

import de.electricshutter.driver.shutter.ElectricShutterDriver;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
public class ElectricShutterAdapter extends AObservable implements IShutter, IObserver{

    ElectricShutterDriver driver;

    public ElectricShutterAdapter(String serialNumber, String shutterIP, String shuttername){

        driver = new ElectricShutterDriver(serialNumber, shutterIP, shuttername);
    }

    @Override
    public void moveUp() throws RemoteException{

        driver.moveUp();
    }

    @Override
    public void moveDown() throws RemoteException{

        driver.moveDown();
    }

    @Override
    public boolean isUp() throws RemoteException {
        return driver.isUp();
    }

    @Override
    public boolean isDown() throws RemoteException{
        return driver.isDown();
    }

    @Override
    public String getShutterName() {
        return driver.getShutterName();
    }

    @Override
    public String getShutterManufacturer() {
        return driver.getShutterManufacturer();
    }

    @Override
    public String getShutterModel() {
        return driver.getShutterModel();
    }

    @Override
    public String getShutterSerialnumber() {
        return driver.getShutterSerialnumber();
    }

    @Override
    public int getShutterPosition() {
        return driver.getShutterPosition();
    }

    @Override
    public void update(AObservable o, Object change) {

    }

}
