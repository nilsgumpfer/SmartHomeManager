package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 15.04.2017.
 */
public class CollectiveMoveUpCommand extends ACollectiveMoveCommand {
    private CollectiveMoveUpCommand(){}

    public CollectiveMoveUpCommand(List<IUpAndDownMovableDevice> devices) {
        this.devices = devices;
        failureCode = ResponseCode.MoveUpFailed;
    }
}
