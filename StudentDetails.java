package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.io.*;  // For file handling

public class StudentDetails extends JFrame implements ActionListener {
    
    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel, export;
    
    StudentDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);                                                                                                                                                                        
        
        JLabel heading = new JLabel("Search by Roll No.");
        heading.setBounds(20, 20, 150, 20);
        heading.setFont(new Font("Arial", Font.BOLD, 14));  // Custom font for header
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        table.setFont(new Font("Arial", Font.PLAIN, 14));  // Font for table content
        table.setRowHeight(30);  // Increase row height for better visibility
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));  // Header font style
        table.getTableHeader().setBackground(new Color(200, 220, 255));  // Header background color
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  // Prevent automatic resizing of