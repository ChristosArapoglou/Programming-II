import java.util.Scanner;
import java.sql.*;

public class VerifyTest{
    //A dummmy main created to test the functionality of Verify class.
    public static void main(String args[]) {
        Connection dbcon = Database.initiateConnection();
        boolean flag;
        Scanner sc = new Scanner(System.in);
        System.out.println("Give an email address.");
        do {
            String email = sc.nextLine();
            flag = Verify.uniqueEmail(dbcon, email);
        } while (flag);
        System.out.println("Insert your username and password.");
        do {
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            flag = Verify.login(dbcon, username, password);
        } while (flag);
    }
}