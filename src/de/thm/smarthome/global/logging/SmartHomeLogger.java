package de.thm.smarthome.global.logging;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nils on 04.02.2017.
 */
public class SmartHomeLogger {
    private static SmartHomeLogger instance = new SmartHomeLogger();
    private List<String> listOfLogs = new ArrayList<>();

    private SmartHomeLogger(){
        //I´m a singleton! I have no public constructor.
    }

    public static void log(String message){
        String timestamp = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss:fff] : ").format(new Date());
        SmartHomeLogger.getInstance().listOfLogs.add(timestamp + message);
    }

    public static String[] readLogs(int limit){
        String [] array = {};
        return SmartHomeLogger.getInstance().listOfLogs.toArray(array);
    }

    public static SmartHomeLogger getInstance()
    {
        return instance;
    }
}
