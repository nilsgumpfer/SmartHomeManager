package de.conrad.driver.weatherstation;

import de.thm.smarthome.global.interfaces.WeatherStationClientInterface;
import de.thm.smarthome.global.interfaces.WeatherStationServerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Nils on 27.01.2017.
 */
public class ConradWeatherStationDriver implements WeatherStationClientInterface{
    private String serialnumber;
    private double temperature;
    private double windVelocity;
    private double airPressure;
    private double rainfallAmount;

    public ConradWeatherStationDriver(String productSerialNumber){

        //TODO: Invoke command remotely at station!
        this.serialnumber = productSerialNumber;
        this.temperature = 6.58;
        this.windVelocity = 33.5;
        this.airPressure = 1203.44;
        this.rainfallAmount = 30.1;
    }

    public double getTemperature(){

        //TODO: Invoke command remotely at station!
        return temperature;
    };

    public double getWindVelocity() {

        //TODO: Invoke command remotely at station!
        return windVelocity;
    }

    public double getAirPressure() {

        //TODO: Invoke command remotely at station!
        return airPressure;
    }

    public double getRainfallAmount() {

        //TODO: Invoke command remotely at station!
        return rainfallAmount;
    }

    public void startClient(String wetterstationIP, String wetterstationname){
        try{

            LocateRegistry.getRegistry(wetterstationIP);

            UnicastRemoteObject.exportObject(this,0);

            Remote ro = Naming.lookup("//"+wetterstationIP+"/"+wetterstationname);
            System.out.print("Look up done.. trying to communicate \n \n");

            WeatherStationServerInterface server = (WeatherStationServerInterface) ro;


        } catch (RemoteException e) {
            e.printStackTrace();
        }

        catch (NotBoundException e) {
            e.printStackTrace();
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
