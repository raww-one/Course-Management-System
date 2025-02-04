package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Eee extends JFrame implements ActionListener{
    private JPanel panel;
    private ImageIcon icon1, icon2, icon3, icon4, icon5;
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
    private JButton button1, button2, button3, button4, button5, button6;
    private boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
    private Font f1, f2,  f4, f5;



    public Eee(){
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

        f4 = new Font("Segoe UI", Font.PLAIN, 30);
        f5 = new Font("Segoe UI", Font.PLAIN, 22);

        button1 = new JButton("Back");
        button1.setFont(f2);
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.decode("#6F4E37"));
        button1.setBounds(480, 720, 100, 25);
        button1.addActionListener(this);
        panel.add(button1);

        //IEC
        icon1 = new ImageIcon(getClass().getResource("/images/Iecimage.jpg"));
        label1 = new JLabel(icon1);
        label1.setBounds(0, 30, 350, 200);
        panel.add(label1);;

        label2 = new JLabel("Introduction to Electrical Circuits");
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        label2.setBounds(70, 130, 350, 200);
        panel.add(label2);

        label3 = new JLabel("500 TK");
        label3.setFont(new Font("Arial", Font.BOLD, 15));
        label3.setBounds(140, 150, 350, 200);
        panel.add(label3);

        button2 = new JButton("ADD");
        button2.setFont(f2);
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.decode("#6F4E37"));
        button2.setBounds(77, 260, 200, 25);
        button2.addActionListener(this);
        panel.add(button2);

        //DLC
        icon2 = new ImageIcon(getClass().getResource("/images/DLCimage.jpg"));
        label4 = new JLabel(icon2);
        label4.setBounds(0, 340, 350, 200);
        panel.add(label4);

        label5 = new JLabel("DIGITAL LOGIC AND CIRCUITS");
        label5.setFont(new Font("Arial", Font.BOLD, 15));
        label5.setBounds(70, 465, 350, 200);
        panel.add(label5);

        label6 = new JLabel("500 TK");
        label6.setFont(new Font("Arial", Font.BOLD, 15));
        label6.setBounds(140, 485, 350, 200);
        panel.add(label6);

        button3 = new JButton("ADD");
        button3.setFont(f2);
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.decode("#6F4E37"));
        button3.setBounds(77, 595, 200, 25);
        button3.addActionListener(this);
        panel.add(button3);


        //Processor
        icon3 = new ImageIcon(getClass().getResource("/images/Microprocessor.jpg"));
        label5 = new JLabel(icon3);
        label5.setBounds(620, 30, 400, 200);
        panel.add(label5);

        label6 = new JLabel("Microprocessor and Embedded System");
        label6.setFont(new Font("Arial", Font.BOLD, 15));
        label6.setBounds(690, 135, 350, 200);
        panel.add(label6);

        label7 = new JLabel("500 TK");
        label7.setFont(new Font("Arial", Font.BOLD, 15));
        label7.setBounds(800, 150, 350, 200);
        panel.add(label7);

        button4 = new JButton("ADD");
        button4.setFont(f2);
        button4.setForeground(Color.WHITE);
        button4.setBackground(Color.decode("#6F4E37"));
        button4.setBounds(730, 260, 200, 25);
        button4.addActionListener(this);
        panel.add(button4);


        //Electromagnet
        icon4 = new ImageIcon(getClass().getResource("/images/Electromagnetic.png"));
        label6 = new JLabel(icon4);
        label6.setBounds(620, 340, 400, 200);
        panel.add(label6);

        label7 = new JLabel("Electromagnetics Fields and Waves");
        label7.setFont(new Font("Arial", Font.BOLD, 15));
        label7.setBounds(702, 440, 350, 200);
        panel.add(label7);

        label8 = new JLabel("500 TK");
        label8.setFont(new Font("Arial", Font.BOLD, 15));
        label8.setBounds(800, 460, 350, 200);
        panel.add(label8);

        button5 = new JButton("ADD");
        button5.setFont(f2);
        button5.setForeground(Color.WHITE);
        button5.setBackground(Color.decode("#6F4E37"));
        button5.setBounds(730, 570, 200, 25);
        button5.addActionListener(this);
        panel.add(button5);


        //Cart
        icon5 = new ImageIcon(getClass().getResource("/images/Cartimage.jpg"));
        label8 = new JLabel(icon5);
        label8.setFont(new Font("Arial", Font.BOLD, 15));
        label8.setBounds(320, 210, 400, 200);
        panel.add(label8);

        //Cart Count
        label9 = new JLabel(""+Cart.getItemCount());
        label9.setFont(new Font("Arial", Font.BOLD, 15));
        label9.setBounds(515, 160, 350, 200);
        panel.add(label9);


        //cart button to go check cart
        button6 = new JButton("Buy Now");
        button6.setFont(f2);
        button6.setForeground(Color.WHITE);
        button6.setBackground(Color.decode("#6F4E37"));
        button6.setBounds(445, 360, 150, 40);
        button6.addActionListener(this);
        panel.add(button6);
        super.add(panel);
    }


    public void actionPerformed(ActionEvent me)
    {

        if(me.getSource() == button1)
        {
            Main obj1 = new Main();
            obj1.setVisible(true);
            this.setVisible(false);
        }
        if(me.getSource() == button2){
            if(flag1 == false){
                flag1 = true;
                Cart.addItem();
                button2.setText("ADDED");
            }

        }
        if(me.getSource() == button3){
            if(flag2 == false){
                flag2 = true;
                Cart.addItem();
                button3.setText("ADDED");
            }
        }
        if(me.getSource() == button4){
            if(flag3 == false){
                flag3 = true;
                Cart.addItem();
                button4.setText("ADDED");
            }
        }
        if(me.getSource() == button5){
            if(flag4 == false){
                flag4 = true;
                Cart.addItem();
                button5.setText("ADDED");
            }
        }
        if(me.getSource() == button6 && Cart.getItemCount() == 0){
            JOptionPane.showMessageDialog(null, "You have not added any course!");
        }
        else if(me.getSource() == button6){
            Payment obj1 = new Payment();
            obj1.setVisible(true);
            this.setVisible(false);
        }
        label9.setText(""+Cart.getItemCount());

    }
}
