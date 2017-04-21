package de.thm.smarthome.global.observer;

import de.thm.smarthome.global.transfer.WeatherStationTransferObject;

/**
 * Created by Nils on 21.04.2017.
 */
public interface IWeatherstationObserver {
    void updateMeWithNewWeatherstationData(WeatherStationTransferObject weatherStationTransferObject);
}
