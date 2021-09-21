package IT20198886;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JTextField;

public class profile extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profile frame = new profile();
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
	public profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 638, 31);
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				System.exit(20);
			}
		});
		lblX.setBounds(693, 11, 10, 20);
		panel.add(lblX);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel.setBounds(666, 14, 17, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		
		JLabel lblNewLabel_6 = new JLabel("X");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							dispose();
							StaffHome st=new StaffHome();
							st.setVisible(true);
}
		});
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(610, 13, 18, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_9 = new JLabel("-");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);	

			}
		});
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9.setBounds(587, 13, 25, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_2 = new JLabel("My Profile");
		lblNewLabel_2.setBounds(270, 42, 146, 24);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(95, 158, 160));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Staff ID");
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_5.setBounds(142, 118, 97, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Full Name");
		lblNewLabel_3.setBounds(142, 167, 87, 14);
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NIC");
		lblNewLabel_4.setBounds(142, 207, 63, 14);
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("N/A");
		lblNewLabel_3_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_3_1.setBounds(295, 122, 87, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(142, 285, 66, 31);
		lblAge.setForeground(new Color(95, 158, 160));
		lblAge.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblAge);
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setBounds(142, 340, 57, 14);
		lblNewLabel_8.setForeground(new Color(95, 158, 160));
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Gender");
		lblNewLabel_7.setBounds(142, 249, 76, 14);
		lblNewLabel_7.setForeground(new Color(95, 158, 160));
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				UpdateProfile update=new UpdateProfile();
				update.setVisible(true);
			}
		});
		btnNewButton.setBounds(282, 422, 110, 31);
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(295, 167, 245, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(295, 207, 245, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(295, 249, 245, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(295, 293, 243, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(295, 340, 245, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 28, 638, 525);
		contentPane.add(lblNewLabel_1);
		setUndecorated(true);
		
		lblNewLabel_1.setIcon(new ImageIcon(profile.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_1);
		 
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		 
		 
	}
	
	

	
	}


