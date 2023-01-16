package com.dmst.president;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class asks the user to input their personal data in order
 * to sign up to our social media platform. After verifying that
 * their Student Number and email are unique (there aren't duplicates
 * in the database), their sign up is completed and is registered to
 * our database.
 */
public class SignUp {
    /**
     * User's Student Number.
     */
    private String sn;
    /**
     * User's first name.
     */
    private String firstName;
    /**
     * User's last name.
     */
    private String lastName;
    /**
     * User's username.
     */
    private String username;
    /**
     * User's password.
     */
    private String password;
    /**
     * User's email.
     */
    private String email;
    /**
     * User's date of birth.
     */
    private String dob;
    /**
     * User's AUEB study department.
     */
    private String stDept;
    private final Scanner in = new Scanner(System.in);
    private static final long DELAYDURATION = 1000;
    /**
     * This method asks the user for their Student Number.
     */
    protected String askSn(final Connection dbcon) {
        System.out.println("Please, enter your student number.");
        do {
            sn = in.nextLine();
        } while (uniqueSn(dbcon, sn));
        System.out.println("Accepted student number.");
        UniPost.delay(DELAYDURATION);
        return sn;
    }
    /**
     * This method asks the user for their first name.
     */
    protected String askFirstName() {
        System.out.println("Enter your first name.");
        final String firstName = in.nextLine();
        return firstName;
    }
    /**
     * This method asks the user for their last name.
     */
    protected String askLastName() {
        System.out.println("Enter your last name.");
        final String lastName = in.nextLine();
        return lastName;
    }
    /**
     * This method asks the user for their username.
     */
    protected String askUsername() {
        System.out.println("Enter your username.");
        final String username = in.nextLine();
        return username;
    }
    /**
     * This method asks the user for their password.
     */
    protected String askPassword() {
        System.out.println("Create your password.");
        final String password = in.nextLine();
        return password;
    }
    /**
     * This method asks the user for their study department.
     */
    protected String askStDept() {
       System.out.println("Enter your study department.");
       final String stDept = in.nextLine();
       return stDept;
    }
    /**
     * This method asks the user for their date of birth.
     */
    protected String askDob() {
        System.out.println("Enter your date of birth: ");
        System.out.println("Year: ");
        final int year = in.nextInt();
        System.out.println("Month: ");
        final int month = in.nextInt();
        System.out.println("Day: ");
        final int day = in.nextInt();
        dob = year + "-" + month + "-" + day;
        return dob;
    }
    /**
     * This method asks the user for their email. A verification check
     * is executed in this method to ensure that the user's email is not
     * already registered in the database.
     */
    protected String askEmail(final Connection dbcon) {
        System.out.println("Enter your email address.");
        do {
            email = in.nextLine();
        } while (uniqueEmail(dbcon, email));
        System.out.println("Accepted email address.");
        UniPost.delay(DELAYDURATION);
        return email;
    }
    /**
     * This method takes the user's email as a parameter and checks
     * whether this email exists in the database or not. If it doesn't,
     * the user can proceed with the sign up process. If it exists, it
     * means that some other user uses this email, so he has to enter a
     * different, unique email address to continue.
     */
    protected static boolean uniqueEmail(final Connection dbcon, final String email) {
        boolean flag = false;
        Statement stmt;
        try {
            stmt = dbcon.createStatement();
            final String query = "SELECT * FROM JUsers WHERE email = '" + email + "'";
            final ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                System.err.println("This email already exists. "
                    + "Please insert a new email address.");
                flag = true;
            }
            rs.close();
            stmt.close();
        } catch (final SQLException e) {
            System.out.print("SQLException: ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * This method takes the user's student number as a parameter and checks
     * whether this sn exists in the database or not. If it doesn't,
     * the user can proceed with the sign up process. If it exists, it
     * means that some other user uses this student number, so he has to enter a
     * different, unique sn to continue.
     */
    protected static boolean uniqueSn(final Connection dbcon, final String sn) {
        boolean flag = false;
        Statement stmt;
        try {
            stmt = dbcon.createStatement();
            final String query = "SELECT * FROM JUsers WHERE AM = '" + sn + "'";
            final ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                System.err.println("This Student Number already exists. "
                    + "Please insert a new student number.");
                flag = true;
            }
            rs.close();
            stmt.close();
        } catch (final SQLException e) {
            System.out.print("SQLException: ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * This method takes all of the user's input data and stores it in the
     * database as a new user.
     */
    protected void newUser(final Connection dbcon) {
        DatabaseUser.insertUser(dbcon, askSn(dbcon), askFirstName(),
         askLastName(), askUsername(), askPassword(), askStDept(),
         askEmail(dbcon), askDob());
    }
}
