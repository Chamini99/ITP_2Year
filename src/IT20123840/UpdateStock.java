package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateStock extends JFrame {

	private JPanel contentPane;
	private JTextField txt_vaccineName;
	private JTextField txt_expireDate;
	private JTextField txt_price;
	private JTextField txt_quantity;
	private JTextField txt_vaccineID;
	private JTextField txt_companyID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStock frame = new UpdateStock();
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
	public UpdateStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 450, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblX.setBounds(424, 0, 26, 33);
		panel.add(lblX);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX_1 = new JLabel("  -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX_1.setBounds(401, 0, 26, 33);
		panel.add(lblX_1);
		
		JLabel lblUpdateVaccineDetails = new JLabel("Update Vaccine Details");
		lblUpdateVaccineDetails.setForeground(new Color(95, 158, 160));
		lblUpdateVaccineDetails.setFont(new Font("Calibri", Font.BOLD, 24));
		lblUpdateVaccineDetails.setBounds(110, 44, 230, 30);
		contentPane.add(lblUpdateVaccineDetails);
		
		JLabel lblCompanyID = new JLabel("Company ID");
		lblCompanyID.setForeground(new Color(95, 158, 160));
		lblCompanyID.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCompanyID.setBounds(75, 389, 102, 20);
		contentPane.add(lblCompanyID);
		
		JLabel lblVaccineName = new JLabel("Vaccine Name");
		lblVaccineName.setForeground(new Color(95, 158, 160));
		lblVaccineName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVaccineName.setBounds(75, 265, 102, 20);
		contentPane.add(lblVaccineName);
		
		JLabel lblExpireDate = new JLabel("Expire Date");
		lblExpireDate.setForeground(new Color(95, 158, 160));
		lblExpireDate.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblExpireDate.setBounds(75, 296, 75, 20);
		contentPane.add(lblExpireDate);
		
		JLabel lblPricers = new JLabel("Price (Rs)");
		lblPricers.setForeground(new Color(95, 158, 160));
		lblPricers.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPricers.setBounds(75, 327, 62, 20);
		contentPane.add(lblPricers);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(95, 158, 160));
		lblQuantity.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblQuantity.setBounds(75, 358, 56, 20);
		contentPane.add(lblQuantity);
		
		txt_companyID = new JTextField();
		txt_companyID.setBounds(243, 389, 132, 20);
		contentPane.add(txt_companyID);
		txt_companyID.setColumns(10);
		
		txt_vaccineName = new JTextField();
		txt_vaccineName.setColumns(10);
		txt_vaccineName.setBounds(243, 265, 132, 20);
		contentPane.add(txt_vaccineName);
		
		txt_expireDate = new JTextField();
		txt_expireDate.setColumns(10);
		txt_expireDate.setBounds(243, 296, 132, 20);
		contentPane.add(txt_expireDate);
		
		txt_price = new JTextField();
		txt_price.setColumns(10);
		txt_price.setBounds(243, 327, 132, 20);
		contentPane.add(txt_price);
		
		txt_quantity = new JTextField();
		txt_quantity.setColumns(10);
		txt_quantity.setBounds(243, 358, 132, 20);
		contentPane.add(txt_quantity);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vaccine_name = txt_vaccineName.getText();
				String expire_date = txt_expireDate.getText();
				String s_price = txt_price.getText();
				String s_quantity = txt_quantity.getText();
				String company_id = txt_companyID.getText();
				
				if (txt_vaccineName.getText().isEmpty() || txt_expireDate.getText().isEmpty() || txt_price.getText().isEmpty() || txt_quantity.getText().isEmpty() || txt_companyID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnUpdate, "Please fill all fields");
				}
				
				else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
	
							String query = "update tbl_companystock set vaccine_name = '"+txt_vaccineName.getText()+"', expire_date = '"+txt_expireDate.getText()+"', s_price = '"+txt_price.getText()+"', s_quantity = '"+txt_quantity.getText()+"', company_id = '"+txt_companyID.getText()+"' where vaccine_id = '"+txt_vaccineID.getText()+"'";
							Statement stmt = connection.createStatement();
							int x = stmt.executeUpdate(query);
						
							JOptionPane.showConfirmDialog(btnUpdate, "The vaccine has been updated successfully!!!");
							EditStock es = new EditStock();
							es.setVisible(true);
							setVisible(false);
						
						connection.close();
					}
					catch (Exception exception) {
						exception.printStackTrace();
					}
					
				}
			}
		});
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditStock es = new EditStock();
				es.setVisible(true);
				setVisible(false);
			}
		});
		btnUpdate.setBackground(new Color(95, 158, 160));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnUpdate.setBounds(75, 444, 102, 33);
		contentPane.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_vaccineID.setText(" ");
				txt_vaccineName.setText(" ");
				txt_expireDate.setText(" ");
				txt_price.setText(" ");
				txt_quantity.setText(" ");
				txt_companyID.setText(" ");
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnReset.setBackground(new Color(95, 158, 160));
		btnReset.setBounds(273, 444, 102, 33);
		contentPane.add(btnReset);
		
		txt_vaccineID = new JTextField();
		txt_vaccineID.setBounds(181, 99, 86, 20);
		contentPane.add(txt_vaccineID);
		txt_vaccineID.setColumns(10);
		
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnView.setBackground(new Color(95, 158, 160));
		btnView.setForeground(new Color(240, 248, 255));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
					Statement stmt = connection.createStatement();
					String query = "select vaccine_name, expire_date, s_price, s_quantity,company_id from tbl_companystock where vaccine_id = '"+txt_vaccineID.getText()+"'";
					ResultSet rs = stmt.executeQuery(query);
					
					if (rs.next()) {
						String vaccineName = rs.getString(1);
						String expireDate = rs.getString(2);
						String price = rs.getString(3);
						String quantity = rs.getString(4);
						String companyID = rs.getString(5);
						
						txt_vaccineName.setText(vaccineName);
						txt_expireDate.setText(expireDate);
						txt_price.setText(price);
						txt_quantity.setText(quantity);
						txt_companyID.setText(companyID);
					}
					else {
						JOptionPane.showMessageDialog(txt_vaccineID, "Vaccine ID not found");
						txt_vaccineID.setText(null);
					}
					
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnView.setBounds(300, 97, 75, 23);
		contentPane.add(btnView);
		
		JLabel lblVaccineId = new JLabel("Vaccine ID");
		lblVaccineId.setForeground(new Color(95, 158, 160));
		lblVaccineId.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVaccineId.setBounds(75, 99, 75, 20);
		contentPane.add(lblVaccineId);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(140, 146, 177, 94);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(UpdateStock.class.getResource("/IT20123840/Assets/Vaccine04.PNG")));
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 450, 472);
		contentPane.add(label);
		label.setIcon(new ImageIcon(UpdateStock.class.getResource("/IT20123840/Assets/login.jpeg")));
		setUndecorated(true);
	}
}
