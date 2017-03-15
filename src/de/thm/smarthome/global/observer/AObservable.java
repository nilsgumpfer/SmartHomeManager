package de.thm.smarthome.global.observer;

import java.util.List;

/**
 * Created by Nils on 28.01.2017.
 */
public abstract class AObservable {
    private List<IObserver> attachedObservers;

    public void attach(IObserver observer){
        attachedObservers.add(observer);
    }

    public void detach(IObserver observer){
        attachedObservers.remove(observer);
    }

    public void notifyObservers(Object change){
        for (IObserver element:attachedObservers) {
            element.update(this,change);
        }
    }
}
