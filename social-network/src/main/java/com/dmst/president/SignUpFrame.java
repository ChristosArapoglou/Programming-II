import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUpFrame extends JFrame{
    //Text Fields
    private  JTextField fname;
    private  JTextField lname; 
    private  JTextField mail; 
    private  JTextField serialnumber;
    private  JTextField dob;
    private  JTextField sdepartment;
    private  JTextField uname;
    private  JPasswordField password;
    
    //Labels
    private JLabel fnamelabel;
    private JLabel lnamelabel;
    private JLabel maillabel;
    private JLabel serialnumberlabel;
    private JLabel doblabel;
    private JLabel sdepartmentlabel;
    private JLabel unamelabel;
    private JLabel passwordlabel;
    
    
    //Button
    private JButton signupbutton;
    
    public SignUpFrame() {
        super("Sign Up Page");
        setLayout(null);

        //First Name Text Field
        fname= new JTextField(10);
        Dimension size1= fname.getPreferredSize();
        fname.setBounds(230,20,size1.width, size1.height);
        fname.setToolTipText("Enter your first name.");

        //Last Name Text Field
        lname= new JTextField(10);
        Dimension size12= lname.getPreferredSize();
        lname.setBounds(230,50,size12.width, size12.height);
        lname.setToolTipText("Enter your last name.");

        //User Name Text Field
        uname= new JTextField(10);
        Dimension size20= uname.getPreferredSize();
        uname.setBounds(230,80,size20.width, size20.height);
        uname.setToolTipText("Enter your username");
       
       //Password Text Field
        password= new JPasswordField(10);
        Dimension size4= password.getPreferredSize();
        password.setBounds(230,110,size4.width, size4.height);
        password.setToolTipText("Enter your password.");

        //Mail Text Filed
        mail= new JTextField(10);
        Dimension size13= mail.getPreferredSize();
        mail.setBounds(230,140,size13.width, size13.height);
        mail.setToolTipText("Enter your e-mail.");

        //Serial Number Text Field
        serialnumber= new JTextField(10);
        Dimension size14= serialnumber.getPreferredSize();
        serialnumber.setBounds(230,170,size14.width, size14.height);
        serialnumber.setToolTipText("Enter your serial number.");

        //Date Of Birth Text Field
        dob= new JTextField(10);
        Dimension size15= dob.getPreferredSize();
        dob.setBounds(230,200,size15.width, size15.height);
        dob.setToolTipText("Enter your date of birth.");

        //Departmet Serial Number Text Field
        sdepartment= new JTextField(10);
        Dimension size16= sdepartment.getPreferredSize();
        sdepartment.setBounds(230,230,size16.width, size16.height);
        sdepartment.setToolTipText("Enter your department's serial number.");

        //First name label
        fnamelabel= new JLabel("Add your first name.");
        Dimension size30 = fnamelabel.getPreferredSize();
        fnamelabel.setBounds(10, 20, size30.width, size30.height);

        //Last Name label
        lnamelabel= new JLabel("Add your last name.");
        Dimension size31 = lnamelabel.getPreferredSize();
        lnamelabel.setBounds(10, 50, size31.width, size31.height);
        
        //Mail name label
        maillabel= new JLabel("Add your mail.");
        Dimension size32 = maillabel.getPreferredSize();
        maillabel.setBounds(10, 80, size32.width, size32.height);
        
        //Serial number label
        serialnumberlabel= new JLabel("Add your serial number.");
        Dimension size33 = serialnumberlabel.getPreferredSize();
        serialnumberlabel.setBounds(10, 110, size33.width, size33.height);

        //Date of Birth label
        doblabel= new JLabel("Add your birth date.");
        Dimension size34 = doblabel.getPreferredSize();
        doblabel.setBounds(10, 140, size34.width, size34.height);
        
        //Department's serial number label
        sdepartmentlabel= new JLabel("Add your department's serial number.");
        Dimension size35 = sdepartmentlabel.getPreferredSize();
        sdepartmentlabel.setBounds(10, 170, size35.width, size35.height);
        
        //User name label
        unamelabel= new JLabel("Add your username.");
        Dimension size36 = unamelabel.getPreferredSize();
        unamelabel.setBounds(10, 200, size36.width, size36.height);
        

        //Password label
        passwordlabel= new JLabel("Add your password.");
        Dimension size37 = passwordlabel.getPreferredSize();
        passwordlabel.setBounds(10, 230, size37.width, size37.height);

        //Creating a button
        signupbutton= new JButton("Sign Up");
        signupbutton.setBounds(230, 280, 150, 20);
        
        //Adding Text Fields
        add(fname);
        add(lname);
        add(mail);
        add(serialnumber);
        add(dob);
        add(sdepartment);
        add(uname);
        add(password);

        //Adding Labels
        add(fnamelabel);
        add(lnamelabel);
        add(maillabel);
        add(serialnumberlabel);
        add(doblabel);
        add(sdepartmentlabel);
        add(unamelabel);
        add(passwordlabel);
        
        //Add Button
        add(signupbutton);
        
        
        SignUpHandler handler = new SignUpHandler();
        
        fname.addActionListener(handler);
        lname.addActionListener(handler);
        uname.addActionListener(handler);
        mail.addActionListener(handler);
        serialnumber.addActionListener(handler);
        password.addActionListener(handler);
        dob.addActionListener(handler);
        sdepartment.addActionListener(handler);


    }

    private class SignUpHandler implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent handler){
          
          String string; 
          
          if(handler.getSource()== fname){
            string = fname.getText();
            
          }else if (handler.getSource()==lname){
            string = lname.getText();
           
          }else if(handler.getSource()==mail){
            string= mail.getText();
            
        }else if (handler.getSource()==serialnumber){
            string = serialnumber.getText();
          
        }else if (handler.getSource()==dob ){
            string = dob.getText();
            
        }else if(handler.getSource()== sdepartment){
            string = sdepartment.getText();
          
        }else if (handler.getSource()== uname){
            string = uname.getText();
          
        }else if (handler.getSource()==password){
            char[] chars = password.getPassword();
            string = String.valueOf(chars);
            JOptionPane.showMessageDialog(null, string,"Password", JOptionPane.ERROR_MESSAGE);
            
        }
        
       
      
}

}

}