package de.thm.smarthome.main.device.shutter.device;

import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.shutter.logic.IShutterLogic;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartShutter extends AObservable implements ISmartDevice, IObserver{

        private IShutterLogic logic;

    public SmartShutter(IShutterLogic logic) {

            this.logic = logic;
        }

    public void moveUp() {
        logic.moveUp();
    }

    public void moveDown() {
        logic.moveDown();
    }

    public boolean isUp() {
        return false;
    }

    public boolean isDown() {
        return false;
    }

    @Override
    public string getName() {

        return logic.getLogicName();
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
