package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.EMoveDirection;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;

import java.util.List;

/**
 * Created by Nils on 15.04.2017.
 */
public class CollectiveMoveDownCommand extends ACollectiveMoveCommand {
    public CollectiveMoveDownCommand(List<IUpAndDownMovableDevice> devices) {
        this.devices = devices;
        this.moveDirection = EMoveDirection.UP;
    }
}
