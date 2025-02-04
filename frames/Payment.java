package frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label1, label2;
    private JButton button1, button2, button3;
    private Font f1, f2,  f4, f5;

    public Payment() {
        super("Payment");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setBounds(770, 250, 1000, 800);
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

        button1 = new JButton("Exit");
        button1.setFont(f2);
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(450,640,130,50);
        button1.addActionListener(this);
        panel.add(button1);

        label1 = new JLabel("Payment Methods");
        label1.setFont(f4);
        label1.setForeground(Color.BLACK);
        label1.setBounds(405,30,300,50);
        panel.add(label1);

        button2 = new JButton("bKash");
        button2.setFont(f2);
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.decode("#6F4E37"));
        button2.setBounds(120,300,160,100);
        button2.addActionListener(this);
        panel.add(button2);

        button3 = new JButton("Card");
        button3.setFont(f2);
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.decode("#6F4E37"));
        button3.setBounds(700,300,160,100);
        button3.addActionListener(this);
        panel.add(button3);

        label2 = new JLabel("Total Amount:"+Cart.getItemCount()*500);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label2.setForeground(Color.BLACK);
        label2.setBounds(780,60,300,30);
        panel.add(label2);


        super.add(panel);

    }
    public void actionPerformed(ActionEvent me) {
        if(me.getSource() == button1) {
            System.exit(0);
        }
        if(me.getSource() == button2) {
            Bkash obj1 = new Bkash();
            obj1.setVisible(true);
            this.setVisible(false);
        }
        if(me.getSource() == button3) {
            Card obj1 = new Card();
            obj1.setVisible(true);
            this.setVisible(false);
        }
    }

}
