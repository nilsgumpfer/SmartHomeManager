import de.thm.smarthome.global.connection.wsprovider.SmartHomeManagerWebServiceProvider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class Controller {



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

    private int hourSet = 0;
    public boolean hourSetManual = false;
    public boolean changeAMPM = false;

    WorkerThread workerThread;

    public static PrintStream ps;

    private SmartHomeManagerWebServiceProvider wsProvider = null;

    public void BTNServerStarten(ActionEvent event) throws IOException {
        if(wsProvider == null){
            wsProvider = new SmartHomeManagerWebServiceProvider();
        }

        /*ps = new PrintStream(new OutputStream() {
            @Override
            public void write(int i) throws IOException {
                ta_srvlog.appendText(String.valueOf((char) i));
            }
        });
        System.setOut(ps);*/

        /*Server wird gestartet*/

        wsProvider.startProviding();
        lbl_Serverip.setText(getServerIP());
        //lbl_Servername.setText(shutter1.shuttername);
        lbl_Serverstatus.setText("Gestartet");

        lbl_Serverport.setText("8080");

        if(lbl_Serverstatus.getText() == "Gestartet"){
            btn_starteServer.setDisable(true);
            btn_stoppeServer.setDisable(false);
        }
    }

    public void BTNServerStoppen(ActionEvent event){
        wsProvider.stopProviding();
        lbl_Serverstatus.setText("Gestoppt");

        if (lbl_Serverstatus.getText() == "Gestoppt"){
            btn_stoppeServer.setDisable(true);
            btn_starteServer.setDisable(false);
        }
    }

    public String getServerIP() {
        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            return ip.getHostAddress();

        } catch (UnknownHostException e) {

            e.printStackTrace();
            return null;
        }
    }

    public void pressBtnStartReset(ActionEvent event){
        if(workerThread != null){
            workerThread.setThreadRunning(false);
        }
            workerThread = new WorkerThread(lblTime, hourSetManual, hourSet, changeAMPM);
            workerThread.setDaemon(true);
            workerThread.start();
    }

    public void pressBtnSetTime(ActionEvent event){
        //workerThread.interrupt();
        setTime(tfHour.getText());
    }

    public void pressBtnChangeAmPm(ActionEvent event){
        changeAMPM = true;
        if(workerThread != null){
            workerThread.setThreadRunning(false);
        }
        workerThread = new WorkerThread(lblTime, hourSetManual, hourSet, changeAMPM);
        workerThread.setDaemon(true);
        workerThread.start();
        changeAMPM = false;
    }

    private void setTime(String hour) {
        if(hour!=""){
            try{
                hourSet = Integer.valueOf(hour);
                hourSetManual = true;
            } catch (Exception e){
                System.out.println("Bitte nur gerade Zahlen eingeben!");
            }
        }

        workerThread.setThreadRunning(false);
        workerThread = new WorkerThread(lblTime, hourSetManual, hourSet, changeAMPM);
        workerThread.setDaemon(true);
        workerThread.start();
        //workerThread.setThreadRunning(true);
    }

    public int getHour(){
        return hourSet;
    }

    private boolean isInt(javafx.scene.control.TextField input, String message){
        try
        {
            int hour = Integer.parseInt(input.getText());
            System.out.println("Eingegebene Stunde: " + hour);
            return true;
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error: " + message + " is not a Number");
            return false;
        }
    }
}
