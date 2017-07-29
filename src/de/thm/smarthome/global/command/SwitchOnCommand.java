package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.PowerStateBean;
import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;

/**
 * Created by Nils on 15.04.2017.
 */
public class SwitchOnCommand extends ASwitchCommand {
    public SwitchOnCommand(IOnAndOffSwitchableDevice device) {
        this.device = device;
        powerToDo = new PowerStateBean(EPowerState.ON);
        expectedStatus = powerToDo;
        requiredStatus = new PowerStateBean(EPowerState.OFF);
    }
}
