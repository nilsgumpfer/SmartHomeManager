package de.thm.smarthome.main.device.shutter.model;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IShutterModel {
    void setName(String name);
    String getName();
    void incrementShutterHeight();
    void decrementShutterHeight();
    void setShutterHeight(int value);
    int getShutterHeight();
}
