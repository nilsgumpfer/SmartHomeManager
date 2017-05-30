package de.thm.smarthome.main.device.thermometer.device;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.thermometer.logic.IThermometerLogic;
import de.thm.smarthome.main.device.thermometer.logic.ThermometerLogicCelsius;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;
import de.thm.smarthome.main.device.thermometer.model.ThermometerModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartThermometer extends AObservable implements ISmartDevice, IObserver {
    private IThermometerLogic logic;
    private ThermometerModel model = new ThermometerModel();

    public SmartThermometer(IThermometerLogic logic) {
        this.logic = logic;
    }

    @Override
    public String getName() {
        return logic.getLogicName();
    }

    @Override
    public void update(AObservable o, Object change) {

    }
    public ThermometerTransferObject getThermometerData(){
        return logic.getThermometerData();
    }
}
