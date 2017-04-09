package de.thm.smarthome.main.device.shutter.logic;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IShutterLogic {
    void moveUp();
    void moveDown();
    String getLogicName();
}
