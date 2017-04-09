package de.thm.smarthome.main.device.shutter.logic;

import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;
import de.thm.smarthome.main.device.shutter.model.ShutterModel;

/**
 * Created by Nils on 27.01.2017.
 */


public class ShutterLogicMaintenanceMode implements IShutterLogic {
    private IShutterModel model;
    private IShutter device;
    private ShutterModel shutterModel;
    private String logicName = "MaintenanceMode";

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
    public String getLogicName(){
        return logicName;
    }

}
