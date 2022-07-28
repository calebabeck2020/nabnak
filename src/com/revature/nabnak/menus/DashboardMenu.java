package com.revature.nabnak.menus;

import com.revature.nabnak.util.MenuRouter;

import java.io.BufferedReader;

public class DashboardMenu extends Menu {

    public DashboardMenu(BufferedReader terminalReader, MenuRouter menuRouter) {
        super("Dashboard", "", terminalReader, menuRouter);
    }

    @Override
    public void render() throws Exception {

    }
}
