package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;

/**
 * Created by Nils on 15.04.2017.
 */
public class SwitchOffCommand implements ICommand {
    IOnAndOffSwitchableDevice device;

    private SwitchOffCommand(){}

    public SwitchOffCommand(IOnAndOffSwitchableDevice device) {
        this.device = device;
    }
private ResponseCode oldState = null;

    @Override
    public ResponseCode invoke() {
        oldState = device.currentState();
        if(oldState == ResponseCode.SwitchedOn){
            device.switchOff();
            return ResponseCode.SwitchedOff;
        }
        //TODO: save current state of device & switch power
        return ResponseCode.AlreadySwitchedOff;
    }

    @Override
    public ResponseCode undo() {
        //oldState = device.currentState();
        if(oldState == ResponseCode.SwitchedOff){
            device.switchOn();
            return ResponseCode.SwitchedOn;
        }
        //TODO: recover state of device & switch back
        return ResponseCode.AlreadySwitchedOn;
    }


}
