package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class MyProfile extends JFrame {

	private JPanel contentPane;
	private JTextField txt_companyName;
	private JTextField txt_address;
	private JTextField txt_contactNo;
	private JTextField txt_email;
	private JTextField txt_userName;
	private JTextField txt_companyID;
	private JPasswordField passwordField;

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
		setLocationRelativeTo(null);
		
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
		lblCompanyName.setBounds(124, 280, 102, 23);
		contentPane.add(lblCompanyName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(95, 158, 160));
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblAddress.setBounds(124, 314, 52, 23);
		contentPane.add(lblAddress);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setForeground(new Color(95, 158, 160));
		lblContactNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblContactNo.setBounds(124, 348, 72, 23);
		contentPane.add(lblContactNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEmail.setForeground(new Color(95, 158, 160));
		lblEmail.setBounds(124, 382, 36, 23);
		contentPane.add(lblEmail);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(95, 158, 160));
		lblUserName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUserName.setBounds(124, 416, 72, 23);
		contentPane.add(lblUserName);
		
		txt_companyName = new JTextField();
		txt_companyName.setBounds(281, 281, 173, 20);
		contentPane.add(txt_companyName);
		txt_companyName.setColumns(10);
		txt_companyName.setEditable(false);
		
		txt_address = new JTextField();
		txt_address.setBounds(281, 315, 173, 20);
		contentPane.add(txt_address);
		txt_address.setColumns(10);
		txt_address.setEditable(false);
		
		txt_contactNo = new JTextField();
		txt_contactNo.setBounds(281, 349, 173, 20);
		contentPane.add(txt_contactNo);
		txt_contactNo.setColumns(10);
		txt_contactNo.setEditable(false);
		
		txt_email = new JTextField();
		txt_email.setBounds(281, 383, 173, 20);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		txt_email.setEditable(false);
		
		txt_userName = new JTextField();
		txt_userName.setBounds(281, 417, 173, 20);
		contentPane.add(txt_userName);
		txt_userName.setColumns(10);
		txt_userName.setEditable(false);
		
		txt_companyID = new JTextField();
		txt_companyID.setColumns(10);
		txt_companyID.setBounds(281, 250, 173, 20);
		contentPane.add(txt_companyID);
		txt_companyID.setEditable(false);
		
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
		btnUpdate.setBounds(244, 456, 120, 33);
		contentPane.add(btnUpdate);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
					Statement stmt = connection.createStatement();
					String query = "select company_id, company_name, company_address, contact_no, company_email, username from tbl_supplycompany where password = '"+passwordField.getText()+"'";
					ResultSet rs = stmt.executeQuery(query);
					
					if (rs.next()) {
						String companyId = rs.getString(1);
						String companyName = rs.getString(2);
						String address = rs.getString(3);
						String contactNo = rs.getString(4);
						String email = rs.getString(5);
						String userName = rs.getString(6);
						
						txt_companyID.setText(companyId);
						txt_companyName.setText(companyName);
						txt_address.setText(address);
						txt_contactNo.setText(contactNo);
						txt_email.setText(email);
						txt_userName.setText(userName);
					}
					else {
						JOptionPane.showMessageDialog(passwordField, "Invalid password");
						passwordField.setText(null);
					}
					
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnView.setForeground(Color.WHITE);
		btnView.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnView.setBackground(new Color(95, 158, 160));
		btnView.setBounds(375, 202, 79, 23);
		contentPane.add(btnView);
		
		JLabel lblCompanyId = new JLabel("Company ID");
		lblCompanyId.setForeground(new Color(95, 158, 160));
		lblCompanyId.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCompanyId.setBounds(124, 249, 86, 23);
		contentPane.add(lblCompanyId);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(235, 204, 86, 20);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(95, 158, 160));
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword.setBounds(124, 202, 72, 23);
		contentPane.add(lblPassword);
		
		JButton btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CompanyHome ch = new CompanyHome();
				ch.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon(MyProfile.class.getResource("/IT20123840/Assets/Back.PNG")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnBack.setBackground(new Color(95, 158, 160));
		btnBack.setBounds(527, 65, 43, 26);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 580, 467);
		contentPane.add(label);
		label.setIcon(new ImageIcon(MyProfile.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
