package de.thm.smarthome.main.device.shutter.device;

import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.shutter.logic.IShutterLogic;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;
import de.thm.smarthome.main.device.shutter.model.ShutterModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartShutter extends AObservable implements ISmartDevice, IObserver{

    private IShutterLogic logic;
    private SmartShutter(IShutterLogic logic) {
        this.logic = logic;
    }
    private IShutterModel shutterModel = new ShutterModel();


    public void moveUp() {
        logic.moveUp();
    }

    public void moveDown() {
        logic.moveDown();
    }

    public boolean isUp(){
        return shutterModel.isUp();
    }
    public boolean isDown(){
        return shutterModel.isDown();
    }

    @Override
    public String getName() {
        return logic.getLogicName();
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
