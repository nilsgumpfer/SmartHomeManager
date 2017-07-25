package HeizungServer.interfaces;



import de.thm.smarthome.global.beans.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Tim on 07.04.2017.
 */
public interface HeizungServerInterface extends Remote
{
    /*void setGenericName(String genericName);
    MeasureBean setDesiredTemperature(double desiredTemperature);
    PowerStateBean setPowerState(boolean powerState);
    MeasureBean getCurrentTemperature();
    MeasureBean getDesiredTemperature();
    PowerStateBean getPowerState();
    ModelVariantBean getModelVariant();*/

    void setGenericName(String new_genericName) throws RemoteException;
    void setDesiredTemperature(MeasureBean new_desiredTemperature) throws RemoteException;
    void setPowerState(PowerStateBean new_powerState) throws RemoteException;
    MeasureBean getCurrentTemperature() throws RemoteException;
    MeasureBean getDesiredTemperature() throws RemoteException;
    ManufacturerBean getManufacturer() throws RemoteException;
    ActionModeBean getActionMode() throws RemoteException;
    PowerStateBean getPowerState() throws RemoteException;
    ModelVariantBean getModelVariant() throws RemoteException;
    String getGenericName() throws RemoteException;
    String getSerialNumber() throws RemoteException;
}
