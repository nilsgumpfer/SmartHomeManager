package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.MoveDirection;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;

import java.util.List;

/**
 * Created by Nils on 28.01.2017.
 */
public class MoveUpCommand extends AMoveCommand {
    private MoveUpCommand(){}

    public MoveUpCommand(IUpAndDownMovableDevice device) {
        this.device = device;
        failureCode = ResponseCode.MoveDownFailed;
        moveDirection = MoveDirection.Down;
    }
}
