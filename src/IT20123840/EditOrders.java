package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EditOrders extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditOrders frame = new EditOrders();
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
	public EditOrders() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ShowData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 650, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(620, 0, 30, 33);
		panel.add(lblX);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX_1 = new JLabel("  -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX_1.setBounds(597, 0, 30, 33);
		panel.add(lblX_1);
		
		JLabel lblEditOrders = new JLabel("Edit Orders");
		lblEditOrders.setForeground(new Color(95, 158, 160));
		lblEditOrders.setFont(new Font("Calibri", Font.BOLD, 28));
		lblEditOrders.setBounds(261, 44, 131, 26);
		contentPane.add(lblEditOrders);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 81, 580, 212);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CompanyHome ch = new CompanyHome();
				ch.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnBack.setBackground(new Color(95, 158, 160));
		btnBack.setBounds(533, 44, 83, 24);
		contentPane.add(btnBack);
		
		JButton btnUpdateStatus = new JButton("Update Status");
		btnUpdateStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateOrders uo = new UpdateOrders();
				uo.setVisible(true);
				setVisible(false);
			}
		});
		btnUpdateStatus.setForeground(Color.WHITE);
		btnUpdateStatus.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnUpdateStatus.setBackground(new Color(95, 158, 160));
		btnUpdateStatus.setBounds(232, 326, 196, 33);
		contentPane.add(btnUpdateStatus);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 34, 650, 352);
		contentPane.add(label);
		setUndecorated(true);
		label.setIcon(new ImageIcon(EditOrders.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
	
	private void ShowData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Order No");
			model.addColumn("Order Date");
			model.addColumn("Vaccine Type");
			model.addColumn("Supply company");
			model.addColumn("Amount");
			model.addColumn("Price");
			model.addColumn("Delivery Date");
			model.addColumn("Supplier Status");
			model.addColumn("Delivery Status");
			model.addColumn("Card Holder");
			model.addColumn("Card Number");
			
			
			String query = "select order_number, order_date, vaccine_type, supply_company, amount, price, deliverd_date, supplier_status, delivery_status, cardholder_name, card_number from tbl_vaccineorder";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
				
			while(rs.next()) {
				model.addRow(new Object[]{
					rs.getString("order_number"),
					rs.getString("order_date"),
					rs.getString("vaccine_type"),
					rs.getString("supply_company"),
					rs.getString("amount"),
					rs.getString("price"),
					rs.getString("deliverd_date"),
					rs.getString("supplier_status"),
					rs.getString("delivery_status"),
					rs.getString("cardholder_name"),
					rs.getString("card_number")
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
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(100);
			table.getColumnModel().getColumn(7).setPreferredWidth(100);
			table.getColumnModel().getColumn(8).setPreferredWidth(100);
			table.getColumnModel().getColumn(9).setPreferredWidth(100);
			table.getColumnModel().getColumn(10).setPreferredWidth(100);
		}
			
		catch(Exception e) {
			System.out.println("error: " + e);
		}
	}
}
