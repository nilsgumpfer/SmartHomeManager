package de.thm.smarthome.global.clock.Option3;

import de.thm.smarthome.global.clock.Option3.ITimeSource;

/**
 * Created by Carlo on 14.04.2017.
 */
public final class TimeSrc implements ITimeSource {
    /** One day in advance of the actual time.*/
    @Override public long currentTimeMillis() {
        return System.currentTimeMillis() + ONE_DAY;
    }

    private static final long ONE_DAY = 24*60*60*1000;
}
