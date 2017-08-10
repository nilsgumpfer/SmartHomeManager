package de.thm.smarthome.global.connection.wsprovider;

import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.interfaces.IServiceFacade;
import de.thm.smarthome.global.transfer.*;
import de.thm.smarthome.main.manager.controller.requestmanager.RequestManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ws")
public class SmartHomeManagerWebServiceDescriptor implements IServiceFacade
{
    private IServiceFacade requestManager = RequestManager.getInstance();

    public SmartHomeManagerWebServiceDescriptor(){
    }

    @GET @Path( "info" ) @Produces( MediaType.TEXT_PLAIN )
    public String getServerInfo() {
        return requestManager.getServerInfo();
    }

    @GET @Path( "createHeating/requesting_user/{requesting_user}/modelVariant/{modelVariant}/manufacturer/{manufacturer}/genericName/{genericName}/serialnumber/{serialnumber}") @Produces( MediaType.APPLICATION_JSON )
    public MessageBean createHeating( @PathParam( "requesting_user" ) String requesting_user,
                                      @PathParam( "modelVariant" ) String modelVariant,
                                      @PathParam( "manufacturer" ) String manufacturer,
                                      @PathParam( "genericName" ) String genericName,
                                      @PathParam( "serialnumber" ) String serialnumber ) {
        //return requestManager.createHeating(requesting_user, modelVariant, manufacturer, genericName, serialnumber);
        return requestManager.createHeating(requesting_user, "Heizung2000X2", "Viessmann", "MyHeating", "243242");
    }

    @GET @Path( "deleteHeating/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean deleteHeating(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.deleteHeating(requesting_user);
    }

    @GET @Path( "switchHeatingOn/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean switchHeatingOn(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.switchHeatingOn(requesting_user);
    }

    @GET @Path( "switchHeatingOff/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean switchHeatingOff(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.switchHeatingOff(requesting_user);
    }

    @GET @Path( "setHeatingTemperature/requesting_user/{requesting_user}/temperature/{temperature}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean setHeatingTemperature(@PathParam( "requesting_user" ) String requesting_user, @PathParam( "temperature" ) double temperature) {
        return requestManager.setHeatingTemperature(requesting_user, temperature);
    }

    @GET @Path( "getHeatingTemperature/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MeasureBean getHeatingTemperature(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getHeatingTemperature(requesting_user);
    }

    @GET @Path( "getHeatingData/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public HeatingTransferObject getHeatingData(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getHeatingData(requesting_user);
    }

    @GET @Path( "createShutter/requesting_user/{requesting_user}/modelVariant/{modelVariant}/manufacturer/{manufacturer}/genericName/{genericName}/serialnumber/{serialnumber}") @Produces( MediaType.APPLICATION_JSON )
    public MessageBean createShutter( @PathParam( "requesting_user" ) String requesting_user,
                                      @PathParam( "modelVariant" ) String modelVariant,
                                      @PathParam( "manufacturer" ) String manufacturer,
                                      @PathParam( "genericName" ) String genericName,
                                      @PathParam( "serialnumber" ) String serialnumber ) {
        return requestManager.createShutter(requesting_user, modelVariant, manufacturer, genericName, serialnumber);
    }

    @GET @Path( "deleteShutter/requesting_user/{requesting_user}/serialnumber/{serialnumber}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean deleteShutter(@PathParam( "requesting_user" ) String requesting_user, @PathParam( "serialnumber" ) String serialnumber) {
        return requestManager.deleteShutter(requesting_user, serialnumber);
    }

    @GET @Path( "moveAllShuttersUp/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean moveAllShuttersUp(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.moveAllShuttersUp(requesting_user);
    }

    @GET @Path( "moveAllShuttersDown/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean moveAllShuttersDown(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.moveAllShuttersDown(requesting_user);
    }

    @GET @Path( "moveShutterUp/requesting_user/{requesting_user}/serialnumber/{serialnumber}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean moveShutterUp(@PathParam( "requesting_user" ) String requesting_user, @PathParam( "serialnumber" ) String serialnumber) {
        return requestManager.moveShutterUp(requesting_user, serialnumber);
    }

    @GET @Path( "moveShutterDown/requesting_user/{requesting_user}/serialnumber/{serialnumber}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean moveShutterDown(@PathParam( "requesting_user" ) String requesting_user, @PathParam( "serialnumber" ) String serialnumber) {
        return requestManager.moveShutterDown(requesting_user, serialnumber);
    }

    @GET @Path( "getShutterPosition/requesting_user/{requesting_user}/serialnumber/{serialnumber}" ) @Produces( MediaType.APPLICATION_JSON )
    public PositionBean getShutterPosition(@PathParam( "requesting_user" ) String requesting_user, @PathParam( "serialnumber" ) String serialnumber) {
        return requestManager.getShutterPosition(requesting_user, serialnumber);
    }

