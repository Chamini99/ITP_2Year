package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SupplierLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierLogin frame = new SupplierLogin();
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
	public SupplierLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 335);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Title = new JLabel("Suwasetha Medical Center");
		lbl_Title.setForeground(new Color(95, 158, 160));
		lbl_Title.setFont(new Font("Tahoma", Font.BOLD, 28));
		lbl_Title.setBounds(103, 44, 381, 35);
		contentPane.add(lbl_Title);
		
		JLabel lbl_SupplierLogin = new JLabel("Supplier Login");
		lbl_SupplierLogin.setForeground(new Color(95, 158, 160));
		lbl_SupplierLogin.setFont(new Font("Calibri", Font.BOLD, 25));
		lbl_SupplierLogin.setBounds(211, 87, 149, 28);
		contentPane.add(lbl_SupplierLogin);
		
		JLabel lbl_Username = new JLabel("User Name");
		lbl_Username.setForeground(new Color (95, 158,160));
		lbl_Username.setFont(new Font("Calibri", Font.BOLD, 20));
		lbl_Username.setBounds(123, 143, 99, 20);
		contentPane.add(lbl_Username);
		
		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setForeground(new Color(95, 158, 160));
		lbl_Password.setFont(new Font("Calibri", Font.BOLD, 20));
		lbl_Password.setBounds(123, 185, 99, 20);
		contentPane.add(lbl_Password);
		
		txt_Username = new JTextField();
		txt_Username.setFont(new Font("Calibri", Font.PLAIN, 13));
		txt_Username.setBounds(274, 144, 188, 21);
		contentPane.add(txt_Username);
		txt_Username.setColumns(10);
		
		JButton btn_SignIn = new JButton("Sign In");
		btn_SignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CompanyHome ch = new CompanyHome();
				ch.setVisible(true);
				setVisible(false);
			}
		});
		btn_SignIn.setFont(new Font("Calibri", Font.PLAIN, 20));
		btn_SignIn.setForeground(new Color(255, 255, 255));
		btn_SignIn.setBackground(new Color(95, 158, 160));
		btn_SignIn.setBounds(211, 236, 149, 35);
		contentPane.add(btn_SignIn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(274, 186, 188, 20);
		contentPane.add(passwordField);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CreateAccount ca = new CreateAccount();
				ca.setVisible(true);
				setVisible(false);
			}
		});
		lblSignUp.setForeground(new Color(95, 158, 160));
		lblSignUp.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblSignUp.setBounds(262, 283, 46, 20);
		contentPane.add(lblSignUp);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX_1 = new JLabel("  -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX_1.setBounds(525, 0, 21, 22);
		panel.add(lblX_1);
		
		JLabel lblX_1_1 = new JLabel("  X");
		lblX_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblX_1_1.setForeground(Color.WHITE);
		lblX_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX_1_1.setBounds(549, 0, 21, 22);
		panel.add(lblX_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(95, 158, 160));
		lblNewLabel.setBounds(0, 0, 580, 335);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(CreateAccount.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
