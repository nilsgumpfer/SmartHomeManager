package de.thm.smarthome.global.clock.Option1;

/**
 * Created by Carlo on 14.04.2017.
 */
public class SysTime {
    public static SysTime INSTANCE = new SysTime();

    public long now() {
        return System.currentTimeMillis();
    }
}