package com.bankapp.bankManagement.LoginAccount;

import com.bankapp.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class transferMoney {
    static Connection c= connection.getConnection();

    public static boolean transfer_Money(int sender_acc,int receiver_acc,int amt){
        if(receiver_acc==0 || sender_acc==0 || amt==0){
            System.out.println();
            return false;
        }
        try{
        String checkBalance = "SELECT balance FROM bank WHERE ac_no = ?";
        PreparedStatement ps = c.prepareStatement(checkBalance);
        ps.setInt(1, sender_acc);
        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getInt("balance") < amt) {
            System.out.println("Insufficient Balance!");
            return false;
        }

        String debit = "UPDATE customer SET balance = balance - ? WHERE ac_no = ?";
        PreparedStatement psDebit = c.prepareStatement(debit);
        psDebit.setInt(1, amt);
        psDebit.setInt(2, sender_acc);
        psDebit.executeUpdate();

        String credit = "UPDATE customer SET balance = balance + ? WHERE ac_no = ?";
        PreparedStatement psCredit = c.prepareStatement(credit);
        psCredit.setInt(1, amt);
        psCredit.setInt(2, receiver_acc);
        psCredit.executeUpdate();

        c.commit();
        return true;

    } catch (Exception e) {
        e.printStackTrace();
    }
        return false;
    }
}
