package com.bankapp;

import com.bankapp.bankManagement.CreateAccount;
import com.bankapp.bankManagement.LoginAccount.Login;

import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.security.spec.ECField;

public class bank {
    public static void  main(String[] args) {
        BufferedReader sc= new BufferedReader(new InputStreamReader(System.in));

        String name;
        int pass_key;
        int ch;

        while(true){
            System.out.println("1. Create bank Account");
            System.out.println("2. Login bank Account");
            System.out.println("3.Log out");

            try{
                System.out.println("Enter Choice");
                ch=Integer.parseInt(sc.readLine());

                switch (ch){
                    case 1->{
                        System.out.println("Enter Unique username");
                        name =sc.readLine();
                        System.out.println("Enter Pass Key");
                        pass_key = Integer.parseInt(sc.readLine());

                        if(CreateAccount.createAccount(name,pass_key)){
                            System.out.println("Bank Account Created Successfully you can log in now");
                        }
                        else{
                            System.out.println("Try Again");
                        }
                    }
                    case 2->{
                        System.out.println("Enter Username");
                        name=sc.readLine();
                        System.out.println("Enter Password");
                        pass_key=Integer.parseInt(sc.readLine());

                        if(!Login.login(name,pass_key)){
                            System.out.println("Login Failed");
                        }
                    }
                    case 3->{
                        System.out.println("Thanks for visiting");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid input! Please try again.");
                }
            }
            catch(Exception e){
                System.out.println("Invalid input");
            }
        }
    }
}