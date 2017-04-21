package de.thm.smarthome.global.observer;

import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.adapter.IHeating;

import java.util.List;

/**
 * Created by Nils on 21.04.2017.
 */
public abstract class AHeatingObservable {
    private List<IHeatingObserver> attachedObservers;

    public void attach(IHeatingObserver observer){
        attachedObservers.add(observer);
    }

    public void detach(IHeatingObserver observer){
        attachedObservers.remove(observer);
    }

    public void notifyObservers(HeatingTransferObject change){
        for (IHeatingObserver element:attachedObservers) {
            element.updateMeWithNewHeatingData(change);
        }
    }
}
