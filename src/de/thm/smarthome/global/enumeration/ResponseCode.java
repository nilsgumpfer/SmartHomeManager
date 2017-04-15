package de.thm.smarthome.global.enumeration;

/**
 * Created by Nils on 14.04.2017.
 */
public enum ResponseCode {
    LoginFailed,
    LoginSuccessful,
    LogoutFailed,
    LogoutSuccessful,
    WrongPassword,
    WrongUsername,
    NotLoggedIn,
    HeatingCouldNotBeCreated,
    ShutetrCouldNotBeCreated,
    ThermometerCouldNotBeCreated,
    LoggedIn, DBError, LoggedOut, UndoSuccessful, CommandInvokedSuccessfully, CommandInvocationFailed, SwitchedOn, SwitchedOff, AlreadySwitchedOn, AlreadySwitchedOff, TemperatureAdjustmentSuccessful, TemperatureAdjustmentFailed, MovedUpSuccessfully, MoveUpFailed, MoveDownFailed, MovedDownSuccessfully, WeatherStationCouldNotBeCreated

}
