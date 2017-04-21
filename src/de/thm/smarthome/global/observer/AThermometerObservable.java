package de.thm.smarthome.global.observer;

import de.thm.smarthome.global.transfer.ThermometerTransferObject;

import java.util.List;

/**
 * Created by Nils on 21.04.2017.
 */
public abstract class AThermometerObservable {
    private List<IThermometerObserver> attachedObservers;

    public void attach(IThermometerObserver observer){
        attachedObservers.add(observer);
    }

    public void detach(IThermometerObserver observer){
        attachedObservers.remove(observer);
    }

    public void notifyObservers(ThermometerTransferObject change){
        for (IThermometerObserver element:attachedObservers) {
            element.updateMeWithNewThermometerData(change);
        }
    }
}
