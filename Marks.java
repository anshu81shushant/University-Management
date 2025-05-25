package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.print.*;

public class Marks extends JFrame implements ActionListener {

    String rollno, semester;  // Store semester as a String
    JButton cancel, printButton;
    JTable table;
    JLabel lblcgpa; 
    JTextField tfcgpa; 

    Marks(String rollno) {
        this.rollno = rollno;

        // Adjusted window size
        setSize(700, 500);
        setLocation(400, 150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        // Centered heading
        JLabel heading = new JLabel("Delhi Technical University", JLabel.CENTER);
        heading.setBounds(0, 10, 700, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);

        // Centered subheading
        JLabel subheading = new JLabel("Result of Examination 2024", JLabel.CENTER);
        subheading.setBounds(0, 50, 700, 25);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(subheading);

        // Roll number
        JLabel lblrollno = new JLabel("Roll Number: " + rollno, JLabel.CENTER);
        lblrollno.setBounds(0, 100, 700, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        // Semester
        JLabel lblsemester = new JLabel("", JLabel.CENTER);
        lblsemester.setBounds(0, 130, 700, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);

        // Table headers and data
        String[] columnNames = {"Subject", "Marks"};
        String[][] data = new String[5][2]; // Assuming 5 subjects

        int[] marks = new int[5];
        double cgpa = 0;

        try {
            Conn c = new Conn();

            // Fetch subjects
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '" + rollno + "'");
            if (rs1.next()) {
                data[0][0] = rs1.getString("subject1");
                data[1][0] = rs1.getString("subject2");
                data[2][0] = rs1.getString("subject3");
                data[3][0] = rs1.getString("subject4");
                data[4][0] = rs1.getString("subject5");
            }

            // Fetch marks and calculate CGPA
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '" + rollno + "'");
            if (rs2.next()) {
                data[0][1] = rs2.getString("marks1");
                data[1][1] = rs2.getString("marks2");
                data[2][1] = rs2.getString("marks3");
                data[3][1] = rs2.getString("marks4");
                data[4][1] = rs2.getString("marks5");
                semester = rs2.getString("semester");  // Save semester value
                lblsemester.setText("Semester: " + semester);

                // Convert marks to integers for CGPA calculation
                for (int i = 0; i < 5; i++) {
                    marks[i] = Integer.parseInt(rs2.getString("marks" + (i + 1)));
                }

                // CGPA calculation assuming 500 total marks for each subject (out of 5 subjects)
                int totalMarks = 0;
                for (int mark : marks) {
                    totalMarks += mark;
                }

                cgpa = (totalMarks / 500.0) * 10; // CGPA calculation
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create table
        table = new JTable(data, columnNames);
        table.setRowHeight(30); // Adjusted row height for better readability
        table.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Font for table text
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16)); // Font for table header
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(100, 170, 500, 150); // Centered table with appropriate size
        add(sp);

        // CGPA Label and TextField
        lblcgpa = new JLabel("CGPA: ");
        lblcgpa.setBounds(80, 350, 150, 30);
        lblcgpa.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblcgpa);

        tfcgpa = new JTextField();
        tfcgpa.setBounds(180, 350, 200, 30);
        tfcgpa.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfcgpa.setText(String.format("%.2f", cgpa)); // Display CGPA in 2 decimal places
        tfcgpa.setEditable(false); // Make CGPA field non-editable
        add(tfcgpa);

        // Back button
        cancel = new JButton("Back");
        cancel.setBounds(290, 400, 120, 30); // Centered button
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(cancel);

        // Print button
        printButton = new JButton("Print");
        printButton.setBounds(420, 400, 120, 30); // Centered button
        printButton.setBackground(Color.GREEN);
        printButton.setForeground(Color.WHITE);
        printButton.addActionListener(this);
        printButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(printButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancel) {
            setVisible(false);
        } else if (ae.getSource() == printButton) {
            printMarks();
        }
    }

    // Method to handle printing
    public void printMarks() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Marks Print Job");

        // Set the printable content
        printerJob.setPrintable(new Printable() {
            public int print(Graphics g, PageFormat pf, int pageIndex) {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                // Set margins and layout
                g.translate((int) pf.getImageableX(), (int) pf.getImageableY());
                g.setFont(new Font("Tahoma", Font.PLAIN, 16));

                // Print header
                g.drawString("Delhi Technical University", 200, 30);
                g.drawString("Result of Examination 2024", 220, 60);
                g.drawString("Roll Number: " + rollno, 230, 90);
                g.drawString("Semester: " + semester, 230, 120); // Use the semester variable

                // Print table data
                int y = 150;
                for (int i = 0; i < 5; i++) {
                    g.drawString("Subject: " + table.getValueAt(i, 0), 100, y);
                    g.drawString("Marks: " + table.getValueAt(i, 1), 400, y);
                    y += 30;
                }

                // Print CGPA
                g.drawString("CGPA: " + tfcgpa.getText(), 100, y + 20);

                return Printable.PAGE_EXISTS;
            }
        });

        // Show print dialog
        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Marks("12345"); // Example roll number
    }
}