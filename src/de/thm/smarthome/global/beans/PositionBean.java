package de.thm.smarthome.global.beans;

import de.thm.smarthome.global.enumeration.EPosition;

/**
 * Created by Nils on 11.06.2017.
 */
public class PositionBean {
    private EPosition position_Enum;
    private String position_String = "NULL";

    public PositionBean(EPosition position_Enum) {
        this.position_Enum = position_Enum;
        lookUpString();
    }

    public EPosition getPosition_Enum() {
        return position_Enum;
    }

    public String getPosition_String() {
        return position_String;
    }

    private void lookUpString(){
        switch (position_Enum){
            case NA:
                position_String = "N/A";
                break;
            case DOWN:
            case P0:
                position_String = "Position 0 / Untere Position (0% geöffnet)";
                break;
            case P1:
                position_String = "Position 1 (20% geöffnet)";
                break;
            case P2:
                position_String = "Position 2 (40% geöffnet)";
                break;
            case MIDDLE:
            case P3:
                position_String = "Position 3 / Mittlere Position (60% geöffnet)";
                break;
            case P4:
                position_String = "Position 4 (80% geöffnet)";
                break;
            case UP:
            case P5:
                position_String = "Position 5 / Obere Position (100% geöffnet)";
                break;
        }
    }
}
