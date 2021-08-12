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

public class MyProfile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyProfile frame = new MyProfile();
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
	public MyProfile() {
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
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(549, 0, 31, 33);
		panel.add(lblX);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX_1 = new JLabel("  -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(new Color(255, 255, 255));
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX_1.setBounds(524, 0, 31, 33);
		panel.add(lblX_1);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setForeground(new Color(95, 158, 160));
		lblMyProfile.setFont(new Font("Calibri", Font.BOLD, 28));
		lblMyProfile.setBounds(244, 44, 120, 33);
		contentPane.add(lblMyProfile);
		
		JLabel label_UserImage = new JLabel("");
		label_UserImage.setBounds(235, 89, 110, 77);
		contentPane.add(label_UserImage);
		setUndecorated(true);
		label_UserImage.setIcon(new ImageIcon(MyProfile.class.getResource("/IT20123840/Assets/user.jpg")));
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setForeground(new Color(95, 158, 160));
		lblCompanyName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCompanyName.setBounds(157, 217, 102, 23);
		contentPane.add(lblCompanyName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(95, 158, 160));
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblAddress.setBounds(157, 251, 52, 23);
		contentPane.add(lblAddress);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setForeground(new Color(95, 158, 160));
		lblContactNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblContactNo.setBounds(157, 285, 72, 23);
		contentPane.add(lblContactNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEmail.setForeground(new Color(95, 158, 160));
		lblEmail.setBounds(157, 319, 36, 23);
		contentPane.add(lblEmail);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(95, 158, 160));
		lblUserName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUserName.setBounds(157, 353, 72, 23);
		contentPane.add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(313, 218, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(313, 252, 126, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(313, 286, 126, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(313, 320, 126, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(313, 354, 126, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateProfile up = new UpdateProfile();
				up.setVisible(true);
				setVisible(false);
			}
		});
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 20));
		btnUpdate.setBackground(new Color(95, 158, 160));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBounds(244, 421, 120, 33);
		contentPane.add(btnUpdate);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 580, 467);
		contentPane.add(label);
		label.setIcon(new ImageIcon(MyProfile.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
