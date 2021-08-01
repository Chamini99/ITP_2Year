package IT20198886;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateProfile extends JFrame {

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
					UpdateProfile frame = new UpdateProfile();
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
	public UpdateProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 540, 26);
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(20);
			}
		});
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(520, 0, 10, 20);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel_1.setBounds(495, 3, 15, 14);
		
		JLabel lblNewLabel_3 = new JLabel("Update Profile");
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_3.setBounds(204, 32, 140, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setForeground(new Color(95, 158, 160));
		lblFullName.setFont(new Font("Dialog", Font.BOLD, 17));
		lblFullName.setBounds(141, 108, 77, 14);
		contentPane.add(lblFullName);
		
		JLabel lblNewLabel_4 = new JLabel("NIC");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setBounds(141, 145, 46, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Branch");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setBounds(141, 190, 65, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tel.No");
		lblNewLabel_6.setForeground(new Color(95, 158, 160));
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_6.setBounds(141, 238, 65, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Gender");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_7.setForeground(new Color(95, 158, 160));
		lblNewLabel_7.setBounds(141, 278, 65, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Age");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_8.setForeground(new Color(95, 158, 160));
		lblNewLabel_8.setBounds(141, 303, 46, 26);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Email");
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_9.setForeground(new Color(95, 158, 160));
		lblNewLabel_9.setBounds(141, 340, 65, 26);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Password");
		lblNewLabel_10.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_10.setForeground(new Color(95, 158, 160));
		lblNewLabel_10.setBounds(141, 383, 92, 14);
		contentPane.add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setBounds(258, 108, 192, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(258, 145, 192, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(258, 185, 192, 20);
		contentPane.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(258, 238, 192, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(258, 278, 192, 20);
		contentPane.add(comboBox_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(258, 309, 192, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(258, 346, 192, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(258, 383, 192, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(233, 455, 111, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 27, 540, 494);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_2.setIcon(new ImageIcon(UpdateProfile.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_2);
	
	}
}
