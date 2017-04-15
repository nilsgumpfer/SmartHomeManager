package de.thm.smarthome.global.command;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IOnAndOffTurnableDevice;

/**
 * Created by Nils on 15.04.2017.
 */
public class TurnOnCommand implements ICommand {
    IOnAndOffTurnableDevice device;

    private TurnOnCommand(){}

    public TurnOnCommand(IOnAndOffTurnableDevice device) {
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
