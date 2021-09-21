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
		lbl_CompanyName.setBounds(139, 188, 108, 23);
		lbl_CompanyName.setForeground(new Color(95, 158, 160));
		lbl_CompanyName.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_CompanyName);
		
		JLabel lbl_Address = new JLabel("Address");
		lbl_Address.setBounds(139, 222, 66, 23);
		lbl_Address.setForeground(new Color(95, 158, 160));
		lbl_Address.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_Address);
		
		JLabel lbl_ContactNo = new JLabel("Contact No");
		lbl_ContactNo.setBounds(139, 256, 78, 23);
		lbl_ContactNo.setForeground(new Color(95, 158, 160));
		lbl_ContactNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_ContactNo);
		
		JLabel lbl_Email = new JLabel("Email");
		lbl_Email.setBounds(139, 290, 46, 23);
		lbl_Email.setForeground(new Color(95, 158, 160));
		lbl_Email.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_Email);
		
		JLabel lbl_UserName = new JLabel("User Name");
		lbl_UserName.setBounds(139, 324, 78, 23);
		lbl_UserName.setForeground(new Color(95, 158, 160));
		lbl_UserName.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_UserName);
		
		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setBounds(139, 358, 78, 23);
		lbl_Password.setForeground(new Color(95, 158, 160));
		lbl_Password.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_Password);
		
		JLabel lbl_ConfirmPassword = new JLabel("Confirm Password");
		lbl_ConfirmPassword.setBounds(139, 392, 126, 23);
		lbl_ConfirmPassword.setForeground(new Color(95, 158, 160));
		lbl_ConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lbl_ConfirmPassword);
		
		companyName = new JTextField();
		companyName.setBounds(296, 189, 143, 20);
		contentPane.add(companyName);
		companyName.setColumns(10);
		
		companyAddress = new JTextField();
		companyAddress.setBounds(296, 223, 143, 20);
		contentPane.add(companyAddress);
		companyAddress.setColumns(10);
		
		mob = new JTextField();
		mob.setBounds(296, 257, 143, 20);
		contentPane.add(mob);
		mob.setColumns(10);
		
		email = new JTextField();
		email.setBounds(296, 291, 143, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		user = new JTextField();
		user.setBounds(296, 325, 143, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(296, 359, 143, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(296, 393, 143, 20);
		contentPane.add(passwordField_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String company_name = companyName.getText();
				String company_address = companyAddress.getText();
				String contact_no = mob.getText();
				int len = contact_no.length();
				String company_email = email.getText();
				
				String username = user.getText();
				String password = passwordField.getText();
				String confirmPassword = passwordField_1.getText();
				
				// Registration form validation
				String msg = "" + companyName;
				msg += "\n";
				if (companyName.getText().isEmpty() || companyAddress.getText().isEmpty() ||email.getText().isEmpty() || user.getText().isEmpty() || passwordField.getText().isEmpty() || passwordField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnSubmit, "Please fill all fields");
				}
				
				else if (len != 10) {
					JOptionPane.showMessageDialog(btnSubmit, "Please enter a valid mobile number");
				}
				
				else if (!(new String(passwordField.getText()).equals(new String(passwordField_1.getText())))) {
					JOptionPane.showMessageDialog(btnSubmit, "Password confirmation is invalid");
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
		btnSubmit.setBounds(139, 451, 108, 34);
		contentPane.add(btnSubmit);
		
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
		btnReset.setBounds(333, 451, 106, 34);
		contentPane.add(btnReset);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 33, 580, 493);
		contentPane.add(label_1);
		label_1.setIcon(new ImageIcon(CreateAccount.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
