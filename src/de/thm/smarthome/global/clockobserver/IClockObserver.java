package de.thm.smarthome.global.clockobserver;

import java.util.List;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IClockObserver {
    public void update(AClockObservable o, Object change);
}
