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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UpdateProfile extends JFrame {

	private JPanel contentPane;
	private JTextField txt_companyName;
	private JTextField txt_address;
	private JTextField txt_contactNo;
	private JTextField txt_email;
	private JTextField txt_userName;
	private JTextField txt_companyID;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JLabel lbl_error4;

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
		setBackground(new Color(250, 235, 235));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 235));
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
		lblCompanyName.setBounds(104, 286, 102, 22);
		contentPane.add(lblCompanyName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(95, 158, 160));
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblAddress.setBounds(104, 319, 52, 22);
		contentPane.add(lblAddress);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setForeground(new Color(95, 158, 160));
		lblContactNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblContactNo.setBounds(104, 352, 72, 22);
		contentPane.add(lblContactNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEmail.setForeground(new Color(95, 158, 160));
		lblEmail.setBounds(104, 385, 36, 22);
		contentPane.add(lblEmail);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(95, 158, 160));
		lblUserName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUserName.setBounds(104, 418, 72, 22);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(95, 158, 160));
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword.setBounds(104, 451, 62, 22);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblConfirmPassword.setForeground(new Color(95, 158, 160));
		lblConfirmPassword.setBounds(104, 484, 117, 22);
		contentPane.add(lblConfirmPassword);
		
		txt_companyName = new JTextField();
		txt_companyName.setBounds(293, 287, 180, 20);
		contentPane.add(txt_companyName);
		txt_companyName.setColumns(10);
		
		txt_address = new JTextField();
		txt_address.setBounds(293, 320, 180, 20);
		contentPane.add(txt_address);
		txt_address.setColumns(10);
		
		txt_contactNo = new JTextField();
		txt_contactNo.setBounds(293, 353, 180, 20);
		contentPane.add(txt_contactNo);
		txt_contactNo.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setBounds(293, 386, 180, 20);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		txt_userName = new JTextField();
		txt_userName.setBounds(293, 419, 180, 20);
		contentPane.add(txt_userName);
		txt_userName.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String company_name = txt_companyName.getText();
				String company_address = txt_address.getText();
				String contact_no = txt_contactNo.getText();
				int len = contact_no.length();
				String company_email = txt_email.getText();
				
				String EMAIL_PATTERN = 
					    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				
				String username = txt_userName.getText();
				String password = passwordField.getText();
				
				String PASSWORD_PATTERN = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
				
				String confirmPassword = passwordField_1.getText();
				
				// Registration form validation
				
				//Validation of filling all the fields
				String msg = "" + txt_companyName;
				msg += "\n";
				if (txt_companyName.getText().isEmpty() || txt_address.getText().isEmpty() || txt_contactNo.getText().isEmpty() ||txt_email.getText().isEmpty() || txt_userName.getText().isEmpty() || passwordField.getText().isEmpty() || passwordField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnUpdate, "Please fill all fields");
				}
				
				//Validation of contact number
				else if (len != 10) {
					JOptionPane.showMessageDialog(btnUpdate, "Please enter a valid mobile number");
				}
				
				//Validation of email address
				else if (!txt_email.getText().matches(EMAIL_PATTERN)) {
					JOptionPane.showMessageDialog(btnUpdate, "Please enter a valid email address");
				}
				
				//Validation of password
				else if (!passwordField.getText().matches(PASSWORD_PATTERN)) {
					JOptionPane.showMessageDialog(btnUpdate, "Password should contain at least 8 characters, one digit, one lower alpha character, upper alpha character and a special character");
				}
				
				//Validation of confirmation password
				else if (!(new String(passwordField.getText()).equals(new String(passwordField_1.getText())))) {
					JOptionPane.showMessageDialog(btnUpdate, "Password confirmation is invalid");
				}
				
				else {
				//Execute sql query to insert data to the table
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
		
						String query = "update tbl_supplycompany set company_name = '"+txt_companyName.getText()+"', company_address = '"+txt_address.getText()+"', contact_no = '"+txt_contactNo.getText()+"', company_email = '"+txt_email.getText()+"', username = '"+txt_userName.getText()+"' , password = '"+passwordField.getText()+"' , confirmPassword = '"+passwordField_1.getText()+"' where company_id = '"+txt_companyID.getText()+"'";
						Statement stmt = connection.createStatement();
						int x = stmt.executeUpdate(query);
					
						JOptionPane.showConfirmDialog(btnUpdate, "Your account has been updated successfully!!!");
						CompanyHome ch = new CompanyHome();
						ch.setVisible(true);
						setVisible(false);
						
						connection.close();
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			}
		});
		
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 20));
		btnUpdate.setBackground(new Color(95, 158, 160));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBounds(104, 536, 102, 33);
		contentPane.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField_2.setText("");
				txt_companyID.setText("");
				txt_companyName.setText("");
				txt_address.setText("");
				txt_contactNo.setText("");
				txt_email.setText("");
				txt_userName.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
			}
		});
		btnReset.setBackground(new Color(95, 158, 160));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setFont(new Font("Calibri", Font.BOLD, 20));
		btnReset.setBounds(366, 536, 107, 33);
		contentPane.add(btnReset);
		
		txt_companyID = new JTextField();
		txt_companyID.setColumns(10);
		txt_companyID.setBounds(293, 254, 180, 20);
		contentPane.add(txt_companyID);
		txt_companyID.setEditable(false);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
					Statement stmt = connection.createStatement();
					String query = "select company_id, company_name, company_address, contact_no, company_email,username, password, confirmPassword from tbl_supplycompany where password = '"+passwordField_2.getText()+"'";
					ResultSet rs = stmt.executeQuery(query);
					
					if (rs.next()) {
						String companyId = rs.getString(1);
						String companyName = rs.getString(2);
						String address = rs.getString(3);
						String contactNo = rs.getString(4);
						String email = rs.getString(5);
						String userName = rs.getString(6);
						String password = rs.getString(7);
						String confirmPassword = rs.getString(8);
						
						txt_companyID.setText(companyId);
						txt_companyName.setText(companyName);
						txt_address.setText(address);
						txt_contactNo.setText(contactNo);
						txt_email.setText(email);
						txt_userName.setText(userName);
						passwordField.setText(password);
						passwordField_1.setText(confirmPassword);
					}
					else {
						JOptionPane.showMessageDialog(passwordField_2, "Invalid Password");
						passwordField_2.setText(null);
					}
					
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnView.setForeground(new Color(240, 248, 255));
		btnView.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnView.setBackground(new Color(95, 158, 160));
		btnView.setBounds(398, 203, 75, 23);
		contentPane.add(btnView);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");

						String query = "delete from tbl_supplycompany where company_id = '"+txt_companyID.getText()+"'";
						Statement stmt = connection.createStatement();
						int x = stmt.executeUpdate(query);
					
						JOptionPane.showConfirmDialog(btnDelete, "Your account has been deleted successfully!!!");
						SupplyHome sh = new SupplyHome();
						sh.frame.setVisible(true);
						setVisible(false);
					
					connection.close();
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Calibri", Font.BOLD, 20));
		btnDelete.setBackground(new Color(95, 158, 160));
		btnDelete.setBounds(235, 536, 102, 33);
		contentPane.add(btnDelete);
		
		JLabel lblCompanyId = new JLabel("Company ID");
		lblCompanyId.setForeground(new Color(95, 158, 160));
		lblCompanyId.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCompanyId.setBounds(104, 253, 102, 22);
		contentPane.add(lblCompanyId);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(293, 452, 180, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(293, 485, 180, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setForeground(new Color(95, 158, 160));
		lblPassword_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword_1.setBounds(104, 208, 102, 22);
		contentPane.add(lblPassword_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(230, 205, 107, 20);
		contentPane.add(passwordField_2);
		
		JLabel lbl_error4 = new JLabel("");
		lbl_error4.setBounds(293, 373, 180, 14);
		contentPane.add(lbl_error4);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 32, 580, 547);
		contentPane.add(label);
		label.setIcon(new ImageIcon(UpdateProfile.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
