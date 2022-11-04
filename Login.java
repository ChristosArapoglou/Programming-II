public class Login {
    String username;
    String password;
    Scanner in = new Scanner(System.in);
    void ask_userName() {
        System.out.println("Please, give your username")
        username = in.nextLine();
    }
    void ask_password() {
        System.out.println("Please, give your password")
        password=in.nextLine();
    }
/*  void logout(String username, String password) {
        username = null;
        password = null;
    }  */

}