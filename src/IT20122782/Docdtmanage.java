package IT20122782;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Docdtmanage extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane;
	private JLabel lb_id;
	private JLabel lb_day;
	private JLabel lb_date;
	private JLabel lb_time;
	private JTextField txtid;
	private JTextField txtday;
	private JTextField txtdate;
	private JTextField txttime;
	private JTable table;
	private JLabel lblNewLabel_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Docdtmanage frame = new Docdtmanage();
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
	public Docdtmanage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Date & Time Management");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(191, 54, 262, 25);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 103, 431, 326);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String doctorid = table.getValueAt(table.getSelectedRow(), 0).toString();
				SetTextField(doctorid);
			}
		});
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("< Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocHome m = new DocHome();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(41, 458, 111, 44);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 800, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(758, 13, 30, 16);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(735, 13, 30, 16);
		panel.add(lblNewLabel_2);
		
		lb_id = new JLabel("ID");
		lb_id.setForeground(new Color(0, 51, 204));
		lb_id.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_id.setBounds(539, 111, 56, 16);
		contentPane.add(lb_id);
		
		lb_day = new JLabel("DAY");
		lb_day.setForeground(new Color(0, 51, 204));
		lb_day.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_day.setBounds(539, 149, 56, 16);
		contentPane.add(lb_day);
		
		lb_date = new JLabel("Date");
		lb_date.setForeground(new Color(0, 51, 204));
		lb_date.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_date.setBounds(539, 182, 56, 16);
		contentPane.add(lb_date);
		
		lb_time = new JLabel("Time");
		lb_time.setForeground(new Color(0, 51, 204));
		lb_time.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_time.setBounds(539, 221, 56, 16);
		contentPane.add(lb_time);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtid.setBounds(607, 109, 181, 22);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtday = new JTextField();
		txtday.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtday.setColumns(10);
		txtday.setBounds(607, 147, 181, 22);
		contentPane.add(txtday);
		
		txtdate = new JTextField();
		txtdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtdate.setColumns(10);
		txtdate.setBounds(607, 180, 181, 22);
		contentPane.add(txtdate);
		
		txttime = new JTextField();
		txttime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txttime.setColumns(10);
		txttime.setBounds(607, 219, 181, 22);
		contentPane.add(txttime);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() >= 0) {
					Update(txtid.getText());
				}
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate.setBackground(new Color(95, 158, 160));
		btnUpdate.setBounds(607, 313, 111, 44);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() >= 0) {
					Delete(txtid.getText());
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBackground(new Color(95, 158, 160));
		btnDelete.setBounds(607, 385, 111, 44);
		contentPane.add(btnDelete);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon((DocLogin.class.getResource("/IT20122782/Image/login.jpeg"))));
		lblNewLabel_3.setBounds(0, 34, 800, 501);
		contentPane.add(lblNewLabel_3);
		
		ShowData();
	}
	
	static Connection con () {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost/db_doctor";
			Class.forName(driver);
			return DriverManager.getConnection(url,"root","");
		}catch(Exception e){
			System.out.println("Connection Failed!" +e);
		}
		return null;
	}
	private void ShowData() {
   	 Connection con = con ();
   	 DefaultTableModel model = new DefaultTableModel();
   	 model.addColumn("ID");
   	 model.addColumn("Day");
   	 model.addColumn("Date");
   	 model.addColumn("Time");
   	 
   	 try {
   		 String query = "select * from tb_manage";
   		 Statement st = con.createStatement();
   		 ResultSet rs = st.executeQuery(query);
   		 while(rs.next()) {
   			 model.addRow(new Object[] {
   				 rs.getString("doctorid"),	 
   				 rs.getString("day"),
   				 rs.getString("date"),
   				 rs.getString("time"),
   			}
   					 );
   		 }
   		 rs.close();
   		 st.close();
   		 con.close();
   		 
   		 table.setModel(model);
   		 table.setAutoResizeMode(0);
   		 table.getColumnModel().getColumn(0).setPreferredWidth(40);
   		 table.getColumnModel().getColumn(1).setPreferredWidth(100);
   		 table.getColumnModel().getColumn(2).setPreferredWidth(100);
   		 table.getColumnModel().getColumn(3).setPreferredWidth(200);
   		 
   		 
   		 
   	 }catch(Exception e){
   		 System.out.println("Error" +e);
   	 }
		}
	
	private void SetTextField(String doctorid) {
		 Connection con = con();
		 try {
			 String Query = "select * from tb_manage where doctorid = ?";
			 PreparedStatement ps = con.prepareStatement(Query);
			 ps.setString(1, doctorid);
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()) {
				 txtid.setText(rs.getString("doctorid"));
				 txtday.setText(rs.getString("day"));
				 txtdate.setText(rs.getString("date"));
				 txttime.setText(rs.getString("time"));
				 
			 }
			 rs.close();
			 ps.close();
			 con.close();
			 
		 }catch(Exception e){
			 System.out.println("Error" +e);
		 }
	 }
	
	private void Update(String doctorid) {
		 Connection con = con();
		 try {
			 String query = "update tb_manage set day = ?, date = ?, time = ? where doctorid = ?";
			 PreparedStatement ps = con.prepareStatement(query);
			 ps.setString(1,txtday.getText());
			 ps.setString(2,txtdate.getText());
			 ps.setString(3, txttime.getText());
			 ps.setString(4, doctorid);
			 ps.execute();
			 ps.close();
			 con.close();
			 
			 JOptionPane.showMessageDialog(null, "Update successful");
			 ShowData();
		 }catch(Exception e){
			 System.out.println("Error" +e);
		 }
	 }
	
	private void Delete(String doctorid) {
		Connection con = con();
		try {
			String query = "delete from tb_manage where doctorid = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, doctorid);
			ps.execute();
			ps.close();
			con.close();
			 
			 JOptionPane.showMessageDialog(null, "Delete successful");
			 ShowData();
		}catch(Exception e){
			System.out.println("Error" +e);
			
		}
	}
}
