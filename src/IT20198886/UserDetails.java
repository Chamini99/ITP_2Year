package IT20198886;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
public class UserDetails extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDetails frame = new UserDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	
	private JTable table_2;
	/**
	 * Create the frame.
	 */
	public UserDetails()  {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ShowData();
			}
		});
		connection=MyConnection.dbconn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 703, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				StaffHome home=new StaffHome();
				home.setVisible(true);
			}
		});
		lblNewLabel.setBounds(682, 11, 11, 21);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_1.setBounds(660, 14, 22, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("User Details");
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNewLabel_3.setBounds(266, 48, 132, 25);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 683, 259);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		
		JButton btnNewButton = new JButton("Assign Vaccine Date");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				assign_dates dates=new assign_dates();
				dates.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(249, 376, 194, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("NIC to Search");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setBounds(450, 87, 109, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 31, 703, 379);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(UserDetails.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_2);
		 
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
	private void ShowData() {
		Connection con=MyConnection.getConnection();
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("people_id");
		model.addColumn("NIC");
		model.addColumn("Name");
		model.addColumn("Registered_date");
		model.addColumn("Age");
		model.addColumn("Gender");
		model.addColumn("Email");
		

		try {
			String query="select * from tbl_Peopledetails";
			Statement st = con.createStatement();
			ResultSet rs  =st . executeQuery(query);
			while (rs.next())
			{
				model.addRow(new Object[] {
						rs.getInt("people_id"),
						rs.getString("NIC"),
						rs.getString("Name"),
						rs.getDate("Registered_date"),
						rs.getInt("Age"),
						rs.getString("Gender"),
						rs.getString("Email"),
						

						
				});
				
			}
			rs.close();
			st.close();
		
			
			table_2.setModel(model);
			table_2.setAutoResizeMode(0);
			table_2.getColumnModel().getColumn(0).setPreferredWidth(60);
			table_2.getColumnModel().getColumn(1).setPreferredWidth(120);
			table_2.getColumnModel().getColumn(2).setPreferredWidth(140);
			table_2.getColumnModel().getColumn(3).setPreferredWidth(100);
			table_2.getColumnModel().getColumn(4).setPreferredWidth(60);
			table_2.getColumnModel().getColumn(5).setPreferredWidth(80);
			table_2.getColumnModel().getColumn(6).setPreferredWidth(120);
			

			
			
		} catch (Exception e) {
			System.out.println("error " +e);
		}

	}
}
