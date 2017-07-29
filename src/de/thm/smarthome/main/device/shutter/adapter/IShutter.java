package de.thm.smarthome.main.device.shutter.adapter;

import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created by Nils on 27.01.2017.
 * Changed by Jenny on 28.07.2017.
 */
public interface IShutter {
    PositionBean getCurrentPosition();
    PositionBean getDesiredPosition();
    ModelVariantBean getModelVariant();
    ManufacturerBean getManufacturer();

    /* PositionBean oder MessageBean?! Muss Message Bean sein, da es im Adapter so verarbeitet wird*/
    MessageBean setDesiredPosition(PositionBean desiredPosition);
    void attach(IObserver observer);

}
