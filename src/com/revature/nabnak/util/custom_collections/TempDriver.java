package com.revature.nabnak.util.custom_collections;

import com.revature.nabnak.models.Member;

import javax.sound.midi.Soundbank;

public class TempDriver {

    public static void main(String[] args) {

        LinkedList<Member> members = new LinkedList<>();

        members.add(new Member());
        members.add(new Member());
        members.add(new Member("email","name",12,"time"));
        members.add(new Member());

        System.out.println(members.size());
        System.out.println(members.get(2));

    }
}
