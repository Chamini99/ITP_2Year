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

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField txt_NIC;
	private JTextField txt_name;
	private JTextField txt_date;
	private JTextField pre_dose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignUpdate frame = new AssignUpdate();
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
	public AssignUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 579, 29);
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				StaffHome sh=new StaffHome();
				sh.setVisible(true);
			}
		});
		lblNewLabel.setBounds(557, 4, 11, 21);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(523, 11, 24, 6);
		panel.add(lblNewLabel_1);
		
		JLabel lblOrderId = new JLabel("NIC");
		lblOrderId.setForeground(new Color(95, 158, 160));
		lblOrderId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOrderId.setBounds(129, 119, 93, 14);
		contentPane.add(lblOrderId);
		
		JLabel lblNewLabel_4 = new JLabel("Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setBounds(129, 212, 69, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setBounds(129, 141, 107, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Type");
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(129, 243, 93, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Select Dose");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setForeground(new Color(220, 20, 60));
		lblNewLabel_6.setBounds(129, 180, 107, 14);
		contentPane.add(lblNewLabel_6);
		
		txt_NIC = new JTextField();
		txt_NIC.setBounds(244, 118, 133, 20);
		contentPane.add(txt_NIC);
		txt_NIC.setColumns(10);
		
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(112, 128, 144));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			    String NIC=txt_NIC.getText();

			    String query1 = "select * from tbl_peopledetails where NIC	='"+NIC+"'  ";
			    try (Statement stmt =  MyConnection.getConnection().createStatement()) {
			      ResultSet rs = stmt.executeQuery(query1);
			      while (rs.next()) {
				        String name=rs.getString("Name");
				        txt_name.setText(name);    
				        txt_date.setText("");
				       // cmb_type.setSelectedItem("Sinopharm");				        
			        }
			        
			       
			    } catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
				
			    
				
				
				
				
				
				
			}
		});
		btnSearch.setBounds(387, 117, 93, 23);
		contentPane.add(btnSearch);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(244, 148, 236, 20);
		contentPane.add(txt_name);
		
		
		JComboBox cmb_type = new JComboBox();
		cmb_type.setModel(new DefaultComboBoxModel(new String[] {"Sinopharm", "Astrazeneca Oxford", "Sputnik V", "Pfizer", "Moderna"}));
		cmb_type.setBackground(Color.WHITE);
		cmb_type.setBounds(244, 243, 180, 20);
		contentPane.add(cmb_type);
		
		
		
		
		
		JComboBox dose_cmb = new JComboBox();
		dose_cmb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				  txt_date.setText("");
				  	pre_dose.setText("");
			        cmb_type.setSelectedItem("Sinopharm");
			        
			        
			    	String dose=dose_cmb.getSelectedItem().toString();
				    String NIC=txt_NIC.getText();


					
					String query2 = "select * from tbl_vaccineassign where dose	='"+dose+"' AND  NIC ='"+NIC+"'  ";
				    try (Statement stmt =  MyConnection.getConnection().createStatement()) {
				      ResultSet rs = stmt.executeQuery(query2);
				      while (rs.next()) {
				    	
				    	  
					        String assign_date=rs.getString("assign_date");
					        String vaccine_type=rs.getString("vaccine_type");
					        String dose1=rs.getString("dose");

					        pre_dose.setText(dose1);
					        txt_date.setText(assign_date);
					        cmb_type.setSelectedItem(vaccine_type);
					        
				        }
				        
				       
				    } catch (SQLException sqlException) {
						sqlException.printStackTrace();
					}
				
			}
		});
		dose_cmb.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				
				
			}
		});
		dose_cmb.setBackground(new Color(255, 255, 255));
		dose_cmb.setModel(new DefaultComboBoxModel(new String[] {"1st Dose", "2nd Dose"}));
		dose_cmb.setBounds(244, 179, 133, 20);
		contentPane.add(dose_cmb);
		
		txt_date = new JTextField();
		txt_date.setColumns(10);
		txt_date.setBounds(244, 214, 133, 20);
		contentPane.add(txt_date);
		
		pre_dose = new JTextField();
		pre_dose.setVisible(false);
		pre_dose.setColumns(10);
		pre_dose.setBounds(436, 357, 133, 20);
		contentPane.add(pre_dose);
		
		JLabel lblAssignVaccineDates = new JLabel("Assign Vaccine Dates Update");
		lblAssignVaccineDates.setForeground(new Color(95, 158, 160));
		lblAssignVaccineDates.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAssignVaccineDates.setBounds(187, 60, 236, 29);
		contentPane.add(lblAssignVaccineDates);
		
		JButton btnNewButton = new JButton("Update Assign");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String NIC=txt_NIC.getText();
				   String Vaccine_type=cmb_type.getSelectedItem().toString();
				   String assign_date=txt_date.getText();
				   String dose=dose_cmb.getSelectedItem().toString();
				   String predose=pre_dose.getText();

				try{  
					 
					Statement st=MyConnection.getConnection().createStatement();  
					//int mark = Integer.parseInt(str3); // Mark is an integer
					// Adding record 
					String query1="UPDATE tbl_vaccineassign SET vaccine_type='"+Vaccine_type+"' ,assign_date='"+assign_date+"' WHERE NIC='" +NIC+"' AND dose='" +predose+"' ";
							
					st.executeUpdate(query1); // record added. 
					
					JOptionPane.showMessageDialog(null, "Assignment of Vaccine updated successfully");
					dispose();
					assign_details details = new assign_details();
					details.setVisible(true);
					//con.close();  
					
				}catch(SQLException sqlException){
					JOptionPane.showMessageDialog(null," Something Went Wrong");
					sqlException.printStackTrace();} 
				
				
				
			}
		});
		
	
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setBounds(227, 292, 117, 23);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 27, 579, 373);
		contentPane.add(lblNewLabel_2);
		setUndecorated(true);
		
		lblNewLabel_2.setIcon(new ImageIcon(AssignUpdate.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_2);
		 
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		 JLabel lblAssign = new JLabel("Assign ");
		 lblAssign.setBounds(241, 69, 46, 14);
		 contentPane.add(lblAssign);
		
	}
}
