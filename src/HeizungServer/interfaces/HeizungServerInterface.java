package HeizungServer.interfaces;



import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.observer.IObserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created on 07.04.2017.
 */

    //Zeigt Client welche Methoden Server zur Verfügung stellt

public interface HeizungServerInterface extends Remote
    //Erweiterung der eigenen Schnittstelle um die Schnittstelle Remote.
        // Durch Remote können entfernte Methoden angeboten werden; dient hier als Markierungsschnittelstelle da leer
        //Die angebotenen Methoden können unbeabsichtigte Fehler auslösen, weshalb für jede Methode RemoteException in
        // einer throws-Anweisung aufzuführen sind

{
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

        //Observer anmelden
    void attach(Object observer);
}
