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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffRegister extends JFrame {

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
					StaffRegister frame = new StaffRegister();
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
	public StaffRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 550, 32);
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(20);
			}
		});
		lblX.setBounds(517, 11, 23, 14);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		panel.add(lblX);
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(491, 11, 16, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.setBounds(220, 57, 115, 32);
		lblNewLabel_2.setForeground(new Color(95, 158, 160));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Full Name");
		lblNewLabel_3.setBounds(144, 127, 89, 14);
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(263, 124, 166, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("NIC");
		lblNewLabel_4.setBounds(144, 164, 49, 14);
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(263, 161, 166, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Tel.No");
		lblNewLabel_6.setBounds(144, 198, 57, 35);
		lblNewLabel_6.setForeground(new Color(95, 158, 160));
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(263, 198, 166, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Gender");
		lblNewLabel_7.setBounds(144, 244, 60, 14);
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_7.setForeground(new Color(95, 158, 160));
		contentPane.add(lblNewLabel_7);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(263, 235, 166, 26);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_8 = new JLabel("Age");
		lblNewLabel_8.setBounds(144, 272, 71, 26);
		lblNewLabel_8.setForeground(new Color(95, 158, 160));
		lblNewLabel_8.setBackground(new Color(95, 158, 160));
		lblNewLabel_8.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		contentPane.add(lblNewLabel_8);
		
		textField_3 = new JTextField();
		textField_3.setBounds(263, 272, 166, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Email");
		lblNewLabel_9.setForeground(new Color(95, 158, 160));
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_9.setBounds(144, 312, 64, 14);
		contentPane.add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setBounds(263, 309, 166, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Password");
		lblNewLabel_10.setForeground(new Color(95, 158, 160));
		lblNewLabel_10.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_10.setBounds(144, 349, 93, 14);
		contentPane.add(lblNewLabel_10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(263, 346, 166, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnConfirm.setBackground(new Color(95, 158, 160));
		btnConfirm.setForeground(new Color(255, 255, 255));
		btnConfirm.setFont(new Font("Dialog", Font.BOLD, 18));
		btnConfirm.setBounds(220, 419, 148, 32);
		contentPane.add(btnConfirm);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 33, 550, 510);
		contentPane.add(lblNewLabel_1);
		 
		lblNewLabel_1.setIcon(new ImageIcon(StaffRegister.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_1);
	}
}
