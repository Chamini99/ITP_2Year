package IT20119744;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class profile extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 580, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(ICONIFIED);
			}
		});
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Segoe UI", Font.BOLD, 40));
		label.setBounds(495, 2, 30, 20);
		panel.add(label);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblX.setBounds(540, 2, 42, 33);
		panel.add(lblX);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setForeground(new Color(95, 158, 160));
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblAdmin.setBounds(251, 58, 112, 33);
		contentPane.add(lblAdmin);
		setUndecorated(true);
		
		JButton btnNewButton = new JButton("PEOPLE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				managePeople P= new managePeople();
				P.setVisible(true);				
				setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(74, 126, 165, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DOCTOR");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageDoctor D= new manageDoctor();
				D.setVisible(true);				
				setVisible(false);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(95, 158, 160));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_1.setBounds(342, 126, 165, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("STAFF");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageStaff S= new manageStaff();
				S.setVisible(true);				
				setVisible(false);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(95, 158, 160));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_2.setBounds(74, 191, 165, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELIVERY");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageDelivery De= new manageDelivery();
				De.setVisible(true);				
				setVisible(false);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(95, 158, 160));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_3.setBounds(74, 248, 165, 33);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SUPPLIER");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageSupplier Su= new manageSupplier();
				Su.setVisible(true);				
				setVisible(false);
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(95, 158, 160));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_4.setBounds(342, 191, 165, 33);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("ADMIN");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageAdmin A= new manageAdmin();
				A.setVisible(true);				
				setVisible(false);
			}
		});
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(95, 158, 160));
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_5.setBounds(342, 248, 165, 33);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_6 =new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 580, 335);
		lblNewLabel_6.setIcon(new ImageIcon(profile.class.getResource("/IT20119744/assets/login.jpeg")));
		contentPane.add(lblNewLabel_6);
	}
}
