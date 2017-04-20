package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.Power;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;

/**
 * Created by Nils on 15.04.2017.
 */
public class SwitchOnCommand extends ASwitchCommand {
    private SwitchOnCommand(){}

    public SwitchOnCommand(IOnAndOffSwitchableDevice device) {
        this.device = device;
        powerToDo = Power.On;
        expectedStatus = ResponseCode.SwitchedOff;
        requiredStatus = ResponseCode.SwitchedOn;
    }
}
