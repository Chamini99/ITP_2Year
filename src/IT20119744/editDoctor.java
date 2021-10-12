package IT20119744;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class editDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField searchdoctor;
	private JTextField updateid;
	private JLabel imagelbl;
	private JTextField updatename;
	private JTextField updatenic;
	private JTextField updateemail;
	private JTextField updatequalification;
	private JTextField updatephone;
	private JTable table;
	private JTextField updateusername;
	private JTextField updatepassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editDoctor frame = new editDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void displaydoctor() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("NIC");
		model.addColumn("Email");
		model.addColumn("Qulification");
		model.addColumn("Phone");
		model.addColumn("Password");
		model.addColumn("Recovery Email");
		
		
		//model.setColumnIdentifiers();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			Statement stmt=conn.createStatement();
			String query= "select id, name, nic, email, qualification, phone_no, username, password from tb_doctorinfo";
			ResultSet rs= stmt.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("nic"),
						rs.getString("email"),
						rs.getString("qualification"),
						rs.getString("phone_no"),
						rs.getString("username"),
						rs.getString("password")
				});
			}
			rs.close();
			stmt.close();
			conn.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(80);
			table.getColumnModel().getColumn(3).setPreferredWidth(200);
			table.getColumnModel().getColumn(4).setPreferredWidth(200);
			table.getColumnModel().getColumn(5).setPreferredWidth(80);
			table.getColumnModel().getColumn(6).setPreferredWidth(100);
			table.getColumnModel().getColumn(7).setPreferredWidth(150);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	private void settextfields(String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			String query= "select id, name, nic, email, qualification, phone_no, username, password from tb_doctorinfo where id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				updateid.setText(rs.getString("id"));
				updatename.setText(rs.getString("name"));
				updatenic.setText(rs.getString("nic"));
				updateemail.setText(rs.getString("email"));
				updatequalification.setText(rs.getString("qualification"));
				updatephone.setText(rs.getString("phone_no"));
				updateusername.setText(rs.getString("username"));
				updatepassword.setText(rs.getString("password"));
				
				
			}
			rs.close();
			ps.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void updatedoctor(String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			String query= "update tb_doctorinfo set name = ?, nic = ?, email = ?, qualification = ?, phone_no = ?, username = ?, password = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, updatename.getText());
			ps.setString(1, updatenic.getText());
			ps.setString(2, updateemail.getText());
			ps.setString(3, updatequalification.getText());
			ps.setString(4, updatephone.getText());
			ps.setString(5, updateusername.getText());
			ps.setString(5, updatepassword.getText());
			ps.setString(6, id);
			ps.execute();
			
			ps.close();
			conn.close();
			JOptionPane.showMessageDialog(null,"Sussfully Updated");
			displaydoctor();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void deletedoctor(String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			String query= "delete from tb_doctorinfo where id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			
			ps.execute();
			
			ps.close();
			conn.close();
			//JOptionPane.showConfirmDialog(null,"Do you want to Delete?","Confirmation",JOptionPane.YES_NO_OPTION);
			JOptionPane.showMessageDialog(null,"Sussfully Deleted");
			displaydoctor();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public editDoctor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				displaydoctor();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 660);
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
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(958, 0, 42, 33);
		panel.add(lblX);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//setVisible(false);
				if(JOptionPane.showConfirmDialog(null,"Do you want to Exit?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					editDoctor.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.white);
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Segoe UI", Font.BOLD, 22));
		
		JLabel label = new JLabel("-");
		label.setBounds(916, 0, 30, 20);
		panel.add(label);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setForeground(Color.white);

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setForeground(Color.RED);
			}
		});
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Segoe UI", Font.BOLD, 40));
		setUndecorated(true);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(95, 158, 160));
		lblNewLabel_2.setBounds(132, 46, 120, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSearch.setForeground(new Color(95, 158, 160));
		lblSearch.setBounds(584, 59, 100, 20);
		contentPane.add(lblSearch);
		
		searchdoctor = new JTextField();
		searchdoctor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel tabledoctor =(DefaultTableModel)table.getModel();
				String search = searchdoctor.getText().trim();
				
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tabledoctor);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		searchdoctor.setBounds(744, 51, 200, 33);
		contentPane.add(searchdoctor);
		searchdoctor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setBounds(20, 100, 170, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setBounds(20, 163, 175, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_21 = new JLabel("NIC");
		lblNewLabel_21.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_21.setForeground(new Color(95, 158, 160));
		lblNewLabel_21.setBounds(20, 226, 170, 33);
		contentPane.add(lblNewLabel_21);
		
		JLabel lblNewLabel_31 = new JLabel("Email");
		lblNewLabel_31.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_31.setForeground(new Color(95, 158, 160));
		lblNewLabel_31.setBounds(20, 289, 170, 33);
		contentPane.add(lblNewLabel_31);
		
		JLabel lblNewLabel_4 = new JLabel("Qualification");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setBounds(20, 352, 170, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setBounds(20, 415, 170, 33);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Username");
		lblNewLabel_5_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_5_1.setBounds(20, 478, 170, 33);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_4_1.setBounds(20, 541, 170, 33);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel docid = new JLabel("");
		docid.setHorizontalAlignment(SwingConstants.CENTER);
		docid.setForeground(Color.RED);
		docid.setBounds(200, 140, 200, 16);
		contentPane.add(docid);
		
		JLabel docname = new JLabel("");
		docname.setHorizontalAlignment(SwingConstants.CENTER);
		docname.setForeground(Color.RED);
		docname.setBounds(200, 204, 200, 16);
		contentPane.add(docname);
		
		JLabel docnic = new JLabel("");
		docnic.setHorizontalAlignment(SwingConstants.CENTER);
		docnic.setForeground(Color.RED);
		docnic.setBounds(200, 267, 200, 16);
		contentPane.add(docnic);
		
		JLabel docemail = new JLabel("");
		docemail.setHorizontalAlignment(SwingConstants.CENTER);
		docemail.setForeground(Color.RED);
		docemail.setBounds(200, 330, 200, 16);
		contentPane.add(docemail);
		
		JLabel docqualification = new JLabel("");
		docqualification.setHorizontalAlignment(SwingConstants.LEFT);
		docqualification.setForeground(Color.RED);
		docqualification.setBounds(200, 393, 200, 16);
		contentPane.add(docqualification);
		
		JLabel docphone = new JLabel("");
		docphone.setHorizontalAlignment(SwingConstants.CENTER);
		docphone.setForeground(Color.RED);
		docphone.setBounds(200, 456, 200, 16);
		contentPane.add(docphone);
		
		JLabel docusername = new JLabel("");
		docusername.setHorizontalAlignment(SwingConstants.CENTER);
		docusername.setForeground(Color.RED);
		docusername.setBounds(200, 519, 200, 16);
		contentPane.add(docusername);
		
		JLabel docpassword = new JLabel("");
		docpassword.setForeground(Color.RED);
		docpassword.setBounds(200, 582, 200, 16);
		contentPane.add(docpassword);
		
		updateid = new JTextField();
		updateid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updateid.setBounds(200, 100, 200, 33);
		contentPane.add(updateid);
		updateid.setColumns(10);
		updateid.setForeground(new Color(95, 158, 160));
		
		updatename = new JTextField();
		updatename.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[a-zA-Z]{0,50}$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updatename.getText());
				if(!match.matches()) {
					docname.setText("Invalid Name!");
				}else {
					docname.setText(null);
				}
			}
		});
		updatename.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updatename.setColumns(10);
		updatename.setBounds(200, 163, 200, 33);
		contentPane.add(updatename);
		updatename.setForeground(new Color(95, 158, 160));
		
		updatenic = new JTextField();
		updatenic.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[0-9]{9}+[a-zA-Z]{1}$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updatenic.getText());
				if(!match.matches()) {
					docnic.setText("Invalid Phone!");
				}else {
					docnic.setText(null);
				}
			}
		});
		updatenic.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updatenic.setColumns(10);
		updatenic.setBounds(200, 226, 200, 33);
		contentPane.add(updatenic);
		updatenic.setForeground(new Color(95, 158, 160));
		
		updateemail = new JTextField();
		updateemail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updateemail.getText());
				if(!match.matches()) {
					docemail.setText("Invalid Email!");
				}else {
					docemail.setText(null);
				}

			}
		});
		updateemail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updateemail.setColumns(10);
		updateemail.setBounds(200, 289, 200, 33);
		contentPane.add(updateemail);
		updateemail.setForeground(new Color(95, 158, 160));
		
		updatequalification = new JTextField();
		updatequalification.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[a-zA-Z]{0,255}$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updatequalification.getText());
				if(!match.matches()) {
					docqualification.setText("Invalid Name!");
				}else {
					docqualification.setText(null);
				}
			}
		});
		updatequalification.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updatequalification.setColumns(10);
		updatequalification.setBounds(200, 352, 200, 33);
		contentPane.add(updatequalification);
		updatequalification.setForeground(new Color(95, 158, 160));
		
		updatephone = new JTextField();
		updatephone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[0-9]{10}$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updatephone.getText());
				if(!match.matches()) {
					docphone.setText("Invalid Phone!");
				}else {
					docphone.setText(null);
				}
			}
		});
		updatephone.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updatephone.setColumns(10);
		updatephone.setBounds(200, 415, 200, 33);
		contentPane.add(updatephone);
		updatephone.setForeground(new Color(95, 158, 160));
		
		updateusername = new JTextField();
		updateusername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^[a-zA-Z0-9]{0,50}$";
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updateusername.getText());
				if(!match.matches()) {
					docusername.setText("Invalid Name!");
				}else {
					docusername.setText(null);
				}
			}
		});
		updateusername.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updateusername.setColumns(10);
		updateusername.setBounds(200, 478, 200, 33);
		contentPane.add(updateusername);
		updateusername.setForeground(new Color(95, 158, 160));
		
		updatepassword = new JTextField();
		updatepassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&])(?=\\S+$).{8,20}$";
				//(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8, 20}
				Pattern patt= Pattern.compile(PATTERN);
				Matcher match=patt.matcher(updatepassword.getText());
				if(!match.matches()) {
					docpassword.setText("Invalid Password!");
				}else {
					docpassword.setText(null);
				}
			}
		});
		updatepassword.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updatepassword.setColumns(10);
		updatepassword.setBounds(200, 541, 200, 33);
		contentPane.add(updatepassword);
		updatepassword.setForeground(new Color(95, 158, 160));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(412, 100, 560, 440);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String updateid = table.getValueAt(table.getSelectedRow(), 0).toString();
				settextfields(updateid);
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()>=0);
				updatedoctor(updateid.getText());
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnUpdate.setBounds(494, 588, 150, 40);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0);
				deletedoctor(updateid.getText());
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnDelete.setBounds(744, 588, 150, 40);
		contentPane.add(btnDelete);
		
		JLabel label_1 = new JLabel("<<<");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageDoctor mD= new manageDoctor ();
				mD.setVisible(true);				
				setVisible(false);
			}
		});
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		label_1.setBounds(23, 0, 72, 33);
		panel.add(label_1);
		
		imagelbl =new JLabel("");
		imagelbl.setForeground(new Color(255, 255, 255));
		imagelbl.setBounds(0, 0, 1000, 660);
		imagelbl.setIcon(new ImageIcon(editDoctor.class.getResource("/IT20119744/assets/login.jpeg")));
		contentPane.add(imagelbl);
	}
}
