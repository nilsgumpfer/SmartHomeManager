package de.conrad.driver.weatherstation;

import WeatherStationServer.interfaces.WeatherStationClientInterface;
import WeatherStationServer.interfaces.WeatherStationServerInterface;

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
public class ConradWeatherStationDriver implements WeatherStationClientInterface {
    private String serialnumber;
    private double temperature;
    private double windVelocity;
    private double airPressure;
    private double rainfallAmount;
    public WeatherStationServerInterface server;

    public ConradWeatherStationDriver(String productSerialNumber, String wetterstationIP, String wetterstationname) {

        //TODO: Invoke command remotely at station!
        this.serialnumber = productSerialNumber;
        this.temperature = 6.58;
        this.windVelocity = 33.5;
        this.airPressure = 1203.44;
        this.rainfallAmount = 30.1;
        try {

            LocateRegistry.getRegistry(wetterstationIP);

            UnicastRemoteObject.exportObject(this, 0);

            Remote ro = Naming.lookup("//" + wetterstationIP + "/" + wetterstationname);
            System.out.print("Look up done.. trying to communicate \n \n");

            server = (WeatherStationServerInterface) ro;


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getWeatherStationName() {
        return null;
    }

    public String getWeatherStationManufacturer() {
        return null;
    }

    public String getWeatherStationModel() {
        return null;
    }

    public String getWeatherStationSerialnumber() {
        return null;
    }

    public double getTemperature() throws RemoteException {

        return server.getTemperature(this);
    }

    public double getWindVelocity() throws RemoteException {


        return server.getWindVelocity(this);
    }

    public double getAirPressure() throws RemoteException {


        return server.getAirPressure(this);
    }

    public double getRainfallAmount() throws RemoteException {


        return server.getRainfallAmount(this);
    }

    /*public static void main(String args[]) throws RemoteException {
        ConradWeatherStationDriver bd = new ConradWeatherStationDriver("1234", "192.168.100.106", "Test");
        System.out.print(bd.getAirPressure() + "\n");
        System.out.print(bd.getRainfallAmount() +"\n" );
        System.out.print(bd.getTemperature() +"\n");
    }*/
}
