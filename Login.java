package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login, cancel;
    JTextField tfusername;
    JPasswordField tfpassword;
    JLabel lblusername, lblpassword, errorMessage;
    
    Login() {
        
        // Setting the layout and background
        getContentPane().setBackground(Color.decode("#f1f1f1"));
        setLayout(null);
        
        // Title Label
        JLabel title = new JLabel("University Management System");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(100, 20, 350, 30);
        title.setForeground(Color.decode("#2E4053"));
        add(title);
        
        // Username Label and TextField
        lblusername = new JLabel("Username:");
        lblusername.setBounds(40, 80, 100, 25);
        lblusername.setFont(new Font("Arial", Font.PLAIN, 16));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 80, 200, 25);
        tfusername.setFont(new Font("Arial", Font.PLAIN, 16));
        tfusername.setBackground(Color.white);
        add(tfusername);
        
        // Password Label and PasswordField
        lblpassword = new JLabel("Password:");
        lblpassword.setBounds(40, 120, 100, 25);
        lblpassword.setFont(new Font("Arial", Font.PLAIN, 16));
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 120, 200, 25);
        tfpassword.setFont(new Font("Arial", Font.PLAIN, 16));
        tfpassword.setBackground(Color.white);
        add(tfpassword);
        
        // Error message label for invalid credentials
        errorMessage = new JLabel("");
        errorMessage.setBounds(150, 160, 200, 25);
        errorMessage.setForeground(Color.RED);
        errorMessage.setFont(new Font("Arial", Font.ITALIC, 14));
        add(errorMessage);

        // Login Button
        login = new JButton("Login");
        login.setBounds(40, 200, 150, 35);
        login.setBackground(Color.decode("#2E4053"));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 16));
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(login);
        
        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 200, 150, 35);
        cancel.setBackground(Color.decode("#E74C3C"));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(cancel);
        
        // Image icon for UI (you can replace it with any icon you prefer)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 50, 200, 200);
        add(image);
        
        // Window settings
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = new String(tfpassword.getPassword());
            
            // Validate fields
            if (username.isEmpty() || password.isEmpty()) {
                errorMessage.setText("Please enter both fields!");
                return;
            }
            
            // SQL Query to check credentials
            String query = "select * from login where username='" + username + "' and password='" + password + "'";
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    setVisible(false);
                    new Project(); // Open the project dashboard after successful login
                } else {
                    errorMessage.setText("Invalid username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false); // Close the login form
        }
    }
    
    public static void main(String[] args) {
        new Login(); // Create and show the login form
    }
}