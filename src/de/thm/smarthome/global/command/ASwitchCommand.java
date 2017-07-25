package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PowerStateBean;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;

import java.rmi.RemoteException;

/**
 * Created by Nils on 19.04.2017.
 */
public abstract class ASwitchCommand implements ICommand {
    protected IOnAndOffSwitchableDevice device;
    protected PowerStateBean oldState             = null;
    protected PowerStateBean expectedStatus       = null;
    protected PowerStateBean requiredStatus       = null;
    protected PowerStateBean powerToDo            = null;

    @Override
    public MessageBean invoke() throws RemoteException{
        MessageBean responseCode = null;

        //before new state is set, save old one for possible undo-operation
        oldState = device.currentState();

        //check if current status is as expected, do operation
        if(oldState == expectedStatus) {
            switch(powerToDo.getPowerState_Enum())
            {
                case ON:
                    responseCode = device.switchOn();
                    break;
                case OFF:
                    responseCode = device.switchOff();
                    break;
            }
        }
        else
            responseCode = new MessageBean(false);

        return responseCode;
    }

    @Override
    public MessageBean undo() throws RemoteException{
        MessageBean responseCode = null;

        //check if current status is as expected, do operation
        if(oldState == requiredStatus) {
            switch(powerToDo.getPowerState_Enum())
            {
                case ON:
                    responseCode = device.switchOff();
                    break;
                case OFF:
                    responseCode = device.switchOn();
                    break;
            }
        }

        return responseCode;
    }
}
