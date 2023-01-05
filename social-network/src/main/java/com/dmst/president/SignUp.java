package com.dmst.president;

import java.util.Scanner;
import java.util.GregorianCalendar;

public class SignUp {
    /*declaration of variables*/
    String firstName;
    String lastName;
    String username;
    String password;
    String email;
    String sn;
    GregorianCalendar dob;
    String stDept;
    Scanner in = new Scanner(System.in);
    /*welcoming the user to the platform*/
    void welcomingUser() {
    	System.out.println("Welcome to UniPost!");
    	System.out.println("You will need to fill in your details below.");
    }
    /*asks from the user to give his first name*/
    void askFirstName() {
        System.out.println("Please, give your first name");
        firstName = in.nextLine();
    }
    /*asks from the user to give his last name*/
    void askLastName() {
        System.out.println("Please, give your last name");
        lastName = in.nextLine();
    }
    /*asks from the user to give his user name that he will use in the platform*/
    void  askUserName() {
        System.out.println("Please, give your username");
        username = in.nextLine();
    }
    /*asks from the user to create password for his user name*/ 
    void  askPassword() {
        System.out.println("Please, create your password");
        password = in.nextLine();
    }
    /*asks from the user to give his email*/  
    void askEmail() {
        System.out.println("Please, give your email");
        email = in.nextLine();
    }
    /*asks from the user to give his student number*/   
    void askStudentNumber() {
        System.out.println("Please, give your student number");
        sn = in.nextLine();
    }
    /*asks from the user to give his date of birth*/
     void askDateOfBirth() {
        System.out.print("Please, enter your date of birth: ");
        System.out.println("Year: ");
        int year = in.nextInt();
        System.out.println("Month: ");
        int month = in.nextInt();
        System.out.println("Day: ");
        int day = in.nextInt();    
        dob = new GregorianCalendar(year, month, day);
     }
     /*asks from the user to give his study department*/
     void askStudyDepartment() {
        System.out.println("Please, enter your study department.");
        stDept = in.nextLine();
        stDept = in.nextLine();
    }
}
