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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddVaccine extends JFrame {

	private JPanel contentPane;
	private JTextField vaccineName;
	private JTextField expireDate;
	private JTextField price;
	private JTextField quantity;
	private JTextField companyID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVaccine frame = new AddVaccine();
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
	public AddVaccine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 348);
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
		lblX.setBounds(423, 0, 27, 33);
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
		lblX_1.setBounds(402, 0, 27, 33);
		panel.add(lblX_1);
		
		JLabel lblAddNewVaccine = new JLabel("Add New Vaccine");
		lblAddNewVaccine.setForeground(new Color(95, 158, 160));
		lblAddNewVaccine.setFont(new Font("Calibri", Font.BOLD, 28));
		lblAddNewVaccine.setBounds(127, 44, 203, 26);
		contentPane.add(lblAddNewVaccine);
		
		JLabel lblVaccineName = new JLabel("Vaccine Name");
		lblVaccineName.setForeground(new Color(95, 158, 160));
		lblVaccineName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVaccineName.setBounds(80, 106, 102, 20);
		contentPane.add(lblVaccineName);
		
		JLabel lblExpireDate = new JLabel("Expire Date");
		lblExpireDate.setForeground(new Color(95, 158, 160));
		lblExpireDate.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblExpireDate.setBounds(80, 137, 75, 20);
		contentPane.add(lblExpireDate);
		
		JLabel lblPricers = new JLabel("Price (Rs)");
		lblPricers.setForeground(new Color(95, 158, 160));
		lblPricers.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPricers.setBounds(80, 168, 62, 20);
		contentPane.add(lblPricers);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(95, 158, 160));
		lblQuantity.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblQuantity.setBounds(80, 199, 56, 20);
		contentPane.add(lblQuantity);
		
		vaccineName = new JTextField();
		vaccineName.setColumns(10);
		vaccineName.setBounds(242, 106, 132, 20);
		contentPane.add(vaccineName);
		
		expireDate = new JTextField();
		expireDate.setColumns(10);
		expireDate.setBounds(242, 137, 132, 20);
		contentPane.add(expireDate);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(242, 168, 132, 20);
		contentPane.add(price);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(242, 199, 132, 20);
		contentPane.add(quantity);
		
		companyID = new JTextField();
		companyID.setColumns(10);
		companyID.setBounds(242, 230, 132, 20);
		contentPane.add(companyID);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vaccine_name = vaccineName.getText();
				String expire_date = expireDate.getText();
				String s_price = price.getText();
				String s_quantity = quantity.getText();
				String company_id = companyID.getText();
				
				if (vaccineName.getText().isEmpty() || expireDate.getText().isEmpty() ||price.getText().isEmpty() || quantity.getText().isEmpty() || companyID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnAdd, "Please fill all fields");
				}
				
				else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
						
						String query1 = "select * from tbl_companystock where vaccine_name = '"+vaccineName+"' ";
						Statement stmt1 = connection.createStatement();
						ResultSet rs = stmt1.executeQuery(query1);
						
						if (rs.next()) {
							JOptionPane.showConfirmDialog(btnAdd, "This vaccine is already exist");
							
						}
						else {
							String query = "insert into tbl_companystock (vaccine_name, expire_date, s_price, s_quantity, company_id) values ('"+vaccine_name+"', '"+expire_date+"', '"+s_price+"', '"+s_quantity+"', '"+company_id+"')";
						
							Statement stmt = connection.createStatement();
							int x = stmt.executeUpdate(query);
						
							JOptionPane.showConfirmDialog(btnAdd, "The vaccine has been added successfully!!!");
							EditStock es = new EditStock();
							es.setVisible(true);
							setVisible(false);
							
						}
						
						connection.close();
					}
					catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnAdd.setBackground(new Color(95, 158, 160));
		btnAdd.setBounds(80, 273, 85, 33);
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaccineName.setText(" ");
				expireDate.setText(" ");
				price.setText(" ");
				quantity.setText(" ");
				companyID.setText(" ");
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnReset.setBackground(new Color(95, 158, 160));
		btnReset.setBounds(289, 273, 85, 33);
		contentPane.add(btnReset);
		setUndecorated(true);
		
		JLabel lblCompanyID = new JLabel("Company ID");
		lblCompanyID.setForeground(new Color(95, 158, 160));
		lblCompanyID.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCompanyID.setBounds(80, 230, 102, 20);
		contentPane.add(lblCompanyID);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(AddVaccine.class.getResource("/IT20123840/Assets/Back.PNG")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditStock es = new EditStock();
				es.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnBack.setBackground(new Color(95, 158, 160));
		btnBack.setBounds(397, 68, 43, 26);
		contentPane.add(btnBack);
		
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 450, 348);
		contentPane.add(label);
		label.setIcon(new ImageIcon(AddVaccine.class.getResource("/IT20123840/Assets/login.jpeg")));
	}

}
