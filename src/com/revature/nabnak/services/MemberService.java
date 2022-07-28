package com.revature.nabnak.services;

import com.revature.nabnak.models.Member;
import com.revature.nabnak.util.exceptions.InvalidUserInputException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    // TODO: IMPLEMENT ME!!!
    public boolean isEmailAvailable() {
        return false;
    }

}
