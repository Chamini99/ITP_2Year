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

public class Orders extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders frame = new Orders();
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
	public Orders() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ShowData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 650, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblX.setBounds(621, 0, 29, 33);
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
		lblX_1.setBounds(599, 0, 29, 33);
		panel.add(lblX_1);
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblOrders = new JLabel("Orders");
		lblOrders.setFont(new Font("Calibri", Font.BOLD, 28));
		lblOrders.setBounds(287, 44, 79, 27);
		contentPane.add(lblOrders);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 93, 564, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SupplyHome sh = new SupplyHome();
				sh.frame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnBack.setBackground(new Color(95, 158, 160));
		btnBack.setBounds(285, 359, 104, 37);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 650, 386);
		contentPane.add(label);
		setUndecorated(true);
		label.setIcon(new ImageIcon(Orders.class.getResource("/IT20123840/Assets/login.jpeg")));
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
