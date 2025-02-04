package frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label1, label2, label3, label4, label5, label6;
    private ImageIcon icon1, icon2, icon3, icon4;
    private JButton button1, button2, button3;
    private Font f1, f2,  f4, f5;

    public Main() {
        super.setBounds(770, 250, 1000, 800);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#ede8d0"));

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Cascadia Code", Font.PLAIN, 25);

        f4 = new Font("Segoe UI", Font.BOLD, 30);
        f5 = new Font("Segoe UI", Font.PLAIN, 22);


        label1 = new JLabel("DEPARTMENT");
        label1.setFont(f4);
        label1.setForeground(Color.BLACK);
        label1.setBounds(430, 10, 300, 35);
        panel.add(label1);

        //icon1 = new ImageIcon("image.PNG");// image not showing through this
        icon1 = new ImageIcon(getClass().getResource("/images/CSEimage.jpg"));
        label2 = new JLabel(icon1);
        label2.setBounds(60, 280, 250, 130);
        panel.add(label2);

        button1 = new JButton("CSE");
        button1.setFont(f2);
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.decode("#6F4E37"));
        button1.setBounds(125, 420, 150, 40);
        button1.addActionListener(this);
        panel.add(button1);

        icon2 = new ImageIcon(getClass().getResource("/images/EEEimage.png"));
        label3 = new JLabel(icon2);
        label3.setBounds(380, 280, 210, 130);
        panel.add(label3);

        button2 = new JButton("EEE");
        button2.setFont(f2);
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.decode("#6F4E37"));
        button2.setBounds(425, 416, 150, 40);
        button2.addActionListener(this);
        panel.add(button2);

        icon3 = new ImageIcon(getClass().getResource("/images/BBAimage.png"));
        label4 = new JLabel(icon3);
        label4.setBounds(660, 280, 310, 130);
        panel.add(label4);

        button3 = new JButton("BBA");
        button3.setFont(f2);
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.decode("#6F4E37"));
        button3.setBounds(755, 416, 150, 40);
        button3.addActionListener(this);
        panel.add(button3);

        Cart.removeItem();



        super.add(panel);
    }
        public void actionPerformed(ActionEvent me){

            if(me.getSource() == button1){
                Cse obj1 = new Cse();
                obj1.setVisible(true);
                this.setVisible(false);
            }
            if(me.getSource() == button2){
                Eee obj1 = new Eee();
                obj1.setVisible(true);
                this.setVisible(false);
            }
            if(me.getSource() == button3){
                Bba obj1 = new Bba();
                obj1.setVisible(true);
                this.setVisible(false);
            }
        }
}