package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.ConnectionImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField companyName;
	private JTextField companyAddress;
	private JTextField mob;
	private JTextField email;
	private JTextField user;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lbl_error1;
	private JLabel lbl_error2;
	private JLabel lbl_error3;
	private JLabel lbl_error4;
	
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
		setBounds(100, 100, 580, 583);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
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
		label.setBounds(214, 78, 143, 74);
		label.setBackground(new Color(95, 158, 160));
		contentPane.add(label);
		label.setIcon(new ImageIcon(CreateAccount.class.getResource("/IT20123840/Assets/user.jpg")));
		
		JLabel lbl_CompanyName = new JLabel("Company Name");
		lbl_CompanyName.setBounds(136, 177, 108, 23);
		lbl_CompanyName.setForeground(new Color(95, 158, 160));
		lbl_CompanyName.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_CompanyName);
		
		JLabel lbl_Address = new JLabel("Address");
		lbl_Address.setBounds(136, 229, 66, 23);
		lbl_Address.setForeground(new Color(95, 158, 160));
		lbl_Address.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_Address);
		
		JLabel lbl_ContactNo = new JLabel("Contact No");
		lbl_ContactNo.setBounds(136, 279, 78, 23);
		lbl_ContactNo.setForeground(new Color(95, 158, 160));
		lbl_ContactNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_ContactNo);
		
		JLabel lbl_Email = new JLabel("Email");
		lbl_Email.setBounds(136, 332, 46, 23);
		lbl_Email.setForeground(new Color(95, 158, 160));
		lbl_Email.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_Email);
		
		JLabel lbl_UserName = new JLabel("User Name");
		lbl_UserName.setBounds(136, 383, 78, 23);
		lbl_UserName.setForeground(new Color(95, 158, 160));
		lbl_UserName.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_UserName);
		
		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setBounds(136, 431, 78, 23);
		lbl_Password.setForeground(new Color(95, 158, 160));
		lbl_Password.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_Password);
		
		JLabel lbl_ConfirmPassword = new JLabel("Confirm Password");
		lbl_ConfirmPassword.setBounds(136, 478, 126, 23);
		lbl_ConfirmPassword.setForeground(new Color(95, 158, 160));
		lbl_ConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_ConfirmPassword);
		
		companyName = new JTextField();
		companyName.setBounds(296, 178, 143, 20);
		contentPane.add(companyName);
		companyName.setColumns(10);
		
		companyAddress = new JTextField();
		companyAddress.setBounds(296, 230, 143, 20);
		contentPane.add(companyAddress);
		companyAddress.setColumns(10);
		
		mob = new JTextField();
		mob.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					int i = Integer.parseInt(mob.getText());
					if (mob.getText().length()==10) {
						lbl_error1.setText("");
					}
					else {
						lbl_error1.setText("Invalid mobile number");
					}
				}
				catch (NumberFormatException e1) {
					lbl_error1.setText("Invalid contact number");
				}
				
			}
		});
		mob.setBounds(296, 280, 143, 20);
		contentPane.add(mob);
		mob.setColumns(10);
		
		String EMAIL_PATTERN = 
			    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		email = new JTextField();
		email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!email.getText().matches(EMAIL_PATTERN)) {
					lbl_error2.setText("Invalid email address");		
				}
				else {
					lbl_error2.setText(" ");
				}
			}
		});
		email.setBounds(296, 333, 143, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		user = new JTextField();
		user.setBounds(296, 384, 143, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		String PASSWORD_PATTERN = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!passwordField.getText().matches(PASSWORD_PATTERN)) {
					lbl_error3.setText("Should contain at least 8 characters,digit,lower character,"
							+ "upper character,special character");
				}
				else {
					lbl_error3.setText(" ");
				}
			}
		});
		passwordField.setBounds(296, 432, 143, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!(new String(passwordField.getText()).equals(new String(passwordField_1.getText())))) {
					lbl_error4.setText("Invalid password confirmation");
				}
				else {
					lbl_error4.setText(" ");
				}
			}
		});
		passwordField_1.setBounds(296, 479, 143, 20);
		contentPane.add(passwordField_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String company_name = companyName.getText();
				String company_address = companyAddress.getText();
				String contact_no = mob.getText();
				String company_email = email.getText();
				String username = user.getText();
				String password = passwordField.getText();
				String confirmPassword = passwordField_1.getText();
				
				// Registration form validation
				
				//Validation of filling all the fields
				String msg = "" + companyName;
				msg += "\n";
				if (companyName.getText().isEmpty() || companyAddress.getText().isEmpty() ||email.getText().isEmpty() || user.getText().isEmpty() || passwordField.getText().isEmpty() || passwordField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnSubmit, "Please fill all fields");
				}
				
				else {
				//Execute sql query to insert data to the table
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
					
					String query1 = "select * from tbl_supplycompany where company_name = '"+company_name+"' ";
					Statement stmt1 = connection.createStatement();
					ResultSet rs = stmt1.executeQuery(query1);
					
					if (rs.next()) {
						JOptionPane.showConfirmDialog(btnSubmit, "This is already exist");
						}
					
					else {
						String query = "insert into tbl_supplycompany (company_name, company_address, contact_no, company_email, username, password, confirmPassword) values ('"+company_name+"', '"+company_address+"', '"+contact_no+"', '"+company_email+"', '"+username+"', '"+password+"', '"+confirmPassword+"')";
					
						Statement stmt = connection.createStatement();
						int x = stmt.executeUpdate(query);
					
						JOptionPane.showConfirmDialog(btnSubmit, "Your account has been created successfully!!!");
						SupplierLogin sl = new SupplierLogin();
						sl.setVisible(true);
						setVisible(false);
						
					}
					
					connection.close();
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			}
		});
		
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(95, 158, 160));
		btnSubmit.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSubmit.setBounds(139, 538, 108, 34);
		contentPane.add(btnSubmit);
		
		//Reset the fields of the form
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				companyName.setText(" ");
				companyAddress.setText(" ");
				mob.setText(" ");
				email.setText(" ");
				user.setText(" ");
				passwordField.setText(" ");
				passwordField_1.setText(" ");
			}
		});
		btnReset.setBackground(new Color(95, 158, 160));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnReset.setBounds(333, 538, 106, 34);
		contentPane.add(btnReset);
		
		lbl_error1 = new JLabel("");
		lbl_error1.setBounds(296, 307, 143, 14);
		contentPane.add(lbl_error1);
		
		lbl_error2 = new JLabel("");
		lbl_error2.setBounds(296, 358, 143, 14);
		contentPane.add(lbl_error2);
		
		lbl_error3 = new JLabel("");
		lbl_error3.setBounds(30, 453, 526, 14);
		contentPane.add(lbl_error3);
		
		lbl_error4 = new JLabel("");
		lbl_error4.setBounds(296, 500, 143, 14);
		contentPane.add(lbl_error4);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 33, 580, 550);
		contentPane.add(label_1);
		label_1.setIcon(new ImageIcon(CreateAccount.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
