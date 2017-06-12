package de.thm.smarthome.global.interfaces;

import de.thm.smarthome.global.enumeration.EMessageCode;

/**
 * Created by Nils on 15.04.2017.
 */
public interface IUpAndDownMovableDevice {
    EMessageCode moveDown();
    EMessageCode moveUp();
    int getPosition();
    EMessageCode setPosition(int position);


    boolean isUp();

    boolean isDown();
}
