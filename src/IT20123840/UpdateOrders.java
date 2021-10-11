package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.Document;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class UpdateOrders extends JFrame {

	private JPanel contentPane;
	private JTextArea txt_orderDetails;
	private JTextField supplierStatus;
	private JTextField orderNo;
	private JTextField OrderDate;
	private JTextField VaccineType;
	private JTextField SupplyCompany;
	private JTextField Amount;
	private JTextField Price;
	private JTextField DeliverdDate;
	private JTextField SupplierStts;
	private JTextField CardHolder;
	private JTextField CardNo;
	private JTextField OrderNo1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateOrders frame = new UpdateOrders();
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
	public UpdateOrders() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
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
		lblX.setBounds(622, 0, 28, 33);
		panel.add(lblX);
		lblX.setForeground(new Color(240, 248, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX_1 = new JLabel("  -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(new Color(240, 248, 255));
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX_1.setBounds(600, 0, 28, 33);
		panel.add(lblX_1);
		
		JTextField orderNo = new JTextField();
		orderNo.setBounds(10, 93, 86, 20);
		contentPane.add(orderNo);
		orderNo.setColumns(10);
		
		JLabel lblUpdateOrderStatus = new JLabel("Update Order Status");
		lblUpdateOrderStatus.setForeground(new Color(95, 158, 160));
		lblUpdateOrderStatus.setFont(new Font("Calibri", Font.BOLD, 28));
		lblUpdateOrderStatus.setBounds(195, 44, 257, 27);
		contentPane.add(lblUpdateOrderStatus);
		
		JLabel txt_supplierStatus = new JLabel("Supplier Status");
		txt_supplierStatus.setForeground(new Color(95, 158, 160));
		txt_supplierStatus.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_supplierStatus.setBounds(10, 157, 102, 20);
		contentPane.add(txt_supplierStatus);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
				Statement stmt = connection.createStatement();
				String query = "select supplier_status from tbl_vaccineorder where order_number = '"+orderNo.getText()+"'";
				ResultSet rs = stmt.executeQuery(query);
				
				if (rs.next()) {
					String supplierStts = rs.getString(1);
					
					supplierStatus.setText(supplierStts);
				}
				else {
					JOptionPane.showMessageDialog(orderNo, "Order number not found");
					orderNo.setText(null);
				}
				
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		});
		btnView.setForeground(new Color(240, 248, 255));
		btnView.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnView.setBackground(new Color(95, 158, 160));
		btnView.setBounds(172, 91, 75, 23);
		contentPane.add(btnView);
		
		supplierStatus = new JTextField();
		supplierStatus.setColumns(10);
		supplierStatus.setBounds(161, 157, 86, 20);
		contentPane.add(supplierStatus);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String supplierStts = supplierStatus.getText();
				
				if (supplierStatus.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnUpdate, "Please fill 'Supplier Status' field");
				}
				
				else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
	
							String query = "update tbl_vaccineorder set supplier_status = '"+supplierStatus.getText()+"' where order_number = '"+orderNo.getText()+"'";
							Statement stmt = connection.createStatement();
							int x = stmt.executeUpdate(query);
						
							JOptionPane.showConfirmDialog(btnUpdate, "The status has been updated successfully!!!");
						
						connection.close();
					}
					catch (Exception exception) {
						exception.printStackTrace();
					}
				}
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
					Statement stmt1 = connection.createStatement();
					String query1 = "select order_number, order_date, vaccine_type, supply_company,amount, price, deliverd_date, supplier_status, cardholder_name, card_number from tbl_vaccineorder where order_number = '"+orderNo.getText()+"'";
					ResultSet rs = stmt1.executeQuery(query1);
					
					if (rs.next()) {
						String oOrderNo = rs.getString(1);
						String oOrderDate = rs.getString(2);
						String oVaccineType = rs.getString(3);
						String oSupplyCompany = rs.getString(4);
						String oAmount = rs.getString(5);
						String oPrice = rs.getString(6);
						String oDeliverdDate = rs.getString(7);
						String oSupplierStatus = rs.getString(8);
						String oCardHolder = rs.getString(9);
						String oCardNo = rs.getString(10);
						
						OrderNo1.setText(oOrderNo);
						OrderDate.setText(oOrderDate);
						VaccineType.setText(oVaccineType);
						SupplyCompany.setText(oSupplyCompany);
						Amount.setText(oAmount);
						Price.setText(oPrice);
						DeliverdDate.setText(oDeliverdDate);
						SupplierStts.setText(oSupplierStatus);
						CardHolder.setText(oCardHolder);
						CardNo.setText(oCardNo);
					}
					else {
						JOptionPane.showMessageDialog(orderNo, "Order number not found");
						orderNo.setText(null);
					}
				}
				
				catch (Exception exception) {
					exception.printStackTrace();
				}
				
				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnUpdate.setBackground(new Color(95, 158, 160));
		btnUpdate.setBounds(10, 227, 113, 33);
		contentPane.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				orderNo.setText(" ");
				supplierStatus.setText(" ");
				OrderNo1.setText(" ");
				OrderDate.setText(" ");
				VaccineType.setText(" ");
				SupplyCompany.setText(" ");
				Amount.setText(" ");
				Price.setText(" ");
				DeliverdDate.setText(" ");
				SupplierStts.setText(" ");
				CardHolder.setText(" ");
				CardNo.setText(" ");
			}
		});
		
		
		
		JLabel txt_orderDate = new JLabel("Order Date");
		txt_orderDate.setForeground(new Color(95, 158, 160));
		txt_orderDate.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_orderDate.setBounds(332, 116, 102, 20);
		contentPane.add(txt_orderDate);
		
		JLabel txt_supplyCompany = new JLabel("Supply Company");
		txt_supplyCompany.setForeground(new Color(95, 158, 160));
		txt_supplyCompany.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_supplyCompany.setBounds(332, 178, 120, 20);
		contentPane.add(txt_supplyCompany);
		
		JLabel txt_price = new JLabel("Price");
		txt_price.setForeground(new Color(95, 158, 160));
		txt_price.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_price.setBounds(332, 240, 102, 20);
		contentPane.add(txt_price);
		
		JLabel txt_deliverdDate = new JLabel("Deliverd Date");
		txt_deliverdDate.setForeground(new Color(95, 158, 160));
		txt_deliverdDate.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_deliverdDate.setBounds(332, 271, 102, 20);
		contentPane.add(txt_deliverdDate);
		
		JLabel txt_cardHolder = new JLabel("Card Holder");
		txt_cardHolder.setForeground(new Color(95, 158, 160));
		txt_cardHolder.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_cardHolder.setBounds(332, 333, 102, 20);
		contentPane.add(txt_cardHolder);
		
		JLabel txt_vaccineType = new JLabel("Vaccine Type");
		txt_vaccineType.setForeground(new Color(95, 158, 160));
		txt_vaccineType.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_vaccineType.setBounds(332, 147, 102, 20);
		contentPane.add(txt_vaccineType);
		
		JLabel txt_amount = new JLabel("Amount");
		txt_amount.setForeground(new Color(95, 158, 160));
		txt_amount.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_amount.setBounds(332, 209, 102, 20);
		contentPane.add(txt_amount);
		
		JLabel txt_supplierStatus1 = new JLabel("Supplier Status");
		txt_supplierStatus1.setForeground(new Color(95, 158, 160));
		txt_supplierStatus1.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_supplierStatus1.setBounds(332, 302, 102, 20);
		contentPane.add(txt_supplierStatus1);
		
		JLabel txt_cardNo = new JLabel("Card No");
		txt_cardNo.setForeground(new Color(95, 158, 160));
		txt_cardNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_cardNo.setBounds(332, 364, 102, 20);
		contentPane.add(txt_cardNo);
		
		OrderDate = new JTextField();
		OrderDate.setColumns(10);
		OrderDate.setBounds(478, 116, 113, 20);
		contentPane.add(OrderDate);
		OrderDate.setEditable(false);
		
		VaccineType = new JTextField();
		VaccineType.setColumns(10);
		VaccineType.setBounds(478, 147, 113, 20);
		contentPane.add(VaccineType);
		VaccineType.setEditable(false);
		
		SupplyCompany = new JTextField();
		SupplyCompany.setColumns(10);
		SupplyCompany.setBounds(478, 178, 113, 20);
		contentPane.add(SupplyCompany);
		SupplyCompany.setEditable(false);
		
		Amount = new JTextField();
		Amount.setColumns(10);
		Amount.setBounds(478, 209, 113, 20);
		contentPane.add(Amount);
		Amount.setEditable(false);
		
		Price = new JTextField();
		Price.setColumns(10);
		Price.setBounds(478, 240, 113, 20);
		contentPane.add(Price);
		Price.setEditable(false);
		
		DeliverdDate = new JTextField();
		DeliverdDate.setColumns(10);
		DeliverdDate.setBounds(478, 271, 113, 20);
		contentPane.add(DeliverdDate);
		DeliverdDate.setEditable(false);
		
		SupplierStts = new JTextField();
		SupplierStts.setColumns(10);
		SupplierStts.setBounds(478, 302, 113, 20);
		contentPane.add(SupplierStts);
		SupplierStts.setEditable(false);
		
		CardHolder = new JTextField();
		CardHolder.setColumns(10);
		CardHolder.setBounds(478, 333, 113, 20);
		contentPane.add(CardHolder);
		CardHolder.setEditable(false);
		
		CardNo = new JTextField();
		CardNo.setColumns(10);
		CardNo.setBounds(478, 364, 113, 20);
		contentPane.add(CardNo);
		CardNo.setEditable(false);
		
		OrderNo1 = new JTextField();
		OrderNo1.setEditable(false);
		OrderNo1.setColumns(10);
		OrderNo1.setBounds(478, 85, 113, 20);
		contentPane.add(OrderNo1);
		OrderNo1.setEditable(false);
		
		JLabel txt_orderNo = new JLabel("Order No");
		txt_orderNo.setForeground(new Color(95, 158, 160));
		txt_orderNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_orderNo.setBounds(332, 85, 102, 20);
		contentPane.add(txt_orderNo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(UpdateOrders.class.getResource("/IT20123840/Assets/Background.jpg")));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(95, 158, 160));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(294, 82, 346, 313);
		contentPane.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(UpdateOrders.class.getResource("/IT20123840/Assets/Back.PNG")));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EditOrders eo = new EditOrders();
				eo.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnBack.setBackground(new Color(95, 158, 160));
		btnBack.setBounds(596, 44, 44, 27);
		contentPane.add(btnBack);
		
		JTextArea txt_orderDetails = new JTextArea();
		txt_orderDetails.setBounds(109, 417, 431, 272);
		contentPane.add(txt_orderDetails);
		
		JButton btnReciept = new JButton("Reciept");
		btnReciept.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					txt_orderDetails.append("\t\t Orders Details \n\n" +
							"   Oredr No: \t\t\t" +  OrderNo1.getText() + 
							"\n===============================================\n\n" +
							"   Oredr Date: \t\t\t" +  OrderDate.getText() + "\n" +
							"   Vaccine Type: \t\t\t" +  VaccineType.getText() + "\n" +
							"   Supply Company: \t\t" +  SupplyCompany.getText() + "\n" +
							"   Amount: \t\t\t" +  Amount.getText() + "\n" +
							"   Price: \t\t\t" +  Price.getText() + "\n" +
							"   Deliverd Date: \t\t" +  DeliverdDate.getText() + "\n" +
							"   Supplier Status: \t\t" +  SupplierStts.getText() + "\n" +
							"   Card Holder: \t\t\t" +  CardHolder.getText() + "\n" +
							"   Card No: \t\t\t" +  CardNo.getText() + "\n\n" +
							"==============================================="
									);
			}
		});
		btnReciept.setForeground(Color.WHITE);
		btnReciept.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnReciept.setBackground(new Color(95, 158, 160));
		btnReciept.setBounds(171, 227, 113, 33);
		contentPane.add(btnReciept);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txt_orderDetails.print();
				} 
				catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}

		});
		btnPrint.setIcon(new ImageIcon(UpdateOrders.class.getResource("/IT20123840/Assets/Printing.PNG")));
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnPrint.setBackground(new Color(95, 158, 160));
		btnPrint.setBounds(10, 295, 113, 33);
		contentPane.add(btnPrint);
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnReset.setBackground(new Color(95, 158, 160));
		btnReset.setBounds(171, 295, 113, 33);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UpdateOrders.class.getResource("/IT20123840/Assets/login.jpeg")));
		lblNewLabel.setBounds(0, 33, 650, 667);
		contentPane.add(lblNewLabel);
		setUndecorated(true);
	}
}
