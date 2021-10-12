package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Stock extends JFrame {

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
					Stock frame = new Stock();
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
	public Stock() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ShowData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblX_1 = new JLabel("   -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblX_1.setBounds(521, 0, 35, 33);
		panel.add(lblX_1);
		
		JLabel lblX = new JLabel("   X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblX.setBounds(545, 0, 35, 33);
		panel.add(lblX);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setForeground(new Color(95, 158, 160));
		lblStock.setFont(new Font("Calibri", Font.BOLD, 28));
		lblStock.setBounds(256, 44, 63, 26);
		contentPane.add(lblStock);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 93, 521, 170);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(Stock.class.getResource("/IT20123840/Assets/Back.PNG")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SupplyHome sh = new SupplyHome();
				sh.frame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(new Color(240, 248, 255));
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnBack.setBackground(new Color(95, 158, 160));
		btnBack.setBounds(241, 288, 104, 37);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 580, 315);
		contentPane.add(label);
		setUndecorated(true);
		label.setIcon(new ImageIcon(Stock.class.getResource("/IT20123840/Assets/login.jpeg")));
		
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
	
}
