package frames;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import controller.UserController;
import model.User;

public class LoginFrame extends JFrame {

    private Container c;
    private ImageIcon  logo, backgroundimg;
    private JLabel label1, imgLabel,backgroundLabel;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1;
    private JButton btn1, btn2, btn3, nBtn;
    private JPasswordField tf2;
    private Cursor cursor;

    public LoginFrame() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Login Page");
        this.setSize(820, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#ede8d0"));

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Cascadia Code", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 30);
        f5 = new Font("Segoe UI", Font.PLAIN, 22);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        // Title
        label1 = new JLabel();
        label1.setText("Please Login");
		label1.setForeground(Color.black);
        label1.setBounds(220, 50, 500, 90);
        label1.setFont(f1);
        c.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("User Name");
		label1.setForeground(Color.black);
        label1.setBounds(240, 145, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(390, 155, 200, 35);
        tf1.setFont(f5);
		c.add(tf1);
		

        // Password
        label1 = new JLabel();
        label1.setText("Password");
		label1.setForeground(Color.black);
        label1.setBounds(240, 205, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf2 = new JPasswordField();
        tf2.setBounds(390, 215, 200, 35);
        tf2.setFont(f2);
        tf2.setEchoChar('*');
        c.add(tf2);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        

        btn2 = new JButton("Back");
        btn2.setBounds(190, 325, 200, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#6F4E37"));
        c.add(btn2);

        btn3 = new JButton("Login");
        btn3.setBounds(440, 325, 200, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#6F4E37"));
        c.add(btn3);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);
        

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                HomeFrame frame = new HomeFrame();
                frame.setVisible(true);
            }
        });

        // Login Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String textField1 = tf1.getText().toLowerCase(); // User Name 
                String textField2 = tf2.getText(); // Password

                if (textField1.isEmpty() || textField2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    User user = UserController.login(textField1, textField2);
                    if(user != null) {
                        JOptionPane.showMessageDialog(null, "Login Successful.", "Welcome!", JOptionPane.WARNING_MESSAGE);
                        //User login successfull, now show user page!
                        Main userframe = new Main();
                        userframe.setVisible(true);
                        setVisible(false);      
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                    }

                }

            }
        });
    }

}