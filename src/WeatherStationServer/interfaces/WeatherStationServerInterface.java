package WeatherStationServer.interfaces;

import de.thm.smarthome.global.observer.AObservable;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Tim on 07.04.2017.
 */
public interface WeatherStationServerInterface extends Remote
{
    double getWindVelocity();
    double getRainfallAmount();
    double getAirHumidity();
    double getAirPressure();
    double getTemperature();
    void setGenericName(String genericName);
}
