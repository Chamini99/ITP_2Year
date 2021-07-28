package IT20198886;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SplashScreen;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		  
		  JLabel lblUserName = new JLabel("User Name");
		  lblUserName.setForeground(new Color(95, 158, 160));
		  lblUserName.setFont(new Font("Source Sans Pro Light", Font.BOLD, 18));
		  lblUserName.setBounds(96, 150, 128, 14);
		  contentPane.add(lblUserName);
		  
		  JLabel lblPassword = new JLabel("Password");
		  lblPassword.setForeground(new Color(95, 158, 160));
		  lblPassword.setFont(new Font("Source Sans Pro Light", Font.BOLD, 18));
		  lblPassword.setBounds(96, 191, 128, 14);
		  contentPane.add(lblPassword);
		  
		  passwordField = new JPasswordField();
		  passwordField.setBounds(207, 191, 259, 20);
		  contentPane.add(passwordField);
		  
		  textField = new JTextField();
		  textField.setBounds(207, 150, 259, 20);
		  contentPane.add(textField);
		  textField.setColumns(10);
		  
		  JButton btnSignIn = new JButton("Sign In");
		  btnSignIn.setFont(new Font("Source Sans Pro Light", Font.BOLD, 18));
		  btnSignIn.setBackground(new Color(95, 158, 160));
		  btnSignIn.setForeground(new Color(255, 255, 255));
		  btnSignIn.setBounds(233, 244, 139, 33);
		  contentPane.add(btnSignIn);
		  
		  JLabel lblStaffLogin = new JLabel("Staff Login");
		  lblStaffLogin.setForeground(new Color(95, 158, 160));
		  lblStaffLogin.setFont(new Font("Source Sans Pro Light", Font.BOLD, 18));
		  lblStaffLogin.setBounds(244, 89, 128, 37);
		  contentPane.add(lblStaffLogin);
		  
		  JPanel panel = new JPanel();
		  panel.setBackground(new Color(95, 158, 160));
		  panel.setBounds(0, 0, 580, 33);
		  contentPane.add(panel);
		  panel.setLayout(null);
		  
		  JLabel lblNewLabel_2 = new JLabel("X");
		  lblNewLabel_2.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent arg0) {
		  		System.exit(20);
		  	}
		  });
		  lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		  lblNewLabel_2.setForeground(new Color(255, 255, 255));
		  lblNewLabel_2.setBounds(550, 11, 46, 14);
		  panel.add(lblNewLabel_2);
		  
		  JLabel lblNewLabel_2_1 = new JLabel("-");
		  lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent arg0) {
		  		setState(ICONIFIED);	
		  	}
		  });
		  lblNewLabel_2_1.setForeground(Color.WHITE);
		  lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		  lblNewLabel_2_1.setBounds(524, 11, 46, 14);
		  panel.add(lblNewLabel_2_1);
		
		
		  JLabel lblNewLabel_1 = new JLabel("Suwasetha Medical Center");
	        lblNewLabel_1.setForeground(new Color(95, 158, 160));
	        lblNewLabel_1.setFont(new Font("Source Sans Pro Light", Font.BOLD, 30));
	        lblNewLabel_1.setBounds(121, 37, 411, 56);
	        contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Register");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				StaffRegister register=new StaffRegister();
				register.setVisible(true);
				
			}
		});
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_3.setBounds(271, 288, 139, 36);
		contentPane.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 580, 335);
		contentPane.add(lblNewLabel);
		
		 lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel);
		 
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
