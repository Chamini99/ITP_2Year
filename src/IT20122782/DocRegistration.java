package IT20122782;

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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class DocRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_NIC;
	private JTextField txt_email;
	private JTextField txt_gender;
	private JTextField txt_qualification;
	private JTextField txt_contact;
	private JTextField txt_username;
	private JTextField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocRegistration frame = new DocRegistration();
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
	public DocRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblsignup = new JLabel("Sign up ");
		lblsignup.setForeground(new Color(95, 158, 160));
		lblsignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblsignup.setBounds(10, 34, 94, 33);
		contentPane.add(lblsignup);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(0, 51, 204));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(95, 86, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblNIC = new JLabel("NIC");
		lblNIC.setForeground(new Color(0, 51, 204));
		lblNIC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNIC.setBounds(95, 115, 56, 16);
		contentPane.add(lblNIC);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(0, 51, 204));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(95, 144, 56, 24);
		contentPane.add(lblEmail);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(0, 51, 204));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(95, 181, 56, 16);
		contentPane.add(lblGender);
		
		JLabel lblQualification = new JLabel("Qualification");
		lblQualification.setForeground(new Color(0, 51, 204));
		lblQualification.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQualification.setBounds(95, 208, 112, 24);
		contentPane.add(lblQualification);
		
		JLabel lblContact = new JLabel("Contact number");
		lblContact.setForeground(new Color(0, 51, 204));
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContact.setBounds(92, 245, 127, 16);
		contentPane.add(lblContact);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(0, 51, 204));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(95, 274, 94, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 51, 204));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(95, 313, 77, 16);
		contentPane.add(lblPassword);
		
		txt_name = new JTextField();
		txt_name.setBounds(230, 84, 259, 22);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_NIC = new JTextField();
		txt_NIC.setBounds(230, 113, 259, 22);
		contentPane.add(txt_NIC);
		txt_NIC.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setBounds(230, 146, 259, 22);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		txt_gender = new JTextField();
		txt_gender.setBounds(230, 175, 259, 22);
		contentPane.add(txt_gender);
		txt_gender.setColumns(10);
		
		txt_qualification = new JTextField();
		txt_qualification.setBounds(230, 210, 259, 22);
		contentPane.add(txt_qualification);
		txt_qualification.setColumns(10);
		
		txt_contact = new JTextField();
		txt_contact.setBounds(230, 243, 259, 22);
		contentPane.add(txt_contact);
		txt_contact.setColumns(10);
		
		txt_username = new JTextField();
		txt_username.setBounds(230, 277, 259, 22);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.setBounds(230, 311, 259, 22);
		contentPane.add(txt_password);
		txt_password.setColumns(10);
		
		JButton btn__signup = new JButton("Sign Up");
		btn__signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocProfile m = new DocProfile();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btn__signup.setForeground(Color.WHITE);
		btn__signup.setBackground(new Color(95, 158, 160));
		btn__signup.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn__signup.setBounds(230, 361, 127, 37);
		contentPane.add(btn__signup);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(DocLogin.class.getResource("/IT20122782/Image/login.jpeg")));
		lblNewLabel_9.setBounds(0, 34, 580, 406);
		contentPane.add(lblNewLabel_9);
		
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
		lblNewLabel_10.setBounds(547, 13, 21, 16);
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
		lblNewLabel_10_1.setBounds(527, 13, 21, 16);
		panel.add(lblNewLabel_10_1);
		
		
	}
}
