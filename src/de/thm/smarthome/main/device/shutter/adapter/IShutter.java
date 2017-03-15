package de.thm.smarthome.main.device.shutter.adapter;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IShutter {
    void moveUp();
    void moveDown();
    boolean isUp();
    boolean isDown();
}
