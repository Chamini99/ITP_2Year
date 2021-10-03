package IT20119744;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class addAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtemail;
	private JTextField txtphone;
	private JTextField txtpassword;
	private JTextField txtrecoveryemail;
	private JTextField txtconfirmpassword;
	
	Connection con = null;
	PreparedStatement prestmt =  null;
	ResultSet rs = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addAdmin frame = new addAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void validatePassword() {
		String password1= txtpassword.getText();
		String password2= txtconfirmpassword.getText();
		
		if(!password1.equals(password2)) {
			JOptionPane.showMessageDialog(this, "Password does not match, Check again");
		}
	}
	
	
	/*public void validatePhone(JTextField field, JLabel label, String name) {
		if(field.getText().length()>10 || field.getText().length()<10){
			label.setText("Invalid Phone Number"+name);
		}
		else {
			label.setVisible(false);
		}
	}*/

	/**
	 * Create the frame.
	 */
	public addAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setForeground(Color.WHITE);
			}
		});
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Segoe UI", Font.BOLD, 40));
		label.setBounds(495, 2, 30, 20);
		panel.add(label);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//setVisible(false);
				if(JOptionPane.showConfirmDialog(null,"Do you want to Exit?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					addAdmin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblX.setBounds(540, 2, 42, 33);
		panel.add(lblX);
		
		JLabel label_1 = new JLabel("<<");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageAdmin mA= new manageAdmin ();
				mA.setVisible(true);				
				setVisible(false);
			}
		});
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		label_1.setBounds(23, 0, 40, 33);
		panel.add(label_1);
		
		JLabel lblAdd = new JLabel("Add");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setForeground(new Color(95, 158, 160));
		lblAdd.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAdd.setBounds(0, 49, 580, 27);
		contentPane.add(lblAdd);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(77, 100, 200, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setBounds(77, 170, 200, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setForeground(new Color(95, 158, 160));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setBounds(77, 240, 200, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_3.setBounds(77, 310, 200, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Confirm Password");
		lblNewLabel_3_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_3_1.setBounds(77, 380, 200, 33);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Recovery Email");
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_4.setBounds(77, 450, 200, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel name_validation = new JLabel("");
		name_validation.setHorizontalAlignment(SwingConstants.CENTER);
		name_validation.setForeground(Color.RED);
		name_validation.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		name_validation.setBounds(283, 140, 232, 20);
		contentPane.add(name_validation);
		
		JLabel email_validation = new JLabel("");
		email_validation.setHorizontalAlignment(SwingConstants.CENTER);
		email_validation.setForeground(Color.RED);
		email_validation.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		email_validation.setBounds(283, 210, 232, 20);
		contentPane.add(email_validation);
		
		JLabel phone_validation = new JLabel("");
		phone_validation.setHorizontalAlignment(SwingConstants.CENTER);
		phone_validation.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		phone_validation.setForeground(new Color(255, 0, 0));
		phone_validation.setBounds(283, 280, 232, 20);
		contentPane.add(phone_validation);
		
		txtname = new JTextField();
		txtname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String PATTERN ="^[a-zA-Z]{0,50}$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(txtname.getText());
				if(!match.matches()) {
					name_validation.setText("Invalid Name!");
				}else {
					name_validation.setText(null);
				}
				/*if(txtname.getText().isEmpty()) {
					name_validation.setText("Name can't be Empty");
				}*/
			}
		});
		txtname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtname.setForeground(new Color(95, 158, 160));
		txtname.setBounds(283, 100, 232, 33);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel password_validation = new JLabel("");
		password_validation.setHorizontalAlignment(SwingConstants.CENTER);
		password_validation.setForeground(Color.RED);
		password_validation.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		password_validation.setBounds(283, 350, 232, 20);
		contentPane.add(password_validation);
		
		JLabel confpass_validation = new JLabel("");
		confpass_validation.setHorizontalAlignment(SwingConstants.CENTER);
		confpass_validation.setForeground(Color.RED);
		confpass_validation.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		confpass_validation.setBounds(283, 420, 232, 20);
		contentPane.add(confpass_validation);
		
		JLabel remail_validation = new JLabel("");
		remail_validation.setHorizontalAlignment(SwingConstants.CENTER);
		remail_validation.setForeground(Color.RED);
		remail_validation.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		remail_validation.setBounds(283, 490, 232, 20);
		contentPane.add(remail_validation);
		
		
		txtemail = new JTextField();
		txtemail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//String PATTERN ="^[a-zA-Z0-9]{0,255}@[a-zA-Z]{0,10}.[a-zA-Z]{0,5}$";
				String PATTERN ="^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(txtemail.getText());
				if(!match.matches()) {
					email_validation.setText("Invalid Email!");
				}else {
					email_validation.setText(null);
				}
			}
		});
		txtemail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtemail.setForeground(new Color(95, 158, 160));
		txtemail.setBounds(283, 170, 232, 33);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[0-9]{10}$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(txtphone.getText());
				if(!match.matches()) {
					phone_validation.setText("Invalid Phone!");
				}else {
					phone_validation.setText(null);
				}
			}
		});
		txtphone.addFocusListener(new FocusAdapter() {
			/*@Override
			public void focusLost(FocusEvent e) {
				validatePhone(txtphone, phone_validation, "Phone");
			}*/
		});
		txtphone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtphone.setForeground(new Color(95, 158, 160));
		txtphone.setBounds(283, 240, 232, 33);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&])(?=\\S+$).{8,20}$";
				//(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8, 20}
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(txtpassword.getText());
				if(!match.matches()) {
					password_validation.setText("Invalid Password!");
				}else {
					password_validation.setText(null);
				}
			}
		});
		txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtpassword.setForeground(new Color(95, 158, 160));
		txtpassword.setBounds(283, 310, 232, 33);
		contentPane.add(txtpassword);
		txtpassword.setColumns(10);
		
		txtrecoveryemail = new JTextField();
		txtrecoveryemail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(txtrecoveryemail.getText());
				if(!match.matches()) {
					remail_validation.setText("Invalid Email!");
				}else {
					remail_validation.setText(null);
				}
			}
		});
		txtrecoveryemail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtrecoveryemail.setForeground(new Color(95, 158, 160));
		txtrecoveryemail.setBounds(283, 450, 232, 33);
		contentPane.add(txtrecoveryemail);
		txtrecoveryemail.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String admin_name = txtname.getText();
				String admin_email	= txtemail.getText();
				String admin_phone = txtphone.getText();
				String admin_password = txtpassword.getText();
				String admin_confirm_password =txtconfirmpassword.getText(); 			
				String admin_recovery_email=txtrecoveryemail.getText();
				
				
				String name = ""+admin_name;
				name+=" \n";
				if(txtname.getText().isEmpty() || txtemail.getText().isEmpty() || txtphone.getText().isEmpty() || txtpassword.getText().isEmpty() || txtconfirmpassword.getText().isEmpty() || txtrecoveryemail.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(btnAdd, "Can't be Empty!");
				}else {

					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
						
						String query= "INSERT INTO tbl_admin values(0,'"+admin_name+"','"+admin_email+"','"+admin_phone+"','"+admin_password+"','"+admin_confirm_password+"','"+admin_recovery_email+"')";
						
						Statement stmtadd=conn.createStatement();
						int rsadd =stmtadd.executeUpdate(query);
						if(rsadd==0) {
							JOptionPane.showMessageDialog(btnAdd,"Already Exist");
						}else {
							JOptionPane.showMessageDialog(btnAdd,"Hello,"+name+"Your account is created Successfully!");
							txtname.setText(null);
							txtemail.setText(null);
							txtphone.setText(null);
							txtpassword.setText(null);
							txtconfirmpassword.setText(null);
							txtrecoveryemail.setText(null);
							txtname.requestFocusInWindow();
						}
						conn.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				/*if(txtname.getText().isEmpty() || txtemail.getText().isEmpty() || txtphone.getText().isEmpty() || txtpassword.getText().isEmpty() || txtconfirmpassword.getText().isEmpty() || txtrecoveryemail.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(btnAdd, "Can't be Empty!");
				}else {
					try {
						String sql= "INSERT INTO tbl_admin(admin_name, admin_email, admin_phone, admin_password, admin_confirm_password, admin_recovery_email) VALUES (?,?,?,?,?,?)";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
						prestmt = con.prepareStatement(sql);
						prestmt.setString(1, txtname.getText());
						prestmt.setString(2, txtemail.getText());
						prestmt.setString(3, txtphone.getText());
						prestmt.setString(4, txtpassword.getText());
						prestmt.setString(5, txtconfirmpassword.getText());
						prestmt.setString(6, txtrecoveryemail.getText());
						
						prestmt.executeUpdate();
						JOptionPane.showMessageDialog(btnAdd, "Your account is created Successfully!");
						txtname.getText();
						txtemail.getText();
						txtphone.getText();
						txtpassword.getText();
						txtconfirmpassword.getText();
						txtrecoveryemail.getText();
					
						con.close();
					}catch(SQLException | HeadlessException ex){
						JOptionPane.showMessageDialog(null, ex);
					}
				}*/	
			}	
		});
		
		txtconfirmpassword = new JTextField();
		txtconfirmpassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				validatePassword();
			}
		});
		txtconfirmpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&])(?=\\S+$).{8,20}$";
				//(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8, 20}
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(txtconfirmpassword.getText());
				if(!match.matches()) {
					confpass_validation.setText("Invalid Password!");
				}else{
					confpass_validation.setText(null);
				}

			}
		});
		txtconfirmpassword.setForeground(new Color(95, 158, 160));
		txtconfirmpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtconfirmpassword.setColumns(10);
		txtconfirmpassword.setBounds(283, 380, 232, 33);
		contentPane.add(txtconfirmpassword);
		btnAdd.setBackground(new Color(95, 158, 160));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnAdd.setBounds(250, 520, 97, 40);
		contentPane.add(btnAdd);
		
		
		
		setUndecorated(true);
		
		JLabel backgroundimg =new JLabel("");
		backgroundimg.setBounds(0, 0, 580, 580);
		backgroundimg.setIcon(new ImageIcon(createAccount.class.getResource("/IT20119744/assets/login.jpeg")));
		contentPane.add(backgroundimg);

		
		
	}
}
