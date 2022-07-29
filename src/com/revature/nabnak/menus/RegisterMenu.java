package com.revature.nabnak.menus;

import com.revature.nabnak.models.*;
import com.revature.nabnak.util.*;
import java.io.*;
import java.time.LocalDateTime;


public class RegisterMenu extends Menu {


    public RegisterMenu(BufferedReader terminalReader, MenuRouter menuRouter) {
        super("Register", "/welcome/register", terminalReader, menuRouter);
    }

    @Override
    public void render() throws IOException {

        System.out.println("Please enter your email: ");
        String email = terminalReader.readLine();

        System.out.println("Please enter your full name: ");
        String fullName = terminalReader.readLine();

        System.out.println("Please enter months of experience: ");
        int experienceMonths = Integer.parseInt(terminalReader.readLine());

        String registrationDate = LocalDateTime.now().toString();

        System.out.println("Please enter your password: ");
        String password = terminalReader.readLine();


        // System.out.printf("New User registered under:\n %s,%s,%s,%s", email, fullName, experienceMonths, registrationDate);

        File memoryFile = new File("resources/data.txt");

        // try with resources block (extends AutoCloseable, so file auto-closes)
        // in this case, fileWriter is auto-closed, REMEMBER TO ALWAYS CLOSE YOUR RESOURCES
        try(FileWriter fileWriter = new FileWriter(memoryFile, true);) {

            // build a new member using the User's input values
            Member member = new Member(email,fullName,experienceMonths,registrationDate, password);


            System.out.println("New user has registered: " + member);
            fileWriter.write(member.writeToFile());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
