// TODO; kann gelöscht werden, wenn JPA funktioniert
 package de.thm.smarthome.global.connection.database.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Tim on 25.03.2017.
 */
public class MySQLConnection {
    public static Connection conn;
    private static String server = "127.0.0.1";
    private static String serverport = "3306";
    private static String username = "root";
    private static String password = "";
    private static String db = "smarthome";

    /*private static String username = "SHa";
    private static String password = "SHa!$";
    private static String db = "smarthome";*/
    public Connection getConn() {
        return conn;
    }

    public void CreateConnection() throws SQLException {
        try {
            //Load driver
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //TODO: Nils war´s, bitte wieder einkommentieren!
            //Connect to database
            String str = "jdbc:mysql://" + server + ":" + serverport + "/" + db;
            conn = DriverManager.getConnection(str, username, password);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}