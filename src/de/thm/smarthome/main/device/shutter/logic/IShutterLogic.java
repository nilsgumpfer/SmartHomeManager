package de.thm.smarthome.main.device.shutter.logic;

import de.thm.smarthome.global.transfer.ShutterTransferObject;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IShutterLogic {
    void moveUp();
    void moveDown();
    void setLogicName(String logicName);
    int getPosition();
    void setPosition(int shutterHeight);
    ShutterTransferObject getShutterData = null;
    int getShutterPosition();

}
