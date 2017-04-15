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
    public ResponseCode execute() {
        return null;
    }

    @Override
    public ResponseCode undo() {
        return null;
    }
}
