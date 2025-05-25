package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        // Setting the window size and location
        setSize(900, 600); // Slightly wider for better visibility
        setLocation(300, 100);
        setLayout(null);

        // Adding a background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT); // Scaled to fit the window
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 900, 600);
        add(background);

        // Transparent panel to display content over the background
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(50, 50, 800, 500);
        contentPanel.setBackground(new Color(255, 255, 255, 180)); // White with transparency
        contentPanel.setLayout(null);
        background.add(contentPanel);

        // Heading
        JLabel heading = new JLabel("<html><center>University Management System</center></html>", SwingConstants.CENTER);
        heading.setBounds(50, 20, 700, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(new Color(0, 51, 102)); // Dark blue color
        contentPanel.add