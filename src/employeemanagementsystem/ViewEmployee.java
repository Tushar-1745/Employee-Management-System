package employeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;


public class ViewEmployee extends JFrame implements ActionListener{
    JTable table;
    Choice chname;
    JButton search, print, update, back;
    
    ViewEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchbyname = new JLabel("Search by Employee name");
        searchbyname.setBounds(400, 20, 150, 20);
        add(searchbyname);
        
        chname = new Choice();
        chname.setBounds(550, 20, 150, 20);
        add(chname);
        
        try{
            Connectivity con = new Connectivity();
            
            ResultSet set = con.s.executeQuery("select * from employee");
            
            while(set.next()){
                chname.add(set.getString("name"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        getContentPane().setBackground(Color.WHITE);
        
        try{
            Connectivity con = new Connectivity();
            
            ResultSet set = con.s.executeQuery("select * from employee");
            
            table.setModel(DbUtils.resultSetToTableModel(set));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(100, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(270, 70, 100, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(420, 70, 100, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(570, 70, 100, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(720, 70, 100, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            
            String query = "select * from employee where name= '"+chname.getSelectedItem()+"'";
            try{
                Connectivity con = new Connectivity();
                ResultSet rs = con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print){
            
            try{
                table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(chname.getSelectedItem());
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[]){
        new ViewEmployee();
    }
}
