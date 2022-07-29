package com.revature.nabnak.menus;

import com.revature.nabnak.models.Member;
import com.revature.nabnak.util.AppState;
import com.revature.nabnak.util.CustomLogger;
import com.revature.nabnak.util.MenuRouter;

import java.io.*;
import java.time.LocalDateTime;

import static com.revature.nabnak.util.AppState.shutdown;

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
        System.out.println(welcomeMessages[1]);
        System.out.println(welcomeMessages[2]);
        System.out.println(welcomeMessages[3]);
        System.out.println(welcomeMessages[4]);

            try { // try-block leverages risky code that might throw an Exception
                String input = terminalReader.readLine(); //throws an IOException, MUST be handled before compilation

                switch (input) {
                    case "1":
                        System.out.println("User has selected login..."); // login message
                        CustomLogger.logToFile("User selected Login, navigating to login");
                        menuRouter.transfer("/login");

                        break;
                    case "2":
                        System.out.println("User has selected register..."); // register message
                        CustomLogger.logToFile("User selected Register, navigating to register");
                        menuRouter.transfer("/register");

                        break;
                    case "3":
                        System.out.println("User wishes to view other members"); // view members message
                        CustomLogger.logToFile("User selected View Members");
                        break;
                    case "4":
                        System.out.println("User has selected Exit. Have a nice day!"); // exit message
                        CustomLogger.logToFile("User selected Exit Application, shutting down...");
                        AppState.shutdown();
                        break;
                    default:
                        System.out.println("Invalid input, try again..."); // invalid input message
                        CustomLogger.logToFile("User input error, returning to WelcomeMenu");
                }

            } catch (IOException e) { // catches IOException and assigns it to variable 'e'
                e.printStackTrace();
                CustomLogger.logToFile(e);
            }

    }
}
