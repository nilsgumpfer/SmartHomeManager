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
    private static boolean supressConsoleOutput = false;
    private List<String> listOfLogs = new ArrayList<>();

    private SmartHomeLogger(){
        //I´m a singleton! I have no public constructor.
    }

    public static void log(String message){
        String timestamp = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss:SSS] : ").format(new Date());
        SmartHomeLogger.getInstance().listOfLogs.add(timestamp + message);

        if(supressConsoleOutput == false)
            System.out.println(timestamp + message);
    }

    public static void log(Exception e){
        log(e.getMessage() + " (" + e.toString() + ")");
        e.printStackTrace();
    }

    public static String[] readLogs(int limit){
        String [] array = {};
        try {
            List<String> logs = SmartHomeLogger.getInstance().listOfLogs;
            int size = logs.size();
            int end = size - 1;
            int start = end - limit;

            if(logs.size() > limit)
                array = logs.subList(start, end).toArray(array);
            else
                array = logs.toArray(array);
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
        }
        return array;
    }

    public static SmartHomeLogger getInstance()
    {
        return instance;
    }

    public static void supressConsoleOutput(boolean flag) {
        supressConsoleOutput = flag;
    }
}
