package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 15.04.2017.
 */
public class CollectiveMoveUpCommand implements ICommand {
    List<IUpAndDownMovableDevice> devices = new ArrayList<>();

    private CollectiveMoveUpCommand(){}

    public CollectiveMoveUpCommand(List<IUpAndDownMovableDevice> devices) {
        this.devices = devices;
    }

    @Override
    public ResponseCode invoke() {
        for(IUpAndDownMovableDevice device : devices) {
            device.moveUp();
        }
        //TODO: save current state of devices & move all devices up
        return ResponseCode.MoveUpFailed;
    }

    @Override
    public ResponseCode undo() {
        for(IUpAndDownMovableDevice device : devices) {
            device.moveDown();
        }
        //TODO: recover state of devices & move all devices back
        return ResponseCode.UndoFailed;
    }
}
