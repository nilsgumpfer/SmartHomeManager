package de.thm.smarthome.main.device.shutter.adapter;

import de.electriccompany.driver.shutter.ElectricShutterDriver;
import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
public class ElectricShutterAdapter extends AObservable implements IShutter, IObserver
{
    private ElectricShutterDriver driver;
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.ELECTRIC_COMPANY);

    public ElectricShutterAdapter(ElectricShutterDriver driver) {
        this.driver = driver;
    }

    @Override
    public void update(AObservable o, Object change) {
        //TODO: Observer-Pattern
    }

    @Override
    public MessageBean setDesiredPosition(PositionBean desiredPosition) {
        return new MessageBean(driver.setDesiredPosition(desiredPosition.getPosition_Int()));
    }

    @Override
    public PositionBean getCurrentPosition() {
         return new PositionBean(driver.getCurrentPosition());
    }

    @Override
    public PositionBean getDesiredPosition() {
        return new PositionBean(driver.getDesiredPosition());
    }

    @Override
    public ModelVariantBean getModelVariant() {
        return new ModelVariantBean(EDeviceManufacturer.ELECTRIC_COMPANY, driver.getModelVariant());
    }
}
