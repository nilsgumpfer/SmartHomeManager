package ShutterServer.interfaces;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.observer.AObservable;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Tim on 07.04.2017.
 */
public interface ShutterServerInterface extends Remote
{

    void setDesiredPosition(PositionBean new_desiredPosition) throws RemoteException;
    void setGenericName(String new_genericName) throws RemoteException;
    PositionBean getCurrentPosition() throws RemoteException;
    PositionBean getDesiredPosition() throws RemoteException;
    ModelVariantBean getModelVariant() throws RemoteException;
    ManufacturerBean getManufacturer() throws RemoteException;
    ActionModeBean getActionMode() throws RemoteException;
    String getGenericName() throws RemoteException;
    String getSerialNumber() throws RemoteException;

    /*void setGenericName(String genericName);

    PositionBean getCurrentPosition() throws RemoteException;

    PositionBean getDesiredPosition() throws RemoteException;

    ModelVariantBean getModelVariant () throws RemoteException;

    PositionBean setDesiredPosition(PositionBean new_desiredPosition) throws RemoteException;*/


}
