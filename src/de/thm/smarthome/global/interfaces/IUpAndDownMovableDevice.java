package de.thm.smarthome.global.interfaces;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;

/**
 * Created by Nils on 15.04.2017.
 */
public interface IUpAndDownMovableDevice {
    MessageBean moveDown();
    MessageBean moveUp();
    PositionBean getPosition();
    MessageBean setPosition(PositionBean position);
    boolean isUp();
    boolean isDown();
}
