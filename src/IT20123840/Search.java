package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField txt_vaccineID;
	private JTextField txt_vaccineName;
	private JTextField txt_expireDate;
	private JTextField txt_price;
	private JTextField txt_quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		lblX.setBounds(424, 0, 26, 33);
		panel.add(lblX);
		lblX.setForeground(new Color(240, 248, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX_1 = new JLabel("  -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(new Color(240, 248, 255));
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX_1.setBounds(403, 0, 26, 33);
		panel.add(lblX_1);
		
		JLabel lblNewLabel_1 = new JLabel("Find Vaccine");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 28));
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setBounds(152, 44, 147, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblVaccineId = new JLabel("Vaccine ID");
		lblVaccineId.setForeground(new Color(95, 158, 160));
		lblVaccineId.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVaccineId.setBounds(52, 88, 75, 20);
		contentPane.add(lblVaccineId);
		
		txt_vaccineID = new JTextField();
		txt_vaccineID.setColumns(10);
		txt_vaccineID.setBounds(151, 88, 132, 20);
		contentPane.add(txt_vaccineID);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");
					Statement stmt = connection.createStatement();
					String query = "select vaccine_name, expire_date, s_price, s_quantity from tbl_companystock where vaccine_id = '"+txt_vaccineID.getText()+"'";
					ResultSet rs = stmt.executeQuery(query);
					
					if (rs.next()) {
						String vaccineName = rs.getString(1);
						String expireDate = rs.getString(2);
						String price = rs.getString(3);
						String quantity = rs.getString(4);
						
						txt_vaccineName.setText(vaccineName);
						txt_expireDate.setText(expireDate);
						txt_price.setText(price);
						txt_quantity.setText(quantity);
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
		btnFind.setForeground(new Color(240, 248, 255));
		btnFind.setBackground(new Color(95, 158, 160));
		btnFind.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnFind.setBounds(321, 84, 75, 26);
		contentPane.add(btnFind);
		
		JLabel lblVaccineName = new JLabel("Vaccine Name");
		lblVaccineName.setForeground(new Color(95, 158, 160));
		lblVaccineName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVaccineName.setBounds(87, 134, 99, 20);
		contentPane.add(lblVaccineName);
		
		txt_vaccineName = new JTextField();
		txt_vaccineName.setColumns(10);
		txt_vaccineName.setBounds(232, 134, 132, 20);
		contentPane.add(txt_vaccineName);
		setUndecorated(true);
		
		JLabel lblExpireDate = new JLabel("Expire Date");
		lblExpireDate.setForeground(new Color(95, 158, 160));
		lblExpireDate.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblExpireDate.setBounds(87, 165, 75, 20);
		contentPane.add(lblExpireDate);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(95, 158, 160));
		lblPrice.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPrice.setBounds(87, 196, 37, 20);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(95, 158, 160));
		lblQuantity.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblQuantity.setBounds(87, 227, 57, 20);
		contentPane.add(lblQuantity);
		
		txt_expireDate = new JTextField();
		txt_expireDate.setColumns(10);
		txt_expireDate.setBounds(232, 165, 132, 20);
		contentPane.add(txt_expireDate);
		
		txt_price = new JTextField();
		txt_price.setColumns(10);
		txt_price.setBounds(232, 196, 132, 20);
		contentPane.add(txt_price);
		
		txt_quantity = new JTextField();
		txt_quantity.setColumns(10);
		txt_quantity.setBounds(232, 227, 132, 20);
		contentPane.add(txt_quantity);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CompanyHome ch = new CompanyHome();
				ch.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(new Color(240, 248, 255));
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnBack.setBackground(new Color(95, 158, 160));
		btnBack.setBounds(193, 258, 75, 26);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 34, 450, 266);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Search.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
