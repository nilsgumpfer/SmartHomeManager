package de.thm.smarthome.main.device.shutter.logic;

import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;
import de.thm.smarthome.main.device.shutter.model.ShutterModel;

/**
 * Created by Nils on 27.01.2017.
 */


public class ShutterLogicMaintenanceMode implements IShutterLogic {
    private IShutterModel model;
    private IShutter device;
    private ShutterModel shutterModel; //TODO: Von Nils: Warum gibt es ein Model-Interface, obwohl hier das konkrete Model verwendet wird??

    public ShutterLogicMaintenanceMode(IShutterModel model, IShutter device){
        setLogicName("MaintenanceMode");
    }

    @Override
    public void setLogicName(String logicName){
        model.setLogicName(logicName);
    }

    @Override
    public int getPosition() {
        return model.getShutterHeight();
    }

    @Override
    public void setPosition(int shutterHeight) {
        //TODO: Fehlermeldung: "Rollläden können im Wartungsmodus nicht gesetzt werden"
        SmartHomeLogger.log("Rollläden können im Wartungsmodus nicht gesetzt werden");
    }

    @Override
    public void moveUp() {
        shutterModel.setShutterHeight(5);
    }

    @Override
    public void moveDown() {
        shutterModel.setShutterHeight(0);
    }

}
