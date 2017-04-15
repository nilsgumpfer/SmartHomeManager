package de.thm.smarthome.global.helper;

import de.thm.smarthome.global.enumeration.ResponseCode;

/**
 * Created by Nils on 15.04.2017.
 */
public class MessageRepository {
    private static MessageRepository ourInstance = new MessageRepository();

    public static MessageRepository getInstance() {
        return ourInstance;
    }

    private MessageRepository() {
    }

    public static String getMessage(ResponseCode responseCode){
        switch (responseCode){
            case LoginFailed:
                return "Login fehlgeschlagen.";
            case LoginSuccessful:
                return "Login erfolgreich.";
            case LogoutFailed:
                return "Logout fehlgeschlagen.";
            case LogoutSuccessful:
                return "Logout erfolgreich.";
            case WrongPassword:
                return "Falsches Passwort.";
            case WrongUsername:
                return "Unbekannter Benutzername.";
            case NotLoggedIn:
                return "Benutzer nicht eingeloggt.";
            case HeatingCouldNotBeCreated:
                return "Heizung konnte nicht angelegt werden.";
            case ShutterCouldNotBeCreated:
                return "Rollladen konnte nicht angelegt werden.";
            case ThermometerCouldNotBeCreated:
                return "Thermometer konnte nicht angelegt werden.";
            case LoggedIn:
                return "Benutzer eingeloggt.";
            case DBError:
                return "Fehler in der Datenbank.";
            case LoggedOut:
                return "Benutzer ausgeloggt.";
            case UndoSuccessful:
                return "Undo erfolgreich.";
            case CommandInvokedSuccessfully:
                return "Command erfolgreich ausgeführt.";
            case CommandInvocationFailed:
                return "Command konnte nicht ausgeführt werden.";
            case SwitchedOn:
                return "Gerät eingeschaltet.";
            case SwitchedOff:
                return "Gerät ausgeschaltet.";
            case AlreadySwitchedOn:
                return "Gerät ist bereits eingeschaltet.";
            case AlreadySwitchedOff:
                return "Gerät ist bereits ausgeschaltet.";
            case TemperatureAdjustmentSuccessful:
                return "Temperatur erfolgreich angepasst.";
            case TemperatureAdjustmentFailed:
                return "Temperatur konnte nicht angepasst werden.";
            case MovedUpSuccessfully:
                return "Hochfahren erfolgreich.";
            case MoveUpFailed:
                return "Hochfahren fehlgeschlagen.";
            case MoveDownFailed:
                return "Herunterfahren fehlgeschlagen.";
            case MovedDownSuccessfully:
                return "Herunterfahren erfolgreich.";
            case UndoFailed:
                return "Undo konnte nicht ausgeführt werden.";
            case MoveToPositionFailed:
                return "Position konnte nicht geändert werden.";
            case MoveToPositionSuccessful:
                return "Position erfolgreich geändert.";
            case SwitchOnFailed:
                return "Gerät konnte nicht eingeschaltet werden.";
            case SwitchOffFailed:
                return "Gerät erfolgreich eingeschaltet.";
            case AlreadyMovedDown:
                return "Unterste Position bereits erreicht.";
            case AlreadyMovedUp:
                return "Oberste Position bereits erreicht.";
            case AlreadyAtThisPosition:
                return "Position bereits erreicht.";
            case UserCreatedSuccessfully:
                return "Benutzer erfolgreich angelegt.";
            case UserCreationFailed:
                return "Benutzer konnte nicht angelegt werden.";
            case UserDeletedSuccessfully:
                return "Benutzer erfolgreich gelöscht.";
            case UserDeletionFailed:
                return "Benutzer konnte nicht gelöscht werden.";
            case UserAlteredSuccessfully:
                return "Benutzer erfolgreich geändert.";
            case UserAlterationFailed:
                return "Benutzer konnte nicht geändert werden.";
            case WeatherStationCouldNotBeCreated:
                return "Wetterstation konnte nicht angelegt werden.";
            default:
                return "N/A";
        }
    }
}
