package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;

/**
 * Created by Nils on 15.04.2017.
 */
public class SwitchOnCommand implements ICommand {
    IOnAndOffSwitchableDevice device;

    private SwitchOnCommand(){}

    public SwitchOnCommand(IOnAndOffSwitchableDevice device) {
        this.device = device;
    }

    @Override
    public ResponseCode invoke() {
        return null;
    }

    @Override
    public ResponseCode undo() {
        return null;
    }
}
