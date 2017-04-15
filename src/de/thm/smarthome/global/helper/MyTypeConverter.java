package de.thm.smarthome.global.helper;

import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 15.04.2017.
 */
public class MyTypeConverter {
    private static MyTypeConverter ourInstance = new MyTypeConverter();

    public static MyTypeConverter getInstance() {
        return ourInstance;
    }

    private MyTypeConverter() {

    }

    public static List<IUpAndDownMovableDevice> convertDeviceList(List<SmartShutter> input)
    {
        List<IUpAndDownMovableDevice> output = new ArrayList<>();

        for (SmartShutter item : input) {
            output.add(item);
        }

        return output;
    }


}
