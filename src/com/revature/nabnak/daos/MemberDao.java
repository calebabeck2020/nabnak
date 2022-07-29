package com.revature.nabnak.daos;

import com.revature.nabnak.models.Member;
import com.revature.nabnak.util.CustomLogger;
import com.revature.nabnak.util.custom_collections.LinkedList;

import java.io.*;

public class MemberDao implements Crudable<Member> {
    // 4 primary operations for the DAO is Create, Read, Update, & Delete (CRUD)


    @Override
    public Member create(Member newMember) {
        File memoryFile = new File("resources/data.txt");

        // try with resources block (extends AutoCloseable, so file auto-closes)
        // in this case, fileWriter is auto-closed, REMEMBER TO ALWAYS CLOSE YOUR RESOURCES
        try(FileWriter fileWriter = new FileWriter(memoryFile, true)) {

            System.out.println("New user has registered: " + newMember);
            fileWriter.write(newMember.writeToFile());
            CustomLogger.logToFile("New User added to database: " + newMember);
            return newMember;

        } catch (IOException e) {
            e.printStackTrace();
            CustomLogger.logToFile(e);
            return null;
        }
    }

    @Override
    public LinkedList<Member> findAll() {
        LinkedList<Member> members = new LinkedList<>();

        try ( // initialize the try-with-resources block for our fileReader
              FileReader fileReader = new FileReader("resources/data.txt");
              BufferedReader reader = new BufferedReader(fileReader)
        ) {

            String line = reader.readLine(); // first line of the file is assigned to the String 'line'

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

                members.add(member); // line is added to String array of members
                line = reader.readLine(); // the next file line is assigned to 'line'
            }

        } catch (IOException e) {
            CustomLogger.logToFile(e);
        }

        return members;
    }

    @Override
    public Member findById(String id) {
        return null;
    }

    @Override
    public boolean update(Member updatedObject) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    public boolean loginCredentialCheck(String email, String password) {
        LinkedList<Member> memberList = findAll();
        Member member;

        for (int i = 0; i < memberList.size(); i++) {
            member = memberList.get(i);
            if (email.equalsIgnoreCase(member.getEmail()) && password.equals(member.getPassword())) {
                return true;
            }
        }

        return false;

    }
}
