package IT20122782;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DocLogin {

	private JFrame frame;
	private JTextField txt_username;
	private JTextField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocLogin window = new DocLogin();
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
	public DocLogin() {
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
		
		
		JLabel lblLogin = new JLabel("Login to Doctor");
		lblLogin.setForeground(new Color(95, 158, 160));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(205, 60, 171, 28);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setForeground(new Color(95, 158, 160));
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserName.setBounds(78, 108, 171, 28);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(95, 158, 160));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(78, 149, 171, 28);
		frame.getContentPane().add(lblPassword);
		
		txt_username = new JTextField();
		txt_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_username.setBounds(218, 114, 249, 22);
		frame.getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_password.setColumns(10);
		txt_password.setBounds(218, 155, 249, 22);
		frame.getContentPane().add(txt_password);
		
		JButton btn_login = new JButton("Login");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_doctor","root","");
					java.sql.Statement stmt=conn.createStatement();
					String sql= "select  * from tb_doctorinfo where username='"+txt_username.getText()+"'and password='"+txt_password.getText()+"'";
					ResultSet rs= stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Login Sucessfully");
						frame.dispose();
						DocHome P= new DocHome();
						P.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"Invalid Username or Password","ERROR",JOptionPane.ERROR_MESSAGE);
						txt_username.setText(null);
						txt_password.setText(null);
						txt_username.requestFocusInWindow();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		/*btn_login.setBackground(new Color(95, 158, 160));
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocProfile m = new DocProfile();
				m.setVisible(true);
				frame.setVisible(false);
			}
		});*/
		btn_login.setForeground(Color.WHITE);
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_login.setBounds(249, 234, 127, 25);
		frame.getContentPane().add(btn_login);
		
		JLabel lblCreateAnAccount = new JLabel("Create an account");
		lblCreateAnAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocRegistration m = new DocRegistration();
				m.setVisible(true);
				frame.setVisible(false);
			}
		});
		lblCreateAnAccount.setForeground(new Color(95, 158, 160));
		lblCreateAnAccount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreateAnAccount.setBounds(249, 294, 171, 28);
		frame.getContentPane().add(lblCreateAnAccount);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account?");
		lblDontHaveAn.setForeground(Color.BLACK);
		lblDontHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDontHaveAn.setBounds(78, 294, 222, 28);
		frame.getContentPane().add(lblDontHaveAn);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frame.setVisible(false);
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblX.setBounds(549, 13, 31, 16);
		panel.add(lblX);
		
		JLabel lblX_1 = new JLabel("-");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.setState(frame.ICONIFIED);
			}
		});
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblX_1.setBounds(525, 13, 22, 16);
		panel.add(lblX_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DocLogin.class.getResource("/IT20122782/Image/login.jpeg")));
		lblNewLabel.setBounds(0, 31, 580, 304);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}

	

	}

