package com.revature.nabnak.menus;

import com.revature.nabnak.models.Member;
import com.revature.nabnak.util.MenuRouter;

import java.io.*;
import java.time.LocalDateTime;

public class WelcomeMenu extends Menu {

    static String[] welcomeMessages = {"Welcome to Nabnak", "1) Login", "2) Register", "3) View Members", "4) Exit Application"};

    public WelcomeMenu(BufferedReader terminalReader, MenuRouter menuRouter) {
        super("Welcome", "/welcome", terminalReader, menuRouter);
    }

    @Override // overriding the method that the Class is inheriting
    public void render() {

        // Define the datatype in the array, this is the only acceptable type
        // Arrays are fixed in size

        // print out the welcome messages
        System.out.println(welcomeMessages[0]);
        printLoginRegisterExit();

            try { // try-block leverages risky code that might throw an Exception
                String input = terminalReader.readLine(); //throws an IOException, MUST be handled before compilation

                switch (input) {
                    case "1":
                        System.out.println("User has selected login..."); // login message

                        printLoginRegisterExit();
                        break;
                    case "2":
                        System.out.println("User has selected register..."); // register message

                        printLoginRegisterExit();
                        break;
                    case "3":
                        System.out.println("User wishes to view other members");

                        break;
                    case "4":
                        System.out.println("User has selected Exit. Have a nice day!");

                        break;
                    default:
                        System.out.println("Invalid input, try again...");
                        printLoginRegisterExit();
                }

            } catch (IOException e) { // catches IOException and assigns it to variable 'e'
                e.printStackTrace();
            }

    }

    private void printLoginRegisterExit() {
        System.out.println("Please select one of the following:");
        System.out.println(welcomeMessages[1]);
        System.out.println(welcomeMessages[2]);
        System.out.println(welcomeMessages[3]);
        System.out.println(welcomeMessages[4]);
    }
}
