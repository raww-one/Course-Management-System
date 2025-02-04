package frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bkash extends JFrame implements ActionListener, KeyListener {
    private JPanel panel;
    private JLabel label1, label2;
    private JTextField tf1;
    private JPasswordField pf1;
    private JButton button1;

    public Bkash() {
        super("Bkash");
        super.setBounds(1200, 440, 500, 350);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#ede8d0"));


        label1 = new JLabel("Enter your bKash Number");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        label1.setBounds(80, 70, 200, 80);
        panel.add(label1);

        tf1 = new JTextField();
        tf1.setFont(new Font("Arial", Font.PLAIN, 10));
        tf1.setBounds(275, 100, 90, 22);
        panel.add(tf1);

        label2 = new JLabel("Enter Your PIN");
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        label2.setBounds(80, 100, 300, 80);
        panel.add(label2);

        pf1 = new JPasswordField();
        pf1.setFont(new Font("Arial", Font.PLAIN, 10));
        pf1.setBounds(275, 128, 90, 22);
        pf1.addKeyListener(this);
        panel.add(pf1);

        button1 = new JButton("Submit");
        button1.setFont(new Font("Seoge UI", Font.BOLD, 20));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.decode("#6F4E37"));
        button1.setBounds(275, 160, 100, 32);
        button1.addActionListener(this);
        panel.add(button1);

        super.add(panel);
    }
    public void keyTyped(KeyEvent me) {
        if(pf1.getText().length()>=5){
            me.consume();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public void actionPerformed(ActionEvent me) {
        String pin = pf1.getText();
        String number = tf1.getText();


        if(number.length()!=11 || pin.length() != 5) {
            JOptionPane.showMessageDialog(null, "Please check all the fields");
        }
        else {
            Success obj1 = new Success();
            obj1.setVisible(true);
            this.setVisible(false);
        }
    }
}
