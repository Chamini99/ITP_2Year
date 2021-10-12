package IT20198886;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollBar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class StaffRegister extends JFrame {

	protected static final InputEvent e = null;
	private static final String NIC = null;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t6;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffRegister frame = new StaffRegister();
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
	public StaffRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 552, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				
				
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblX.setBounds(528, 11, 24, 14);
		panel.add(lblX);
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel.setBounds(511, 11, 17, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(95, 158, 160));
		lblNewLabel_2.setBounds(244, 42, 126, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Full Name");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setBounds(119, 113, 85, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NIC");
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_4.setBounds(119, 148, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_5.setBounds(119, 181, 72, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Age");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_7.setForeground(new Color(95, 158, 160));
		lblNewLabel_7.setBounds(119, 226, 46, 19);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_8.setForeground(new Color(95, 158, 160));
		lblNewLabel_8.setBounds(119, 271, 72, 19);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Password");
		lblNewLabel_9.setForeground(new Color(95, 158, 160));
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_9.setBounds(119, 321, 98, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel finalResult = new JLabel("");
		finalResult.setForeground(Color.RED);
		finalResult.setBounds(325, 290, 133, 14);
		contentPane.add(finalResult);
		
		t1 = new JTextField();
		t1.setBounds(244, 113, 214, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField(10);
		t2.setBounds(244, 148, 214, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(244, 181, 214, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		 
		t4 = new JTextField();
		
		t4.setBounds(244, 228, 214, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		t4.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = t4.getText();
	            int l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	
	            } else {
	            JOptionPane.showMessageDialog(null, "Enter Numaric value only");
	            }
	         }
	      });
		
		t6 = new JTextField();
		t6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				boolean check = EmailValidation.isValid(t6.getText());  
			    if (check) {  
			      //finalResult.setText("Email is Valid");  
			    	finalResult.setVisible(false);
			    }  
			    else {  
			    	finalResult.setVisible(true);

			      finalResult.setText("Email is not Valid");  
			    }  
				
			}
		});
		t6.setBounds(244, 270, 214, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				
		       String Full_name=t1.getText();
			   String NIC=t2.getText();
			   String Gender=t3.getText();
				 String Age=t4.getText();
			    String Email=t6.getText();
				String Password=passwordField_1.getText();
				
				int AgeInt = Integer.parseInt(Age);
				// creating one object 
			//	my_update obj=new my_update();
			//	obj.my_db_update(Full_name,NIC,Gender,Age,Email,Password );
				
				try{  
					 
					Statement st=MyConnection.getConnection().createStatement();  
					//int mark = Integer.parseInt(str3); // Mark is an integer
					// Adding record 
					String query1="INSERT INTO tbl_staffmember (Full_name,NIC,Gender,Age,Email,Password)"
							+ "VALUES('" +Full_name+"','"+NIC+"','"+Gender+"','"+AgeInt+"','"+Email+"','"+Password+"')";
					st.executeUpdate(query1); // record added. 
					
					JOptionPane.showMessageDialog(null, "Staff Member added successfully");
					dispose();
					StaffHome home = new StaffHome();
					home.setVisible(true);
					//con.close();  
					
				}catch(SQLException sqlException){
					JOptionPane.showMessageDialog(null," Something Went Wrong");
					sqlException.printStackTrace();} 
					//////////////////////////////
				
				
			

			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login login=new Login();
				login.setVisible(true);
			}
		});
		
		
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(216, 421, 116, 23);
		contentPane.add(btnNewButton);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(244, 315, 214, 20);
		contentPane.add(passwordField_1);
		
		passwordField_1.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	        	 String text = passwordField_1.getText();
	             int length = text.length();

	             if (length ==5) {
	            	 
	             } else if (length <=5) {
	            	
	            } else {
	             JOptionPane.showMessageDialog(null, "limit exceed");
	            }
	         }
	      });

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_1.setBounds(0, 29, 552, 653);
		contentPane.add(lblNewLabel_1);
		setUndecorated(true);
		
		lblNewLabel_1.setIcon(new ImageIcon(profile.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_1);
		 
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
}
