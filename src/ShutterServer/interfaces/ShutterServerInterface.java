package ShutterServer.interfaces;

import de.thm.smarthome.global.observer.AObservable;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Tim on 07.04.2017.
 */
public interface ShutterServerInterface extends Remote
{
    void setGenericName(String genericName);

    int getCurrentPosition();

    int getDesiredPosition();

    boolean setDesiredPosition(int desiredPosition);
}
