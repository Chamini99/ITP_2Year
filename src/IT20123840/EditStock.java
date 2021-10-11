package IT20123840;

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
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditStock extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField searchBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStock frame = new EditStock();
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
	public EditStock() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ShowData();
			}
		}); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 622, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		lblX.setBounds(594, 0, 28, 33);
		panel.add(lblX);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX_1 = new JLabel("  -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setBounds(572, 0, 28, 33);
		panel.add(lblX_1);
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		JLabel lblEditStock = new JLabel("Edit Stock");
		lblEditStock.setForeground(new Color(95, 158, 160));
		lblEditStock.setFont(new Font("Calibri", Font.BOLD, 24));
		lblEditStock.setBounds(263, 44, 98, 30);
		contentPane.add(lblEditStock);
		
		JButton btnAddNewVaccine = new JButton("Add New Vaccine");
		btnAddNewVaccine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddVaccine av = new AddVaccine();
				av.setVisible(true);
				setVisible(false);
			}
		});
		btnAddNewVaccine.setBackground(new Color(95, 158, 160));
		btnAddNewVaccine.setForeground(new Color(255, 255, 255));
		btnAddNewVaccine.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnAddNewVaccine.setBounds(215, 347, 196, 33);
		contentPane.add(btnAddNewVaccine);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 126, 540, 199);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		setUndecorated(true);
		
		JButton btnUpdateStock = new JButton("Update");
		btnUpdateStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UpdateStock us = new UpdateStock();
				us.setVisible(true);
				setVisible(false);
			}
		});
		btnUpdateStock.setForeground(Color.WHITE);
		btnUpdateStock.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnUpdateStock.setBackground(new Color(95, 158, 160));
		btnUpdateStock.setBounds(40, 347, 105, 33);
		contentPane.add(btnUpdateStock);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setIcon(new ImageIcon(EditStock.class.getResource("/IT20123840/Assets/Back.PNG")));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CompanyHome ch = new CompanyHome();
				ch.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(new Color(95, 158, 160));
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnBack.setBackground(new Color(95, 158, 160));
		btnBack.setBounds(495, 44, 44, 30);
		contentPane.add(btnBack);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteVaccine dv = new DeleteVaccine();
				dv.setVisible(true);
				setVisible(false);
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnDelete.setBackground(new Color(95, 158, 160));
		btnDelete.setBounds(475, 347, 105, 33);
		contentPane.add(btnDelete);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Vaccine Details");
				MessageFormat footer = new MessageFormat("Suwasetha Vaccine Management System");
				
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Cannot be printed !" + e1.getMessage());
				}
			}
		});
		btnPrint.setIcon(new ImageIcon(EditStock.class.getResource("/IT20123840/Assets/Printing.PNG")));
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnPrint.setBackground(new Color(95, 158, 160));
		btnPrint.setBounds(465, 85, 115, 30);
		contentPane.add(btnPrint);
		
		searchBar = new JTextField();
		searchBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(searchBar.getText().trim()));
			}
		});
		searchBar.setBounds(40, 95, 174, 20);
		contentPane.add(searchBar);
		searchBar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EditStock.class.getResource("/IT20123840/Assets/search.PNG")));
		lblNewLabel.setBounds(215, 95, 31, 20);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 622, 404);
		contentPane.add(label);
		label.setIcon(new ImageIcon(EditStock.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
	
	private void ShowData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
		
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Vaccine ID");
			model.addColumn("Vaccine Name");
			model.addColumn("Expire Date");
			model.addColumn("Price");
			model.addColumn("Quantity");
		
		
			String query = "select vaccine_id, vaccine_name, expire_date, s_price, s_quantity from tbl_companystock";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[]{
					rs.getString("vaccine_id"),
					rs.getString("vaccine_name"),
					rs.getString("expire_date"),
					rs.getString("s_price"),
					rs.getString("s_quantity")
				});
			}
			
			rs.close();
			stmt.close();
			connection.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(140);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
		}
		
		catch(Exception e) {
			System.out.println("error: " + e);
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
