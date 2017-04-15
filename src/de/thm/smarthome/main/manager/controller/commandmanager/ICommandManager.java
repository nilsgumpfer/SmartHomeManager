package de.thm.smarthome.main.manager.controller.commandmanager;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.global.transfer.ShutterTransferObject;

/**
 * Created by Nils on 05.02.2017.
 */
public interface ICommandManager {
    ResponseCode undoLastCommand();

    ResponseCode addSetTemperatureCommand(HeatingTransferObject heatingTransferObject);
    ResponseCode addSetTemperatureCommand(ITemperatureRelevantDevice temperatureRelevantDevice, double temperature);

    ResponseCode addMoveUpCommand();
    ResponseCode addMoveDownCommand();
    ResponseCode addMoveUpCommand(ShutterTransferObject shutterTransferObject);
    ResponseCode addMoveDownCommand(ShutterTransferObject shutterTransferObject);
    ResponseCode addMoveUpCommand(IUpAndDownMovableDevice upAndDownMovableDevice);
    ResponseCode addMoveDownCommand(IUpAndDownMovableDevice upAndDownMovableDevice);

    ResponseCode addSwitchOnCommand(HeatingTransferObject heatingTransferObject);
    ResponseCode addSwitchOffCommand(HeatingTransferObject heatingTransferObject);
    ResponseCode addSwitchOnCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice);
    ResponseCode addSwitchOffCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice);
}
