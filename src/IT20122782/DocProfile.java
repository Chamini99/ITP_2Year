package IT20122782;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DocProfile extends JFrame {

	
	private JPanel contentPane;
	private JTextField txt_NIC;
	private JTextField txt_email;
	private JTextField txt_qualification;
	private JTextField txt_contact;
	private JTextField txt_username;
	private JTextField txt_password;
	private JTextField txt_name;
	private JTable table;
	private JTextField txt_id;

	
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
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);  
		
		JLabel lblNewLabel = new JLabel("My Profile");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(337, 46, 102, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lbname = new JLabel("Name");
		lbname.setForeground(new Color(0, 51, 204));
		lbname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbname.setBounds(126, 118, 56, 16);
		contentPane.add(lbname);
		
		
		JLabel lbnic = new JLabel("NIC");
		lbnic.setForeground(new Color(0, 51, 204));
		lbnic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbnic.setBounds(126, 160, 56, 16);
		contentPane.add(lbnic);
		
		
	
		txt_NIC = new JTextField();
		txt_NIC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_NIC.setBounds(301, 157, 256, 22);
		contentPane.add(txt_NIC);
		txt_NIC.setColumns(10);
		
		JLabel lbemail = new JLabel("Email");
		lbemail.setForeground(new Color(0, 51, 204));
		lbemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbemail.setBounds(126, 193, 56, 16);
		contentPane.add(lbemail);
		
		JLabel lbuemail = new JLabel("");
		lbuemail.setForeground(Color.RED);
		lbuemail.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lbuemail.setBounds(593, 194, 158, 16);
		contentPane.add(lbuemail);
		
		txt_email = new JTextField();
		txt_email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z0-9]{0,30}[@][a-zA-Z]{0,20}[.][a-zA-Z]{0,5}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txt_email.getText());
				if(!match.matches()) {
					lbuemail.setText("Invalid Update Email!");
				}else {
					lbuemail.setText(null);
				}
			}
		});
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_email.setBounds(301, 192, 256, 22);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lbqualification = new JLabel("Qualification");
		lbqualification.setForeground(new Color(0, 51, 204));
		lbqualification.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbqualification.setBounds(126, 232, 88, 16);
		contentPane.add(lbqualification);
		
		txt_qualification = new JTextField();
		txt_qualification.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_qualification.setBounds(301, 235, 256, 22);
		contentPane.add(txt_qualification);
		txt_qualification.setColumns(10);
		
		JLabel lbcontact = new JLabel("Contact number");
		lbcontact.setForeground(new Color(0, 51, 204));
		lbcontact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbcontact.setBounds(126, 267, 132, 16);
		contentPane.add(lbcontact);
		
		JLabel lbucontact = new JLabel("");
		lbucontact.setForeground(Color.RED);
		lbucontact.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lbucontact.setBounds(581, 274, 158, 16);
		contentPane.add(lbucontact);
		
		
		txt_contact = new JTextField();
		txt_contact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[0-9]{10}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txt_contact.getText());
				if(!match.matches()) {
					lbucontact.setText("Invalid Update Contact Number!");
				}else {
					lbucontact.setText(null);
				}
			}
				
			
		});
		txt_contact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_contact.setBounds(301, 270, 256, 22);
		contentPane.add(txt_contact);
		txt_contact.setColumns(10);
		
		JLabel lbusername = new JLabel("Username");
		lbusername.setForeground(new Color(0, 51, 204));
		lbusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbusername.setBounds(126, 306, 102, 16);
		contentPane.add(lbusername);
		
		JLabel lbuusername = new JLabel("");
		lbuusername.setForeground(Color.RED);
		lbuusername.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lbuusername.setBounds(581, 313, 158, 16);
		contentPane.add(lbuusername);
		
		txt_username = new JTextField();
		txt_username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-z0-9]{0,30}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txt_username.getText());
				if(!match.matches()) {
					lbuusername.setText("Invalid Update Username!");
				}else {
					lbuusername.setText(null);
				}
			}
		});
		txt_username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_username.setBounds(301, 309, 256, 22);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lbpassword = new JLabel("Password");
		lbpassword.setForeground(new Color(0, 51, 204));
		lbpassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbpassword.setBounds(126, 341, 102, 16);
		contentPane.add(lbpassword);
		
		JLabel lbupassword = new JLabel("");
		lbupassword.setForeground(Color.RED);
		lbupassword.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lbupassword.setBounds(581, 348, 158, 16);
		contentPane.add(lbupassword);
		
		txt_password = new JTextField();
		txt_password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z0-9]{0,12}[@#*/=][a-zA-Z0-9]{0,10}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txt_password.getText());
				if(!match.matches()) {
					lbupassword.setText("Invalid Update Password!");
				}else {
					lbupassword.setText(null);
				}
			}
		});
		txt_password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_password.setBounds(301, 344, 256, 22);
		contentPane.add(txt_password);
		txt_password.setColumns(10);
		
		
	   
		
		JButton btnNewButton = new JButton("UPDATE");
		/*btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocUpdate m = new DocUpdate();
				m.setVisible(true);
				setVisible(false);
			}
		});*/
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() >= 0) {
					Update(txt_id.getText());
				}
			}
		});
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(619, 403, 132, 41);
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
		panel.setBounds(0, 0, 800, 33);
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
		lblNewLabel_10.setBounds(756, 13, 32, 16);
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
		lblNewLabel_10_1.setBounds(735, 13, 22, 16);
		panel.add(lblNewLabel_10_1);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_name.setColumns(10);
		txt_name.setBounds(301, 115, 256, 22);
		contentPane.add(txt_name);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 488, 720, 286);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = table.getValueAt(table.getSelectedRow(), 0).toString();
				SetTextField(name);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lbid = new JLabel("ID");
		lbid.setForeground(new Color(0, 51, 204));
		lbid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbid.setBounds(126, 81, 56, 16);
		contentPane.add(lbid);
		
		txt_id = new JTextField();
		txt_id.setBounds(301, 84, 256, 22);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(DocLogin.class.getResource("/IT20122782/Image/login.jpeg")));
		lblNewLabel_9.setBounds(0, 32, 800, 755);
		contentPane.add(lblNewLabel_9);
		
		ShowData();
		
	}
	
	static Connection con () {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost/db_doctor";
			Class.forName(driver);
			return DriverManager.getConnection(url,"root","");
		}catch(Exception e){
			System.out.println("Connection Failed!" +e);
		}
		return null;
	}
		
		private void ShowData() {
    	 Connection con = con ();
    	 DefaultTableModel model = new DefaultTableModel();
    	 model.addColumn("ID");
    	 model.addColumn("Name");
    	 model.addColumn("NIC");
    	 model.addColumn("Email");
    	 model.addColumn("Qualification");
    	 model.addColumn("Contact No");
    	 model.addColumn("Username");
    	 model.addColumn("Password");
    	 try {
    		 String query = "select * from tb_doctorinfo";
    		 Statement st = con.createStatement();
    		 ResultSet rs = st.executeQuery(query);
    		 while(rs.next()) {
    			 model.addRow(new Object[] {
    				 rs.getString("id"),	 
    				 rs.getString("name"),
    				 rs.getString("nic"),
    				 rs.getString("email"),
    				 rs.getString("qualification"),
    				 rs.getString("phone_no"),
    				 rs.getString("username"),
    				 rs.getString("password"),
    				 
    				 
    				 
    			 }
    					 );
    		 }
    		 rs.close();
    		 st.close();
    		 con.close();
    		 
    		 table.setModel(model);
    		 table.setAutoResizeMode(0);
    		 table.getColumnModel().getColumn(0).setPreferredWidth(40);
    		 table.getColumnModel().getColumn(1).setPreferredWidth(100);
    		 table.getColumnModel().getColumn(2).setPreferredWidth(100);
    		 table.getColumnModel().getColumn(3).setPreferredWidth(200);
    		 table.getColumnModel().getColumn(4).setPreferredWidth(100);
    		 table.getColumnModel().getColumn(5).setPreferredWidth(100);
    		 table.getColumnModel().getColumn(6).setPreferredWidth(100);
    		 table.getColumnModel().getColumn(7).setPreferredWidth(100);
    		 
    		 
    	 }catch(Exception e){
    		 System.out.println("Error" +e);
    	 }
		}
    	 private void SetTextField(String id) {
    		 Connection con = con();
    		 try {
    			 String Query = "select * from tb_doctorinfo where id = ?";
    			 PreparedStatement ps = con.prepareStatement(Query);
    			 ps.setString(1, id);
    			 ResultSet rs = ps.executeQuery();
    			 while (rs.next()) {
    				 txt_id.setText(rs.getString("id"));
    				 txt_name.setText(rs.getString("name"));
    				 txt_NIC.setText(rs.getString("nic"));
    				 txt_email.setText(rs.getString("email"));
    				 txt_qualification.setText(rs.getString("qualification"));
    				 txt_contact.setText(rs.getString("phone_no"));
    				 txt_username.setText(rs.getString("username"));
    				 txt_password.setText(rs.getString("password"));
    			 }
    			 rs.close();
    			 ps.close();
    			 con.close();
    			 
    		 }catch(Exception e){
    			 System.out.println("Error" +e);
    		 }
    	 }
    	 
    	 private void Update(String id) {
    		 Connection con = con();
    		 try {
    			 String query = "update tb_doctorinfo set name = ?, nic = ?, email = ?, qualification = ?, phone_no = ?, username = ?, password = ? where id = ?";
    			 PreparedStatement ps = con.prepareStatement(query);
    			 ps.setString(1,txt_name.getText());
    			 ps.setString(2,txt_NIC.getText());
    			 ps.setString(3, txt_email.getText());
    			 ps.setString(4, txt_qualification.getText());
    			 ps.setString(5, txt_contact.getText());
    			 ps.setString(6, txt_username.getText());
    			 ps.setString(7, txt_password.getText());
    			 ps.setString(8, id);
    			 ps.execute();
    			 ps.close();
    			 con.close();
    			 
    			 JOptionPane.showMessageDialog(null, "Update successful");
    			 ShowData();
    		 }catch(Exception e){
    			 System.out.println("Error" +e);
    		 }
    	 }
}
