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

public class stock extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock frame = new stock();
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
	public stock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 621, 31);
		panel.setBackground(new Color(95, 158, 160));
		panel.setForeground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setBounds(597, 11, 25, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setBounds(573, 11, 24, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("Our Stock");
		lblNewLabel_3.setForeground(new Color(95, 158, 160));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_3.setBounds(263, 43, 126, 14);
		contentPane.add(lblNewLabel_3);
		
		table = new JTable();
		table.setBounds(32, 94, 563, 285);
		contentPane.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 29, 621, 389);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_2.setIcon(new ImageIcon(UserDetails.class.getResource("/IT20198886/Assets/login.jpeg")));
		 contentPane.add(lblNewLabel_2);
	}

}
