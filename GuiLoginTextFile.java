import javax.swing.*;
import java.awt.*;
import java.awt.event.*;                    //PENDING
import java.io.File;
import java.io.FileWriter;
import java.util.*;
public class GuiLoginTextFile {

    public static void register()
    {
       JFrame frame = new JFrame("REGISTER");      
       frame.setSize(600,500);  
       frame.setBounds(700, 50, 600, 500); 
       frame.setLayout(null);        
       JLabel name = new JLabel("Email    :- ");
       JTextField tf = new JTextField(20);
       JLabel pass = new JLabel("Password :- ");
       JLabel result = new JLabel();
       JPasswordField pf = new JPasswordField(20);
       JButton bt1 = new JButton("Submit");        
       name.setBounds(100, 100, 100, 20);        
       frame.add(name);
       tf.setBounds(180, 100, 200, 20);       
       frame.add(tf);
       pass.setBounds(100, 130,100,20);
       frame.add(pass);  
       pf.setBounds(180, 130,200,20);   
       frame.add(pf);   
       bt1.setBounds(180, 170,100,30);    
       frame.add(bt1);
       result.setBounds(100, 200,700,30);       
       frame.add(result);       
       frame.setVisible(true); 

       ActionListener click = new ActionListener(){
           public void actionPerformed(ActionEvent e){
           String mail = tf.getText();
           String psw = pf.getText();

        try {
           File obj = new File("GuiLoginTextFile.txt");
           if(obj.createNewFile()){System.out.println("file created");}
           FileWriter wr = new FileWriter("GuiLoginTextFile.txt",true);
           Scanner scn1 = new Scanner(obj); int flag=0; 
           while(scn1.hasNext())
           {   String st = scn1.nextLine();
               if(st.contains("Email:- "+mail+", Password:- "+psw)){
               result.setText("Account with this Email is Already exist");
               flag=1;  break;}
           }
           scn1.close();
           if(flag==0){   wr.write("Email:- "+mail+", Password:- "+psw+"\n");
                       wr.close();
                       result.setText("Registered Successfully");
                       tf.setText("");
                       pf.setText(""); 
                   }         
        } catch (Exception ee) {
        }                                      
     }};
       bt1.addActionListener(click);  
    }

     public static void login()
     {
        JFrame frame = new JFrame("LOGIN");      
        frame.setSize(700,600);   
        frame.setLayout(null);        
        JLabel name = new JLabel("Email    :- ");
        JTextField tf = new JTextField(20);
        JLabel pass = new JLabel("Password :- ");
        JLabel result = new JLabel();
        JPasswordField pf = new JPasswordField(20);
        JButton bt1 = new JButton("Submit"); 
        JLabel reg = new JLabel("New User, Please Register Here:- ");     
        JButton rb = new JButton("REGISTER");  
        name.setBounds(100, 100, 100, 20);        
        frame.add(name);
        tf.setBounds(180, 100, 200, 20);       
        frame.add(tf);
        pass.setBounds(100, 130,100,20);
        frame.add(pass);  
        pf.setBounds(180, 130,200,20);   
        frame.add(pf);   
        bt1.setBounds(180, 170,100,30);    
        frame.add(bt1);
        result.setBounds(100, 200,700,30);       
        frame.add(result);
        reg.setBounds(100,260,200,20);
        frame.add(reg);
        rb.setBounds(290,260,90,20);
        frame.add(rb);
        frame.setVisible(true);            

        ActionListener click = new ActionListener(){
            public void actionPerformed(ActionEvent e){
            String mail = tf.getText();
            String psw = pf.getText();

         try {
            File obj = new File("GuiLoginTextFile.txt");
            Scanner scn1 = new Scanner(obj); int flag=0; 
            while(scn1.hasNext())
            {   String st = scn1.nextLine();
                if(st.contains("Email:- "+mail)){ 
                    result.setText("Login Successfully");
                        tf.setText("");
                        pf.setText("");
                
                flag=1;  break;}
            }
            scn1.close(); 
            if(flag==0){   result.setText("Invalid Email Or Password");
                    }         
         } catch (Exception ee) {
         }                                      
      }};
      ActionListener click2 = new ActionListener(){
        public void actionPerformed(ActionEvent eee){
            register();
        }};
        bt1.addActionListener(click);  
        rb.addActionListener(click2);
     }
    public static void main(String[] args) {   
        login();       
    }
} 