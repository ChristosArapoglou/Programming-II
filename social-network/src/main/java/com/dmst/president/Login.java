
import java.util.Scanner;

 /*The class Login ask from user to enter his/her credentials and accordingly to that,
    he/she can connect in our website */
public class Login {
    User connection = new User();
    String username;
    String password;
    Scanner in = new Scanner(System.in);
    void ask_userName() {
        System.out.println("Please, give your username"); /*Ask from user to enter his/her username*/
        username = in .nextLine();
    }
    void ask_password() {
        System.out.println("Please, give your password"); /*Ask from user to enter his/her password*/
        password = in .nextLine();
    }
    boolean stop = false;
    void connectornot() {
        do {
            /*The method connectornot verifies user's credentials via User class */
           /* and prints messages about the results of verification */


            if (connection.verify(username, password)) {
                System.out.println("Correct credentials, have a nice experience in our web");
                stop = true;
                /*edo prepei na anoigei to parathyro ths efarmoghs */
                
            }   
            else {
                System.out.println("Sorry, your credentials are incorrect!");
                System.out.println();
                System.out.println("Please,try again!");

                ask_userName();
                ask_password();
            }

        } while (stop = true);

    }
}
/*  void logout(String username, String password) {
        username = null;
        password = null;
    }  */