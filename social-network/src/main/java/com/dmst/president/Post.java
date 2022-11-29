

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat; 
import java.util.Scanner;

public class Post {

    private Date creationDate; // This instance variable is necessary only in case we need to keep the date as a date type(for SQL)
    private String strDate;
    private int likes = 0;  // TODO: later
    private String text;
    private String creator; // User's username

    public Post(String text, String creator) {
        Date creationDate = new Date(); // Current date is allocated on variable creationDate type Date
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");  // The preffered format is implemented
        this.strDate = dateFormat.format(creationDate); // Variable creationDate is converted to String using the format method 
        this.text = text;
        this.creator = creator;
    }

    @Override
    public String toString() {   
        /*  This method is used to display a post
         If the post exceeds the 70 character limit
         Then a StringBuffer is used to insert an escape character */

        StringBuffer sb = new StringBuffer(text); 
        int lines = sb.length() / 70;            
        for (int i=1; i <= lines; i++) {        
            sb.insert(i * 70, "\n");
        }
        String s = String.format("--------------------------------"+
                    "--------------------------------------\n"+
                    "User %s posted:%40s\n\n%s\n%70s\n"+
                    "--------------------------------------"+
                    "--------------------------------"
                ,creator, strDate, sb.toString(), "Likes:" +likes);
        return s;
    
    
    }


    public static void main(String[] args) {  // dummy main :)
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your thoughts :");
        Post p = new Post(in.nextLine(), "Alexis Mardas");
        System.out.println(p);
        
    }
    
    /* public void react() {
        this.likes++;
    } */ 
    
}
