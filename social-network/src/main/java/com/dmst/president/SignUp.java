import java.util.Scanner;
import java.util.Date;
public class SignUp {
    String fname;
    String lname;
    String uname;
    String password;
    String mail;
    String snumber;
    Date dbirth;
    String sdepartment;
    Scanner in = new Scanner(System.in);
    void ask_firstName() {
        System.out.println("Please, give your first name");
        fname = in.nextLine();

    }
    void ask_lastName() {
         System.out.println("Please, give your last name");
        lname = in.nextLine();
    }
    void  ask_userName() {
        System.out.println("Please, give your username");
        uname = in.nextLine();
    }
    void  ask_password() {
        System.out.println("Please, create your password");
        password = in.nextLine();
    }
    void ask_email() {
        System.out.println("Please, give your email");
        mail = in.nextLine();
    }
    void ask_studentNumber() {
        System.out.println("Please, give your student number");
        snumber = in.nextLine();
    }
    void ask_date_of_Birth() {
        System.out.println("Please, give your date of birth");
        dbirth = in.nextLine();
    }
    void ask_studyDepartment() {
        System.out.println("Please, give your study department");
        sdepartment=in.nextLine();
    }
}
