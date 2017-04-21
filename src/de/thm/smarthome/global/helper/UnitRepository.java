package de.thm.smarthome.global.helper;

import de.thm.smarthome.global.enumeration.UnitOfMeasurement;

/**
 * Created by Nils on 21.04.2017.
 */
public class UnitRepository {
    private static UnitRepository ourInstance = new UnitRepository();

    public static UnitRepository getInstance() {
        return ourInstance;
    }

    private UnitRepository() {
    }

    public static String getUnitAsText(UnitOfMeasurement unitOfMeasurement){
        switch (unitOfMeasurement)
        {
            case temperature_DegreesCelsius:
                return "°C";
            case temperature_DegreesFahrenheit:
                return "°F";
            case velocity_KilometersPerHour:
                return "km/h";
            case velocity_MilesPerHour:
                return "mph";
            case volume_LitresPerSquareMeter:
                return "l/m²";
            case volume_GallonsPerSquareInch:
                return "gal/inch²";
            case pressure_Bar:
                return "Bar";
            case pressure_PoundForcePerSquareInch:
                return "pf/inch²";
            case distance_meters:
                return "m";
            case distance_feet:
                return "ft";
            case relation_percent:
                return "%";
            default:
                return "N/A";
        }
    }
}
