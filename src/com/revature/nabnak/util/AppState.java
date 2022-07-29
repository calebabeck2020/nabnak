package com.revature.nabnak.util;

import com.revature.nabnak.menus.*;
import java.io.*;

public class AppState {

    private static boolean isRunning; // true while the application 'is running'
    private final MenuRouter menuRouter;


    public AppState() {
        isRunning = true;
        menuRouter = new MenuRouter();

        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));

        WelcomeMenu welcomeMenu = new WelcomeMenu(terminalReader, menuRouter);
        RegisterMenu registerMenu = new RegisterMenu(terminalReader, menuRouter);
        DashboardMenu dashboardMenu = new DashboardMenu(terminalReader, menuRouter);

        menuRouter.addMenu(welcomeMenu);
        menuRouter.addMenu(registerMenu);
        menuRouter.addMenu(dashboardMenu);
    }

    public void startUp() {

        CustomLogger.openLogger();

        while (isRunning) {
            menuRouter.transfer("/welcome");
        }

        CustomLogger.closeLogger();
    }

    public static void shutdown() {
        isRunning = false;
    }

}
