package com.bankapp.bankManagement.LoginAccount;

import com.bankapp.connection;

import java.sql.Connection;

public class transferMoney {
    static Connection c= connection.getConnection();

    public static boolean transfer_Money(int sender_acc,int receiver_acc,int amt){
        if(receiver_acc==0 || sender_acc==0 || amt==0){
            System.out.println();
            return false;
        }
    return true;
    }
}
