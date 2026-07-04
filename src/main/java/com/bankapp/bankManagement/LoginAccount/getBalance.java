package com.bankapp.bankManagement.LoginAccount;

import com.bankapp.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getBalance {
    static Connection c= connection.getConnection();
    public static void getbalance(int acc_no){
        try {
            String a = "SELECT * FROM bank WHERE ac_no=?";
            PreparedStatement p = c.prepareStatement(a);
            p.setInt(1,acc_no);
            ResultSet r= p.executeQuery();

            System.out.println("\n-------------------------------------");
            System.out.printf("%12s %15s %12s\n","Account no.","Customer Name","Balance");
            while(r.next()){
                System.out.printf("%12d %15s %12d\n",r.getInt("ac_no"),r.getString("c_name"),r.getInt("balance"));
            }
            System.out.println("---------------------------------------------");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
