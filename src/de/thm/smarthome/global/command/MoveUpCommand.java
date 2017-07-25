package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.EMoveDirection;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;

/**
 * Created by Nils on 28.01.2017.
 */
public class MoveUpCommand extends AMoveCommand {
    public MoveUpCommand(IUpAndDownMovableDevice device) {
        this.device = device;
        moveDirection = EMoveDirection.Down;
    }
}
