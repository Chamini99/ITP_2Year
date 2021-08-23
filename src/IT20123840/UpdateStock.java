package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UpdateStock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		setBounds(100, 100, 450, 450);
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
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setForeground(new Color(95, 158, 160));
		lblCompanyName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCompanyName.setBounds(75, 113, 102, 20);
		contentPane.add(lblCompanyName);
		
		JLabel lblVaccineId = new JLabel("Vaccine ID");
		lblVaccineId.setForeground(new Color(95, 158, 160));
		lblVaccineId.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVaccineId.setBounds(75, 154, 69, 20);
		contentPane.add(lblVaccineId);
		
		JLabel lblVaccineName = new JLabel("Vaccine Name");
		lblVaccineName.setForeground(new Color(95, 158, 160));
		lblVaccineName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVaccineName.setBounds(75, 194, 102, 20);
		contentPane.add(lblVaccineName);
		
		JLabel lblExpireDate = new JLabel("Expire Date");
		lblExpireDate.setForeground(new Color(95, 158, 160));
		lblExpireDate.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblExpireDate.setBounds(75, 232, 75, 20);
		contentPane.add(lblExpireDate);
		
		JLabel lblPricers = new JLabel("Price (Rs)");
		lblPricers.setForeground(new Color(95, 158, 160));
		lblPricers.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPricers.setBounds(75, 273, 62, 20);
		contentPane.add(lblPricers);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(95, 158, 160));
		lblQuantity.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblQuantity.setBounds(75, 314, 56, 20);
		contentPane.add(lblQuantity);
		
		textField = new JTextField();
		textField.setBounds(243, 113, 132, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(243, 154, 132, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(243, 194, 132, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(243, 232, 132, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(243, 273, 132, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(243, 314, 132, 20);
		contentPane.add(textField_5);
		
		JButton btnUpdate = new JButton("Update");
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
		btnUpdate.setBounds(75, 386, 102, 33);
		contentPane.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnReset.setBackground(new Color(95, 158, 160));
		btnReset.setBounds(273, 386, 102, 33);
		contentPane.add(btnReset);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 450, 417);
		contentPane.add(label);
		label.setIcon(new ImageIcon(UpdateStock.class.getResource("/IT20123840/Assets/login.jpeg")));
		setUndecorated(true);
	}
}
