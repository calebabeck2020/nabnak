package com.revature.nabnak;

import java.util.*;
import java.io.*;

/* This software is a kanban board for professional developers aimed
    to be the next best virtual board online.

    GOAL: allow team members to join the app, be assigned a role and
    share their Kanban cards
*/

public class MainDriver {

    // initialize BufferedReader to read user input
    public static BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        // Define the datatype in the array, this is the only acceptable type
        // Arrays are fixed in size
        String[] welcomeMessages = {"Welcome to Nabnak", "1) Login", "2) Register", "3) Exit Application"};

        // print out the welcome messages
        System.out.println(welcomeMessages[0]);
        System.out.println(welcomeMessages[1]);
        System.out.println(welcomeMessages[2]);
        System.out.println(welcomeMessages[3]);

        boolean running = true;

        while (running) {
            try { // try-block leverages risky code that might throw an Exception
                String input = terminalReader.readLine(); //throws an IOException, MUST be handled before compilation

                switch (input) {
                    case "1":
                        System.out.println("Login");
                        login();
                        break;
                    case "2":
                        System.out.println("Register");
                        break;
                    case "3":
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid input, please try again");
                }

            } catch (IOException e) { // catches IOException and assigns it to variable 'e'
                e.printStackTrace();
            }
        }
    }

    public static void login() {

        try {
            System.out.println("Please enter your email: \n>");
            String email = terminalReader.readLine();

            System.out.println("Please enter your full name: \n>");
            String fullName = terminalReader.readLine();

            System.out.println("Please enter months of experience: \n>");
            String expMonths = terminalReader.readLine();

            System.out.println("Please enter your registration date: \n>");
            String regDate = terminalReader.readLine();

            System.out.printf("New User registered under:\n %s,%s,%s,%s", email, fullName, expMonths, regDate);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
