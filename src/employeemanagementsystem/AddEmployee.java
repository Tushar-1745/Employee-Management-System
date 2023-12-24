package employeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField tfname, tfsalary, tfcity, tfmono, tfemail;
    JDateChooser jdcdob;
    JComboBox jcedu;
    JButton Add, Back;
    AddEmployee(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(400, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel jname = new JLabel("Name: ");
        jname.setBounds(240, 150, 150, 30);
        jname.setFont(new Font("serif", Font.PLAIN, 20));
        add(jname);

        tfname = new JTextField();
        tfname.setBounds(300, 150, 150, 30);
        add(tfname);
        
        JLabel jdob = new JLabel("Date of Birth: ");
        jdob.setBounds(540, 150, 150, 30);
        jdob.setFont(new Font("serif", Font.PLAIN, 20));
        add(jdob);
        
        jdcdob = new JDateChooser();
        jdcdob.setBounds(660, 150, 150, 30);
        add(jdcdob);
        
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
        
        String[] courses = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA"};
        jcedu = new JComboBox(courses);
        jcedu.setBounds(350, 300, 150, 30);
        add(jcedu);
        
        Add = new JButton("Add Details");
        Add.setBounds(370, 400, 150, 30);
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.addActionListener(this);
        add(Add);
        
        Back = new JButton("Back");
        Back.setBounds(570, 400, 150, 30);
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
        if(ae.getSource()==Add){
            
            String name=tfname.getText();
            String dob = ((JTextField) jdcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String city = tfcity.getText();
            String phone = tfmono.getText();
            String email = tfemail.getText();
            String edu=(String)jcedu.getSelectedItem();
            
            try{
                Connectivity c = new Connectivity();
                
                String query = "insert into employee values('" + name + "', '" + dob + "', '" + salary + "', '" + city + "', '" + phone + "', '" + email + "', '" + edu + "')";
                
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details addedd successfully");
                setVisible(false);
                new Home();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new AddEmployee();
    }
}
