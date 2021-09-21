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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class editSupplier extends JFrame {

	private JPanel contentPane;
	private JTextField updateid;
	private JTextField updatename;
	private JTextField updateaddress;
	private JTextField updateemail;
	private JTextField updateusername;
	private JTextField updatepassword;
	private JTextField searchsupplier;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editSupplier frame = new editSupplier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void displaysupplier() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Address");
		model.addColumn("Email");
		model.addColumn("Username");
		model.addColumn("Password");
		
		
		//model.setColumnIdentifiers();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			Statement stmt=conn.createStatement();
			String query= "select company_id, company_name, company_address, company_email, username, password from tbl_supplycompany";
			ResultSet rs= stmt.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("company_id"),
						rs.getString("company_name"),
						rs.getString("company_address"),
						rs.getString("company_email"),
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
			table.getColumnModel().getColumn(2).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setPreferredWidth(120);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(150);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	private void settextfields(String company_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			String query= "select company_id, company_name, company_address, company_email, username, password from tbl_supplycompany where company_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, company_id);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				updateid.setText(rs.getString("company_id"));
				updatename.setText(rs.getString("company_name"));
				updateaddress.setText(rs.getString("company_address"));
				updateemail.setText(rs.getString("company_email"));
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
	
	private void updatesupplier(String company_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			String query= "update tbl_supplycompany set company_name = ?, company_address = ?, company_email = ?, username = ?, password = ?  where company_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, updatename.getText());
			ps.setString(2, updateaddress.getText());
			ps.setString(3, updateemail.getText());
			ps.setString(4, updateusername.getText());
			ps.setString(5, updatepassword.getText());
			ps.setString(6, company_id);
			ps.execute();
			
			ps.close();
			conn.close();
			JOptionPane.showMessageDialog(null,"Sussfully Updated");
			displaysupplier();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void deletesupplier(String company_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			String query= "delete from tbl_supplycompany where company_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, company_id);
			
			ps.execute();
			
			ps.close();
			conn.close();
			JOptionPane.showMessageDialog(null,"Sussfully Deleted");
			displaysupplier();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public editSupplier() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				displaysupplier();
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
					editSupplier.this.dispose();
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
			public void mouseEntered(MouseEvent e) {
				label.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setForeground(Color.white);
			}
		});
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Segoe UI", Font.BOLD, 40));
		setUndecorated(true);
		
		JLabel lblNewLabel_2 = new JLabel("Supplier");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(95, 158, 160));
		lblNewLabel_2.setBounds(132, 46, 120, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSearch.setForeground(new Color(95, 158, 160));
		lblSearch.setBounds(584, 59, 100, 20);
		contentPane.add(lblSearch);
		
		
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
		
		JLabel lblNewLabel_21 = new JLabel("Address");
		lblNewLabel_21.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_21.setForeground(new Color(95, 158, 160));
		lblNewLabel_21.setBounds(20, 262, 170, 33);
		contentPane.add(lblNewLabel_21);
		
		JLabel lblNewLabel_31 = new JLabel("Email");
		lblNewLabel_31.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_31.setForeground(new Color(95, 158, 160));
		lblNewLabel_31.setBounds(20, 332, 170, 33);
		contentPane.add(lblNewLabel_31);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setBounds(20, 402, 170, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setBounds(20, 472, 170, 33);
		contentPane.add(lblNewLabel_5);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0);
				updatesupplier(updateid.getText());
			}
		});
		
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnUpdate.setBounds(45, 574, 150, 40);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0);
				deletesupplier(updateid.getText());
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnDelete.setBounds(228, 574, 150, 40);
		contentPane.add(btnDelete);
		
		updateid = new JTextField();
		updateid.setFont(new Font("Tahoma", Font.PLAIN, 22));
		updateid.setBounds(200, 122, 200, 33);
		contentPane.add(updateid);
		updateid.setColumns(10);
		updateid.setForeground(new Color(95, 158, 160));
		
		updatename = new JTextField();
		updatename.setFont(new Font("Tahoma", Font.PLAIN, 22));
		updatename.setColumns(10);
		updatename.setBounds(200, 192, 200, 33);
		contentPane.add(updatename);
		
		updateaddress = new JTextField();
		updateaddress.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updateaddress.setColumns(10);
		updateaddress.setBounds(202, 262, 200, 33);
		contentPane.add(updateaddress);
		updateaddress.setForeground(new Color(95, 158, 160));
		
		updateemail = new JTextField();
		updateemail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		updateemail.setColumns(10);
		updateemail.setBounds(200, 332, 200, 33);
		contentPane.add(updateemail);
		updateemail.setForeground(new Color(95, 158, 160));
		
		updateusername = new JTextField();
		updateusername.setFont(new Font("Tahoma", Font.PLAIN, 22));
		updateusername.setColumns(10);
		updateusername.setBounds(200, 402, 200, 33);
		contentPane.add(updateusername);
		updateusername.setForeground(new Color(95, 158, 160));
		
		updatepassword = new JTextField();
		updatepassword.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updatepassword.setColumns(10);
		updatepassword.setBounds(200, 472, 200, 33);
		contentPane.add(updatepassword);
		updatepassword.setForeground(new Color(95, 158, 160));
		
		searchsupplier = new JTextField();
		searchsupplier.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel tablesupplier =(DefaultTableModel)table.getModel();
				String search = searchsupplier.getText().toLowerCase();
				
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tablesupplier);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		searchsupplier.setColumns(10);
		searchsupplier.setBounds(699, 56, 200, 33);
		contentPane.add(searchsupplier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(412, 122, 560, 440);
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
		
		JLabel label_1 = new JLabel("<<");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageSupplier mS= new manageSupplier ();
				mS.setVisible(true);				
				setVisible(false);
			}
		});
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		label_1.setBounds(23, 0, 40, 33);
		panel.add(label_1);
		
		JLabel lblNewLabel_11 =new JLabel("");
		lblNewLabel_11.setBounds(0, 0, 1000, 660);
		lblNewLabel_11.setIcon(new ImageIcon(createAccount.class.getResource("/IT20119744/assets/login.jpeg")));
		contentPane.add(lblNewLabel_11);
	}

}