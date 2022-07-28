package com.revature.nabnak.models;

// classes are blueprints for a given object
//
public class Member {
    // Section 1: fields/attributes/State/Data
    private String email;
    private String fullName;
    private int experienceMonths;
    private String registrationDate;
    private String password;

    // Section 2: Constructors
    // default no arg constructor
    public Member() {
        super(); // super is the class this is inheriting from
        // the root object of this class is called Object
    }

    // custom constructor without password input
    public Member(String email, String fullName, int experienceMonths, String registrationDate) {
        this.email = email;
        this.fullName = fullName;
        this.experienceMonths = experienceMonths;
        this.registrationDate = registrationDate;
    }

    // custom constructor with password input
    public Member(String email, String fullName, int experienceMonths, String registrationDate, String password) {
        this.email = email;
        this.fullName = fullName;
        this.experienceMonths = experienceMonths;
        this.registrationDate = registrationDate;
        this.password = password;
    }



    // Section 3: Methods

    // Encapsulation - prevent the manipulation of data outside a class
    // EMAIL SETTER/GETTER
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email; // inside the scope of the Object
    }

    // FULL NAME SETTER/GETTER
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    // EXPERIENCE MONTHS SETTER/GETTER
    public void setExperienceMonths(int experienceMonths) {
        this.experienceMonths = experienceMonths;
    }

    public int getExperienceMonths() {
        return experienceMonths;
    }

    // REGISTRATION DATE SETTER/GETTER
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    // PASSWORD SETTER/GETTER
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password; // inside the scope of the Object
    }


    public String writeToFile() {
        return email + "," + fullName + "," + experienceMonths + "," + registrationDate + "," + password + "\n";
    }

    // Polymorphism - overriding the toString() function
    @Override // metadata  annotation to show the function is being overridden
    public String toString() {
        return "Member{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", experienceMonths='" + experienceMonths + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';

    }
}
