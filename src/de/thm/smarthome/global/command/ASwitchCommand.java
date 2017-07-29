package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PowerStateBean;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;

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
    public MessageBean invoke(){
        //before new state is set, save old one for possible undo-operation
        oldState = device.currentState();

        //check if current status is as expected, do operation
        if(oldState == expectedStatus) {
            try
            {
                switch (powerToDo.getPowerState_Enum()) {
                    case ON:
                        return device.switchOn();
                    case OFF:
                        return device.switchOff();
                    default:
                        return new MessageBean(false);
                }
            }
            catch (Exception e)
            {
                SmartHomeLogger.log(e);
                return new MessageBean(false);
            }
        }
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean undo(){
        //check if current status is as expected, do operation
        if(oldState == requiredStatus) {
            try
            {
                switch (powerToDo.getPowerState_Enum()) {
                    case ON:
                        return device.switchOff();
                    case OFF:
                        return device.switchOn();
                    default:
                        return new MessageBean(false);
                }
            }
            catch (Exception e)
            {
                SmartHomeLogger.log(e);
                return new MessageBean(false);
            }
        }
        else
            return new MessageBean(false);
    }
}
