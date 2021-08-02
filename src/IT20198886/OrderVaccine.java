package IT20198886;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class OrderVaccine extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 553, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 553, 27);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setBounds(526, 11, 17, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setBounds(501, 11, 17, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JLabel lblNewLabel_3 = new JLabel("Request Vaccine");
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_3.setBounds(227, 33, 155, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Vaccine Type");
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_4.setBounds(110, 108, 129, 27);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(301, 111, 129, 27);
		contentPane.add(comboBox);
		
		JLabel lblSupplyCompany = new JLabel("Supply Company");
		lblSupplyCompany.setFont(new Font("Dialog", Font.BOLD, 17));
		lblSupplyCompany.setForeground(new Color(95, 158, 160));
		lblSupplyCompany.setBounds(110, 164, 140, 27);
		contentPane.add(lblSupplyCompany);
		
		textField = new JTextField();
		textField.setBounds(301, 170, 129, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblVaccineAmount = new JLabel("Vaccine Amount");
		lblVaccineAmount.setForeground(new Color(95, 158, 160));
		lblVaccineAmount.setFont(new Font("Dialog", Font.BOLD, 17));
		lblVaccineAmount.setBounds(110, 217, 155, 27);
		contentPane.add(lblVaccineAmount);
		
		textField_1 = new JTextField();
		textField_1.setBounds(301, 223, 129, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Delivered Date");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setBounds(110, 283, 129, 14);
		contentPane.add(lblNewLabel_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dateChooser.setBounds(301, 283, 129, 27);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(214, 391, 117, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 26, 553, 495);
		contentPane.add(lblNewLabel_2);
		setUndecorated(true);
		
		lblNewLabel_2.setIcon(new ImageIcon(OrderVaccine.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_2);
	
	}
}
