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
    static BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
    static String[] welcomeMessages = {"Welcome to Nabnak", "1) Login", "2) Register", "3) View Members", "4) Exit Application"};

    public static void main(String[] args) {

        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));

        WelcomeMenu welcomeMenu = new WelcomeMenu(terminalReader);

    }



}
