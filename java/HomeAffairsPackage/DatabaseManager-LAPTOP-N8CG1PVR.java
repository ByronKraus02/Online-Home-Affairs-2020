/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeAffairsPackage;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ByronKraus
 */
public class DatabaseManager {

    Connection conn = null;

    public DatabaseManager() {
        String filename = "HomeAffairs.accdb";
        try {
            if (filename.endsWith(".mdb") || filename.endsWith(".accdb")) {
                String url = "jdbc:ucanaccess://" + filename;
                conn = DriverManager.getConnection(url);
//Creates a connection with the database 
            } else {
                throw new FileNotFoundException();
            }
            System.out.println("Connection successful");
        } catch (Exception e) {
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
    }

    //Querys the database
    public ResultSet queryDatabase(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    //Updates the tables in the database
    public void updateDatabase(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }
}
