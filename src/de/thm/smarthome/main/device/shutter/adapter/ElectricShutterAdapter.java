package de.thm.smarthome.main.device.shutter.adapter;

import de.electriccompany.driver.shutter.ElectricShutterDriver;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created by Nils on 27.01.2017.
 */
public class ElectricShutterAdapter extends AObservable implements IShutter, IObserver
{
    private ElectricShutterDriver driver;
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.ELECTRIC_COMPANY);

    public ElectricShutterAdapter(ElectricShutterDriver driver) {
        this.driver = driver;
        this.driver.attach(this);
    }

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("ElectricShutterAdapter: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
    }

    //Setter Methoden//

    @Override
    public MessageBean setDesiredPosition(PositionBean desiredPosition) {
        return driver.setDesiredPosition(desiredPosition);
    }

    //Getter Methoden//

    @Override
    public PositionBean getCurrentPosition() { return driver.getCurrentPosition(); }

    @Override
    public PositionBean getDesiredPosition() { return driver.getDesiredPosition(); }

    @Override
    public ModelVariantBean getModelVariant() { return driver.getModelVariant();}

    @Override
    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

}


