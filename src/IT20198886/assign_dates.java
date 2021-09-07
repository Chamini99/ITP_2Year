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
import javax.swing.JTable;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class assign_dates extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
//test
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					assign_dates frame = new assign_dates();
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
	public assign_dates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 686, 31);
		panel.setBackground(new Color(95, 158, 160));
		panel.setForeground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(20);
			}
		});
		lblNewLabel.setBounds(665, 11, 21, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_1.setBounds(642, 11, 16, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("Assign Vaccine Date");
		lblNewLabel_3.setBounds(275, 32, 214, 25);
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 19));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Registered Date");
		lblNewLabel_4.setBounds(412, 87, 120, 21);
		lblNewLabel_4.setFont(new Font("Dialog", Font.ITALIC, 16));
		lblNewLabel_4.setForeground(new Color(95, 158, 160));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NIC");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_5.setForeground(new Color(95, 158, 160));
		lblNewLabel_5.setBounds(155, 239, 63, 25);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(341, 244, 148, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Vaccine Date");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_6.setForeground(new Color(95, 158, 160));
		lblNewLabel_6.setBounds(155, 285, 126, 25);
		contentPane.add(lblNewLabel_6);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(341, 290, 148, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_7 = new JLabel("Vaccine Type");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_7.setForeground(new Color(95, 158, 160));
		lblNewLabel_7.setBounds(155, 321, 126, 25);
		contentPane.add(lblNewLabel_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(341, 326, 148, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_8 = new JLabel("Dose");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_8.setForeground(new Color(95, 158, 160));
		lblNewLabel_8.setBounds(155, 371, 63, 14);
		contentPane.add(lblNewLabel_8);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(341, 371, 148, 20);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				assign_details  dates=new assign_details();
				dates.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setBounds(276, 418, 89, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(66, 113, 592, 90);
		contentPane.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(-25, 32, 711, 445);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_2.setIcon(new ImageIcon(assign_dates.class.getResource("/IT20198886/Assets/login.jpeg")));
		contentPane.add(lblNewLabel_2);
		
	}
}
