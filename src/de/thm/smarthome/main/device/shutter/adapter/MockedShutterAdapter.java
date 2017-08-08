package de.thm.smarthome.main.device.shutter.adapter;

import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EModelVariant;
import de.thm.smarthome.global.enumeration.EPosition;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created on 27.01.2017.
 */
public class MockedShutterAdapter extends AObservable implements IShutter, IObserver
{
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.NA);

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("MockedShutterAdapter: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
    }

    //SETTER//

    @Override
    public MessageBean setDesiredPosition(PositionBean desiredPosition) {
        return new MessageBean(false);
    }

    //GETTER//

    @Override
    public PositionBean getCurrentPosition() { return new PositionBean(EPosition.NA); }

    @Override
    public PositionBean getDesiredPosition() { return new PositionBean(EPosition.NA); }

    @Override
    public ModelVariantBean getModelVariant() { return new ModelVariantBean(EModelVariant.NA);}

    @Override
    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }


    }


