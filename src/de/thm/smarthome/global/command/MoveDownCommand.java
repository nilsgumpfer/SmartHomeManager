package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.EMoveDirection;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;

/**
 * Created by Nils on 28.01.2017.
 */
public class MoveDownCommand extends AMoveCommand {
    private MoveDownCommand(){}

    public MoveDownCommand(IUpAndDownMovableDevice device) {
        this.device = device;
        failureCode = EMessageCode.MoveDownFailed;
        moveDirection = EMoveDirection.Down;
    }
}
