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

public class MyProfile extends JFrame {

	private JPanel contentPane;
	private JTextField txt_companyName;
	private JTextField txt_address;
	private JTextField txt_contactNo;
	private JTextField txt_email;
	private JTextField txt_userName;
	private JTextField companyID;

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
		lblCompanyName.setBounds(157, 256, 102, 23);
		contentPane.add(lblCompanyName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(95, 158, 160));
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblAddress.setBounds(157, 290, 52, 23);
		contentPane.add(lblAddress);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setForeground(new Color(95, 158, 160));
		lblContactNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblContactNo.setBounds(157, 324, 72, 23);
		contentPane.add(lblContactNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEmail.setForeground(new Color(95, 158, 160));
		lblEmail.setBounds(157, 358, 36, 23);
		contentPane.add(lblEmail);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(95, 158, 160));
		lblUserName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUserName.setBounds(157, 392, 72, 23);
		contentPane.add(lblUserName);
		
		txt_companyName = new JTextField();
		txt_companyName.setBounds(313, 257, 126, 20);
		contentPane.add(txt_companyName);
		txt_companyName.setColumns(10);
		
		txt_address = new JTextField();
		txt_address.setBounds(313, 291, 126, 20);
		contentPane.add(txt_address);
		txt_address.setColumns(10);
		
		txt_contactNo = new JTextField();
		txt_contactNo.setBounds(313, 325, 126, 20);
		contentPane.add(txt_contactNo);
		txt_contactNo.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setBounds(313, 359, 126, 20);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		txt_userName = new JTextField();
		txt_userName.setBounds(313, 393, 126, 20);
		contentPane.add(txt_userName);
		txt_userName.setColumns(10);
		
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
		btnUpdate.setBounds(244, 440, 120, 33);
		contentPane.add(btnUpdate);
		
		companyID = new JTextField();
		companyID.setColumns(10);
		companyID.setBounds(157, 203, 126, 20);
		contentPane.add(companyID);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
					Statement stmt = connection.createStatement();
					String query = "select company_name, company_address, contact_no, company_email, username from tbl_supplycompany where company_id = '"+companyID.getText()+"'";
					ResultSet rs = stmt.executeQuery(query);
					
					if (rs.next()) {
						String companyName = rs.getString(1);
						String address = rs.getString(2);
						String contactNo = rs.getString(3);
						String email = rs.getString(4);
						String userName = rs.getString(5);
						
						txt_companyName.setText(companyName);
						txt_address.setText(address);
						txt_contactNo.setText(contactNo);
						txt_email.setText(email);
						txt_userName.setText(userName);
					}
					else {
						JOptionPane.showMessageDialog(companyID, "Company ID not found");
						companyID.setText(null);
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
		btnView.setBounds(360, 202, 79, 23);
		contentPane.add(btnView);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 580, 467);
		contentPane.add(label);
		label.setIcon(new ImageIcon(MyProfile.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
