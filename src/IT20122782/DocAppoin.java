package IT20122782;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
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
import javax.swing.RowFilter;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DocAppoin extends JFrame {

	private JPanel contentPane;
	private JTable tb;
	
	
	Connection con = null;
	PreparedStatement prestmt = null;
	ResultSet rs = null;
	private JTextField txtsearch;

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
		
		JLabel lblappoinment = new JLabel("My Appoinments");
		lblappoinment.setForeground(new Color(95, 158, 160));
		lblappoinment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblappoinment.setBounds(292, 48, 188, 35);
		contentPane.add(lblappoinment);
		
		JButton btnback = new JButton("< Back");
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocHome m = new DocHome();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnback.setBackground(new Color(95, 158, 160));
		btnback.setForeground(Color.WHITE);
		btnback.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnback.setBounds(34, 486, 113, 35);
		contentPane.add(btnback);
		
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
		
		tb = new JTable();
		scrollPane.setViewportView(tb);
		
		JButton btnprint = new JButton("Print Report");
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header = new MessageFormat("Details Of Appoinments");
				try {
					tb.print(JTable.PrintMode.FIT_WIDTH, header, null);
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
		
		JLabel lbsearch = new JLabel("Search");
		lbsearch.setForeground(new Color(0, 51, 204));
		lbsearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbsearch.setBounds(34, 121, 84, 16);
		contentPane.add(lbsearch);
		
		txtsearch = new JTextField();
		txtsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DefaultTableModel table = (DefaultTableModel)tb.getModel();
				String search = txtsearch.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
				tb.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		txtsearch.setBounds(115, 119, 150, 22);
		contentPane.add(txtsearch);
		txtsearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DocLogin.class.getResource("/IT20122782/Image/login.jpeg")));
		lblNewLabel.setBounds(0, 35, 771, 536);
		contentPane.add(lblNewLabel);
		
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
   		 
   		 tb.setModel(model);
   		 tb.setAutoResizeMode(0);
   		 tb.getColumnModel().getColumn(0).setPreferredWidth(40);
   		 tb.getColumnModel().getColumn(1).setPreferredWidth(100);
   		 tb.getColumnModel().getColumn(2).setPreferredWidth(100);
   		 tb.getColumnModel().getColumn(3).setPreferredWidth(100);
   		 tb.getColumnModel().getColumn(4).setPreferredWidth(150);
   		 
   		 
   	 }catch(Exception e){
   		 System.out.println("Error" +e);
   	 }
		}
}
