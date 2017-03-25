package de.thm.smarthome.main.device.shutter.logic;

import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;

/**
 * Created by Nils on 27.01.2017.
 */


public class ShutterLogicMaintenanceMode implements IShutterLogic {
    private IShutterModel model;
    private IShutter device;
    private ShutterModel shutterModel;
    private logicName = "MaintenanceMode";

    public ShutterLogicMaintenanceMode(IShutterModel model, IShutter device){}

    @Override
    public void moveUp() {
        shutterModel.setShutterHeight(5);
    }

    @Override
    public void moveDown() {
        shutterModel.setShutterHeight(0);
    }

    @Override
    public string getLogicName(){
        return logicName;
    }

}
