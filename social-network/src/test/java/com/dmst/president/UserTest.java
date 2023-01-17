package com.dmst.president;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

public class UserTest {

    /*Creating the date of birth object */
    Date date_of_birth = new GregorianCalendar(2003, Calendar.NOVEMBER, 2).getTime();
    /*Creating the sign up date object */
    Date signupDate = new GregorianCalendar(2022, Calendar.SEPTEMBER, 2).getTime();
    /*Creating a user */
    User userobject = new User("Giannis", "Sarantopoulos", "giannisntop", 
          "1234@#", "johnntopoulos@aueb.gr","8382",date_of_birth, "DMST");
    
    @Test
    void testGetDate_of_birth() {
       /*Converting date_of_birth variable into a String */
        SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
        String expecteddob= sdf.format(date_of_birth);
        String actualdob = sdf.format(userobject.getDob());
        
        assertEquals(expecteddob, actualdob);
    }

    @Test
    void testGetEmail() {
        String expectedemail= "johnntopoulos@aueb.gr";
        String actualemail= userobject.getEmail();
        assertTrue(expectedemail.equals(actualemail));
    }

    @Test
    void testGetFirst_name() {
       String expectedfname= "Giannis";
       String actualfname= userobject.getFirstName();
       assertEquals(expectedfname, actualfname);
    }

    @Test
    void testGetLast_name() {
        String expectedlname= "Sarantopoulos";
        String actuallname= userobject.getLastName();
        assertEquals(expectedlname, actuallname);
    }

    @Test
    void testGetPassword() {
       String expectedpassword= "1234@#";
       String actualpassword= userobject.getPassword();
       assertEquals(expectedpassword, actualpassword);
    }

    @Test
    void testGetStudent_number() {
        String expectedsnum= "8382";
        String actualsnum= userobject.getSn();
        assertEquals(expectedsnum, actualsnum);
    }

    @Test
    void testGetStudy_department() {
       String expecteddept = "DMST";
       String actualdept= userobject.getStDept(); 
       assertTrue(expecteddept.equals(actualdept));
    }

    @Test
    void testGetUser_name() {
       String expecteduname= "giannisntop";
       String actualuname = userobject.getUsername();
       assertEquals(expecteduname, actualuname);
    }
    
}