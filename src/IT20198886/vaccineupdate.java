package IT20198886;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class vaccineupdate extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField textField;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vaccineupdate frame = new vaccineupdate();
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
	public vaccineupdate() {
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
		lblNewLabel.setBounds(558, 0, 11, 21);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(523, 11, 24, 6);
		panel.add(lblNewLabel_1);
		
		JLabel lblOrderId = new JLabel("Order ID");
		lblOrderId.setForeground(new Color(95, 158, 160));
		lblOrderId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrderId.setBounds(118, 78, 93, 14);
		contentPane.add(lblOrderId);
		
		JLabel lblNewLabel_4 = new JLabel("Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setBounds(118, 153, 69, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Vaccine Type");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setBounds(118, 111, 107, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Company");
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(118, 184, 93, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Amount");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setForeground(new Color(95, 158, 160));
		lblNewLabel_6.setBounds(118, 221, 69, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Price");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setForeground(new Color(95, 158, 160));
		lblNewLabel_7.setBounds(118, 254, 69, 14);
		contentPane.add(lblNewLabel_7);
		
		t1 = new JTextField();
		t1.setBounds(243, 77, 236, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(243, 118, 236, 20);
		contentPane.add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(243, 153, 236, 20);
		contentPane.add(dateChooser);
		
		t2 = new JTextField();
		t2.setBounds(238, 186, 241, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(243, 220, 236, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(243, 253, 236, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 27, 579, 373);
		contentPane.add(lblNewLabel_2);
		setUndecorated(true);
		
		lblNewLabel_2.setIcon(new ImageIcon(vaccineupdate.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_2);
		
	}
}
