package IT20122782;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DocRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_NIC;
	private JTextField txt_email;
	private JTextField txt_qualification;
	private JTextField txt_contact;
	private JTextField txt_username;
	private JTextField txt_password;
	
	Connection con = null;
	PreparedStatement prestmt = null;
	ResultSet rs = null;

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
		setBounds(100, 100, 600, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);  
		
		JLabel lblsignup = new JLabel("Sign up ");
		lblsignup.setForeground(new Color(95, 158, 160));
		lblsignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblsignup.setBounds(10, 34, 94, 33);
		contentPane.add(lblsignup);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(0, 51, 204));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(25, 90, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblNIC = new JLabel("NIC");
		lblNIC.setForeground(new Color(0, 51, 204));
		lblNIC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNIC.setBounds(25, 129, 56, 16);
		contentPane.add(lblNIC);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(0, 51, 204));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(25, 158, 56, 24);
		contentPane.add(lblEmail);
		
		JLabel lblQualification = new JLabel("Qualification");
		lblQualification.setForeground(new Color(0, 51, 204));
		lblQualification.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQualification.setBounds(25, 195, 112, 24);
		contentPane.add(lblQualification);
		
		JLabel lblContact = new JLabel("Contact number");
		lblContact.setForeground(new Color(0, 51, 204));
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContact.setBounds(20, 241, 127, 16);
		contentPane.add(lblContact);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(0, 51, 204));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(25, 278, 94, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 51, 204));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(25, 317, 77, 16);
		contentPane.add(lblPassword);
		
		JLabel lbname = new JLabel("");
		lbname.setForeground(Color.RED);
		lbname.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lbname.setBounds(410, 91, 178, 16);
		contentPane.add(lbname);
		
		JLabel lbemail = new JLabel("");
		lbemail.setForeground(Color.RED);
		lbemail.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lbemail.setBounds(410, 163, 178, 16);
		contentPane.add(lbemail);
		
		JLabel lbcontact = new JLabel("");
		lbcontact.setForeground(Color.RED);
		lbcontact.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lbcontact.setBounds(410, 242, 178, 16);
		contentPane.add(lbcontact);
		
		JLabel lbusername = new JLabel("");
		lbusername.setForeground(Color.RED);
		lbusername.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lbusername.setBounds(410, 284, 178, 16);
		contentPane.add(lbusername);
		
		JLabel lbpassword = new JLabel("");
		lbpassword.setForeground(Color.RED);
		lbpassword.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lbpassword.setBounds(410, 318, 178, 16);
		contentPane.add(lbpassword);
		
		
		txt_name = new JTextField();
		txt_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z]{0,30}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txt_name.getText());
				if(!match.matches()) {
					lbname.setText("Invalid Name!");
				}else {
					lbname.setText(null);
				}
			}
		});
		txt_name.setBounds(159, 88, 239, 22);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_NIC = new JTextField();
		txt_NIC.setBounds(159, 127, 239, 22);
		contentPane.add(txt_NIC);
		txt_NIC.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String PATTERN = "^[a-zA-Z0-9]{0,30}[@][a-zA-Z]{0,20}[.][a-zA-Z]{0,5}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txt_email.getText());
				if(!match.matches()) {
					lbemail.setText("Invalid Email!");
				}else {
					lbemail.setText(null);
				}
			}
		});
		txt_email.setBounds(159, 160, 239, 22);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		txt_qualification = new JTextField();
		txt_qualification.setBounds(159, 197, 239, 22);
		contentPane.add(txt_qualification);
		txt_qualification.setColumns(10);
		
		txt_contact = new JTextField();
		txt_contact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[0-9]{10}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txt_contact.getText());
				if(!match.matches()) {
					lbcontact.setText("Invalid Contact Number!");
				}else {
					lbcontact.setText(null);
				}
			}

			
		});
		txt_contact.setBounds(159, 239, 239, 22);
		contentPane.add(txt_contact);
		txt_contact.setColumns(10);
		
		txt_username = new JTextField();
		txt_username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String PATTERN = "^[a-z0-9]{0,30}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txt_username.getText());
				if(!match.matches()) {
					lbusername.setText("Invalid Username!");
				}else {
					lbusername.setText(null);
				}
			}
			
		});
		txt_username.setBounds(159, 281, 239, 22);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z0-9]{0,12}[@#*/=][a-zA-Z0-9]{0,10}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txt_password.getText());
				if(!match.matches()) {
					lbpassword.setText("Invalid Password!");
				}else {
					lbpassword.setText(null);
				}
			}
			
		});
		txt_password.setBounds(159, 315, 239, 22);
		contentPane.add(txt_password);
		txt_password.setColumns(10);
		
		JButton btn_signup = new JButton("Sign Up");
		btn_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql = "INSERT INTO tb_doctorinfo(name, nic, email, qualification, phone_no, username, password ) values (?,?,?,?,?,?,?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_doctor","root","");
					prestmt = con.prepareStatement(sql);
					prestmt.setString(1, txt_name.getText());
					prestmt.setString(2, txt_NIC.getText());
					prestmt.setString(3, txt_email.getText());
					prestmt.setString(4, txt_qualification.getText());
					prestmt.setString(5, txt_contact.getText());
					prestmt.setString(6, txt_username.getText());
					prestmt.setString(7, txt_password.getText());
					
					prestmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Your account is created successfully!");
					dispose();
					DocProfile P= new DocProfile();
				    P.setVisible(true);
					
				}catch(SQLException | HeadlessException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				}
			
				
				
		});	
		
		/*btn_signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocProfile m = new DocProfile();
				m.setVisible(true);
				setVisible(false);
			}
		});*/
		btn_signup.setForeground(Color.WHITE);
		btn_signup.setBackground(new Color(95, 158, 160));
		btn_signup.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_signup.setBounds(203, 364, 127, 37);
		contentPane.add(btn_signup);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 600, 33);
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
		lblNewLabel_10.setBounds(567, 13, 21, 16);
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
		lblNewLabel_10_1.setBounds(541, 13, 7, 16);
		panel.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DocLogin.class.getResource("/IT20122782/Image/login.jpeg")));
		lblNewLabel.setBounds(0, 34, 600, 406);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		
		
		
		
		
	}
}
