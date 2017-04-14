package de.thm.smarthome.global.clock.Option3;

/**
 * Created by Carlo on 14.04.2017.
 */


    public interface ITimeSource {
        /** Return the system time. */
        long currentTimeMillis();
    }
