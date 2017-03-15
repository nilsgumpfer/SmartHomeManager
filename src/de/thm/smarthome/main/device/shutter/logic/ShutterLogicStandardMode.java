package de.thm.smarthome.main.device.shutter.logic;

import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class ShutterLogicStandardMode implements IShutterLogic {
    private IShutterModel model;
    private IShutter device;

    public ShutterLogicStandardMode(IShutterModel model, IShutter device){}

    @Override
    public int moveUp() {
        return 0;
    }

    @Override
    public int moveDown() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}
