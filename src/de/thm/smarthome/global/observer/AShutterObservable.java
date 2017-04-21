package de.thm.smarthome.global.observer;

import de.thm.smarthome.global.transfer.ShutterTransferObject;

import java.util.List;

/**
 * Created by Nils on 21.04.2017.
 */
public class AShutterObservable {
    private List<IShutterObserver> attachedObservers;

    public void attach(IShutterObserver observer){
        attachedObservers.add(observer);
    }

    public void detach(IShutterObserver observer){
        attachedObservers.remove(observer);
    }

    public void notifyObservers(ShutterTransferObject change){
        for (IShutterObserver element:attachedObservers) {
            element.updateMeWithNewShutterData(change);
        }
    }
}
