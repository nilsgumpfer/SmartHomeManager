package de.thm.smarthome.main.manager.controller.eventmanager;

import de.thm.smarthome.global.observer.AObservable;

/**
 * Created by Nils on 05.02.2017.
 */
public class EventManager implements IEventManager {
    private static EventManager ourInstance = new EventManager();

    private EventManager(){}

    public static EventManager getInstance() {
        return ourInstance;
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
