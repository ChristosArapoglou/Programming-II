import java.util.*;
import java.text.SimpleDateFormat;


public class Validate{

   public static boolean  valdob(String s){
        SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy");
        Date BOD= null;
        df.setLenient(false);
        
        try{
            BOD= df.parse(s); 
            return true;
        }catch(Exception e){
           
            return false;
           

        }
    } 

}