package de.thm.smarthome.main.device.heating.device;

import UI.Controller;
import de.thm.smarthome.global.observer.AClockObservable;
import de.thm.smarthome.global.observer.IClockObserver;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.heating.model.HeatingModel;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
 public class SmartHeating extends AObservable implements ITemperatureRelevantDevice, ISmartDevice, IObserver, IOnAndOffSwitchableDevice, IClockObserver {
    private IHeatingLogic logic;
    private HeatingModel heatingModel = new HeatingModel();
    private EMessageCode currentState = null;

    public SmartHeating(IHeatingLogic logic) {
        this.logic = logic;
        Controller controller = new Controller();
        controller.attach(this);
    }

    @Override
    public EMessageCode setTemperature(double temperature) throws RemoteException{
        return logic.setTemperature(temperature);
    }

    @Override
    public double getTemperature() throws RemoteException{
        return logic.getTemperature();
    }

    @Override
    public String getName() {
        return null;
    }


    @Override
    public void update(AObservable o, Object change) {

    }

    @Override
    public EMessageCode switchOn(){
        try {
            return logic.switchOn();
        }
        catch (Exception e)
        {
            return EMessageCode.SwitchOnFailed;
        }
/*
        currentState = ResponseCode.SwitchedOn;
        return ResponseCode.SwitchedOn;*/
    }

    @Override
    public EMessageCode switchOff(){
        try {
            return logic.switchOn();
        }
        catch (Exception e)
        {
            return EMessageCode.SwitchOnFailed;
        }
/*
        currentState = ResponseCode.SwitchedOff;
        return ResponseCode.AlreadySwitchedOff;*/
    }
    @Override
    public EMessageCode currentState(){
        return currentState;
    }

    @Override
    public void update(AClockObservable o, Object change) {
        if(change=="nightmode"){
            heatingModel.setTemperature(18);
        }else{
            //Daymode
            heatingModel.setTemperature(21);
        }
    }

    public HeatingTransferObject getHeatingData() throws RemoteException {
        return logic.getHeatingData();
    }
}
