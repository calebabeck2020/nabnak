package com.revature.nabnak.menus;

import com.revature.nabnak.util.MenuRouter;

import java.io.BufferedReader;

public class LoginMenu extends Menu{

    public LoginMenu(BufferedReader terminalReader, MenuRouter menuRouter) {
        super("Login", "/login", terminalReader, menuRouter);
    }


    @Override
    public void render() throws Exception {

    }
}
