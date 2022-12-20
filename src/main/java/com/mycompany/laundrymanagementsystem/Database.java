package com.mycompany.laundrymanagementsystem;

import java.sql.*;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class Database {

    static String url = "jdbc:sqlite:C:\\Users\\Jericho Opsima\\DataGripProjects\\lms-2\\lms.sqlite?foreign_keys=true";
    
    public static Connection connect() {
        Connection connect = null;
        
        try {
            connect = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return connect;
    }
    
    public static DSLContext context() {
        DSLContext context = null;
        context = DSL.using(connect(), SQLDialect.SQLITE);
        
        return context;
    }

}