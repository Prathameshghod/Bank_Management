package com.bankapp;

import java.sql.Connection;

public class testConnection{
    public static void main(String[] agrs){
        Connection c= connection.getConnection();
        if(c!=null){
            System.out.println("Connected");
        }
        else{
            System.out.println("Not Connected");
        }
    }
}
