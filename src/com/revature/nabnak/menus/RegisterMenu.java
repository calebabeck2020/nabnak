package com.revature.nabnak.menus;

import com.revature.nabnak.models.*;
import com.revature.nabnak.services.MemberService;
import com.revature.nabnak.util.*;
import java.io.*;
import java.time.LocalDateTime;


public class RegisterMenu extends Menu {


    public RegisterMenu(BufferedReader terminalReader, MenuRouter menuRouter) {
        super("Register", "/register", terminalReader, menuRouter);
    }

    @Override
    public void render() throws IOException {

        System.out.println("Please enter your email: ");
        String email = terminalReader.readLine();
        CustomLogger.logToFile("User entered valid email");

        System.out.println("Please enter your full name: ");
        String fullName = terminalReader.readLine();
        CustomLogger.logToFile("User entered valid full name");

        System.out.println("Please enter months of experience: ");
        int experienceMonths = Integer.parseInt(terminalReader.readLine());
        CustomLogger.logToFile("User entered valid experience in months");

        String registrationDate = LocalDateTime.now().toString();

        System.out.println("Please enter your password: ");
        String password = terminalReader.readLine();
        CustomLogger.logToFile("User entered valid password");


        // System.out.printf("New User registered under:\n %s,%s,%s,%s", email, fullName, experienceMonths, registrationDate);

        Member newMember = new Member(email,fullName,experienceMonths,registrationDate,password);

        MemberService memberService = new MemberService();
        memberService.registerMember(newMember);

        CustomLogger.logToFile("Navigating to dashboard for " + newMember.getEmail());
        menuRouter.transfer("/dashboard");
    }
}
