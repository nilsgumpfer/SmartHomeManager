package de.electriccompany.driver.thermometer;

import ThermometerServer.interfaces.ThermometerClientInterface;
import ThermometerServer.interfaces.ThermometerServerInterface;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EModelVariant;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Nils on 27.01.2017.
 */
public class IndoorThermometerDriver extends AObservable implements ThermometerClientInterface, IObserver
{
    private ThermometerServerInterface deviceServer;

    private ModelVariantBean modelVariant;
    private String genericName;
    private String serialnumber;
    private String hostname;

    public IndoorThermometerDriver(String serialnumber, String genericName, ModelVariantBean modelVariantBean)
    {
        this.serialnumber   = serialnumber;
        this.genericName    = genericName;
        this.modelVariant = modelVariantBean;

        //hostname = "192.168.100.106";
        readModelVariantInformation();

        initConnection();
    }

    private void readModelVariantInformation() {

        switch (modelVariant.getModelVariant_Enum()){
            case  Thermometer3000:
                hostname = modelVariant.getModelVariant_String();
                break;
        }
    }

    private void initConnection()
    {
        //TODO: get IP Address for host-name
        //String host = modelVariant;
        int port    = 0;

        try {

            SmartHomeLogger.log("Looking for Electric Company Thermometer: " + modelVariant + "..");

            LocateRegistry.getRegistry(hostname, port);

            SmartHomeLogger.log("Found thermometer: " + hostname + ":" + port + "Establishing connection..");

            UnicastRemoteObject.exportObject(this, 0);

            Remote remoteObject = Naming.lookup("//" + hostname + "/" + "SmartHomeAPI");

            SmartHomeLogger.log("Successfully connected.");

            deviceServer = (ThermometerServerInterface) remoteObject;

            deviceServer.setGenericName(genericName);

            deviceServer.attach(this);
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
        }
    }

    public ModelVariantBean getModelVariant(){
        try {
            return deviceServer.getModelVariant();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new ModelVariantBean(EModelVariant.NA);
        }
    }

    public MeasureBean getTemperature(){
        try {
            return deviceServer.getTemperature();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new MeasureBean(0.0, EUnitOfMeasurement.NA);
        }

        }

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("IndoorThermometerDriver: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);

    }

}
