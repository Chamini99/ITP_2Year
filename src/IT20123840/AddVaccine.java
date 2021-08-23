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

public class AddVaccine extends JFrame {

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
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setForeground(new Color(95, 158, 160));
		lblCompanyName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCompanyName.setBounds(80, 117, 102, 20);
		contentPane.add(lblCompanyName);
		
		JLabel lblVaccineId = new JLabel("Vaccine ID");
		lblVaccineId.setForeground(new Color(95, 158, 160));
		lblVaccineId.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVaccineId.setBounds(80, 159, 69, 20);
		contentPane.add(lblVaccineId);
		
		JLabel lblVaccineName = new JLabel("Vaccine Name");
		lblVaccineName.setForeground(new Color(95, 158, 160));
		lblVaccineName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVaccineName.setBounds(80, 197, 102, 20);
		contentPane.add(lblVaccineName);
		
		JLabel lblExpireDate = new JLabel("Expire Date");
		lblExpireDate.setForeground(new Color(95, 158, 160));
		lblExpireDate.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblExpireDate.setBounds(80, 239, 75, 20);
		contentPane.add(lblExpireDate);
		
		JLabel lblPricers = new JLabel("Price (Rs)");
		lblPricers.setForeground(new Color(95, 158, 160));
		lblPricers.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPricers.setBounds(80, 282, 62, 20);
		contentPane.add(lblPricers);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(95, 158, 160));
		lblQuantity.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblQuantity.setBounds(80, 322, 56, 20);
		contentPane.add(lblQuantity);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(242, 117, 132, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(242, 158, 132, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(242, 198, 132, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(242, 236, 132, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(242, 277, 132, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(242, 318, 132, 20);
		contentPane.add(textField_5);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnAdd.setBackground(new Color(95, 158, 160));
		btnAdd.setBounds(80, 385, 102, 33);
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnReset.setBackground(new Color(95, 158, 160));
		btnReset.setBounds(272, 385, 102, 33);
		contentPane.add(btnReset);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 450, 417);
		contentPane.add(label);
		setUndecorated(true);
		label.setIcon(new ImageIcon(AddVaccine.class.getResource("/IT20123840/Assets/login.jpeg")));
	}

}
