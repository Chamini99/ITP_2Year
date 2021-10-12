package IT20198886;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class assign_dates extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField t1;
	private JTextField textField_1;
	private JTextField textField_2;
//test
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					assign_dates frame = new assign_dates();
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
	public assign_dates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 686, 31);
		panel.setBackground(new Color(95, 158, 160));
		panel.setForeground(new Color(0, 0, 0));
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
		lblNewLabel.setBounds(665, 11, 21, 14);
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
		lblNewLabel_1.setBounds(642, 11, 16, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("Assign Vaccine Date");
		lblNewLabel_3.setBounds(275, 32, 214, 25);
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 19));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Registered Date");
		lblNewLabel_4.setBounds(412, 87, 120, 21);
		lblNewLabel_4.setFont(new Font("Dialog", Font.ITALIC, 16));
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NIC");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setBounds(155, 239, 63, 25);
		contentPane.add(lblNewLabel_5);
		
		t1 = new JTextField();
		t1.setBounds(341, 244, 148, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Vaccine Date");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_6.setForeground(new Color(95, 158, 160));
		lblNewLabel_6.setBounds(155, 285, 126, 25);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Vaccine Type");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_7.setForeground(new Color(95, 158, 160));
		lblNewLabel_7.setBounds(155, 321, 126, 25);
		contentPane.add(lblNewLabel_7);
		
		JComboBox cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"Astrazeneca Oxford", "Sputnik V", "Pfizer", "Moderna"}));
		cb.setBounds(341, 326, 148, 20);
		contentPane.add(cb);
		
		JLabel lblNewLabel_8 = new JLabel("Dose");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_8.setForeground(new Color(95, 158, 160));
		lblNewLabel_8.setBounds(155, 371, 63, 14);
		contentPane.add(lblNewLabel_8);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1st Dose", "2nd Dose"}));
		comboBox_1.setBounds(341, 371, 148, 20);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String NIC=t1.getText();
				   String Vaccine_type=cb.getSelectedItem().toString();
				   String assign_date=textField_2.getText();
				   String dose=comboBox_1.getSelectedItem().toString();
				  
					
					
					// creating one object 
				//	my_update obj=new my_update();
				//	obj.my_db_update(Full_name,NIC,Gender,Age,Email,Password );
					
					try{  
						 
						Statement st=MyConnection.getConnection().createStatement();  
						//int mark = Integer.parseInt(str3); // Mark is an integer
						// Adding record 
						String query1="INSERT INTO tbl_vaccineassign (NIC,vaccine_type,assign_date,dose)"
								+ "VALUES('" +NIC+"','"+Vaccine_type+"','"+assign_date+"','"+dose+"')";
						st.executeUpdate(query1); // record added. 
						
						JOptionPane.showMessageDialog(null, "Date added successfully");
						dispose();
						assign_details details = new assign_details();
						details.setVisible(true);
						//con.close();  
						
					}catch(SQLException sqlException){
						JOptionPane.showMessageDialog(null," Something Went Wrong");
						sqlException.printStackTrace();} 
						//////////////////////////////
					
					
				

				
				
			}
			
			
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				assign_details  dates=new assign_details();
				dates.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setBounds(275, 418, 89, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(34, 118, 620, 90);
		contentPane.add(table);
		
		textField_1 = new JTextField();
		
		textField_1.addKeyListener(new KeyAdapter() {
			Connection con=MyConnection.getConnection();
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					
					String query="select * from tbl_peopledetails where Registered_date=? ";
					java.sql.PreparedStatement pst =con.prepareStatement(query);
					pst.setString(1,textField_1.getText());
					 ResultSet rs=pst.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 pst.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		textField_1.setBounds(546, 90, 130, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(341, 290, 148, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(-25, 32, 711, 445);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_2.setIcon(new ImageIcon(assign_dates.class.getResource("/IT20198886/Assets/login.jpeg")));
		contentPane.add(lblNewLabel_2);
		

		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
