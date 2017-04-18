import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Created by Carlo on 15.04.2017.
 */

public class WorkerThread extends Thread{

    private Label lbl_time = null;
    Calendar cal;

    int hour;
    int min;
    int sec;
    int AM_PM;
    String day_night = "";

    boolean hourSetManual;
    int hourSet;
    boolean incomingChange = false;
    boolean threadRunning = true;

    public WorkerThread(Label lbl_time, boolean hourSetManual, int hourSet, boolean incomingChange) {
        this.hourSetManual = hourSetManual;
        this.hourSet = hourSet;
        this.incomingChange = incomingChange;
        threadRunning = true;

        setDaemon(true);
        this.lbl_time = lbl_time;
    }

    @Override
    public void run() {
        //while (!this.isInterrupted()) {
            while (threadRunning) {
            // UI updaten
            Platform.runLater(() -> {
                // entsprechende UI Komponente updaten

                cal = new GregorianCalendar();
                System.out.println("durchlauf");

                if(hourSetManual==false)
                {
                    hour = cal.get(Calendar.HOUR);
                } else {
                    hour = hourSet;
                }

                min = cal.get(Calendar.MINUTE);
                sec = cal.get(Calendar.SECOND);

                System.out.println("erstes am/pm");
                System.out.println(AM_PM);

                if(AM_PM!=0 && AM_PM !=1){
                    AM_PM = cal.get(Calendar.AM_PM);
                }

                System.out.println("ampm");
                System.out.println(AM_PM);

                System.out.println("incomingChange");
                System.out.println(incomingChange);
                if(incomingChange == true){
                    if(AM_PM == 1){
                        AM_PM = 0;
                    } else if(AM_PM == 0){
                        AM_PM = 1;
                    }
                }

                System.out.println("ampm2");
                System.out.println(AM_PM);

                if(AM_PM == 1)
                {
                    day_night = "PM";
                }
                else
                {
                    day_night = "AM";
                }

                String time = hour + ":" + min + ":" + sec + " "  + day_night;

                lbl_time.setFont(new Font(50));
                lbl_time.setText(time);
            });

            // Thread schlafen
            try {
                // fuer 0,5 Sekunde
                sleep(500);
                //sleep(TimeUnit.SECONDS.toMillis(1));
            } catch (InterruptedException ex) {
                //Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setThreadRunning(boolean running){
        threadRunning = running;
        System.out.println("threadrunning");
        System.out.println(threadRunning);
    }
}