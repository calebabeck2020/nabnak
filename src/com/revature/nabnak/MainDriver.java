package com.revature.nabnak;

import com.revature.nabnak.menus.*;
import com.revature.nabnak.models.*;
import com.revature.nabnak.util.MenuRouter;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.*;



/* This software is a kanban board for professional developers aimed
    to be the next best virtual board online.

    GOAL: allow team members to join the app, be assigned a role and
    share their Kanban cards
*/

public class MainDriver {

    // initialize BufferedReader to read user input

    public static void main(String[] args) {

        boolean isRunning = true;

        // initialize BufferedReader to read user input
        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
        MenuRouter menuRouter = new MenuRouter();

        WelcomeMenu welcomeMenu = new WelcomeMenu(terminalReader, menuRouter);
        RegisterMenu registerMenu = new RegisterMenu(terminalReader, menuRouter);
        DashboardMenu dashboardMenu = new DashboardMenu(terminalReader, menuRouter);

        menuRouter.addMenu(welcomeMenu);
        menuRouter.addMenu(registerMenu);
        menuRouter.addMenu(dashboardMenu);

        while(isRunning) {

        }



    }



}
