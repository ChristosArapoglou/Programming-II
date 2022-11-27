import java.util.Scanner;

/*The class Login ask from user to enter his/her credentials,
and accordingly to that,
he/she can connect in our website */
public class Login {
    User connection = new User();
    String username;
    String password;
    Scanner in = new Scanner(System.in);
    /*Ask from user to enter his/her username*/
    void askUserName() {
        System.out.println("Please, give your username"); 
        username = in .nextLine();
    }
    /*Ask from user to enter his/her password*/
    void askPassword() {
        System.out.println("Please, give your password"); 
        password = in .nextLine();
    }
    boolean stop = false; 
    /*The method connectornot verifies user's credentials
    via User class and prints messages 
    about about the results of verification */

    void connectornot() {
        do {
            if (connection.verify(username, password)) {
                System.out.println("Correct credentials, have a nice experience in our web");
                stop = true;
                /*edo prepei na anoigei to parathyro ths efarmoghs */
            }   else {
                System.out.println("Sorry, your credentials are incorrect!");
                System.out.println();
                System.out.println("Please,try again!");

                askUserName();
                askPassword();
            }

        } while (stop = true);

    }
}

