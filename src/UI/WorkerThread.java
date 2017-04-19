package UI;

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
    int AM_PM = 2;
    String day_night = "";

    boolean hourSetManual;
    int hourSet;
    boolean incomingChange = false;
    int oldAM_PM;
    boolean threadRunning = true;

    public WorkerThread(Label lbl_time, boolean hourSetManual, int hourSet, boolean incomingChange, int oldAM_PM) {
        this.hourSetManual = hourSetManual;
        this.hourSet = hourSet;
        this.incomingChange = incomingChange;
        this.oldAM_PM = oldAM_PM;
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

                if(hourSetManual==false)
                {
                    hour = cal.get(Calendar.HOUR);
                } else {
                    hour = hourSet;
                }

                min = cal.get(Calendar.MINUTE);
                sec = cal.get(Calendar.SECOND);

                if(AM_PM!=0 && AM_PM !=1){
                    AM_PM = cal.get(Calendar.AM_PM);
                }

                if(incomingChange == true){
                    incomingChange=false;
                    if(oldAM_PM == 1){
                        AM_PM = 0;
                    } else if(oldAM_PM == 0){
                        AM_PM = 1;
                    }
                }

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
                sleep(1000);
                //sleep(TimeUnit.SECONDS.toMillis(1));
            } catch (InterruptedException ex) {
                //Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setThreadRunning(boolean running){
        threadRunning = running;
    }

    public int getAM_PM(){
        return AM_PM;
    }
}