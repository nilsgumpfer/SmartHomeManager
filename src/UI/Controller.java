package UI;

import de.thm.smarthome.global.connection.wsprovider.SmartHomeManagerWebServiceProvider;
import de.thm.smarthome.global.metadata.MetaDataManager;
import de.thm.smarthome.global.observer.AClockObservable;
import de.thm.smarthome.global.observer.IClockObserver;
import de.thm.smarthome.main.manager.main.SmartHomeManagerMainClass;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class Controller extends AClockObservable {

    @FXML
    private Label lbl_Serverip;
    @FXML
    private Label lbl_Servername;
    @FXML
    private Label lbl_Serverport;
    @FXML
    private Label lbl_Serverstatus;
    @FXML
    private Label lbl_srvmsg;
    @FXML
    private Label lbl_RestURL;
    @FXML
    private Button btn_starteServer;
    @FXML
    private Button btn_stoppeServer;
    @FXML
    private Button btnSetTime;
    @FXML
    private Button btnStartReset;
    @FXML
    private Button btnChangeAmPm;
    @FXML
    public Label lblTime;
    @FXML
    private TextField tfHour;
    @FXML
    private TextField tfAmPm;
    @FXML
    private TextArea ta_srvlog;

    private int hourSet = 0;
    public boolean hourSetManual = false;
    public boolean changeAMPM = false;
    int oldAM_PM;

    WorkerThread workerThread;

    public static PrintStream ps;

    private SmartHomeManagerWebServiceProvider wsProvider = null;

    private List<IClockObserver> attachedClockObservers;

    public void BTNServerStarten(ActionEvent event) throws IOException {

        ps = new PrintStream(new OutputStream() {

            @Override
            public void write(int i) throws IOException {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ta_srvlog.appendText(String.valueOf((char) i));
                    }
                });


            }
        });
        System.setOut(ps);

        /*
        if(wsProvider == null){
            wsProvider = new SmartHomeManagerWebServiceProvider();
        }*/

        /*ps = new PrintStream(new OutputStream() {
            @Override
            public void write(int i) throws IOException {
                ta_srvlog.appendText(String.valueOf((char) i));
            }
        });
        System.setOut(ps);*/

        /*Server wird gestartet*/

        //wsProvider.startProviding();

        SmartHomeManagerMainClass.startSmartHomeServer();

        lbl_Servername.setText(getServerName());
        lbl_RestURL.setText(getREST_URL());
        lbl_Serverip.setText(getServerIP());

        MetaDataManager.setHostStatus("Gestartet");
        lbl_Serverstatus.setText(getServerStatus());

        lbl_Serverport.setText(getREST_Port());

        if(lbl_Serverstatus.getText() == "Gestartet"){
            btn_starteServer.setDisable(true);
            btn_stoppeServer.setDisable(false);
        }
    }

    public void BTNServerStoppen(ActionEvent event){
        //wsProvider.stopProviding();

        SmartHomeManagerMainClass.stopSmartHomeServer();

        MetaDataManager.setHostStatus("Gestoppt");
        lbl_Serverstatus.setText(getServerStatus());

        if (lbl_Serverstatus.getText() == "Gestoppt"){
            btn_stoppeServer.setDisable(true);
            btn_starteServer.setDisable(false);
        }
    }

    public String getServerIP() {
        return MetaDataManager.getIpAddress();
    }

    public String getServerName() {
        return MetaDataManager.getHostName();
    }

    public String getREST_URL() {
        return MetaDataManager.getUrlREST();
    }

    public String getREST_Port() {
        return MetaDataManager.getPortREST();
    }

    public String getServerStatus() {
        return MetaDataManager.getStatus();
    }

    public void pressBtnStartReset(ActionEvent event){
        hourSetManual = false;
        if(workerThread != null){
            workerThread.setThreadRunning(false);
        }
            workerThread = new WorkerThread(lblTime, hourSetManual, hourSet, changeAMPM, oldAM_PM);
            workerThread.setDaemon(true);
            workerThread.start();
    }

    public void pressBtnSetTime(ActionEvent event){
        setTime(tfHour.getText());
    }

    public void pressBtnChangeAmPm(ActionEvent event){
        changeAMPM = true;
        oldAM_PM = workerThread.getAM_PM();
        if(workerThread != null){
            workerThread.setThreadRunning(false);
        }
        workerThread = new WorkerThread(lblTime, hourSetManual, hourSet, changeAMPM, oldAM_PM);
        workerThread.setDaemon(true);
        workerThread.start();
        changeAMPM = false;
    }

    private void setTime(String hour) {
        if(hour!="") {
            if (checkInt(tfHour) == true) {
                hourSet = Integer.valueOf(hour);
                if (hourSet >= 0 && hourSet < 12) {
                    hourSetManual = true;
                    workerThread.setThreadRunning(false);
                    workerThread = new WorkerThread(lblTime, hourSetManual, hourSet, changeAMPM, oldAM_PM);
                    workerThread.setDaemon(true);
                    workerThread.start();
                } else {
                    System.out.println("Bitte nur Zahlen zwischen 0 und 11 eingeben!");
                }
                } else{
                System.out.println("Bitte nur gerade Zahlen eingeben!");
            }
        }
    }

    public int getHour(){
        return hourSet;
    }

    private boolean checkInt(javafx.scene.control.TextField input){
        try
        {
            int hour = Integer.parseInt(input.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public void update(AClockObservable o, Object change) {

    }

    @Override
    public void attach(IClockObserver observer) {
        super.attach(observer);
    }

    @Override
    public void notifyObservers(Object change){
        for (IClockObserver element:attachedClockObservers) {
            element.update(this,change);
        }
    }
}
