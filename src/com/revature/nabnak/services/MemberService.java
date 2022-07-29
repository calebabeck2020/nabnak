package com.revature.nabnak.services;

import com.revature.nabnak.models.Member;
import com.revature.nabnak.util.*;
import com.revature.nabnak.util.exceptions.*;

import java.io.*;

public class MemberService {

    public Member registerMember(Member newMember) {

        try {
            if (!isMemberValid(newMember)) {
                throw new RuntimeException("New Member is invalid");
            }

            File memoryFile = new File("resources/data.txt");

            // try with resources block (extends AutoCloseable, so file auto-closes)
            // in this case, fileWriter is auto-closed, REMEMBER TO ALWAYS CLOSE YOUR RESOURCES
            try(FileWriter fileWriter = new FileWriter(memoryFile, true);) {

                System.out.println("New user has registered: " + newMember);
                fileWriter.write(newMember.writeToFile());
                CustomLogger.logToFile("New User added to database: " + newMember);

            } catch (IOException e) {
                e.printStackTrace();
            }
            //TODO: LOG INFO AS PERSISTED

        } catch (InvalidUserInputException e) {
            e.printStackTrace();
            return null;
        }

        return newMember;
    }

    public boolean isMemberValid(Member newMember) {
        if (newMember == null) return false;
        if (newMember.getEmail() == null || newMember.getEmail().trim().equals("")) return false;
        if (newMember.getFullName() == null || newMember.getFullName().trim().equals("")) return false;
        if (newMember.getExperienceMonths() <= 0) return false;
        if (newMember.getRegistrationDate() == null || newMember.getRegistrationDate().trim().equals("")) return false;
        if (newMember.getPassword() == null || newMember.getPassword().trim().equals("")) return false;

        return true; // the member is valid
    }

    // TODO: THIS FUNCTION INTERACTS WITH THE DATABASE, SHOULD IMPLEMENT IN 'MemberDao' CLASS
    public Member[] getMemberList() {
        Member[] members = new Member[10];

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
            CustomLogger.logToFile(e);
        }

        return members;
    }

    public boolean isEmailAvailable(String email) {
        // initialize list of members from the database
        Member[] memberList = getMemberList();
        boolean available = true;

        for (Member member: memberList) {
            if(member.getEmail().equals(email)) {
                CustomLogger.logToFile("User inputted email already in use: '" + email + '\'');
                available = false;
                break;
            }
        }

        return available;
    }

}
