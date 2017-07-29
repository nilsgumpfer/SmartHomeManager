package de.thm.smarthome.global.metadata;

import de.thm.smarthome.global.logging.SmartHomeLogger;

import java.net.InetAddress;

public class MetaDataManager {
    private static MetaDataManager ourInstance = new MetaDataManager();

    private static String ipAddress     = "N/A";
    private static String hostName      = "N/A";
    private static String portREST      = "N/A";
    private static String suffixREST    = "N/A";
    private static String protocolREST  = "N/A";
    private static String hostStatus    = "N/A";

    public static MetaDataManager getInstance() {
        return ourInstance;
    }

    private MetaDataManager() {
    }

    public static MetaDataManager getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(MetaDataManager ourInstance) {
        MetaDataManager.ourInstance = ourInstance;
    }

    public static String getIpAddress() {
        updateIpAddress();
        return ipAddress;
    }

    public static void updateIpAddress() {
        try
        {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
            ipAddress = "N/A";
        }
    }

    public static String getHostName() {
        updateHostName();
        return hostName;
    }

    public static void updateHostName() {
        try
        {
            hostName = InetAddress.getLocalHost().getHostName();
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
            hostName = "N/A";
        }
    }

    public static String getPortREST() {
        return portREST;
    }

    public static void setPortREST(String portREST) {
        MetaDataManager.portREST = portREST;
    }

    public static String getSuffixREST() {
        return suffixREST;
    }

    public static void setSuffixREST(String suffixREST) {
        MetaDataManager.suffixREST = suffixREST;
    }

    public static void setProtocolREST(String protocolREST) {
        MetaDataManager.protocolREST = protocolREST;
    }

    public static String getProtocolREST() {
        return protocolREST;
    }

    public static String getUrlREST() {
        updateHostName();
        return protocolREST + "://" + hostName + ":" + portREST + "/" + suffixREST + "/";
    }

    public static String getStatus() {
        return hostStatus;
    }

    public static void setHostStatus(String hostStatus) {
        MetaDataManager.hostStatus = hostStatus;
    }
}
