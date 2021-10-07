package IT20119744;

import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.sql.Connection;

import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class adminLogin {

	JFrame frame;
	private JTextField txtusername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminLogin window = new adminLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		JLabel lblLogin = new JLabel("Admin Login");
		lblLogin.setForeground(new Color(95, 158, 160));
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(0, 72, 580, 33);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(110, 125, 102, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(110, 170, 86, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		txtusername.setForeground(new Color(95, 158, 160));
		txtusername.setBounds(250, 118, 250, 34);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
					Statement stmt=conn.createStatement();
					String sql= "select * from tbl_admin where BINARY admin_email='"+txtusername.getText()+"' and BINARY admin_password='"+txtpassword.getText()+"'";
					ResultSet rs= stmt.executeQuery(sql);
					
					if(rs.next()) {
						if(txtusername.getText().equals("thamoda@gmail.com") &&  txtpassword.getText().equals("Thamoda#123")){
							frame.dispose();
							profile P= new profile();
							P.setVisible(true);
						}else {
							frame.dispose();
							AdminHome CAH= new AdminHome();
							CAH.setVisible(true);
						}
					}else {
						JOptionPane.showMessageDialog(null,"Invalid Username or Password","ERROR",JOptionPane.ERROR_MESSAGE);
						txtusername.setText(null);
						txtpassword.setText(null);
						txtusername.requestFocusInWindow();
						
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}

		});
		btnLogin.setBackground(new Color(95, 158, 160));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		/*btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				profile h= new profile();
				h.setVisible(true);
				frame.setVisible(false);
			}
		});*/
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		txtpassword.setEchoChar((char)0);
		txtpassword.setForeground(new Color(95, 158, 160));
		txtpassword.setBounds(250, 172, 250, 34);
		frame.getContentPane().add(txtpassword);
		btnLogin.setBounds(228, 231, 134, 33);
		frame.getContentPane().add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setForeground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 585, 33);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//frame.setVisible(false);
				if(JOptionPane.showConfirmDialog(null,"Do you want to Exit?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					frame.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setForeground(Color.WHITE);
			}
		});
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_3.setBounds(540, 2, 42, 33);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(frame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.WHITE);
			}
		});
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(495, 2, 30, 20);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 40));
		
		JLabel lblSuwasethaMedicalCenter = new JLabel("Suwasetha Medical Center");
		lblSuwasethaMedicalCenter.setForeground(new Color(95, 158, 160));
		lblSuwasethaMedicalCenter.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblSuwasethaMedicalCenter.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuwasethaMedicalCenter.setBounds(0, 39, 580, 34);
		frame.getContentPane().add(lblSuwasethaMedicalCenter);
		
		/*JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				createAccount cA = new createAccount();
				cA.setVisible(true);
				frame.setVisible(false);
			}
		});
		lblCreateAccount.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setForeground(new Color(95, 158, 160));
		lblCreateAccount.setBounds(0, 280, 580, 19);
		frame.getContentPane().add(lblCreateAccount);*/
		
		JLabel lblNewLabel_7 =new JLabel("");
		lblNewLabel_7.setBounds(0, 0, 580, 335);
		lblNewLabel_7.setIcon(new ImageIcon(createAccount.class.getResource("/IT20119744/assets/login.jpeg")));
		frame.getContentPane().add(lblNewLabel_7);
	}

}
