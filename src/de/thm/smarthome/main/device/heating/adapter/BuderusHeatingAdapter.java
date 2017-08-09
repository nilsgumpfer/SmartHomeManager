package de.thm.smarthome.main.device.heating.adapter;

//Die Verbindung zwischen dem physischen Gerät und der Logik stellt der Treiber her
import de.buderus.driver.heating.BuderusHeatingDriver;
import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;


/**
 * Created on 27.01.2017.
 * Changed 28.01.2017
 * Die Verbindung (zwischen Gerät und der Logik, die der Treiber herstellt) werden für Standardisierungszwecke im Adapter
 * gekapselt
 *
 */
//Die die Daten bereitstellende Klasse, wird erweitert um die Klasse Observable.
    //Implementierung der Schnittstellen zu IHeating und IObserver notwendig,
public class BuderusHeatingAdapter extends AObservable implements IHeating, IObserver
{
    ///Übergabe damit der Adapter weiß mit welcher Heizung er sich verbinden muss
    private BuderusHeatingDriver driver;
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.BUDERUS);

    public BuderusHeatingAdapter(BuderusHeatingDriver driver) {
        this.driver = driver;

        //Adpater meldet sich bei Treiber als Observer an/wird gestartet
        this.driver.attach(this);
    }

    @Override
    public void update(Object o, Object change) { //Wird bei Benachrichtigungen vom Observable o (Object O) aufgerufen
        SmartHomeLogger.log("BuderusHeatingAdapter: Detected a change! [" + o.toString() + "]");
        notifyObservers(change); // Informiert Observer über Änderung
    }


    //SETTER//

    //Mit dem Aktualisierbarer (Adapter) werden diese Setz-Möglichkeiten überwacht.
    // In jeder seiner Set-Methoden wird ein Attribut-Änderungs-Event ausgelöst.

    @Override
    public MessageBean setDesiredTemperature(MeasureBean temperature) {
        return driver.setDesiredTemperature(temperature);
    }

    @Override
    public MessageBean setPowerState(PowerStateBean powerState) {
        return driver.setPowerState(powerState);
    }

    //GETTER//

    @Override
    public MeasureBean getCurrentTemperature() {
        return driver.getCurrentTemperature();
    }

    @Override
    public MeasureBean getDesiredTemperature() {
        return driver.getDesiredTemperature();
    }

    @Override
    public ModelVariantBean getModelVariant() {
        return driver.getModelVariant();
    }

    @Override
    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    @Override
    public PowerStateBean getPowerState() {
        return driver.getPowerState();
    }

}
