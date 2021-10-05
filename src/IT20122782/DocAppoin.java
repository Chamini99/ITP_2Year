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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DocAppoin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	Connection con = null;
	PreparedStatement prestmt = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocAppoin frame = new DocAppoin();
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
	public DocAppoin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("My Appoinments");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(292, 48, 188, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocHome m = new DocHome();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(34, 486, 113, 35);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 771, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(728, 13, 19, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("-");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(704, 11, 19, 16);
		panel.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 173, 452, 283);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnprint = new JButton("Print Report");
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header = new MessageFormat("Details Of Appoinments");
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, null);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Cannot be print!");
				}
			}
		});
		btnprint.setForeground(Color.WHITE);
		btnprint.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnprint.setBackground(new Color(95, 158, 160));
		btnprint.setBounds(542, 486, 170, 35);
		contentPane.add(btnprint);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DocLogin.class.getResource("/IT20122782/Image/login.jpeg")));
		lblNewLabel_2.setBounds(0, 36, 771, 515);
		contentPane.add(lblNewLabel_2);
		
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
   	 model.addColumn("Name");
   	 model.addColumn("Age");
   	 model.addColumn("Gender");
   	 model.addColumn("Reason");
   	 
   	 try {
   		 String query = "select * from tb_people";
   		 Statement st = con.createStatement();
   		 ResultSet rs = st.executeQuery(query);
   		 while(rs.next()) {
   			 model.addRow(new Object[] {
   				 rs.getString("id"),	 
   				 rs.getString("name"),
   				 rs.getString("age"),
   				 rs.getString("gender"),
   				 rs.getString("reason"),
   				 
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
   		 table.getColumnModel().getColumn(3).setPreferredWidth(100);
   		 table.getColumnModel().getColumn(4).setPreferredWidth(150);
   		 
   		 
   	 }catch(Exception e){
   		 System.out.println("Error" +e);
   	 }
		}
}
