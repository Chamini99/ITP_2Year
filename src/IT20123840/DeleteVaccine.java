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

public class DeleteVaccine extends JFrame {

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
					DeleteVaccine frame = new DeleteVaccine();
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
	public DeleteVaccine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		lblX.setForeground(new Color(240, 248, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX_1 = new JLabel("  -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(new Color(240, 248, 255));
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX_1.setBounds(403, 0, 26, 33);
		panel.add(lblX_1);
		
		txt_vaccineID = new JTextField();
		txt_vaccineID.setColumns(10);
		txt_vaccineID.setBounds(92, 98, 132, 20);
		contentPane.add(txt_vaccineID);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Vaccine");
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 28));
		lblNewLabel_1.setBounds(147, 44, 174, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
	
		btnView.setForeground(new Color(240, 248, 255));
		btnView.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnView.setBackground(new Color(95, 158, 160));
		btnView.setBounds(299, 94, 75, 26);
		contentPane.add(btnView);
		
		JLabel lblVaccineName = new JLabel("Vaccine Name");
		lblVaccineName.setForeground(new Color(95, 158, 160));
		lblVaccineName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVaccineName.setBounds(92, 140, 99, 20);
		contentPane.add(lblVaccineName);
		
		JLabel lblExpireDate = new JLabel("Expire Date");
		lblExpireDate.setForeground(new Color(95, 158, 160));
		lblExpireDate.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblExpireDate.setBounds(92, 171, 75, 20);
		contentPane.add(lblExpireDate);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(95, 158, 160));
		lblPrice.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPrice.setBounds(92, 202, 37, 20);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(95, 158, 160));
		lblQuantity.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblQuantity.setBounds(92, 233, 57, 20);
		contentPane.add(lblQuantity);
		
		txt_vaccineName = new JTextField();
		txt_vaccineName.setColumns(10);
		txt_vaccineName.setBounds(242, 140, 132, 20);
		contentPane.add(txt_vaccineName);
		
		txt_expireDate = new JTextField();
		txt_expireDate.setColumns(10);
		txt_expireDate.setBounds(242, 171, 132, 20);
		contentPane.add(txt_expireDate);
		
		txt_price = new JTextField();
		txt_price.setColumns(10);
		txt_price.setBounds(242, 202, 132, 20);
		contentPane.add(txt_price);
		
		txt_quantity = new JTextField();
		txt_quantity.setColumns(10);
		txt_quantity.setBounds(242, 233, 132, 20);
		contentPane.add(txt_quantity);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suwasetha_vaccine", "root", "");

						String query = "delete from tbl_companystock where vaccine_id = '"+txt_vaccineID.getText()+"'";
						Statement stmt = connection.createStatement();
						int x = stmt.executeUpdate(query);
					
						JOptionPane.showConfirmDialog(btnDelete, "The vaccine has been deleted successfully!!!");
						EditStock es = new EditStock();
						es.setVisible(true);
						setVisible(false);
					
					connection.close();
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnDelete.setBackground(new Color(95, 158, 160));
		btnDelete.setBounds(92, 286, 94, 33);
		contentPane.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditStock es = new EditStock();
				es.setVisible(true);
				setVisible(false);
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnCancel.setBackground(new Color(95, 158, 160));
		btnCancel.setBounds(280, 286, 94, 33);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 32, 450, 318);
		contentPane.add(lblNewLabel);
		setUndecorated(true);
		lblNewLabel.setIcon(new ImageIcon(DeleteVaccine.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
