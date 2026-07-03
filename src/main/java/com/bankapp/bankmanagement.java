package com.bankapp;

import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.sql.*;

public class bankmanagement {
    static Connection c= connection.getConnection();

    public static boolean createAccount(String name,int pass_key){
        if(name.isEmpty() || pass_key==0){
            System.out.println("Try Again");
            return false;
        }

        try{
            String a = "INSERT INTO bank(c_name, balance, pass_key) VALUES (?,1000,?)";
            PreparedStatement b= c.prepareStatement(a);
            b.setString(1,name);
            b.setInt(2,pass_key);

            int r=b.executeUpdate();
            if(r==1){
                System.out.println("Account Created");
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean login(String name,int pass_key){
        if(name.isEmpty() || pass_key==0){
            System.out.println("Try Again");
            return false;
        }

    }
}
