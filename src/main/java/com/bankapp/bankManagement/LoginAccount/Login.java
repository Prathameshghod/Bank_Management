package com.bankapp.bankManagement.LoginAccount;

import com.bankapp.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    static Connection c = connection.getConnection();

    public static boolean login(String name, int pass_key) {
        if (name.isEmpty() || pass_key == 0) {
            System.out.println("Try Again");
            return false;
        }
        try {
            String a = "SELECT * FROM bank WHERE c_name=? AND pass_key=?";
            PreparedStatement p = c.prepareStatement(a);
            p.setString(1, name);
            p.setInt(2, pass_key);

            ResultSet r = p.executeQuery();
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

            if (r.next()) {
                int sender_acc = r.getInt("ac_no");
                int ch;
                while (true) {
                    System.out.println("Hello " + r.getString("c_name"));
                    System.out.println("Enter Choice");
                    System.out.println("1. Transfer Money");
                    System.out.println("2. Check Balance");
                    System.out.println("3. Logout");
                    ch = Integer.parseInt(sc.readLine());

                    if (ch == 1) {
                        System.out.println("Enter Receiver Account no.");
                        int receiver_acc = Integer.parseInt(sc.readLine());
                        int amt = Integer.parseInt(sc.readLine());
                        if (transferMoney(sender_acc, receiver_acc, amt)) {
                            System.out.println("Transaction Successfull");
                        } else {
                            System.out.println("Transaction failed! Please try again.");
                        }
                    } else if (ch == 2) {
                        getBalance(sender_acc);
                    } else if (ch == 3) {
                        System.out.println("Logged out successfully. Returning to main menu.");
                        break;
                    } else {
                        System.out.println("Invalid choice! Try again.");
                    }
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}