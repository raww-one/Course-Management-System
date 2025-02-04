package frames;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import controller.AdminController;
import controller.UserController;
import model.User;

import java.util.*;
import java.util.List;
import java.io.*;
import java.nio.file.*;
import java.lang.*;

public class AdminPanelFrame extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btn1, btn2, btn3, btn4, nBtn;
    private Cursor cursor;

    private String[] column = { "User Name", "Password", "Email", "Department", "Student ID", "Date and Time" };

    AdminPanelFrame() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Admin Panel");
        this.setSize(700, 570);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#ede8d0"));

        

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Cascadia Code", Font.PLAIN, 15);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("User Data");
        label1.setBounds(200, 10, 400, 80);
		label1.setForeground(Color.BLACK);
        label1.setFont(f1);
        c.add(label1);

        // JButtons
        btn1 = new JButton("Refresh");
        btn1.setBounds(526, 400, 104, 30);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        c.add(btn1);
        btn1.setBackground(Color.decode("#000000"));

        btn2 = new JButton("Delete");
        btn2.setBounds(422, 400, 104, 30);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#000000"));
        c.add(btn2);

        btn3 = new JButton("Add");
        btn3.setBounds(318, 400, 104, 30);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#000000"));
        c.add(btn3);


        btn4 = new JButton("Logout");
        btn4.setBounds(250, 460, 184, 50);
        btn4.setFont(f3);
        btn4.setCursor(cursor);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#6F4E37"));
        c.add(btn4);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(220);

        scroll = new JScrollPane(table);
        scroll.setBounds(53, 96, 578, 300);
        scroll.setBackground(Color.WHITE);
        c.add(scroll);
        
        List<User> users = UserController.getUsers();
        for (int i = 0; i < users.size(); i++) {
          User u = users.get(i);
          String[] row = new String[7];
          row[0] = u.getUsername();
          row[1] = u.getPassword();
          row[2] = u.getEmail();
          row[3] = u.getDepartment();
          row[4] = u.getStudentId();
          row[5] = u.getDate();

          model.addRow(row);
        }

        // Refresh Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                AdminPanelFrame frame = new AdminPanelFrame();
                frame.setVisible(true);

            }
        });
		  // Add Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminAddUserFrame frame = new AdminAddUserFrame();
                frame.setVisible(true);
            }
        });

        

        // Back Button
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminLoginFrame frame = new AdminLoginFrame();
                frame.setVisible(true);
            }
        });

        // Delete Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (table.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                    UserController.delete(removeUser);

                    setVisible(false);
                    AdminPanelFrame frame = new AdminPanelFrame();
                    frame.setVisible(true);
                }

            }
        });

      
    }

   
}