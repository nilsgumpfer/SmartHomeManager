package de.thm.smarthome.main.manager.controller.commandmanager;

import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.interfaces.IPositionRelevantDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.global.transfer.ShutterTransferObject;

/**
 * Created by Nils on 05.02.2017.
 */
public interface ICommandManager {
    EMessageCode undoLastCommand();

    EMessageCode addSetTemperatureCommand(HeatingTransferObject heatingTransferObject);
    EMessageCode addSetTemperatureCommand(ITemperatureRelevantDevice temperatureRelevantDevice, double temperature);

    EMessageCode addMoveUpCommand();
    EMessageCode addMoveDownCommand();
    EMessageCode addMoveUpCommand(ShutterTransferObject shutterTransferObject);
    EMessageCode addMoveDownCommand(ShutterTransferObject shutterTransferObject);
    EMessageCode addMoveUpCommand(IUpAndDownMovableDevice upAndDownMovableDevice);
    EMessageCode addMoveDownCommand(IUpAndDownMovableDevice upAndDownMovableDevice);

    EMessageCode addSetPositionCommand(IPositionRelevantDevice positionRelevantDevice, int position);

    EMessageCode addSwitchOnCommand(HeatingTransferObject heatingTransferObject);
    EMessageCode addSwitchOffCommand(HeatingTransferObject heatingTransferObject);
    EMessageCode addSwitchOnCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice);
    EMessageCode addSwitchOffCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice);
}
