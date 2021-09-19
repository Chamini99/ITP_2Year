package IT20198886;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 413);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 718, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_1 = new JLabel("X");
		lbl_1.setForeground(new Color(255, 255, 255));
		lbl_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_1.setBounds(674, 11, 22, 14);
		panel.add(lbl_1);
		
		JLabel lbl_2 = new JLabel("-");
		lbl_2.setForeground(new Color(255, 255, 255));
		lbl_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_2.setBounds(653, 11, 22, 14);
		panel.add(lbl_2);
		
		JLabel lblNewLabel = new JLabel("Suwasetha Medical Center");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(202, 42, 397, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_image1 = new JLabel("");
		lbl_image1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		lbl_image1.setBounds(53, 100, 104, 101);
		contentPane.add(lbl_image1);
		
		lbl_image1.setIcon(new ImageIcon(Home.class.getResource("/IT20198886/Assets/patient.jpg")));
		contentPane.add(lbl_image1);
		
		JLabel lbl_4 = new JLabel("People Mgt");
		lbl_4.setForeground(new Color(95, 158, 160));
		lbl_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_4.setBounds(53, 195, 104, 48);
		contentPane.add(lbl_4);
		
		JLabel lbl_image2 = new JLabel("New label");
		lbl_image2.setBounds(326, 94, 98, 107);
		contentPane.add(lbl_image2);
		setUndecorated(true);
		
		lbl_image2.setIcon(new ImageIcon(Home.class.getResource("/IT20198886/Assets/staff.png")));
		contentPane.add(lbl_image2);
		
		JLabel lblNewLabel_1 = new JLabel("Staff Mgt");
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(326, 205, 98, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl_image3 = new JLabel("New label");
		lbl_image3.setBounds(576, 100, 98, 91);
		contentPane.add(lbl_image3);
		
		lbl_image3.setIcon(new ImageIcon(Home.class.getResource("/IT20198886/Assets/doctor.png")));
		contentPane.add(lbl_image3);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor Mgt");
		lblNewLabel_2.setForeground(new Color(95, 158, 160));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(586, 210, 98, 19);
		contentPane.add(lblNewLabel_2);
		
	}
}
