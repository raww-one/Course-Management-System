package frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Card extends JFrame implements ActionListener, KeyListener {
    private JPanel panel;
    private JLabel label1, label2, label3, label4, label5, label6, label7;
    private ImageIcon image1, image2;
    private JTextField tf1, tf2, tf3, tf4;
    private JButton button1;
    private JPasswordField pf1;
    private Font f1, f2,  f4, f5;


    public Card() {
        super("Card");
        super.setBounds(1200, 440, 500, 350);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#ede8d0"));

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Cascadia Code", Font.PLAIN, 25);

        f4 = new Font("Segoe UI", Font.PLAIN, 30);
        f5 = new Font("Segoe UI", Font.PLAIN, 22);

        image1 = new ImageIcon(getClass().getResource("/images/MasterCard.png"));
        label1 = new JLabel(image1);
        label1.setBounds(170, 20, 60,30);
        panel.add(label1);

        image2 = new ImageIcon(getClass().getResource("/images/VisaCard.png"));
        label2 = new JLabel(image2);
        label2.setBounds(240, 20, 60,30);
        panel.add(label2);

        label3 = new JLabel("Card Details");
        label3.setFont(f4);
        label3.setBounds(20, 30, 200,100);
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        label4 = new JLabel("Card Number");
        //label4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        label4.setForeground(Color.BLACK);
        label4.setBounds(20, 140, 100,30);
        panel.add(label4);

        tf1 = new JTextField();
        tf1.setBounds(150, 145, 150,20);
        tf1.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(tf1);

        label5 = new JLabel("Card Expiry");
        label5.setBounds(20, 180, 100,30);
        panel.add(label5);

        tf2 = new JTextField();
        tf2.setBounds(150, 183, 150,20);
        tf2.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(tf2);

        label6 = new JLabel("CVV");
        label6.setBounds(20, 220, 100,30);
        panel.add(label6);

        pf1 = new JPasswordField();
        pf1.setBounds(150, 225, 150,20);
        pf1.setFont(new Font("Arial", Font.PLAIN, 12));
        pf1.addKeyListener(this);
        panel.add(pf1);

        label7 = new JLabel("Card Holder Name");
        label7.setBounds(20, 100, 150,30);
        panel.add(label7);

        tf4 = new JTextField();
        tf4.setBounds(150, 105, 150,20);
        tf4.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(tf4);

        button1 = new JButton("Submit");
        button1.setBounds(300, 260, 150,30);
        button1.setFont(f2);
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.decode("#6F4E37"));
        button1.addActionListener(this);
        panel.add(button1);


        super.add(panel);
    }
    public void keyTyped(KeyEvent me) {
        if(pf1.getText().length()>=3){
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
        String cardNumber = tf1.getText();
        String cardExpiry = tf2.getText();
        String cardSecurity = pf1.getText();
        String cardHolderName = tf4.getText();

        if(cardExpiry.isEmpty() || cardSecurity.isEmpty() || cardHolderName.isEmpty() || cardNumber.length()!=16 || cardSecurity.length() != 3) {
            JOptionPane.showMessageDialog(null, "Please check all the fields");
        }
        else {
            Success obj1 = new Success();
            obj1.setVisible(true);
            this.setVisible(false);
        }
    }
}
