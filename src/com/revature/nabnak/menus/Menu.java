package com.revature.nabnak.menus;

import java.io.*;

// abstract classes
public abstract class Menu {

    protected String name; // only allows classes within the package or sub-class to access
    protected String route;
    protected BufferedReader terminalReader; // dependency injection - as a requirement for the class to function that you want to inject at Instantiation

    public Menu(String name, String route, BufferedReader terminalReader) {
        this.terminalReader = terminalReader;
        this.route = route;
        this.name = name;
    }

    // START GETTERS \\

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    // END GETTERS \\


    // adding abstract keyword requires any inheritors to implement the function
    public abstract void render() throws Exception;



}
