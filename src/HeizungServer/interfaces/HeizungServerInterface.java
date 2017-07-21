package HeizungServer.interfaces;



import de.thm.smarthome.global.beans.*;

import java.rmi.Remote;

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

    void setGenericName(String genericName);
    MeasureBean setDesiredTemperature(double desiredTemperature);
    PowerStateBean setPowerState(boolean powerState);
    MeasureBean getCurrentTemperature();
    MeasureBean getDesiredTemperature();
    ManufacturerBean getManufacturer();
    ActionModeBean getActionMode();
    PowerStateBean getPowerState();
    ModelVariantBean getModelVariant();
    String getGenericName();
    String getSerialNumber();
}
