package com.revature.nabnak;

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

        // Define the datatype in the array, this is the only acceptable type
        // Arrays are fixed in size

        // print out the welcome messages
        System.out.println(welcomeMessages[0]);
        printLoginRegisterExit();

        boolean running = true;

        while (running) {
            try { // try-block leverages risky code that might throw an Exception
                String input = terminalReader.readLine(); //throws an IOException, MUST be handled before compilation

                switch (input) {
                    case "1":
                        System.out.println("User has selected login..."); // login message
                        printLoginRegisterExit();
                        break;
                    case "2":
                        System.out.println("User has selected register..."); // register message
                        register(); // invoke register method
                        printLoginRegisterExit();
                        break;
                    case "3":
                        System.out.println("User wishes to view other members");
                        Member[] members = readFile();

                        for (Member member: members) {
                            System.out.println(member);
                        }

                        break;
                    case "4":
                        System.out.println("User has selected Exit. Have a nice day!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input, try again...");
                        printLoginRegisterExit();
                }

            } catch (IOException e) { // catches IOException and assigns it to variable 'e'
                e.printStackTrace();
            }
        }
    }

    public static void printLoginRegisterExit() {
        System.out.println("Please select one of the following:");
        System.out.println(welcomeMessages[1]);
        System.out.println(welcomeMessages[2]);
        System.out.println(welcomeMessages[3]);
        System.out.println(welcomeMessages[4]);
    }

    public static void register() throws IOException { // throws + ExceptionName is known as DUCKING

        System.out.println("Please enter your email: ");
        String email = terminalReader.readLine();

        System.out.println("Please enter your full name: ");
        String fullName = terminalReader.readLine();

        System.out.println("Please enter months of experience: ");
        String experienceMonths = terminalReader.readLine();

        String registrationDate = LocalDateTime.now().toString();


        // System.out.printf("New User registered under:\n %s,%s,%s,%s", email, fullName, experienceMonths, registrationDate);

        File memoryFile = new File("resources/data.txt");

        // try with resources block (extends AutoCloseable, so file auto-closes)
        // in this case, fileWriter is auto-closed, REMEMBER TO ALWAYS CLOSE YOUR RESOURCES
        try(FileWriter fileWriter = new FileWriter(memoryFile, true);) {

            Member member = new Member(email,fullName,Integer.parseInt(experienceMonths),registrationDate);
            System.out.println("New user has registered: " + member);
            fileWriter.write(member.writeToFile());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Member[] readFile() { // want to return a String Array containing User Information
        Member[] members = new Member[100];

        try ( // initialize the try-with-resources block for our fileReader
                FileReader fileReader = new FileReader("resources/data.txt");
                BufferedReader reader = new BufferedReader(fileReader)
        ) {

            String line = reader.readLine(); // first line of the file is assigned to the String 'line'
            int index = 0; // line index

            // while block will repeat until there are no more lines to read (line = null)
            while(line != null) {
                String[] memberInfo = line.split(",");
                Member member = new Member();

                // assigning values to each member in the Member array
                member.setEmail(memberInfo[0]);
                member.setFullName(memberInfo[1]);
                // wrapper classes auto box (can convert back to primitive values)
                member.setExperienceMonths(Integer.parseInt(memberInfo[2]));
                member.setRegistrationDate(memberInfo[3]);
                member.setPassword(memberInfo[4]);

                members[index] = member; // line is added to String array of members
                index++; // increment line index
                line = reader.readLine(); // the next file line is assigned to 'line'
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return members;
    }

}
