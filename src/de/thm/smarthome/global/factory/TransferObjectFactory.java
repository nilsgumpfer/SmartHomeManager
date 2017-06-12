package de.thm.smarthome.global.factory;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.observer.IWeatherstationObserver;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.global.transfer.WeatherStationTransferObject;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;
import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.weatherstation.adapter.IWeatherStation;

/**
 * Created by Nils on 12.06.2017.
 */
public class TransferObjectFactory {
    public static HeatingTransferObject getHeatingTransferObject(IHeatingModel heatingModel)
    {
        return new HeatingTransferObject(
                                            heatingModel.getCurrentTemperature(),
                                            heatingModel.getDesiredTemperature(),
                                            heatingModel.getModelVariant(),
                                            heatingModel.getManufacturer(),
                                            heatingModel.getActionMode(),
                                            heatingModel.getGenericName(),
                                            heatingModel.getSerialnumber(),
                                            heatingModel.getPowerState()
                                        );
    }

    public static HeatingTransferObject getHeatingTransferObject(IHeatingModel heatingModel, EMessageCode messageCode)
    {
        HeatingTransferObject heatingTransferObject = getHeatingTransferObject(heatingModel);
        heatingTransferObject.setMessageBean(new MessageBean(messageCode));

        return heatingTransferObject;
    }

    public static ShutterTransferObject getShutterTransferObject(IShutter shutter)
    {
        return new ShutterTransferObject(

                                        );

    }

    public static ThermometerTransferObject getThermometerTransferObject(IThermometer thermometer){
        return new ThermometerTransferObject(

                                            );
    }

    public static WeatherStationTransferObject getWeatherStationTransferObject(IWeatherStation weatherStation){
        return new WeatherStationTransferObject(

                                                );
    }
}
