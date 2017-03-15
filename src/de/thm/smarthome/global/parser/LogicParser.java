package de.thm.smarthome.global.parser;

import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.shutter.logic.IShutterLogic;
import de.thm.smarthome.main.device.thermometer.logic.IThermometerLogic;
import de.thm.smarthome.main.device.weatherstation.logic.IWeatherStationLogic;

/**
 * Created by Nils on 04.02.2017.
 */
public class LogicParser {
    void parse(IHeatingLogic logic){}
    void parse(IWeatherStationLogic logic){}
    void parse(IShutterLogic logic){}
    void parse(IThermometerLogic logic){}
}
