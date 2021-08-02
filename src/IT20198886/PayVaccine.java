package IT20198886;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PayVaccine extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayVaccine frame = new PayVaccine();
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
	public PayVaccine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 563, 31);
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setBounds(535, 11, 18, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setBounds(509, 10, 24, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("Pay for vaccines");
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNewLabel_3.setBounds(208, 54, 180, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total Amount");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setBounds(118, 131, 131, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("N/A");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setBounds(316, 131, 96, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("PAY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton.setBounds(249, 177, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Pay with");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_6.setForeground(new Color(95, 158, 160));
		lblNewLabel_6.setBounds(221, 223, 103, 31);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(306, 234, 46, 14);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setIcon(new ImageIcon(PayVaccine.class.getResource("/IT20198886/Assets/images.jpg")));
		 contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Card holder's name");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_8.setForeground(new Color(95, 158, 160));
		lblNewLabel_8.setBounds(118, 269, 167, 14);
		contentPane.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(316, 269, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("CVV");
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_9.setForeground(new Color(95, 158, 160));
		lblNewLabel_9.setBounds(118, 307, 63, 14);
		contentPane.add(lblNewLabel_9);
		
		textField_1 = new JTextField();
		textField_1.setBounds(315, 301, 132, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Account Number");
		lblNewLabel_10.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_10.setForeground(new Color(95, 158, 160));
		lblNewLabel_10.setBounds(118, 332, 151, 14);
		contentPane.add(lblNewLabel_10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(316, 332, 131, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Expire Date");
		lblNewLabel_11.setForeground(new Color(95, 158, 160));
		lblNewLabel_11.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_11.setBounds(118, 357, 114, 23);
		contentPane.add(lblNewLabel_11);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(316, 360, 131, 20);
		contentPane.add(dateChooser);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(95, 158, 160));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(249, 401, 96, 23);
		contentPane.add(btnNewButton_1);
		 
		
		 
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 30, 563, 423);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(PayVaccine.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_2);
		 
	}
}
