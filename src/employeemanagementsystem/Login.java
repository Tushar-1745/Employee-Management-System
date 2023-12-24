package employeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tusername, tpassword;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        
        JLabel username = new JLabel("Username: ");
        username.setBounds(320, 170, 100, 30);
        add(username);
        
        tusername = new JTextField();
        tusername.setBounds(420, 170, 150, 30);
        add(tusername);
        
        JLabel password = new JLabel("Password: ");
        password.setBounds(320, 240, 100, 30);
        add(password);
        
        tpassword = new JTextField();
        tpassword.setBounds(420, 240, 150, 30);
        add(tpassword);
        
        JButton login = new JButton("Login");
        login.setBounds(420, 320, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        
        ImageIcon i4 = new ImageIcon(Login.class.getResource("pictures/loginfront.jpg"));
        Image i5 = i4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(580, 120, 200, 200);
        add(image2);
                  
     
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tusername.getText();
            String password = tpassword.getText();

            Connectivity c = new Connectivity();

            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            ResultSet rs = c.s.executeQuery(query);

            if(rs.next()){
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args){
        new Login();
    }
}
