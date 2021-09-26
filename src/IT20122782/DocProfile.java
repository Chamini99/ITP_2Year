package IT20122782;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DocProfile extends JFrame {

	
	private JPanel contentPane;
	private JTextField txt_NIC;
	private JTextField txt_email;
	private JTextField txt_qualification;
	private JTextField txt_contact;
	private JTextField txt_username;
	private JTextField txt_password;
	private JTextField txt_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
				try {
					DocProfile frame = new DocProfile();
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
	public DocProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("My Profile");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(222, 39, 102, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(0, 51, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(50, 112, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("NIC");
		lblNewLabel_2.setForeground(new Color(0, 51, 204));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(50, 153, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		txt_NIC = new JTextField();
		txt_NIC.setBounds(194, 147, 256, 22);
		contentPane.add(txt_NIC);
		txt_NIC.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(new Color(0, 51, 204));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(50, 199, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		txt_email = new JTextField();
		txt_email.setBounds(194, 197, 256, 22);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Qualification");
		lblNewLabel_5.setForeground(new Color(0, 51, 204));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(50, 238, 88, 16);
		contentPane.add(lblNewLabel_5);
		
		txt_qualification = new JTextField();
		txt_qualification.setBounds(194, 236, 256, 22);
		contentPane.add(txt_qualification);
		txt_qualification.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Contact number");
		lblNewLabel_6.setForeground(new Color(0, 51, 204));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(50, 274, 132, 16);
		contentPane.add(lblNewLabel_6);
		
		txt_contact = new JTextField();
		txt_contact.setBounds(194, 271, 256, 22);
		contentPane.add(txt_contact);
		txt_contact.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Username");
		lblNewLabel_7.setForeground(new Color(0, 51, 204));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(50, 312, 102, 16);
		contentPane.add(lblNewLabel_7);
		
		txt_username = new JTextField();
		txt_username.setBounds(194, 310, 256, 22);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setForeground(new Color(0, 51, 204));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(50, 345, 102, 16);
		contentPane.add(lblNewLabel_8);
		
		txt_password = new JTextField();
		txt_password.setBounds(194, 345, 256, 22);
		contentPane.add(txt_password);
		txt_password.setColumns(10);
		
		
	   
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocUpdate m = new DocUpdate();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(403, 403, 132, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("< Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocHome m = new DocHome();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(95, 158, 160));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(30, 403, 122, 41);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("X");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
			}
		});
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(548, 13, 32, 16);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("-");
		lblNewLabel_10_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setState(ICONIFIED);
			}
		});
		lblNewLabel_10_1.setForeground(Color.WHITE);
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10_1.setBounds(531, 13, 22, 16);
		panel.add(lblNewLabel_10_1);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(194, 110, 256, 22);
		contentPane.add(txt_name);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(DocLogin.class.getResource("/IT20122782/Image/login.jpeg")));
		lblNewLabel_4.setBounds(0, 30, 580, 466);
		contentPane.add(lblNewLabel_4);
		
		
	}
	
}
