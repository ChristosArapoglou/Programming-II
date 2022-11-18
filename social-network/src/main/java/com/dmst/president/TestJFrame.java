import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TestJFrame extends JFrame{
     
      private final JTextField textField1;
      private final JPasswordField passwordField;
      private final JLabel label; 
      private final JLabel label1; 
      private JButton  simpleJButton;
      
      
      
      public TestJFrame(){
        super("Login Page");
        setLayout(null);
        
        //JLbel
        label= new JLabel("Add your username.");
        Dimension size = label.getPreferredSize();
        label.setBounds(10, 20, size.width, size.height);
        
        
        

        //JLabel2
        label1= new JLabel("Add your password.");
        Dimension size2 = label1.getPreferredSize();
        label1.setBounds(10,50, size2.width, size2.height);
        this.setLayout(null);

        
        //TextField1
        textField1= new JTextField(10);
        Dimension size1= textField1.getPreferredSize();
        textField1.setBounds(130,20,size1.width, size1.height);
        textField1.setToolTipText("Text Field 1");
        
        
        
        //PsswordField
        passwordField= new JPasswordField(10);
        Dimension size4= passwordField.getPreferredSize();
        passwordField.setBounds(130,50,size4.width, size4.height);
        passwordField.setToolTipText("Password Field");
        
       
       
       //Button Frame
        simpleJButton= new JButton("Login");
        simpleJButton.setBounds(130,100,150, 20);
        
       
       
        add(textField1);
        add(passwordField); 
        add(label);
        add(label1);
        add(simpleJButton);
        
        
        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        passwordField.addActionListener(handler);
        simpleJButton.addActionListener(handler);
        
      }


        private class TextFieldHandler implements ActionListener{
          
          @Override
          public void actionPerformed(ActionEvent handler){
            
            String string = " No actions happened.";  
            
            if(handler.getSource()== textField1){
              string = textField1.getText();
              
            }else if (handler.getSource()==passwordField){
              JOptionPane.showMessageDialog(null, "Password is secret","Password", JOptionPane.ERROR_MESSAGE);
            }else if(handler.getSource()==simpleJButton){
              string= " Button Field : " + handler.getActionCommand();
            }
            
            if (handler.getSource()!=passwordField){
               JOptionPane.showMessageDialog(null, string);
            }
            System.out.println(passwordField.getPassword());
    
            }
          
}
}