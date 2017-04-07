package de.thm.smarthome.global.interfaces;

import de.thm.smarthome.global.observer.AObservable;

import java.rmi.Remote;

/**
 * Created by Tim on 07.04.2017.
 */
public interface ShutterServerInterface extends Remote {
    public void moveUp(ShutterClientInterface c);
    public void moveDown(ShutterClientInterface c));
    public boolean isUp(ShutterClientInterface c);
    public boolean isDown(ShutterClientInterface c);
    public string getName(ShutterClientInterface c);
    public void update(AObservable o, Object change, ShutterClientInterface c);
}
