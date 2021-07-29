/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mypc
 */
public class JDBCUtils {

    private JDBCUtils() {
    }

    private static Connection connection;
    private static final String SERVERNAME = "CIUZ";
    private static final String DATABASENAME = "SOF203_lab56";
    private static final String PORTNUMBER = "1433";
    private static final String INSTANCE = "";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";
    //Tiện ích kết nối với sql
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                String url = "jdbc:sqlserver://localhost:1433;databaseName=Assignment";
                String url = "jdbc:sqlserver://" + SERVERNAME + ":" + PORTNUMBER + "\\" + INSTANCE + ";databaseName=" + DATABASENAME;
                if (INSTANCE.trim().isEmpty()) {
                    url = "jdbc:sqlserver://" + SERVERNAME + ":" + PORTNUMBER + ";databaseName=" + DATABASENAME;
                }
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                return DriverManager.getConnection(url, userID, password);
                return DriverManager.getConnection(url, USERNAME, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return connection;
    }
}
