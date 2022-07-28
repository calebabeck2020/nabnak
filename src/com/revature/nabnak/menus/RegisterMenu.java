package com.revature.nabnak.menus;

import com.revature.nabnak.models.Member;

import java.io.*;
import java.time.LocalDateTime;

public class RegisterMenu extends Menu {


    public RegisterMenu(BufferedReader terminalReader) {
        super("Register", "/welcome/register", terminalReader);
    }

    @Override
    public void render() throws IOException {

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

            // build a new member using the User's input values
            Member member = new Member(email,fullName,Integer.parseInt(experienceMonths),registrationDate);
            System.out.println("New user has registered: " + member);
            fileWriter.write(member.writeToFile());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Member[] readFile() { // want to return a String Array containing User Information
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
