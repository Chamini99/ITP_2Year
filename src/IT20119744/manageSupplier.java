package IT20119744;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
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
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class manageSupplier extends JFrame {

	private JPanel contentPane;
	private JTable table_supplier;
	private JTextField searchsupplier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageSupplier frame = new manageSupplier();
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
			
			table_supplier.setModel(model);
			table_supplier.setAutoResizeMode(0);
			table_supplier.getColumnModel().getColumn(0).setPreferredWidth(40);
			table_supplier.getColumnModel().getColumn(1).setPreferredWidth(100);
			table_supplier.getColumnModel().getColumn(2).setPreferredWidth(150);
			table_supplier.getColumnModel().getColumn(3).setPreferredWidth(120);
			table_supplier.getColumnModel().getColumn(4).setPreferredWidth(100);
			table_supplier.getColumnModel().getColumn(5).setPreferredWidth(150);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	/**
	 * Create the frame.
	 */
	public manageSupplier() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				displaysupplier();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 420);
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
				label.setForeground(Color.white);
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
					manageSupplier.this.dispose();
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
		lblX.setBounds(540, 2, 42, 33);
		panel.add(lblX);
		setUndecorated(true);
		
		JLabel lblNewLabel_2 = new JLabel("Suppliers");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel_2.setForeground(new Color(95, 158, 160));
		lblNewLabel_2.setBounds(412, 52, 150, 33);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 147, 550, 200);
		contentPane.add(scrollPane);
		
		table_supplier = new JTable();
		scrollPane.setViewportView(table_supplier);
		
		searchsupplier = new JTextField();
		searchsupplier.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel tablesupplier =(DefaultTableModel)table_supplier.getModel();
				String search = searchsupplier.getText().toLowerCase();
				
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tablesupplier);
				table_supplier.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		searchsupplier.setBounds(116, 52, 200, 33);
		contentPane.add(searchsupplier);
		searchsupplier.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSearch.setForeground(new Color(95, 158, 160));
		lblSearch.setBounds(10, 55, 100, 20);
		contentPane.add(lblSearch);
		
		JButton btnUpdateAdmin = new JButton("UPDATE ");
		btnUpdateAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				editSupplier eS= new editSupplier();
				eS.setVisible(true);				
				setVisible(false);
			}
		});
		btnUpdateAdmin.setForeground(Color.WHITE);
		btnUpdateAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnUpdateAdmin.setBackground(new Color(95, 158, 160));
		btnUpdateAdmin.setBounds(12, 105, 120, 33);
		contentPane.add(btnUpdateAdmin);
		
		JButton btndelete = new JButton("DELETE");
		btndelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editSupplier eS= new editSupplier();
				eS.setVisible(true);				
				setVisible(false);
			}
		});
		btndelete.setForeground(Color.WHITE);
		btndelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btndelete.setBackground(new Color(95, 158, 160));
		btndelete.setBounds(442, 105, 120, 33);
		contentPane.add(btndelete);
		
		JLabel label_1 = new JLabel("<<<");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				profile P= new profile ();
				P.setVisible(true);				
				setVisible(false);
			}
		});
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		label_1.setBounds(23, 0, 63, 33);
		panel.add(label_1);
		
		JButton btnNewButton = new JButton("PRINT LIST");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("List of Suppliers");
				MessageFormat footer = new MessageFormat("Suwasetha Vaccine Management");
				
				try {
					table_supplier.print(JTable.PrintMode.FIT_WIDTH, header, footer);
					
				}catch(PrinterException e1){
					JOptionPane.showMessageDialog(null,"Cannot be Print"+e1.getMessage());
					
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setBounds(207, 360, 150, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 =new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 580, 420);
		lblNewLabel_1.setIcon(new ImageIcon(createAccount.class.getResource("/IT20119744/assets/login.jpeg")));
		contentPane.add(lblNewLabel_1);
		
	}
}
