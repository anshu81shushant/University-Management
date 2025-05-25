package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener {
    
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfgradcgpa, tfpostgradcgpa, tfaadhar;
    JLabel labelempId;
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton submit, cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    AddTeacher() {
        
        setTitle("Add Teacher Details");
        setSize(900, 700);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(200, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);
        
        // Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        tfname.setToolTipText("Enter the teacher's full name");
        add(tfname);
        
        // Father's Name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        tffname.setToolTipText("Enter the father's name");
        add(tffname);
        
        // Employee ID
        JLabel lblempId = new JLabel("Employee ID");
        lblempId.setBounds(50, 200, 200, 30);
        lblempId.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempId);
        
        labelempId = new JLabel("101" + first4);
        labelempId.setBounds(200, 200, 200, 30);
        labelempId.setFont(new Font("serif", Font.BOLD, 20));
        add(labelempId);
        
        // Date of Birth
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        dcdob.setDateFormatString("yyyy-MM-dd");
        add(dcdob);
        
        // Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        tfaddress.setToolTipText("Enter the address");
        add(tfaddress);
        
        // Phone Number
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        tfphone.setToolTipText("Enter a valid 10-digit phone number");
        add(tfphone);
        
        // Email
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        tfemail.setToolTipText("Enter a valid email address");
        add(tfemail);
        
        // Graduation CGPA
        JLabel lblgradcgpa = new JLabel("Graduation CGPA");
        lblgradcgpa.setBounds(400, 300, 200, 30);
        lblgradcgpa.setFont(new Font("serif", Font.BOLD, 20));
        add(lblgradcgpa);
        
        tfgradcgpa = new JTextField();
        tfgradcgpa.setBounds(600, 300, 150, 30);
        tfgradcgpa.setToolTipText("Enter Graduation CGPA");
        add(tfgradcgpa);
        
        // Postgraduation CGPA
        JLabel lblpostgradcgpa = new JLabel("Postgrad. CGPA");
        lblpostgradcgpa.setBounds(50, 350, 200, 30);
        lblpostgradcgpa.setFont(new Font("serif", Font.BOLD, 20));
        add(lblpostgradcgpa);
        
        tfpostgradcgpa = new JTextField();
        tfpostgradcgpa.setBounds(200, 350, 150, 30);
        tfpostgradcgpa.setToolTipText("Enter Postgraduation CGPA");
        add(tfpostgradcgpa);
        
        // Aadhar Number
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        tfaadhar.setToolTipText("Enter a valid 12-digit Aadhar number");
        add(tfaadhar);
        
        // Qualification
        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        String[] courses = {"B.Tech in Computer Science", "M.Tech in Computer Science", "PhD in Computer Science", 
                            "MBA", "M.Sc in Mathematics", "M.Sc in Physics", "MA in English", "M.Ed", "LLM"};
        cbcourse = new JComboBox<>(courses);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        // Department
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        String[] branches = {"Computer Science", "Electronics", "Mechanical", "Mathematics", "Physics", "Chemistry", "English"};
        cbbranch = new JComboBox<>(branches);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            // Validation for empty fields
            if (tfname.getText().isEmpty() || tffname.getText().isEmpty() || tfaddress.getText().isEmpty() || 
                tfphone.getText().isEmpty() || tfemail.getText().isEmpty() || tfgradcgpa.getText().isEmpty() || 
                tfpostgradcgpa.getText().isEmpty() || tfaadhar.getText().isEmpty() || dcdob.getDate() == null) {
                JOptionPane.showMessageDialog(null, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Extracting values
            String name = tfname.getText();
            String fname = tffname.getText();
            String empId = labelempId.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String gradcgpa = tfgradcgpa.getText();
            String postgradcgpa = tfpostgradcgpa.getText();
            String aadhar = tfaadhar.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            
            try {
                String query = "INSERT INTO teacher VALUES('" + name + "', '" + fname + "', '" + empId + "', '" + dob + 
                               "', '" + address + "', '" + phone + "', '" + email + "', '" + gradcgpa + "', '" + postgradcgpa + 
                               "', '" + aadhar + "', '" + course + "', '" + branch + "')";
                
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher details added successfully!");
                setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error while adding teacher details!", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddTeacher();
    }
}