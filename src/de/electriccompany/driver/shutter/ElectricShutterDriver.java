package de.electriccompany.driver.shutter;

import ShutterServer.interfaces.ShutterClientInterface;
import ShutterServer.interfaces.ShutterServerInterface;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.enumeration.EModelVariant;
import de.thm.smarthome.global.enumeration.EPosition;
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
public class ElectricShutterDriver extends AObservable implements ShutterClientInterface, IObserver {
    private ShutterServerInterface deviceServer;

    //TODO: Modelvariant besprechen
    private ModelVariantBean modelVariant;
    private String genericName;
    private String serialnumber;
    private String hostname;

    public ElectricShutterDriver(String serialnumber, String genericName, ModelVariantBean modelVariantBean)
    {
        this.serialnumber   = serialnumber;
        this.genericName    = genericName;
        this.modelVariant = modelVariantBean;

        readModelVariantInformation();

        initConnection();
    }
    /* private void readModelVariantInformation() {
        //TODO: Switch-Case o.Ä. zur Ermittlung des Modells
        modelVariant = "Shutter3000";
    }*/


    private void readModelVariantInformation() {
        switch (modelVariant.getModelVariant_Enum()){
            case  Shutter3000:
                hostname = modelVariant.getModelVariant_String();
                break;
            case  Shutter2000:
                hostname = modelVariant.getModelVariant_String();
                break;
            case  Shutter1000:
                hostname = modelVariant.getModelVariant_String();
                break;
        }}

    private void initConnection()
    {
        //TODO: get IP Address for host-name
        /*String host = modelVariant;*/
        int port    = 0;

        try {

            SmartHomeLogger.log("Looking for Electric Company Shutter: " + modelVariant + "..");

            LocateRegistry.getRegistry(hostname, port);

            SmartHomeLogger.log("Found shutter: " + hostname + ":" + port + "Establishing connection..");

            UnicastRemoteObject.exportObject(this, 0);

            Remote remoteObject = Naming.lookup("//" + hostname + "/" + "SmartHomeAPI");

            SmartHomeLogger.log("Successfully connected.");

            deviceServer = (ShutterServerInterface) remoteObject;

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


    public PositionBean getCurrentPosition() {
        try {
            return deviceServer.getCurrentPosition();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new PositionBean(EPosition.NA); //TODO: Maßeinheit fehlt
        }
    }

    public PositionBean getDesiredPosition() {
        try {
            return deviceServer.getDesiredPosition();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new PositionBean(EPosition.NA);
        }
    }
   /* public int getCurrentPosition() {
        return deviceServer.getCurrentPosition();
    }

    public int getDesiredPosition() {
        return deviceServer.getDesiredPosition();
    }*/

    public MessageBean setDesiredPosition(PositionBean new_desiredPosition) {
        try {
            deviceServer.setDesiredPosition(new_desiredPosition);
            return new MessageBean(true);
        }
        catch(RemoteException rex){
            SmartHomeLogger.log(rex);
            return new MessageBean(false);
        }
    }

    /*public boolean setDesiredPosition(int desiredPosition)
    {
        return deviceServer.setDesiredPosition(desiredPosition);
    }*/

    /*public static void main(String[] args) {
        ElectricShutterDriver ed = new ElectricShutterDriver("12345", "ShutterTest");
        System.out.println(String.valueOf(ed.getCurrentPosition().getPosition_Int()));
        ed.setDesiredPosition(new PositionBean(EPosition.P1));

    }*/

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("ElectricShutterDriver: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
    }
}

