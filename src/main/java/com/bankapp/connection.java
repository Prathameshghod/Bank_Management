package com.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    static Connection c;

    public static Connection getConnection(){
        try{
            String a="com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/bank";
            String user="root";
            String pass="root";

            Class.forName(a);
            c=DriverManager.getConnection(url,user,pass);
        }
        catch(Exception e){
            System.out.println("Connection not created" + e.getMessage());
        }
        return c;
    }
}
