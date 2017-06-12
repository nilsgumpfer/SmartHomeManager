package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;

/**
 * Created by Nils on 15.04.2017.
 */
public class SwitchOffCommand extends ASwitchCommand {
    private SwitchOffCommand(){}

    public SwitchOffCommand(IOnAndOffSwitchableDevice device) {
        this.device = device;
        powerToDo = EPowerState.OFF;
        expectedStatus = EMessageCode.SwitchedOn;
        requiredStatus = EMessageCode.SwitchedOff;
    }
}
