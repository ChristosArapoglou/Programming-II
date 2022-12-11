package com.dmst.president;

import java.util.Scanner;
import java.util.InputMismatchException;

public class LogOut {


    public void logout() throws InputMismatchException {
        Scanner input = new Scanner(System.in);

        boolean flag =true;
        
        while(flag==true) {
        
        System.out.println("");
        System.out.print("Do you want to log out?");
        System.out.print(" Press Y for Yes or N for No");
        System.out.println("");

        String answer = input.nextLine();

        if(answer.equals("Y")) {
            System.out.println("Do you want to close the app or head back to the login page?");
            System.out.print(" Press C for closing the app or L for heading back to the login page. ");
            System.out.println("");

            String answer2 = input.nextLine();
            if(answer2.equals("C")){
               System.exit(1);
            } else if(answer2.equals("L")) {
                Login login = new Login();
                login.askUserName();
                login.askPassword();
                login.connectornot();
                flag =false;
            } else {
                 System.out.println("Please enter a valid charachter. ");
                 
            }

        } else{
            System.out.println("Please enter a valid charachter. ");
            
        }
    }

        input.close();
    }

}