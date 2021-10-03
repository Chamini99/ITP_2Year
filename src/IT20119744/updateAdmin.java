package IT20119744;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.lang.model.element.Name;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class updateAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField updateid;
	private JTextField updateemail;
	private JTextField updatephone;
	private JTextField updatepassword;
	private JTextField updateremail;
	private JTable table;
	private JTextField updatename;
	private JTextField searchadmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateAdmin frame = new updateAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void displayadmindata() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Email");
		model.addColumn("Phone");
		model.addColumn("Password");
		model.addColumn("Recovery Email");
		
		
		//model.setColumnIdentifiers();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			Statement stmt=conn.createStatement();
			String query= "select admin_id,admin_name, admin_email, admin_phone, admin_password, admin_recovery_email from tbl_admin";
			ResultSet rs= stmt.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("admin_id"),
						rs.getString("admin_name"),
						rs.getString("admin_email"),
						rs.getString("admin_phone"),
						rs.getString("admin_password"),
						rs.getString("admin_recovery_email")
				});
			}
			rs.close();
			stmt.close();
			conn.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setPreferredWidth(120);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(150);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	private void settextfields(String admin_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			String query= "select admin_id,admin_name, admin_email, admin_phone, admin_password, admin_recovery_email from tbl_admin where admin_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, admin_id);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				updateid.setText(rs.getString("admin_id"));
				updatename.setText(rs.getString("admin_name"));
				updateemail.setText(rs.getString("admin_email"));
				updatephone.setText(rs.getString("admin_phone"));
				updatepassword.setText(rs.getString("admin_password"));
				updateremail.setText(rs.getString("admin_recovery_email"));
				
				
			}
			rs.close();
			ps.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void updateadmin(String admin_id) {
		if(updatename.getText().isEmpty() || updateemail.getText().isEmpty() || updatephone.getText().isEmpty() || updatepassword.getText().isEmpty() || updateremail.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "Can't be Empty!");
		}else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
				String query= "update tbl_admin set admin_name = ?, admin_email = ?, admin_phone = ?, admin_password = ?, admin_recovery_email = ?  where admin_id = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, updatename.getText());
				ps.setString(2, updateemail.getText());
				ps.setString(3, updatephone.getText());
				ps.setString(4, updatepassword.getText());
				ps.setString(5, updateremail.getText());
				ps.setString(6, admin_id);
				ps.execute();
				
				ps.close();
				conn.close();
				JOptionPane.showMessageDialog(null,"Sussfully Updated");
				displayadmindata();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	private void deleteadmin(String admin_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			String query= "delete from tbl_admin where admin_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, admin_id);
			
			ps.execute();
			
			ps.close();
			conn.close();
			JOptionPane.showMessageDialog(null,"Sussfully Deleted");
			displayadmindata();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void validatePhone(JTextField field, JLabel label, String name) {
		if(field.getText().length()>10 || field.getText().length()<10){
			label.setText("Invalid Phone Number"+name);
		}
		else {
			label.setVisible(false);
		}
	
	}
	/**
	 * Create the frame.
	 */
	public updateAdmin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				displayadmindata();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 1000, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("-");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Segoe UI", Font.BOLD, 40));
		label.setBounds(77, 222, 232, 33);
		panel.add(label);
		
		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblX.setBounds(77, 222, 232, 33);
		panel.add(lblX);
		
		JLabel label_1 = new JLabel("-");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setForeground(Color.white);
			}
		});
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 40));
		label_1.setBounds(910, -2, 30, 20);
		panel.add(label_1);
		
		JLabel lblX_1 = new JLabel("X");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX_1.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX_1.setForeground(Color.white);
			}



		});
		lblX_1.setForeground(new Color(255, 255, 255));
		lblX_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblX_1.setBounds(946, 0, 42, 33);
		panel.add(lblX_1);
		
		JLabel lblUpdate = new JLabel("Admin");
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setForeground(new Color(95, 158, 160));
		lblUpdate.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblUpdate.setBounds(10, 46, 387, 36);
		contentPane.add(lblUpdate);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setBounds(20, 122, 170, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setBounds(20, 192, 175, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setForeground(new Color(95, 158, 160));
		lblNewLabel_2.setBounds(20, 262, 170, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setBounds(20, 332, 170, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setBounds(20, 402, 170, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Recovery Email");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setBounds(20, 472, 170, 33);
		contentPane.add(lblNewLabel_5);
		
		JLabel id_val = new JLabel("");
		id_val.setHorizontalAlignment(SwingConstants.CENTER);
		id_val.setForeground(Color.RED);
		id_val.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		id_val.setBounds(175, 165, 232, 20);
		contentPane.add(id_val);
		
		JLabel name_val = new JLabel("");
		name_val.setHorizontalAlignment(SwingConstants.CENTER);
		name_val.setForeground(Color.RED);
		name_val.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		name_val.setBounds(175, 235, 232, 20);
		contentPane.add(name_val);
		
		JLabel email_val = new JLabel("");
		email_val.setHorizontalAlignment(SwingConstants.CENTER);
		email_val.setForeground(Color.RED);
		email_val.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		email_val.setBounds(175, 305, 232, 20);
		contentPane.add(email_val);
		
		JLabel phone_val = new JLabel("");
		phone_val.setHorizontalAlignment(SwingConstants.CENTER);
		phone_val.setForeground(Color.RED);
		phone_val.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		phone_val.setBounds(175, 375, 232, 20);
		contentPane.add(phone_val);
		
		JLabel password_val = new JLabel("");
		password_val.setHorizontalAlignment(SwingConstants.CENTER);
		password_val.setForeground(Color.RED);
		password_val.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		password_val.setBounds(175, 445, 232, 20);
		contentPane.add(password_val);
		
		JLabel remail_val = new JLabel("");
		remail_val.setHorizontalAlignment(SwingConstants.CENTER);
		remail_val.setForeground(Color.RED);
		remail_val.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		remail_val.setBounds(175, 512, 232, 20);
		contentPane.add(remail_val);
		
		updateid = new JTextField();
		updateid.setForeground(new Color(95, 158, 160));
		updateid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updateid.setBounds(200, 122, 200, 33);
		contentPane.add(updateid);
		updateid.setColumns(10);
		
		updatename = new JTextField();
		updatename.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[a-zA-Z]{0,50}$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updatename.getText());
				if(!match.matches()) {
					name_val.setText("Invalid Name!");
				}else {
					name_val.setText(null);
				}
			}
		});
		updatename.setForeground(new Color(95, 158, 160));
		updatename.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updatename.setColumns(10);
		updatename.setBounds(200, 192, 200, 33);
		contentPane.add(updatename);
		
		updateemail = new JTextField();
		updateemail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updateemail.getText());
				if(!match.matches()) {
					email_val.setText("Invalid Email!");
				}else {
					email_val.setText(null);
				}
			}
		});
		updateemail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updateemail.setForeground(new Color(95, 158, 160));
		updateemail.setBounds(200, 262, 200, 33);
		contentPane.add(updateemail);
		updateemail.setColumns(10);
		
		updatephone = new JTextField();
		updatephone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[0-9]{10}$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updatephone.getText());
				if(!match.matches()) {
					phone_val.setText("Invalid Phone!");
				}else {
					phone_val.setText(null);
				}
			}
		});
		updatephone.setForeground(new Color(95, 158, 160));
		updatephone.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updatephone.setBounds(200, 332, 200, 33);
		contentPane.add(updatephone);
		updatephone.setColumns(10);
		
		updatepassword = new JTextField();
		updatepassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&])(?=\\S+$).{8,20}$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updatepassword.getText());
				if(!match.matches()) {
					password_val.setText("Invalid Password!");
				}else {
					password_val.setText(null);
				}
			}
		});
		updatepassword.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updatepassword.setForeground(new Color(95, 158, 160));
		updatepassword.setBounds(200, 402, 200, 33);
		contentPane.add(updatepassword);
		updatepassword.setColumns(10);
		
		updateremail = new JTextField();
		updateremail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updateremail.getText());
				if(!match.matches()) {
					remail_val.setText("Invalid Email!");
				}else {
					remail_val.setText(null);
				}
			}
		});
		updateremail.setForeground(new Color(95, 158, 160));
		updateremail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updateremail.setBounds(200, 472, 200, 33);
		contentPane.add(updateremail);
		updateremail.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()>=0);
				updateadmin(updateid.getText());
			}
		});
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSearch.setForeground(new Color(95, 158, 160));
		lblSearch.setBounds(529, 56, 100, 20);
		contentPane.add(lblSearch);
		
		searchadmin = new JTextField();
		searchadmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DefaultTableModel tableadmin =(DefaultTableModel)table.getModel();
				String search = searchadmin.getText().toLowerCase();
				
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableadmin);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		searchadmin.setBounds(646, 53, 200, 33);
		contentPane.add(searchadmin);
		searchadmin.setColumns(10);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnUpdate.setForeground(new Color(95, 158, 160));
		btnUpdate.setBounds(20, 549, 140, 36);
		contentPane.add(btnUpdate);
		setUndecorated(true);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0);
				deleteadmin(updateid.getText());
			}
		});
		btndelete.setForeground(new Color(95, 158, 160));
		btndelete.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btndelete.setBounds(223, 549, 140, 36);
		contentPane.add(btndelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(412, 122, 560, 360);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String admin_id = table.getValueAt(table.getSelectedRow(), 0).toString();
				settextfields(admin_id);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label_11 = new JLabel("<<");
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageAdmin mA= new manageAdmin ();
				mA.setVisible(true);				
				setVisible(false);
			}
		});
		label_11.setForeground(new Color(255, 255, 255));
		label_11.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		label_11.setBounds(23, 0, 40, 33);
		panel.add(label_11);
		
		JLabel lblNewLabel_6 =new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 1000, 650);
		lblNewLabel_6.setIcon(new ImageIcon(createAccount.class.getResource("/IT20119744/assets/login.jpeg")));
		contentPane.add(lblNewLabel_6);


	}
}
