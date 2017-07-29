package de.thm.smarthome.main.manager.controller.commandmanager;

import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.interfaces.IPositionRelevantDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;

/**
 * Created by Nils on 05.02.2017.
 */
public interface ICommandManager {
    MessageBean undoLastCommand();

    MessageBean addSetTemperatureCommand(ITemperatureRelevantDevice temperatureRelevantDevice, MeasureBean temperature);

    MessageBean addMoveUpCommand();
    MessageBean addMoveDownCommand();
    MessageBean addMoveUpCommand(IUpAndDownMovableDevice upAndDownMovableDevice);
    MessageBean addMoveDownCommand(IUpAndDownMovableDevice upAndDownMovableDevice);

    MessageBean addSetPositionCommand(IPositionRelevantDevice positionRelevantDevice, PositionBean position);

    MessageBean addSwitchOnCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice);
    MessageBean addSwitchOffCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice);
}
