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
import javax.swing.JPasswordField;
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
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_3;

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
		setBounds(100, 100, 552, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 552, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(20);
				
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblX.setBounds(528, 11, 24, 14);
		panel.add(lblX);
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel.setBounds(511, 11, 17, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(95, 158, 160));
		lblNewLabel_2.setBounds(244, 42, 126, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Full Name");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setBounds(119, 113, 85, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NIC");
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_4.setBounds(119, 148, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tel.No");
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_5.setBounds(119, 181, 72, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_6.setForeground(new Color(95, 158, 160));
		lblNewLabel_6.setBounds(119, 221, 72, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Age");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_7.setForeground(new Color(95, 158, 160));
		lblNewLabel_7.setBounds(119, 252, 46, 19);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_8.setForeground(new Color(95, 158, 160));
		lblNewLabel_8.setBounds(119, 294, 72, 19);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Password");
		lblNewLabel_9.setForeground(new Color(95, 158, 160));
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_9.setBounds(119, 340, 98, 14);
		contentPane.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(244, 113, 214, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(244, 148, 214, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(244, 181, 214, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(244, 254, 214, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(244, 296, 214, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(244, 221, 214, 20);
		contentPane.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(244, 340, 214, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login login=new Login();
				login.setVisible(true);
			}
		});
		
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(230, 439, 116, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_1.setBounds(0, 30, 552, 534);
		contentPane.add(lblNewLabel_1);
		setUndecorated(true);
		
		lblNewLabel_1.setIcon(new ImageIcon(profile.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_1);
		 
		 JButton btnNewButton_1 = new JButton("New button");
		 btnNewButton_1.setBounds(254, 147, 89, 23);
		 contentPane.add(btnNewButton_1);
		 
		
	}
}
