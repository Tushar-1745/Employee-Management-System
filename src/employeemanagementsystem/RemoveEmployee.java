package employeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cname;
    JButton delete, back;
//    JLabel rdfname, rdlname, rddob, rdsalary, rdcity, rdmono, rdemail, rdedu;
    RemoveEmployee(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel jfname = new JLabel("Employee name: ");
        jfname.setBounds(400, 50, 100, 30);
        add(jfname);
        
        cname = new Choice();
        cname.setBounds(550, 50, 100, 30);
        add(cname);
        
        try{
            Connectivity con = new Connectivity();
            String query = "select * from employee";                        
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                cname.add(rs.getString("name"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel rname = new JLabel("First Name: ");
        rname.setBounds(400, 100, 100, 30);
        add(rname);
        JLabel rdname = new JLabel();
        rdname.setBounds(550, 100, 100, 30);
        add(rdname);
        
        JLabel rldob = new JLabel("Date of Birth: ");
        rldob.setBounds(400, 150, 100, 30);
        add(rldob);
        JLabel rddob = new JLabel();
        rddob.setBounds(550, 150, 100, 30);
        add(rddob);
        
        JLabel rlsalary = new JLabel("Salary: ");
        rlsalary.setBounds(400, 200, 100, 30);
        add(rlsalary);
        JLabel rdsalary = new JLabel();
        rdsalary.setBounds(550, 200, 100, 30);
        add(rdsalary);
        
        JLabel rlcity = new JLabel("City: ");
        rlcity.setBounds(400, 250, 100, 30);
        add(rlcity);
        JLabel rdcity = new JLabel();
        rdcity.setBounds(550, 250, 100, 30);
        add(rdcity);
        
        JLabel rlmono = new JLabel("Mobile No.: ");
        rlmono.setBounds(400, 300, 100, 30);
        add(rlmono);
        JLabel rdmono = new JLabel();
        rdmono.setBounds(550, 300, 100, 30);
        add(rdmono);
        
        JLabel rlemail = new JLabel("Email: ");
        rlemail.setBounds(400, 350, 100, 30);
        add(rlemail);
        JLabel rdemail = new JLabel();
        rdemail.setBounds(550, 350, 100, 30);
        add(rdemail);
        
        JLabel rledu = new JLabel("Email: ");
        rledu.setBounds(400, 400, 100, 30);
        add(rledu);
        JLabel rdedu = new JLabel();
        rdedu.setBounds(550, 400, 100, 30);
        add(rdedu);
        
        
        try{
            Connectivity con = new Connectivity();
            
            ResultSet rs = con.s.executeQuery("select * from employee where name='"+cname.getSelectedItem()+"'");
            while(rs.next()){
                rdname.setText(rs.getString("name"));
                rddob.setText(rs.getString("dob"));
                rdsalary.setText(rs.getString("salary"));
                rdcity.setText(rs.getString("city"));
                rdmono.setText(rs.getString("phone"));
                rdemail.setText(rs.getString("email"));
                rdedu.setText(rs.getString("education"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        cname.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Connectivity con = new Connectivity();

                    ResultSet rs = con.s.executeQuery("select * from employee where name='"+cname.getSelectedItem()+"'");
                    while(rs.next()){
                        rdname.setText(rs.getString("name"));
                        rddob.setText(rs.getString("dob"));
                        rdsalary.setText(rs.getString("salary"));
                        rdcity.setText(rs.getString("city"));
                        rdmono.setText(rs.getString("phone"));
                        rdemail.setText(rs.getString("email"));
                        rdedu.setText(rs.getString("education"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(400, 500, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(550, 500, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Connectivity con = new Connectivity();
                String query = "delete from employee where name = '"+cname.getSelectedItem()+"'";
                
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee details deleted successfully");
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
        new RemoveEmployee();
    }

}