    @GET @Path( "setShutterPosition/requesting_user/{requesting_user}/serialnumber/{serialnumber}/position/{position}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean setShutterPosition(@PathParam( "requesting_user" ) String requesting_user, @PathParam( "serialnumber" ) String serialnumber, @PathParam( "position" ) String position) {
        return requestManager.setShutterPosition(requesting_user, serialnumber, position);
    }

    @GET @Path( "getShutterData/requesting_user/{requesting_user}/serialnumber/{serialnumber}" ) @Produces( MediaType.APPLICATION_JSON )
    public ShutterTransferObject getShutterData(@PathParam( "requesting_user" ) String requesting_user, @PathParam( "serialnumber" ) String serialnumber) {
        return requestManager.getShutterData(requesting_user, serialnumber);
    }

    @GET @Path( "getAllShutterData/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public ShutterTransferObject[] getAllShutterData(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getAllShutterData(requesting_user);
    }

    @GET @Path( "createUser/requesting_user/{requesting_user}/username/{username}/password/{password}/firstname/{firstname}/lastname/{lastname}/email/{email}") @Produces( MediaType.APPLICATION_JSON )
    public MessageBean createUser   ( @PathParam( "requesting_user" ) String requesting_user,
                                      @PathParam( "username" ) String username,
                                      @PathParam( "password" ) String password,
                                      @PathParam( "firstname" ) String firstname,
                                      @PathParam( "lastname" ) String lastname,
                                      @PathParam( "email" ) String email ) {
        return requestManager.createUser(requesting_user, username, password, firstname, lastname, email);
    }

    @GET @Path( "deleteUser/requesting_user/{requesting_user}/username/{username}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean deleteUser(@PathParam( "requesting_user" ) String requesting_user, @PathParam( "username" ) String username) {
        return requestManager.deleteUser(requesting_user, username);
    }

    @GET @Path( "alterUser/requesting_user/{requesting_user}/username/{username}/password/{password}/firstname/{firstname}/lastname/{lastname}/email/{email}") @Produces( MediaType.APPLICATION_JSON )
    public MessageBean alterUser   (  @PathParam( "requesting_user" ) String requesting_user,
                                      @PathParam( "username" ) String username,
                                      @PathParam( "password" ) String password,
                                      @PathParam( "firstname" ) String firstname,
                                      @PathParam( "lastname" ) String lastname,
                                      @PathParam( "email" ) String email ) {
        return requestManager.alterUser(requesting_user, username, password, firstname, lastname, email);
    }

    @GET @Path( "login/username/{username}/password/{password}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean login(@PathParam( "username" ) String username, @PathParam( "password" ) String password) {
        return requestManager.login(username, password);
    }

    @GET @Path( "logout/requesting_user/{requesting_user}/username/{username}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean logout(@PathParam( "requesting_user" ) String requesting_user, @PathParam( "username" ) String username) {
        return requestManager.logout(requesting_user, username);
    }

    @GET @Path( "getUserData/requesting_user/{requesting_user}/username/{username}" ) @Produces( MediaType.APPLICATION_JSON )
    public UserTransferObject getUserData(@PathParam( "requesting_user" ) String requesting_user, @PathParam( "username" ) String username) {
        return requestManager.getUserData(requesting_user, username);
    }

    @GET @Path( "getAllUserData/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public UserTransferObject[] getAllUserData(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getAllUserData(requesting_user);
    }

    @GET @Path( "createWeatherStation/requesting_user/{requesting_user}/modelVariant/{modelVariant}/manufacturer/{manufacturer}/genericName/{genericName}/serialnumber/{serialnumber}") @Produces( MediaType.APPLICATION_JSON )
    public MessageBean createWeatherStation(  @PathParam( "requesting_user" ) String requesting_user,
                                              @PathParam( "modelVariant" ) String modelVariant,
                                              @PathParam( "manufacturer" ) String manufacturer,
                                              @PathParam( "genericName" ) String genericName,
                                              @PathParam( "serialnumber" ) String serialnumber ) {
        System.out.println("Hersteller: " + manufacturer);
        System.out.println("Modell: " + modelVariant);
        //return requestManager.createWeatherStation(requesting_user, modelVariant, manufacturer, genericName, serialnumber);
        return requestManager.createWeatherStation(requesting_user, "WeatherStation3000", "CONRAD_ELECTRONIC", "MyWeatherStation", "423423");

    }

    @GET @Path( "deleteWeatherStation/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean deleteWeatherStation(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.deleteWeatherStation(requesting_user);
    }

    @GET @Path( "getAirHumidity/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MeasureBean getAirHumidity(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getAirHumidity(requesting_user);
    }

    @GET @Path( "getAirPressure/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MeasureBean getAirPressure(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getAirPressure(requesting_user);
    }

