package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IOnAndOffTurnableDevice;

/**
 * Created by Nils on 15.04.2017.
 */
public class TurnOffCommand implements ICommand {
    IOnAndOffTurnableDevice device;

    private TurnOffCommand(){}

    public TurnOffCommand(IOnAndOffTurnableDevice device) {
        this.device = device;
    }

    @Override
    public ResponseCode execute() {
        return null;
    }

    @Override
    public ResponseCode undo() {
        return null;
    }
}
