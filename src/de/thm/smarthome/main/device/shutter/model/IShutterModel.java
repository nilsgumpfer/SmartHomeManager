package de.thm.smarthome.main.device.shutter.model;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IShutterModel {
    void setShutterName(String shutterName);
    String getShutterName();
    String getLogicName();
    void setLogicName(String logicName);
    void incrementShutterHeight();
    void decrementShutterHeight();
    void setShutterHeight(int value);
    int getShutterHeight();
    boolean isUp();
    boolean isDown();
}
