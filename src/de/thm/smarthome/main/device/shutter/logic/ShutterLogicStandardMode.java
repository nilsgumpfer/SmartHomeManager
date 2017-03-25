package de.thm.smarthome.main.device.shutter.logic;

import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class ShutterLogicStandardMode implements IShutterLogic {
    private IShutterModel model;
    private IShutter device;
    private ShutterModel shutterModel;
    private logicName = "StandardMode";

    public ShutterLogicStandardMode(IShutterModel model, IShutter device){}

    @Override
    public void moveUp() {
        shutterModel.incrementShutterHeight();
    }

    @Override
    public void moveDown() {
        shutterModel.decrementShutterHeight();
    }

    @Override
    public string getLogicName(){
        return logicName;
    }
}
