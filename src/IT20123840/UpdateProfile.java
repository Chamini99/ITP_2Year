package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateProfile extends JFrame {

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
					UpdateProfile frame = new UpdateProfile();
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
	public UpdateProfile() {
		setBackground(new Color(250, 235, 215));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblX.setBounds(548, 0, 32, 33);
		panel.add(lblX);
		lblX.setForeground(new Color(255, 255, 255));
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
		lblX_1.setBounds(523, 0, 32, 33);
		panel.add(lblX_1);
		
		JLabel lblUpdateProfile = new JLabel("Update Profile");
		lblUpdateProfile.setForeground(new Color(95, 158, 160));
		lblUpdateProfile.setBackground(new Color(255, 255, 255));
		lblUpdateProfile.setFont(new Font("Calibri", Font.BOLD, 28));
		lblUpdateProfile.setBounds(208, 44, 169, 33);
		contentPane.add(lblUpdateProfile);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(218, 88, 107, 89);
		contentPane.add(lblNewLabel);
		setUndecorated(true);
		lblNewLabel.setIcon(new ImageIcon(UpdateProfile.class.getResource("/IT20123840/Assets/user.jpg")));
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setForeground(new Color(95, 158, 160));
		lblCompanyName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCompanyName.setBounds(133, 188, 102, 22);
		contentPane.add(lblCompanyName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(95, 158, 160));
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblAddress.setBounds(133, 221, 52, 22);
		contentPane.add(lblAddress);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setForeground(new Color(95, 158, 160));
		lblContactNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblContactNo.setBounds(133, 254, 72, 22);
		contentPane.add(lblContactNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEmail.setForeground(new Color(95, 158, 160));
		lblEmail.setBounds(133, 287, 36, 22);
		contentPane.add(lblEmail);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(95, 158, 160));
		lblUserName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUserName.setBounds(133, 320, 72, 22);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(95, 158, 160));
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword.setBounds(133, 353, 62, 22);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblConfirmPassword.setForeground(new Color(95, 158, 160));
		lblConfirmPassword.setBounds(133, 386, 117, 22);
		contentPane.add(lblConfirmPassword);
		
		textField = new JTextField();
		textField.setBounds(295, 189, 152, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(295, 222, 152, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(295, 255, 152, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(295, 288, 152, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(295, 321, 152, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(295, 354, 152, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(295, 387, 152, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 20));
		btnUpdate.setBackground(new Color(95, 158, 160));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBounds(133, 440, 102, 33);
		contentPane.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(95, 158, 160));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setFont(new Font("Calibri", Font.BOLD, 20));
		btnReset.setBounds(340, 440, 107, 33);
		contentPane.add(btnReset);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 32, 580, 468);
		contentPane.add(label);
		label.setIcon(new ImageIcon(UpdateProfile.class.getResource("/IT20123840/Assets/login.jpeg")));
	}

}
