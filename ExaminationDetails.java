package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener{
    
    JTextField search;
    JButton submit, cancel;
    JTable table;
    
    ExaminationDetails(){
        setSize(1000, 475);
        setLocation(300,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel ("Check Result");
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);
        
        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);
        
        submit = new JButton("Result");
        submit.setBounds(300, 90, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD,15));
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(440, 90, 120, 30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD,15));
        add(cancel); 
        
        // Initialize table
        table = new JTable(){
            // Make the cells non-editable
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Set font for table
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setRowHeight(30); // Set row height to ensure visibility of text
        
        // Set cell padding
        table.setIntercellSpacing(new Dimension(10, 10));
        
        // Enable auto-resizing of columns
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        // Add the table to a scroll pane
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 310);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            // Dynamically adjust the column widths based on content
            for (int i = 0; i < table.getColumnCount(); i++) {
                int width = 0;
                for (int row = 0; row < table.getRowCount(); row++) {
                    Object value = table.getValueAt(row, i);
                    if (value != null) {
                        width = Math.max(width, value.toString().length() * 10); // Adjust multiplier for padding
                    }
                }
                table.getColumnModel().getColumn(i).setPreferredWidth(width); // Set the column width
            }
            
            // Style the table header
            table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
            table.getTableHeader().setBackground(new Color(255, 204, 0)); // Gold background
            table.getTableHeader().setForeground(Color.BLACK);
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        // Add mouse listener to the table for row selection
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== submit){
            setVisible(false);
            new Marks(search.getText());
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new ExaminationDetails();
    }
}