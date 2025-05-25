package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Splash extends JFrame {

    private JLabel dateTimeLabel;

    Splash() {
        // Set the title of the window
        setTitle("University Management System");

        // Get the screen size for full screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        // Load and scale the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel backgroundImage = new JLabel(i3);
        backgroundImage.setBounds(0, 0, screenSize.width, screenSize.height);

        // Create a layered pane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, screenSize.width, screenSize.height);

        // Add the background image at the lowest layer
        layeredPane.add(backgroundImage, Integer.valueOf(0));

        // Create an overlay panel for text and buttons
        JPanel overlayPanel = new JPanel();
        overlayPanel.setBounds(0, 0, screenSize.width, screenSize.height);
        overlayPanel.setLayout(null);
        overlayPanel.setOpaque(false); // Transparent panel

        // Add welcome text
        JLabel welcomeText = new JLabel("Welcome to the University Management System");
        welcomeText.setBounds(50, 100, screenSize.width - 100, 50);
        welcomeText.setFont(new Font("Serif", Font.BOLD, 40));
        welcomeText.setForeground(Color.BLACK);
        overlayPanel.add(welcomeText);

        // Add description text
        JLabel descriptionText1 = new JLabel("Manage all university operations efficiently and securely.");
        descriptionText1.setBounds(50, 170, screenSize.width - 100, 30);
        descriptionText1.setFont(new Font("Serif", Font.PLAIN, 25));
        descriptionText1.setForeground(Color.DARK_GRAY);
        overlayPanel.add(descriptionText1);

        JLabel descriptionText2 = new JLabel("From student records to administrative tools, it's all here.");
        descriptionText2.setBounds(50, 210, screenSize.width - 100, 30);
        descriptionText2.setFont(new Font("Serif", Font.PLAIN, 25));
        descriptionText2.setForeground(Color.DARK_GRAY);
        overlayPanel.add(descriptionText2);

        // Add a dynamic date and time display
        dateTimeLabel = new JLabel();
        dateTimeLabel.setBounds(screenSize.width - 350, 20, 300, 30);
        dateTimeLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        dateTimeLabel.setForeground(Color.GRAY);
        overlayPanel.add(dateTimeLabel);

        // Update the date and time dynamically
        Timer timer = new Timer(1000, e -> {
            SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
            dateTimeLabel.setText(formatter.format(new Date()));
        });
        timer.start();

        // Add buttons with spacing
        int buttonWidth = 250;
        int buttonHeight = 50;
        int spacing = 30; // Space between buttons
        int startX = (screenSize.width - (buttonWidth * 3 + spacing * 2)) / 2; // Center alignment
        int startY = screenSize.height - 250;

        addButton(overlayPanel, "Login \uD83D\uDD10", startX, startY, e -> openLogin());
        addButton(overlayPanel, "Contact Us \u260E", startX + buttonWidth + spacing, startY, e -> showContactUs());
        addButton(overlayPanel, "Feedback ✍", startX + (buttonWidth + spacing) * 2, startY, e -> openFeedbackForm());

        startY += buttonHeight + spacing; // Move to the next row for remaining buttons

        addButton(overlayPanel, "Help ❓", startX, startY, e -> showHelp());
        addButton(overlayPanel, "About System ℹ", startX + buttonWidth + spacing, startY, e -> showAboutSystem());
        addExitButton(overlayPanel, "Exit \u274C", screenSize.width - 150, screenSize.height - 80); // Bottom-right corner

        // Add the overlay panel at a higher layer
        layeredPane.add(overlayPanel, Integer.valueOf(1));

        // Add the layered pane to the frame
        add(layeredPane);

        // Set window properties
        setUndecorated(true); // Remove borders and title bar
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full-screen mode
        setVisible(true);
    }

    private void addButton(JPanel panel, String text, int x, int y, ActionListener action) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 250, 50); // Standard button size
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setBackground(new Color(70, 130, 180)); // Steel blue color
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);

        // Add hover effects
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(34, 139, 34)); // Green on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180)); // Default
            }
        });

        button.addActionListener(action);
        panel.add(button);
    }

    private void addExitButton(JPanel panel, String text, int x, int y) {
        JButton exitButton = new JButton(text);
        exitButton.setBounds(x, y, 120, 40); // Smaller size for exit
        exitButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);

        // Exit the application when clicked
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(exitButton);
    }

    private void openLogin() {
        new Login();
    }

    private void showContactUs() {
        JOptionPane.showMessageDialog(this,
                "For any queries, contact us:\nEmail: support@university.com\nPhone: +1-234-567-890",
                "Contact Us", JOptionPane.INFORMATION_MESSAGE);
    }

    private void openFeedbackForm() {
        JDialog feedbackDialog = new JDialog(this, "Feedback Form", true);
        feedbackDialog.setLayout(new GridLayout(5, 2, 10, 10));
        feedbackDialog.setSize(400, 300);

        feedbackDialog.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        feedbackDialog.add(nameField);

        feedbackDialog.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        feedbackDialog.add(emailField);

        feedbackDialog.add(new JLabel("Feedback:"));
        JTextArea feedbackArea = new JTextArea();
        feedbackDialog.add(new JScrollPane(feedbackArea));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String feedback = feedbackArea.getText();

            if (name.isEmpty() || email.isEmpty() || feedback.isEmpty()) {
                JOptionPane.showMessageDialog(feedbackDialog,
                        "All fields are required!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(feedbackDialog,
                        "Thank you for your feedback!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                feedbackDialog.dispose();
            }
        });
        feedbackDialog.add(submitButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> feedbackDialog.dispose());
        feedbackDialog.add(cancelButton);

        feedbackDialog.setLocationRelativeTo(this);
        feedbackDialog.setVisible(true);
    }

    private void showHelp() {
        JOptionPane.showMessageDialog(this,
                """
                Help Guide:
                - Login: Access your personalized dashboard.
                - Contact Us: Reach out for technical or administrative support.
                - Feedback: Share your suggestions or report issues.
                - About System: Learn more about this application.
                """,
                "Help", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAboutSystem() {
        JOptionPane.showMessageDialog(this,
                """
                About the System:
                The University Management System is designed to streamline operations
                across various departments. From student record management to
                faculty scheduling, this platform ensures efficiency, security, and
                scalability.
                
                Developed by: [Jyotika, Kashish, Deepali, Tanish, Anshu]
                Version: 1.0
                """,
                "About System", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new Splash();
    }
}