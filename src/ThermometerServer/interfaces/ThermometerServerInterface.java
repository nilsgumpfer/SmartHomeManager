package ThermometerServer.interfaces;

import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.observer.AObservable;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Tim on 07.04.2017.
 */
public interface ThermometerServerInterface extends Remote {
    void setGenericName(String genericName);
    double getTemperature();
}
