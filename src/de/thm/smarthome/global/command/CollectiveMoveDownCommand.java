package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 15.04.2017.
 */
public class CollectiveMoveDownCommand implements ICommand {
    List<IUpAndDownMovableDevice> devices = new ArrayList<>();

    private CollectiveMoveDownCommand(){}

    public CollectiveMoveDownCommand(List<IUpAndDownMovableDevice> devices) {
        this.devices = devices;
    }

    @Override
    public ResponseCode invoke() {
        //TODO: save current state of devices & move all devices down
        return ResponseCode.MoveDownFailed;
    }

    @Override
    public ResponseCode undo() {
        //TODO: recover state of devices & move all devices back
        return ResponseCode.UndoFailed;
    }
}
