package employeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateEmployee extends JFrame implements ActionListener{
    JTextField tfsalary, tfmono, tfcity, tfemail;
    JButton update, Back;
    String name;
    UpdateEmployee(String name){
        this.name=name;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(380, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel jname = new JLabel("Name: ");
        jname.setBounds(240, 150, 150, 30);
        jname.setFont(new Font("serif", Font.PLAIN, 20));
        add(jname);

        JLabel jlbname = new JLabel();
        jlbname.setBounds(300, 150, 150, 30);
        add(jlbname);
        
        JLabel jdob = new JLabel("Date of Birth: ");
        jdob.setBounds(540, 150, 150, 30);
        jdob.setFont(new Font("serif", Font.PLAIN, 20));
        add(jdob);
        
        JLabel jlbdob = new JLabel();
        jlbdob.setBounds(660, 150, 150, 30);
        add(jlbdob);
        
        JLabel jsalary = new JLabel("Salary: ");
        jsalary.setBounds(240, 200, 150, 30);
        jsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(jsalary);

        tfsalary= new JTextField();
        tfsalary.setBounds(300, 200, 150, 30);
        add(tfsalary);
        
        JLabel jcity = new JLabel("City: ");
        jcity.setBounds(540, 200, 150, 30);
        jcity.setFont(new Font("serif", Font.PLAIN, 20));
        add(jcity);

        tfcity = new JTextField();
        tfcity.setBounds(660, 200, 150, 30);
        add(tfcity);
        
        JLabel jmono = new JLabel("Mobile: ");
        jmono.setBounds(240, 250, 150, 30);
        jmono.setFont(new Font("serif", Font.PLAIN, 20));
        add(jmono);

        tfmono = new JTextField();
        tfmono.setBounds(300, 250, 150, 30);
        add(tfmono);
        
        JLabel jemail = new JLabel("Email: ");
        jemail.setBounds(540, 250, 150, 30);
        jemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(jemail);

        tfemail = new JTextField();
        tfemail.setBounds(660, 250, 150, 30);
        add(tfemail);
        
        JLabel jedu = new JLabel("Education: ");
        jedu.setBounds(240, 300, 150, 30);
        jedu.setFont(new Font("serif", Font.PLAIN, 20));
        add(jedu);
        
        
        JLabel jlbedu = new JLabel();
        jlbedu.setBounds(350, 300, 150, 30);
        add(jlbedu);
        
        try{
            Connectivity con = new Connectivity();
            String query = "select * from employee where name = '"+name+"'";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                jlbname.setText(rs.getString("name"));
                jlbdob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfcity.setText(rs.getString("city"));
                tfmono.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                jlbedu.setText(rs.getString("education"));
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        update = new JButton("Update Details");
        update.setBounds(350, 400, 150, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        Back = new JButton("Back");
        Back.setBounds(550, 400, 150, 30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            
            
            String salary = tfsalary.getText();
            String city = tfcity.getText();
            String phone = tfmono.getText();
            String email = tfemail.getText();
            
            try{
                Connectivity c = new Connectivity();
                
                String query = "update employee set salary= '" + salary + "', city = '" + city + "', phone='" + phone + "', email = '" + email + "' where name='"+name+"'";
                
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
//                setVisible(false);
//                new ViewEmployee();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new ViewEmployee();
        }
    }
    public static void main(String[] args){
        new UpdateEmployee("");
    }
}
