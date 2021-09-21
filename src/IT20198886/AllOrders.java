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
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class AllOrders extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		setBounds(100, 100, 670, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 670, 31);
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			     dispose();
			     StaffHome home=new StaffHome();
				 home.setVisible(true);
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
		
		JLabel lblNewLabel_3 = new JLabel("All Orders");
		lblNewLabel_3.setBounds(291, 43, 107, 25);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		
	    
		
		
		
		
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 90, 622, 279);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_1.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table_1);
		
		
	
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 30, 676, 363);
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
						rs.getInt("order_number"),
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