    @GET @Path( "getWindVelocity/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MeasureBean getWindVelocity(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getWindVelocity(requesting_user);
    }

    @GET @Path( "getOutdoorTemperature/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MeasureBean getOutdoorTemperature(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getOutdoorTemperature(requesting_user);
    }

    @GET @Path( "getRainfallAmount/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MeasureBean getRainfallAmount(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getRainfallAmount(requesting_user);
    }

    @GET @Path( "getWeatherStationData/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public WeatherStationTransferObject getWeatherStationData(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getWeatherStationData(requesting_user);
    }

    @GET @Path( "createThermometer/requesting_user/{requesting_user}/modelVariant/{modelVariant}/manufacturer/{manufacturer}/genericName/{genericName}/serialnumber/{serialnumber}") @Produces( MediaType.APPLICATION_JSON )
    public MessageBean createThermometer(     @PathParam( "requesting_user" ) String requesting_user,
                                              @PathParam( "modelVariant" ) String modelVariant,
                                              @PathParam( "manufacturer" ) String manufacturer,
                                              @PathParam( "genericName" ) String genericName,
                                              @PathParam( "serialnumber" ) String serialnumber ) {
        System.out.println("name: " + genericName);
        System.out.println("seriennummer: " + serialnumber);
        //return requestManager.createThermometer(requesting_user, modelVariant, manufacturer, genericName, serialnumber);
        return requestManager.createThermometer(requesting_user, "Thermometer3000", "ELECTRIC_COMPANY", "MyThermometer", "42424");
    }

    @GET @Path( "deleteThermometer/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean deleteThermometer(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.deleteThermometer(requesting_user);
    }

    @GET @Path( "getIndoorTemperature/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MeasureBean getIndoorTemperature(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getIndoorTemperature(requesting_user);
    }

    @GET @Path( "getThermometerData/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public ThermometerTransferObject getThermometerData(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.getThermometerData(requesting_user);
    }

    @GET @Path( "readLogs/requesting_user/{requesting_user}/limit/{limit}" ) @Produces( MediaType.APPLICATION_JSON )
    public String[] readLogs(@PathParam( "requesting_user" ) String requesting_user, @PathParam( "limit" ) int limit) {
        return requestManager.readLogs(requesting_user, limit);
    }

    @GET @Path( "undoLastCommand/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean undoLastCommand(@PathParam( "requesting_user" ) String requesting_user) {
        return requestManager.undoLastCommand(requesting_user);
    }

    @GET @Path( "getHeatingManufacturers_static" ) @Produces( MediaType.APPLICATION_JSON )
    public String[] getHeatingManufacturers_static() {
        return requestManager.getHeatingManufacturers_static();
    }

    @GET @Path( "getShutterManufacturers_static" ) @Produces( MediaType.APPLICATION_JSON )
    public String[] getShutterManufacturers_static() {
        return requestManager.getShutterManufacturers_static();
    }

    @GET @Path( "getThermometerManufacturers_static" ) @Produces( MediaType.APPLICATION_JSON )
    public String[] getThermometerManufacturers_static() {
        return requestManager.getThermometerManufacturers_static();
    }

    @GET @Path( "getWeatherStationManufacturers_static" ) @Produces( MediaType.APPLICATION_JSON )
    public String[] getWeatherStationManufacturers_static() {
        return requestManager.getWeatherStationManufacturers_static();
    }

    @GET @Path( "getHeatingModelVariants_static" ) @Produces( MediaType.APPLICATION_JSON )
    public String[] getHeatingModelVariants_static() {
        return requestManager.getHeatingModelVariants_static();
    }

    @GET @Path( "getThermometerModelVariants_static" ) @Produces( MediaType.APPLICATION_JSON )
    public String[] getThermometerModelVariants_static() {
        return requestManager.getThermometerModelVariants_static();
    }

    @GET @Path( "getWeatherStationModelVariants_static" ) @Produces( MediaType.APPLICATION_JSON )
    public String[] getWeatherStationModelVariants_static() {
        return requestManager.getWeatherStationModelVariants_static();
    }

    @GET @Path( "getShutterModelVariants_static" ) @Produces( MediaType.APPLICATION_JSON )
    public String[] getShutterModelVariants_static() {
        return requestManager.getShutterModelVariants_static();
    }

    @GET @Path( "getShutterPositions_static" ) @Produces( MediaType.APPLICATION_JSON )
    public String[] getShutterPositions_static() {
        return requestManager.getShutterPositions_static();
    }

    @GET @Path( "halloWelt/requesting_user/{requesting_user}" ) @Produces( MediaType.APPLICATION_JSON )
    public MessageBean halloWelt(@PathParam( "requesting_user" ) String requesting_user) {
        return new MessageBean(EMessageCode.SUCCESS);
    }
}