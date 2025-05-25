package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class AddStudent extends JFrame implements ActionListener {
   
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaadhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton submit, cancel;
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent() {
        setTitle("Add Student Details"); // Updated title
        setSize(900, 700);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensures proper closing of application
        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(200, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setHorizontalAlignment(SwingConstants.CENTER); // Center-align heading
        add(heading);

        // Name Label and Field
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        tfname.setToolTipText("Enter the student's full name"); // Tooltip
        add(tfname);

        // Father's Name Label and Field
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        tffname.setToolTipText("Enter the father's name"); // Tooltip
        add(tffname);

        // Roll Number Label
        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        labelrollno = new JLabel("1533" + first4);
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);

        // Date of Birth Label and Picker
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        dcdob.setDateFormatString("yyyy-MM-dd");
        add(dcdob);

        // Address Label and Field
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        tfaddress.setToolTipText("Enter the address");
        add(tfaddress);

        // Phone Number Label and Field
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        tfphone.setToolTipText("Enter a valid 10-digit phone number");
        add(tfphone);

        // Email Label and Field
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        tfemail.setToolTipText("Enter a valid email address");
        add(tfemail);

        // Class X Label and Field
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        tfx.setToolTipText("Enter percentage achieved in Class X");
        add(tfx);

        // Class XII Label and Field
        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        tfxii.setToolTipText("Enter percentage achieved in Class XII");
        add(tfxii);

        // Aadhar Label and Field
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        tfaadhar.setToolTipText("Enter a valid 12-digit Aadhar number");
        add(tfaadhar);

        // Course Label and Dropdown
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        String[] courses = {"B.Tech in Computer Science", "B.Tech in Electronics", "B.Tech in Mechanical", "B.Tech in Civil", 
                            "B.Tech in Biotechnology", "BBA", "B.Sc in Physics", "B.Sc in Chemistry", "B.Sc in Mathematics", 
                            "M.Sc in Physics", "M.Sc in Chemistry", "MBA", "MCom", "BA in English", "BA in Hindi", 
                            "BA in Political Science", "MA in English", "MA in History", "B.Com (Hons)", "MBBS", 
                            "BDS", "B.Pharmacy", "Nursing", "LLB", "BA LLB", "B.Voc in Software Development", 
                            "B.Voc in Tourism and Hospitality"};
        cbcourse = new JComboBox<>(courses);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        // Branch Label and Dropdown
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        String[] branches = {"Computer Science", "Electronics", "Mechanical", "Civil", "Biotechnology", 
                             "Physics", "Chemistry", "Mathematics", "English", "History", "Political Science", 
                             "Software Development", "Tourism and Hospitality"};
        cbbranch = new JComboBox<>(branches);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            // Field Validation
            if (tfname.getText().isEmpty() || tffname.getText().isEmpty() || tfaddress.getText().isEmpty() || 
                tfphone.getText().isEmpty() || tfemail.getText().isEmpty() || tfx.getText().isEmpty() || 
                tfxii.getText().isEmpty() || tfaadhar.getText().isEmpty() || dcdob.getDate() == null) {
                JOptionPane.showMessageDialog(null, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                String name = tfname.getText();
                String fname = tffname.getText();
                String rollno = labelrollno.getText();
                String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
                String address = tfaddress.getText();
                String phone = tfphone.getText();
                String email = tfemail.getText();
                String x = tfx.getText();
                String xii = tfxii.getText();
                String aadhar = tfaadhar.getText();
                String course = (String) cbcourse.getSelectedItem();
                String branch = (String) cbbranch.getSelectedItem();

                String query = "INSERT INTO student VALUES('" + name + "', '" + fname + "', '" + rollno + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + x + "', '" + xii + "', '" + aadhar + "', '" + course + "', '" + branch + "')";
                
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student details added successfully");
                setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error while adding student details!", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddStudent();
    }
}