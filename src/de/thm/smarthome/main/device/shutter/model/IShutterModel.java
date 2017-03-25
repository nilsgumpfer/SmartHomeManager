package de.thm.smarthome.main.device.shutter.model;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IShutterModel {
    void setName();
    string getName();
    void incrementShutterHeight();
    void decrementShutterHeight();
    void setShutterHeight();
    int getShutterHeight();
}
