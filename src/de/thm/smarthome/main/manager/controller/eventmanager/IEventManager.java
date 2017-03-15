package de.thm.smarthome.main.manager.controller.eventmanager;

import de.thm.smarthome.global.observer.AObservable;

/**
 * Created by Nils on 05.02.2017.
 */
public interface IEventManager {
    public void update(AObservable o, Object change);
}
