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
    List<Integer> devicepositions = new ArrayList<>();


    private CollectiveMoveDownCommand(){}

    public CollectiveMoveDownCommand(List<IUpAndDownMovableDevice> devices) {
        this.devices = devices;
    }

    @Override
    public ResponseCode invoke() {
        ResponseCode responseCode;

        for(IUpAndDownMovableDevice device : devices) {
            devicepositions.add(device.getPosition());
            responseCode = device.moveDown();

            if(responseCode == ResponseCode.MoveDownFailed)
                return ResponseCode.CommandInvocationFailed;
        }

        return ResponseCode.CommandInvokedSuccessfully;
    }

    @Override
    public ResponseCode undo() {
        int i = 0;
        ResponseCode responseCode;
        for(IUpAndDownMovableDevice device : devices) {
            responseCode = device.setPosition(devicepositions.get(i));
            if(responseCode == ResponseCode.MoveToPositionFailed)
                return ResponseCode.UndoFailed;
            i++;
        }

        return ResponseCode.UndoSuccessful;
    }
}
