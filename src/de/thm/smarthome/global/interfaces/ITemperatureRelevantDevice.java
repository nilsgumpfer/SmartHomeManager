package de.thm.smarthome.global.interfaces;


import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;

/**
 * Created by Nils on 28.01.2017.
 */
public interface ITemperatureRelevantDevice {
    MessageBean setTemperature(MeasureBean temperature);
    MeasureBean getTemperature();
}
