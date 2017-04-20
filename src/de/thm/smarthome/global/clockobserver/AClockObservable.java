package de.thm.smarthome.global.clockobserver;

import java.util.List;

/**
 * Created by Nils on 28.01.2017.
 */
public abstract class AClockObservable {
    private List<IClockObserver> attachedClockObservers;

    public void attach(IClockObserver observer){
        attachedClockObservers.add(observer);
    }

    public void detach(IClockObserver observer){
        attachedClockObservers.remove(observer);
    }

    public void notifyObservers(Object change){
        for (IClockObserver element:attachedClockObservers) {
            element.update(this,change);
        }
    }
}
