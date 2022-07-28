package com.revature.nabnak;

import com.revature.nabnak.menus.*;
import com.revature.nabnak.models.*;
import com.revature.nabnak.util.*;

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

        AppState appState = new AppState();

        appState.startUp();



    }



}
