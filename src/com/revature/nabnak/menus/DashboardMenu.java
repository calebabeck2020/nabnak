package com.revature.nabnak.menus;

import com.revature.nabnak.util.AppState;
import com.revature.nabnak.util.CustomLogger;
import com.revature.nabnak.util.MenuRouter;


import java.io.*;

public class DashboardMenu extends Menu {

    public DashboardMenu(BufferedReader terminalReader, MenuRouter menuRouter) {
        super("Dashboard", "/dashboard", terminalReader, menuRouter);
    }

    @Override
    public void render() throws IOException {
        System.out.println("Welcome to your Dashboard!\n 1) Make a card\n 2) Exit Application");
        String userInput = terminalReader.readLine();

        switch (userInput) {
            case "1":
                System.out.println("Making a kanban card...");
                CustomLogger.logToFile("User selected Make a Card");
                break;
            case "2":
                System.out.println("User has selected Exit. Have a nice day!");
                CustomLogger.logToFile("User selected Exit Application, shutting down...");
                AppState.shutdown();
                break;
            default:
                System.out.println("Invalid selection, please try again...");
                CustomLogger.logToFile("User input error, returning to Welcome Menu");
        }

    }
}
