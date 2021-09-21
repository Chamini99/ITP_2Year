package IT20198886;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class OrderVaccine extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ammount;
	private JTextField txt_cardName;
	private JTextField txt_cvv;
	private JTextField txt_acnumber;
	private JTextField txt_exdate;
	private JTextField txt_supID;
	protected JLabel lblNewLabel_acc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderVaccine frame = new OrderVaccine();
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
	public OrderVaccine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setVisible(false);
		
		txt_supID = new JTextField();
		txt_supID.setVisible(false);
		txt_supID.setBounds(228, 74, 86, 20);
		contentPane.add(txt_supID);
		txt_supID.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(228, 258, 129, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Moderna", "Sinopharm", "Pfizer", "Sputnic"}));
		comboBox.setBounds(228, 202, 129, 20);
		contentPane.add(comboBox);
		panel_1.setBounds(384, 69, 342, 392);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		try {  
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  

			//Connection conn= DriverManager.getConnection("jdbc:odbc:driverName");  
			Statement st = MyConnection.getConnection().createStatement();

			 ResultSet r=st.executeQuery("select * from tbl_supplycompany");

			 while (r.next()) {  

				 comboBox_1.addItem(r.getString("company_name"));  
			 }


			   // conn.close();
			    } catch (Exception e) {  
			JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
			System.exit(0);  
			}  
		
		
		txt_cardName = new JTextField();
		txt_cardName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txt_cardName.setColumns(10);
		txt_cardName.setBounds(197, 181, 132, 26);
		panel_1.add(txt_cardName);
		
		txt_cvv = new JTextField();
		txt_cvv.setColumns(10);
		txt_cvv.setBounds(197, 218, 132, 26);
		panel_1.add(txt_cvv);
		
		txt_acnumber = new JTextField();
		txt_acnumber.setColumns(10);
		txt_acnumber.setBounds(197, 266, 132, 26);
		panel_1.add(txt_acnumber);
		
		txt_acnumber.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = txt_acnumber.getText();
	            int l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	txt_acnumber.setVisible(true);
	            	lblNewLabel_acc.setText("");
	            } else {
	            	txt_acnumber.setVisible(true);
	               JOptionPane.showMessageDialog(null, " Enter Numaric value only");
	            }
	         }
	      });
		
		txt_exdate = new JTextField();
		txt_exdate.setColumns(10);
		txt_exdate.setBounds(197, 305, 132, 26);
		panel_1.add(txt_exdate);
		
		JLabel lblNewLabel_9 = new JLabel("Expire Date");
		lblNewLabel_9.setForeground(new Color(95, 158, 160));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_9.setBounds(16, 299, 125, 27);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_acc = new JLabel("Account Number");
		lblNewLabel_acc.setForeground(new Color(95, 158, 160));
		lblNewLabel_acc.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_acc.setBounds(16, 266, 149, 14);
		panel_1.add(lblNewLabel_acc);
		
		
		JLabel lblNewLabel_7 = new JLabel("CVV");
		lblNewLabel_7.setForeground(new Color(95, 158, 160));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setBounds(16, 230, 46, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Card holder's name");
		lblNewLabel_6.setForeground(new Color(95, 158, 160));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(11, 187, 165, 21);
		panel_1.add(lblNewLabel_6);
		
	
		
		JLabel lblNewLabel_4_1 = new JLabel("Total Amount");
		lblNewLabel_4_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_4_1.setBounds(33, 81, 131, 14);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Pay for vaccines");
		lblNewLabel_3_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNewLabel_3_1.setBounds(95, 11, 180, 31);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lbl_pricepay = new JLabel("2500");
		lbl_pricepay.setForeground(new Color(255, 0, 0));
		lbl_pricepay.setFont(new Font("Dialog", Font.PLAIN, 17));
		lbl_pricepay.setBounds(198, 81, 131, 14);
		panel_1.add(lbl_pricepay);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 746, 31);
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
		lblNewLabel.setBounds(709, 11, 17, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_1.setBounds(682, 11, 17, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JButton btn_Continue = new JButton("Continue");
		btn_Continue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
//				
				
				
				String comName=comboBox_1.getSelectedItem().toString();
				String vacType=comboBox.getSelectedItem().toString();
				String Amount=txt_ammount.getText();
				int amountint = Integer.parseInt(Amount);

				
				String query = "select * from tbl_supplycompany where company_name='"+comName+"' ";
			    try (Statement stmt =  MyConnection.getConnection().createStatement()) {
			      ResultSet rs = stmt.executeQuery(query);
			      while (rs.next()) {
			        int supplierID = rs.getInt("company_id");
			        String supId=String.valueOf(supplierID);
			       txt_supID.setText(supId);
			        //System.out.println(supplierID);
			 
			      }
			    } catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
				
				
			
			    
			    String supIDVac=txt_supID.getText();
			    
			    String query3 = "select COUNT(*) AS rowcount from tbl_companystock where company_id	='"+supIDVac+"' AND vaccine_name ='"+vacType+"' ";
			    try (Statement stmt =  MyConnection.getConnection().createStatement()) {
			      ResultSet rs = stmt.executeQuery(query3);
			      while (rs.next()) {
			    	  int count = rs.getInt("rowcount") ;
			    	 // System.out.println("MyTable has " + count + " row(s).");
			    	  
			    	  if(count==0) {
				        	JOptionPane.showMessageDialog(null, "No "+vacType+" Stocks Availble On" +comName);

			    	  }
			    	  
			      }
			    } catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			    
			    
			    
			    
			    String query1 = "select * from tbl_companystock where company_id	='"+supIDVac+"' AND vaccine_name ='"+vacType+"' ";
			    try (Statement stmt =  MyConnection.getConnection().createStatement()) {
			      ResultSet rs = stmt.executeQuery(query1);
			      while (rs.next()) {
			        double supplierPrice = rs.getDouble("s_price");
			        int qty=rs.getInt("s_quantity");
			        int company_id=rs.getInt("company_id");
			        String company_idint=String.valueOf(company_id);
			       
			        	 if(qty<amountint) {
								JOptionPane.showMessageDialog(null, "Stock Not Available.Only having "+qty+" Stocks");
					        }else {
					        	 double total=supplierPrice*amountint;
							        
							        String supPrice=String.valueOf(total);
							       lbl_pricepay.setText(supPrice);
							       panel_1.setVisible(true);
					        }
					        
					        double total=supplierPrice*amountint;
					        
					        String supPrice=String.valueOf(total);
					       lbl_pricepay.setText(supPrice);
					      // System.out.println(total);
					        
					      
			        }
			        
			       
			    } catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		btn_Continue.setBackground(new Color(95, 158, 160));
		btn_Continue.setFont(new Font("Dialog", Font.BOLD, 16));
		btn_Continue.setForeground(new Color(255, 255, 255));
		btn_Continue.setBounds(143, 388, 117, 27);
		contentPane.add(btn_Continue);
		setUndecorated(true);
		 
		 JLabel lblNewLabel_3 = new JLabel("Request Vaccine");
		 lblNewLabel_3.setForeground(new Color(95, 158, 160));
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel_3.setBounds(135, 138, 155, 27);
		 contentPane.add(lblNewLabel_3);
		 
		 JLabel lblNewLabel_4 = new JLabel("Vaccine Type");
		 lblNewLabel_4.setForeground(new Color(95, 158, 160));
		 lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel_4.setBounds(37, 196, 129, 27);
		 contentPane.add(lblNewLabel_4);
		 
		 JLabel lblSupplyCompany = new JLabel("Supply Company");
		 lblSupplyCompany.setForeground(new Color(95, 158, 160));
		 lblSupplyCompany.setFont(new Font("Dialog", Font.BOLD, 17));
		 lblSupplyCompany.setBounds(37, 252, 140, 27);
		 contentPane.add(lblSupplyCompany);
		 
		 JLabel lblVaccineAmount = new JLabel("Vaccine Amount");
		 lblVaccineAmount.setForeground(new Color(95, 158, 160));
		 lblVaccineAmount.setFont(new Font("Dialog", Font.BOLD, 17));
		 lblVaccineAmount.setBounds(37, 305, 155, 27);
		 contentPane.add(lblVaccineAmount);
		 
		 txt_ammount = new JTextField();
		 txt_ammount.setColumns(10);
		 txt_ammount.setBounds(228, 311, 129, 27);
		 contentPane.add(txt_ammount);
		 
		 JLabel lblNewLabel_2 = new JLabel("New label");
		 lblNewLabel_2.setBounds(0, 33, 736, 452);
		 contentPane.add(lblNewLabel_2);
		 
		 
		 JButton btn_Submit = new JButton("Confirm");
		 btn_Submit.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	}
		 });
			btn_Submit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					String vType=comboBox.getSelectedItem().toString();
					String supComanpy=comboBox_1.getSelectedItem().toString();
					String amount=txt_ammount.getText();
					String deliverDate="N/A";
					String price=lbl_pricepay.getText();
					String nameCard=txt_cardName.getText();
					String acnumberc=txt_acnumber.getText();
					String cvv=txt_cvv.getText();
					String expiredt=txt_exdate.getText();
					String supStatus="Pending";
					String DelStatus="Pending";
					float pricefloat=Float.parseFloat(price); 
					int amountint = Integer.parseInt(amount);
					//int acNo= Integer.parseInt(acnumberc);
					try{  
						 
						Statement st=MyConnection.getConnection().createStatement();  
						//int mark = Integer.parseInt(str3); // Mark is an integer
						// Adding record 
						String query1="INSERT INTO tbl_vaccineorder (vaccine_type,supply_company, amount,price,cardholder_name,	card_number,supplier_status,delivery_status)"
								+ "VALUES('" +vType+"','"+supComanpy+"',"+amountint+",'"+pricefloat+"','"+nameCard+"','"+acnumberc+"','"+supStatus+"','"+DelStatus+"')";
						st.executeUpdate(query1); // record added. 
						
						JOptionPane.showMessageDialog(null, "Order Request Added Successfully");
						dispose();
						StaffHome home = new StaffHome();
						home.setVisible(true);
						//con.close();  
						
					}catch(SQLException sqlException){
						JOptionPane.showMessageDialog(null," Something Went Wrong");
						sqlException.printStackTrace();} 
						//////////////////////////////
					
					
				}
				
			});
			btn_Submit.setInheritsPopupMenu(true);
			btn_Submit.setForeground(Color.WHITE);
			btn_Submit.setFont(new Font("Tahoma", Font.BOLD, 16));
			btn_Submit.setBackground(new Color(95, 158, 160));
			btn_Submit.setBounds(124, 358, 125, 23);
			panel_1.add(btn_Submit);
			
		 lblNewLabel_2.setIcon(new ImageIcon(OrderVaccine.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_2);
	  
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
}
