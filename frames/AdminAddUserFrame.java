package frames;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import controller.UserController;
import model.User;

public class AdminAddUserFrame extends JFrame {

    private Container c;
    private JLabel label1;
	private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1, tf2, tf4;
    private JComboBox department;
    private JButton btn1, btn2, nBtn;
    private JPasswordField tf3;
    private Cursor cursor;

    AdminAddUserFrame() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Admin Adding Page");
        this.setSize(850, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#ede8d0"));

       

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 38);
        f2 = new Font("Cascadia Code", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 25);
        f5 = new Font("Segoe UI", Font.PLAIN, 19);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        // Title
        label1 = new JLabel();
        label1.setText("Enter Information");
        label1.setBounds(290, 25, 500, 50);
		label1.setForeground(Color.BLACK);
        label1.setFont(f1);
        c.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("User Name");
        label1.setBounds(133, 75, 500, 50);
		label1.setForeground(Color.BLACK);
        label1.setFont(f4);
        c.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(273, 85, 455, 30);
        tf1.setFont(f5);
        c.add(tf1);

        // Email
        label1 = new JLabel();
        label1.setText("Email");
        label1.setBounds(133, 145, 500, 50);
		label1.setForeground(Color.BLACK);
        label1.setFont(f4);
        c.add(label1);

        tf2 = new JTextField();
        tf2.setBounds(273, 120, 455, 30);
        tf2.setFont(f5);
        c.add(tf2);

        // Password
        label1 = new JLabel();
        label1.setText("Password");
        label1.setBounds(133, 110, 500, 50);
		label1.setForeground(Color.BLACK);
        label1.setFont(f4);
        c.add(label1);

        tf3 = new JPasswordField();
        tf3.setBounds(273, 155, 455, 30);
        tf3.setFont(f2);
        tf3.setEchoChar('*');
        c.add(tf3);

        // Question
        label1 = new JLabel();
        label1.setText("Department");
        label1.setBounds(133, 180, 500, 50);
		label1.setForeground(Color.BLACK);
        label1.setFont(f4);
        c.add(label1);

        String[] dept = { "Choose Your Department", "CSE", "EEE",
                "LLB", "Pharmacy" };
        department = new JComboBox(dept);
        department.setBounds(273, 190, 259, 30);
        department.setSelectedIndex(0);
        department.setFont(f5);
        department.setBackground(Color.white);
        c.add(department);

        // Student Id
        label1 = new JLabel();
        label1.setText("Student ID");
        label1.setBounds(133, 215, 500, 50);
		label1.setForeground(Color.BLACK);
        label1.setFont(f4);
        c.add(label1);

        tf4 = new JTextField();
        tf4.setBounds(273, 225, 455, 30);
        tf4.setFont(f5);
        c.add(tf4);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Back");
        btn1.setBounds(181, 325, 163, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#6F4E37"));
        c.add(btn1);

        btn2 = new JButton("Add");
        btn2.setBounds(519, 325, 163, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#6F4E37"));
        c.add(btn2);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Back Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                AdminPanelFrame frame = new AdminPanelFrame();
                frame.setVisible(true);
            }
        });

        // Register Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String textField1 = tf1.getText().toLowerCase(); // User Name
                String textField2 = tf2.getText(); // Email
                String textField3 = tf3.getText(); // Password
                String textField4 = tf4.getText(); //Department
                String dept = String.valueOf(department.getSelectedItem()); // Student ID

                if (textField1.isEmpty() || textField2.isEmpty() || textField3.isEmpty() || textField4.isEmpty()
                        || ((department.getSelectedIndex()) == 0)) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    LocalDateTime myDateObj = LocalDateTime.now();
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
                    String timeAndDate = myDateObj.format(myFormatObj);

                    User user = new User(textField1, textField3, textField2, dept, textField4, timeAndDate);
                        
                    if(UserController.register(user)) {
                        JOptionPane.showMessageDialog(null, "User has been added.", "User Added",
                                JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                        AdminAddUserFrame frame = new AdminAddUserFrame();
                        frame.setVisible(true);
                    }
                }
            }
        });
    }

    
}
