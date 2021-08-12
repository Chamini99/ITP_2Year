package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JLabel lbl_CreateAccount = new JLabel("Create Account");
		lbl_CreateAccount.setBounds(204, 44, 179, 34);
		lbl_CreateAccount.setForeground(new Color(95, 158, 160));
		lbl_CreateAccount.setFont(new Font("Calibri", Font.BOLD, 28));
		contentPane.add(lbl_CreateAccount);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 580, 33);
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(545, 0, 25, 21);
		panel.add(lblX);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX_1 = new JLabel("  -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX_1.setBounds(519, 0, 25, 21);
		panel.add(lblX_1);
		
		JLabel label = new JLabel("");
		label.setBounds(214, 78, 216, 84);
		label.setBackground(new Color(95, 158, 160));
		contentPane.add(label);
		label.setIcon(new ImageIcon(CreateAccount.class.getResource("/IT20123840/Assets/user.jpg")));
		
		JLabel lbl_CompanyName = new JLabel("Company Name");
		lbl_CompanyName.setBounds(139, 193, 108, 23);
		lbl_CompanyName.setForeground(new Color(95, 158, 160));
		lbl_CompanyName.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_CompanyName);
		
		JLabel lbl_Address = new JLabel("Address");
		lbl_Address.setBounds(139, 227, 66, 23);
		lbl_Address.setForeground(new Color(95, 158, 160));
		lbl_Address.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_Address);
		
		JLabel lbl_ContactNo = new JLabel("Contact No");
		lbl_ContactNo.setBounds(139, 261, 78, 23);
		lbl_ContactNo.setForeground(new Color(95, 158, 160));
		lbl_ContactNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_ContactNo);
		
		JLabel lbl_Email = new JLabel("Email");
		lbl_Email.setBounds(139, 295, 46, 23);
		lbl_Email.setForeground(new Color(95, 158, 160));
		lbl_Email.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_Email);
		
		JLabel lbl_UserName = new JLabel("User Name");
		lbl_UserName.setBounds(139, 334, 78, 23);
		lbl_UserName.setForeground(new Color(95, 158, 160));
		lbl_UserName.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_UserName);
		
		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setBounds(139, 368, 78, 23);
		lbl_Password.setForeground(new Color(95, 158, 160));
		lbl_Password.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_Password);
		
		JLabel lbl_ConfirmPassword = new JLabel("Confirm Password");
		lbl_ConfirmPassword.setBounds(139, 402, 126, 23);
		lbl_ConfirmPassword.setForeground(new Color(95, 158, 160));
		lbl_ConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_ConfirmPassword);
		
		textField = new JTextField();
		textField.setBounds(296, 194, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(296, 228, 143, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(296, 262, 143, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(296, 296, 143, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(296, 335, 143, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(296, 369, 143, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(296, 403, 143, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SupplierLogin sl = new SupplierLogin();
				sl.setVisible(true);
				setVisible(false);
			}
		});
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(95, 158, 160));
		btnSubmit.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSubmit.setBounds(139, 462, 108, 34);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(95, 158, 160));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnReset.setBounds(336, 462, 106, 34);
		contentPane.add(btnReset);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 33, 580, 493);
		contentPane.add(label_1);
		label_1.setIcon(new ImageIcon(CreateAccount.class.getResource("/IT20123840/Assets/login.jpeg")));
	}

}
