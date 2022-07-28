package com.revature.nabnak.menus;

import java.io.BufferedReader;

public class RegisterMenu extends Menu {


    public RegisterMenu(BufferedReader terminalReader) {
        super("Register", "/welcome/register", terminalReader);
    }

    @Override
    public void render() {

    }
}
