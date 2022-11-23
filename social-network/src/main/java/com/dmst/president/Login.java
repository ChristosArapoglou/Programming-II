import java.util.Scanner;

public class Login {
    User connection = new User();
    String username;
    String password;
    Scanner in = new Scanner(System.in);
    void ask_userName() {
        System.out.println("Please, give your username");
        username = in.nextLine();
    }
    void ask_password() {
        System.out.println("Please, give your password");
        password=in.nextLine();
    }
    void connectornot() {
        if (connection.verify(username, password)) {
            System.out.println("Correct credentials, have a nice experience in our web");
        }
        else {
            System.out.println("Sorry, your credentials are incorrect!");
            System.out.println();
            System.out.println("Please,try again!");
            ask_userName();
            ask_password();
        }
    }
/*  void logout(String username, String password) {
        username = null;
        password = null;
    }  */

}
