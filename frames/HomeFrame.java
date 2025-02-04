package frames;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HomeFrame extends JFrame {

    private Container c;
    private ImageIcon icon, logo;
    private JLabel label1,label2, imgLabel, backgroundLabel;
    private Font f1, f2;
    private JButton btn1, btn2, btn3, btn4, nBtn;
    private Cursor cursor;

    public HomeFrame() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Home page");
        this.setSize(780, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#ede8d0"));

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/aiub.png"));
        this.setIconImage(icon.getImage());
		
		
		
        // Logo
        logo = new ImageIcon(getClass().getResource("/images/aiub.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(90, 60, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);
	
		
        // Fonts
        f1 = new Font("Franklin Gothic", Font.BOLD, 44);
        f2 = new Font("Cascadia Code", Font.PLAIN, 24);

        // Title
        label1 = new JLabel();
        label1.setText("AIUB Online");
        label1.setBounds(230, 60, 560, 65);
        label1.setFont(f1);
		label1.setForeground(Color.decode("#6F4E37"));
        c.add(label1);
		
		
		 label2 = new JLabel();
        label2.setText("Course Solution");
        label2.setBounds(350, 110, 560, 65);
        label2.setFont(f1);
		label2.setForeground(Color.decode("#6F4E37"));
        c.add(label2);

       

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Login");
        btn1.setBounds(300, 254, 155, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#6F4E37"));
		c.add(btn1);
		

        btn2 = new JButton("Register");
        btn2.setBounds(80, 254, 155, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#6F4E37"));
        c.add(btn2);
		

        btn3 = new JButton("Exit");
        btn3.setBounds(300, 328, 155, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#6F4E37"));
        c.add(btn3);
		

        btn4 = new JButton("Admin");
        btn4.setBounds(520, 254, 155, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#6F4E37"));
        c.add(btn4);

        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);
		
		
		//backgroundimage
		/* backgroundimg =new ImageIcon(getClass().getResource("/images/AiubFull.jpg"));
		backgroundLabel = new JLabel(backgroundimg);
        backgroundLabel.setBounds(0, 0, 780, 500);
        c.add(backgroundLabel);*/

        // Login
       btn1.addActionListener(new ActionListener()
	   {
            public void actionPerformed(ActionEvent ae)
			{
                setVisible(false);
                LoginFrame frame = new LoginFrame();
                frame.setVisible(true);
            }
        });

         //Register
       btn2.addActionListener(new ActionListener() 
	   {
            public void actionPerformed(ActionEvent ae) 
			{
                RegistrationFrame frame = new RegistrationFrame();
                frame.setVisible(true);
                setVisible(false);
            }
        });

        // Exit
         btn3.addActionListener(new ActionListener() 
		 {
            public void actionPerformed(ActionEvent ae) 
			{
                System.exit(0);
            }
        });
		

        // Admin Login
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminLoginFrame frame = new AdminLoginFrame();
                frame.setVisible(true);
                JOptionPane.showMessageDialog(null, "By default, Admin Name and Password is : 'admin'", "Information!",
                                JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
        
    
}