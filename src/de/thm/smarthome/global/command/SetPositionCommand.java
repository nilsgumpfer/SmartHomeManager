package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IPositionRelevantDevice;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;

/**
 * Created by Nils on 15.04.2017.
 */
public class SetPositionCommand implements ICommand {
    IPositionRelevantDevice device;
    int position;
    int oldPosition = 0;

    private SetPositionCommand(){}

    public SetPositionCommand(IPositionRelevantDevice device, int position) {
        this.device     = device;
        this.position   = position;
    }

    @Override
    public ResponseCode invoke() {
        //device.
        device.setPosition(position);
        //TODO: save current state of device & set position
        return ResponseCode.MoveToPositionFailed;
    }

    @Override
    public ResponseCode undo() {
        //TODO: recover state of device & move device back
        return ResponseCode.MoveToPositionFailed;
    }
}
