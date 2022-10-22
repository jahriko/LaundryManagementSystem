package com.mycompany.laundrymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
        static Connection conn = null;
        static String url = "jdbc:sqlite:C:\\Users\\Jericho Opsima\\DataGripProjects\\lms-2\\lms.sqlite?foreign_keys=true";

    public static void main(String[] args) {
        
        Database.connect();
                
    }
    
    public static void connect() {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from employee");
            
            while (rs.next()) {
                System.out.println("first_name: " + rs.getString("first_name"));
            }
        } catch (Exception e) {
            System.out.println("Connection Failed | " + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }

}