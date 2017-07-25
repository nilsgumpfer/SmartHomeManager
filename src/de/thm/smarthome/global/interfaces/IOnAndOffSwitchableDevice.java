package de.thm.smarthome.global.interfaces;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PowerStateBean;

/**
 * Created by Nils on 15.04.2017.
 */
public interface IOnAndOffSwitchableDevice {
    MessageBean switchOn();
    MessageBean switchOff();
    PowerStateBean currentState();
}
