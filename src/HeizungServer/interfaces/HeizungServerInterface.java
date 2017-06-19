package HeizungServer.interfaces;



import java.rmi.Remote;

/**
 * Created by Tim on 07.04.2017.
 */
public interface HeizungServerInterface extends Remote
{
    void setGenericName(String genericName);
    boolean setDesiredTemperature(double desiredTemperature);
    boolean setPowerState(boolean powerState);
    double getCurrentTemperature();
    double getDesiredTemperature();
    boolean getPowerState();
}
