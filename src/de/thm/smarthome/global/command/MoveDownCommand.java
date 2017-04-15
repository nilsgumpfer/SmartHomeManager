package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;

import java.util.List;

/**
 * Created by Nils on 28.01.2017.
 */
public class MoveDownCommand implements ICommand {
    IUpAndDownMovableDevice device;

    private MoveDownCommand(){}

    public MoveDownCommand(IUpAndDownMovableDevice device) {
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
