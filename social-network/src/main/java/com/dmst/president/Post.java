

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;




public class Post {

    private java.sql.Date creationDate;
     //TODO: add time to instance variables
    private int likes = 0;  // TODO: later
    private String text;
    private String creator; // User's username


    // TODO: write void createPost method that invokes constructor
    public Post(String text, String creator) {
        creationDate = new java.sql.Date(System.currentTimeMillis());
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
                    "User %s posted:%40s\n\n%s\n\n"+
                    "--------------------------------------"+
                    "--------------------------------"
                ,creator, creationDate.toString(), sb.toString());
        return s;
    
    
    }

    public static void main(String[] args) {  // dummy main :)

        Post p = new Post("Eimai malakas kai grafo megala"+
        "keimena gia na talaiporeitai onjfnwefnewfnewfewfef"+
        "bewifbewfbewbfiewfbewifbewifbewuibfewuibfewubfewubfe"+
        "wubfuewibfewiubfewbfewifbeuiufbeibfiewubfewuifbuewifbuewbf"+
        "ewubfuewbfewuibfebewubfwefbebaleksis elpizo h malakia pou "+
        "exo grapseinaouleueiopow tha htthela", "Alexis Mardas" );
        System.out.println(p);
    }
    
    /* public void react() {
        this.likes++;
    } */ 
    
}


