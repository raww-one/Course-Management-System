package frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Success extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label1;
    private JButton button1;

    public Success() {
        super("Success");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setBounds(1200, 440, 500, 350);
        super.setResizable(false);
        super.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#ede8d0"));

        label1 = new JLabel("Thanks for purchasing our course", SwingConstants.CENTER);
        label1.setFont(new Font("Seoge UI", Font.BOLD, 25));
        label1.setForeground(Color.BLACK);
        label1.setBounds(7, 120, 500, 30);
        panel.add(label1);

        button1 = new JButton("Finish");
        button1.setFont(new Font("Seoge UI", Font.BOLD, 25));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.decode("#6F4E37"));
        button1.setBounds(160, 230, 150, 30);
        button1.addActionListener(this);
        panel.add(button1);


        super.add(panel);
    }
    public void actionPerformed(ActionEvent me) {
        if(me.getSource() == button1) {
            System.exit(0);
        }
    }
}
