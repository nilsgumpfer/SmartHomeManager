package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;

import java.util.List;

/**
 * Created by Nils on 28.01.2017.
 */
public class MoveUpCommand implements ICommand {
    IUpAndDownMovableDevice device;

    private MoveUpCommand(){}

    public MoveUpCommand(IUpAndDownMovableDevice device) {
        this.device = device;
    }

    @Override
    public ResponseCode invoke() {
        device.moveUp();
        //TODO: save current state of device & move device up
        return ResponseCode.MoveDownFailed;
    }

    @Override
    public ResponseCode undo() {
        device.moveDown();
        //TODO: recover state of device & move device back
        return ResponseCode.MoveUpFailed;
    }
}
