package com.amsterdam.crm_ossoluciones.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseOsSoluciones {
    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/DATABASE_OSSOLUCIONES","amsterdam","1234");
    }
}
