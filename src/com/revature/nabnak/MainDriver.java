package com.revature.nabnak;

import com.revature.nabnak.models.*;
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
                        break;
                    case "2":
                        System.out.println("Register");
                        register(); // invoke register method
                        break;
                    case "3":
                        System.out.println("Exit");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input, please try again");
                        System.out.println(welcomeMessages[1]);
                        System.out.println(welcomeMessages[2]);
                        System.out.println(welcomeMessages[3]);
                }

            } catch (IOException e) { // catches IOException and assigns it to variable 'e'
                e.printStackTrace();
            }
        }
    }

    public static void register() throws IOException {

        System.out.println("Please enter your email: ");
        String email = terminalReader.readLine();

        System.out.println("Please enter your full name: ");
        String fullName = terminalReader.readLine();

        System.out.println("Please enter months of experience: ");
        String experienceMonths = terminalReader.readLine();

        System.out.println("Please enter your registration date: ");
        String registrationDate = terminalReader.readLine();

        System.out.printf("New User registered under:\n %s,%s,%s,%s", email, fullName, experienceMonths, registrationDate);

        File memoryFile = new File("resources/data.txt");

        // try with resources block (EXTENDS AutoCloseable, so file auto-closes
        try(FileWriter fileWriter = new FileWriter(memoryFile, true);) {

            Member member = new Member(email,fullName,Integer.parseInt(experienceMonths),registrationDate,"password");
            fileWriter.write(member.writeToFile());

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
