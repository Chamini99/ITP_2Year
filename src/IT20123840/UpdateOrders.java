package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateOrders extends JFrame {

	private JPanel contentPane;
	private JTextField supplierStatus;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 450, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblX.setBounds(422, 0, 28, 33);
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
		lblX_1.setBounds(399, 0, 28, 33);
		panel.add(lblX_1);
		
		JTextField orderNo = new JTextField();
		orderNo.setBounds(107, 111, 86, 20);
		contentPane.add(orderNo);
		orderNo.setColumns(10);
		
		JLabel lblUpdateOrderStatus = new JLabel("Update Order Status");
		lblUpdateOrderStatus.setForeground(new Color(95, 158, 160));
		lblUpdateOrderStatus.setFont(new Font("Calibri", Font.BOLD, 28));
		lblUpdateOrderStatus.setBounds(107, 44, 257, 27);
		contentPane.add(lblUpdateOrderStatus);
		
		JLabel txt_supplierStatus = new JLabel("Supplier Status");
		txt_supplierStatus.setForeground(new Color(95, 158, 160));
		txt_supplierStatus.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_supplierStatus.setBounds(107, 178, 102, 20);
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
		btnView.setBounds(271, 109, 75, 23);
		contentPane.add(btnView);
		
		supplierStatus = new JTextField();
		supplierStatus.setColumns(10);
		supplierStatus.setBounds(244, 178, 102, 20);
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
							EditOrders eo = new EditOrders();
							eo.setVisible(true);
							setVisible(false);
						
						connection.close();
					}
					catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnUpdate.setBackground(new Color(95, 158, 160));
		btnUpdate.setBounds(107, 235, 102, 33);
		contentPane.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				orderNo.setText(" ");
				supplierStatus.setText(" ");
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnReset.setBackground(new Color(95, 158, 160));
		btnReset.setBounds(244, 235, 102, 33);
		contentPane.add(btnReset);
		setUndecorated(true);
	}
}
