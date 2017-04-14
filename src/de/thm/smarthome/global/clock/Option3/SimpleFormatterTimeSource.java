package de.thm.smarthome.global.clock.Option3;

/**
 * Created by Carlo on 14.04.2017.
 */
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public final class SimpleFormatterTimeSource extends SimpleFormatter {

    @Override public String format(LogRecord aLogRecord) {
        //aLogRecord.setMillis(fTimeSource.currentTimeMillis());
        return super.format(aLogRecord);
    }

    //private ITimeSource fTimeSource = BuildImpl.forTimeSource();
}
