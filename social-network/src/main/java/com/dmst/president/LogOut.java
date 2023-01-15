package com.dmst.president;

import java.util.Scanner;
import java.sql.Connection;
import java.util.InputMismatchException;

/**
 * This class is used to log out users from the application.
 * After logging out, the program returns to its initial wall,
 * where it asks the user if he would like to log in or
 * sign up.
 */
 class LogOut {
    /**
     * This method is designed to help users log out from the
     * app smoothly. After logging out, it asks the user if he
     * desires to sign up or log in again.
     */
    protected void logout() throws InputMismatchException {
        final Connection dbcon = Database.initiateConnection();
        final Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("");
            System.out.print("Do you want to log out?");
            System.out.print(" Press Y for Yes or N for No");
            System.out.println("");
            final String answer = input.nextLine();
            if (answer.equals("Y")) {
                System.out.println("Do you want to close the app or"
                + "head back to the login page?");
                System.out.print(" Press C for closing the app or L "
                + "for heading back to the login page. ");
                System.out.println("");
                final String answer2 = input.nextLine();
                if (answer2.equals("C")) {
                System.exit(1);
                } else if (answer2.equals("L")) {
                    final Login login = new Login();
                    login.askSN();
                    login.askPassword();
                    login.verify(dbcon);
                    flag = false;
                } else {
                    System.out.println("Please enter a valid character. ");
                }
            } else {
                System.out.println("Please enter a valid character. ");
            }
        }
        input.close();
    }
}

