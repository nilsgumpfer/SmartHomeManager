package de.thm.smarthome.global.observer;

import de.thm.smarthome.global.transfer.WeatherStationTransferObject;

import java.util.List;

/**
 * Created by Nils on 21.04.2017.
 */
public abstract class AWeaterstationObservable {
    private List<IWeatherstationObserver> attachedObservers;

    public void attach(IWeatherstationObserver observer){
        attachedObservers.add(observer);
    }

    public void detach(IWeatherstationObserver observer){
        attachedObservers.remove(observer);
    }

    public void notifyObservers(WeatherStationTransferObject change){
        for (IWeatherstationObserver element:attachedObservers) {
            element.updateMeWithNewWeatherstationData(change);
        }
    }
}
