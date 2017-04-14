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
    private String logicName = "";
    private ShutterModel shutterModel = new ShutterModel();

    private SmartShutter(IShutterLogic logic, String shutterName) {
        this.logic = logic;
        shutterModel.setShutterName(shutterName);
    }

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
    public String getLogicName() {
        return shutterModel.getLogicName();
    }

    @Override
    public String getName() {
        return shutterModel.getShutterName();
    }
    @Override
    public void update(AObservable o, Object change) {

    }


}
