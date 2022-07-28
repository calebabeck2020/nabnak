package com.revature.nabnak;

import com.revature.nabnak.menus.WelcomeMenu;
import com.revature.nabnak.models.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

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

        // initialize BufferedReader to read user input
        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            WelcomeMenu welcomeMenu = new WelcomeMenu(terminalReader);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
