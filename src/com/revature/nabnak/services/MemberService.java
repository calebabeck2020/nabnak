package com.revature.nabnak.services;

import com.revature.nabnak.daos.MemberDao;
import com.revature.nabnak.models.Member;
import com.revature.nabnak.util.*;
import com.revature.nabnak.util.custom_collections.LinkedList;
import com.revature.nabnak.util.exceptions.*;

import java.io.*;

public class MemberService {

    MemberDao memberDao = new MemberDao();

    public Member registerMember(Member newMember) {

        try {
            if (!isMemberValid(newMember)) {
                throw new RuntimeException("New Member is invalid");
            }
            if (!isEmailAvailable(newMember.getEmail())) {
                throw new RuntimeException("Member email is invalid");
            }

            memberDao.create(newMember);

        } catch (InvalidUserInputException e) {
            CustomLogger.logToFile(e);
            e.printStackTrace();
            return null;
        }

        return newMember;
    }

    public Member login(Member member) {
        return member;
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

    public boolean isEmailAvailable(String email) {
        // initialize list of members from the database
        LinkedList<Member> memberList = memberDao.findAll();
        Member member;
        boolean available = true;

        for (int i = 0; i < memberList.size(); i++) {
            if(memberList.get(i).getEmail().equalsIgnoreCase(email)) {
                CustomLogger.logToFile("User inputted email already in use: '" + email + '\'');
                available = false;
                break;
            }
        }

        return available;
    }

}
