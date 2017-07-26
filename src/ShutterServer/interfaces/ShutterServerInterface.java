package ShutterServer.interfaces;

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
    void setGenericName(String genericName);

    PositionBean getCurrentPosition() throws RemoteException;

    PositionBean getDesiredPosition() throws RemoteException;

    ModelVariantBean getModelVariant () throws RemoteException;

    PositionBean setDesiredPosition(PositionBean new_desiredPosition) throws RemoteException;


}
