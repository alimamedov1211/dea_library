
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbHelper {
    public static Connection getConnection(){
        String path = "jdbc:mysql://localhost:3307/library_group1?user=root&password=root";
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            c = DriverManager.getConnection(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    return c;
}
}