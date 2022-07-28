package com.revature.nabnak.menus;

import com.revature.nabnak.util.MenuRouter;

import java.io.BufferedReader;

public class DashboardMenu extends Menu {

    public DashboardMenu(BufferedReader terminalReader, MenuRouter menuRouter) {
        super("Dashboard", "", terminalReader, menuRouter);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Welcome to your Dashboard!\n 1) Make a card\n 2) Exit Application");

        String userInput = terminalReader.readLine();

        switch (userInput) {
            case "1":
                System.out.println("Making a kanban card...");
                break;
            case "2":
                System.out.println("User has selected exit. Hope to see you soon!");
                break;
            default:
                System.out.println("Invalid selection, please try again...");
        }

    }
}
