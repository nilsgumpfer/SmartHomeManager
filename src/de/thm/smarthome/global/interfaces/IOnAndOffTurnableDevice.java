package de.thm.smarthome.global.interfaces;

import de.thm.smarthome.global.enumeration.ResponseCode;

/**
 * Created by Nils on 15.04.2017.
 */
public interface IOnAndOffTurnableDevice {
    ResponseCode switchOn();
    ResponseCode switchOff();
}
