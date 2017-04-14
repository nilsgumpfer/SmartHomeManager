package de.thm.smarthome.main.device.shutter.logic;

import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;
import de.thm.smarthome.main.device.shutter.model.ShutterModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class ShutterLogicStandardMode implements IShutterLogic {
    private IShutterModel model;
    private IShutter device;
    private ShutterModel shutterModel;

    public ShutterLogicStandardMode(IShutterModel model, IShutter device){
        setLogicName("StandardMode");
    }

    @Override
    public void setLogicName(String logicName){
        model.setLogicName(logicName);
    }

    @Override
    public void moveUp() {
        shutterModel.incrementShutterHeight();
    }

    @Override
    public void moveDown() {
        shutterModel.decrementShutterHeight();
    }

    public void setShutterHeight(int height) {
        shutterModel.setShutterHeight(height);
    }


}
