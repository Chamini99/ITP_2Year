package IT20198886;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
public class AllOrders extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllOrders frame = new AllOrders();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     Connection connection=null;
     private JTable table_1;
     private JTextField t1;
	/**
	 * Create the frame.
	 */
	public AllOrders() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ShowData();
			}
		});
		connection=MyConnection.dbconn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 670, 31);
		panel.setBackground(new Color(0, 128, 128));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			     dispose();
			    
			}
		});
		
		
		lblNewLabel.setBounds(649, 0, 21, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_1.setBounds(618, 8, 21, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("All Vaccine Orders");
		lblNewLabel_3.setBounds(276, 52, 190, 25);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3.setForeground(new Color(47, 79, 79));
		
	    
		
		
		
		
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(22, 145, 622, 235);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_1.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table_1);
		
		JLabel lblOrderNumber = new JLabel("Enter Order Number");
		lblOrderNumber.setForeground(new Color(255, 0, 0));
		lblOrderNumber.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblOrderNumber.setBounds(347, 404, 163, 31);
		contentPane.add(lblOrderNumber);
		
		t1 = new JTextField();
		t1.setBounds(478, 409, 73, 23);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			 @Override
	         public void actionPerformed(ActionEvent ae) {
				 String sql="DELETE FROM tbl_vaccineorder WHERE order_no='"+t1.getText()+"'";
				 queryUpdate(sql,"Deleted");
			 }

			private void queryUpdate(String sql, String message) {
				try 
					   
					(Statement stmt =  MyConnection.getConnection().createStatement()) {
					     
					   if(stmt.executeUpdate(sql)==1){
					    DefaultTableModel model = (DefaultTableModel)table_1.getModel();
					    model.setRowCount(0);
					    ShowData();
					    
						JOptionPane.showMessageDialog(null, message + " Successfully!");
					   }
					  } catch (SQLException se) {
					   se.printStackTrace();
					  }
				}
				
			
		});
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(568, 407, 73, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Genarate Report");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header=new MessageFormat("Suwasetha Vaccine Management Order Details ");
				MessageFormat footer=new MessageFormat("Suwasetha Medical Center ");
				try {
					
					table_1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
				  
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null," Can not be print!"+e.getMessage());
					
					  }
			
				
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1.setBounds(472, 115, 172, 23);
		contentPane.add(btnNewButton_1);
	
		
	
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 30, 676, 440);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(AllOrders.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_2);
		 
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
	private void ShowData() {
		Connection con=MyConnection.getConnection();
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Order No");
		model.addColumn("Order Date");
		model.addColumn("Vaccine Type");
		model.addColumn("Supplier");
		model.addColumn("Amount");
		model.addColumn("Price");
		model.addColumn("Supplier Status");
		model.addColumn("Delivery Status");

		try {
			String query="select * from tbl_vaccineorder";
			Statement st = con.createStatement();
			ResultSet rs  =st . executeQuery(query);
			while (rs.next())
			{
				model.addRow(new Object[] {
						rs.getInt("order_no"),
						rs.getDate("order_date"),
						rs.getString("vaccine_type"),
						rs.getString("supply_company"),
						rs.getInt("amount"),
						rs.getFloat("price"),
						rs.getString("supplier_status"),
						rs.getString("delivery_status")

						
				});
				
			}
			rs.close();
			st.close();
		
			
			table_1.setModel(model);
			table_1.setAutoResizeMode(0);
			table_1.getColumnModel().getColumn(0).setPreferredWidth(60);
			table_1.getColumnModel().getColumn(1).setPreferredWidth(120);
			table_1.getColumnModel().getColumn(2).setPreferredWidth(140);
			table_1.getColumnModel().getColumn(3).setPreferredWidth(100);
			table_1.getColumnModel().getColumn(4).setPreferredWidth(60);
			table_1.getColumnModel().getColumn(5).setPreferredWidth(80);
			table_1.getColumnModel().getColumn(6).setPreferredWidth(100);
			table_1.getColumnModel().getColumn(7).setPreferredWidth(100);

			
			
		} catch (Exception e) {
			System.out.println("error " +e);
		}
		
	}
	   }

	
	
