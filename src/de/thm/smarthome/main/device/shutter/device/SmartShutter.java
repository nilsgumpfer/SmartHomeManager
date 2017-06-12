package de.thm.smarthome.main.device.shutter.device;

import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.interfaces.IPositionRelevantDevice;
import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.main.device.shutter.logic.IShutterLogic;
import de.thm.smarthome.main.device.shutter.model.ShutterModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartShutter extends AObservable implements ISmartDevice, IObserver, IUpAndDownMovableDevice, IPositionRelevantDevice{
    private IShutterLogic logic;
    private String logicName = "";
    private ShutterModel shutterModel = new ShutterModel();


    private SmartShutter(IShutterLogic logic) {
        this.logic = logic;
    }

    public EMessageCode moveUp() {
        logic.moveUp();
        //return null;
        return EMessageCode.MoveUpFailed;
    }
    @Override
    public EMessageCode moveDown() {
        logic.moveDown();
        //TODO: Anpassen!
        return EMessageCode.MoveDownFailed;
    }
    @Override
    public boolean isUp(){
        return shutterModel.isUp();
    }
    @Override
    public boolean isDown(){
        return shutterModel.isDown();
    }

    public String getLogicName() {
        return shutterModel.getLogicName();
    }

    @Override
    public String getName() {
        return shutterModel.getShutterName();
    }
    @Override
    public void update(AObservable o, Object change) {

    }

    public int getPosition() {
        //TODO: logic getter setter
        //return logic.getPosition();
        return 0;
    }

    @Override
    public EMessageCode setPosition(int position) {
        //TODO: anpassen!
        return EMessageCode.MoveToPositionFailed;
    }

    public EMessageCode setPosition(ShutterTransferObject shutterTransferObject) {
        //TODO: Anpassen!
        return EMessageCode.MoveToPositionFailed;
    }



    public ShutterTransferObject getShutterData() {
        return logic.getShutterData();
    }
}
