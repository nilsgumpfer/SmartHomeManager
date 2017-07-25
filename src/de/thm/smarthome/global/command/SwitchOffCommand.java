package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.PowerStateBean;
import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;

/**
 * Created by Nils on 15.04.2017.
 */
public class SwitchOffCommand extends ASwitchCommand {
    private SwitchOffCommand(){}

    public SwitchOffCommand(IOnAndOffSwitchableDevice device) {
        this.device = device;
        powerToDo = new PowerStateBean(EPowerState.OFF);
        expectedStatus = new PowerStateBean(EPowerState.OFF);
        requiredStatus = new PowerStateBean(EPowerState.ON);
    }
}
