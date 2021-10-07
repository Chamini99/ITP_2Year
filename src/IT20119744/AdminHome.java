package IT20119744;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 600, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSignOut = new JLabel("SIGN OUT");
		lblSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				adminLogin aL = new adminLogin();
				aL.frame.setVisible(true);
			}
		});
		lblSignOut.setForeground(new Color(255, 255, 255));
		lblSignOut.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSignOut.setBounds(12, 0, 100, 33);
		panel.add(lblSignOut);
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setForeground(Color.RED);
			}
				@Override
				public void mouseExited(MouseEvent e) {
					label.setForeground(Color.white);
				}
			});
			label.setForeground(new Color(255, 255, 255));
			label.setFont(new Font("Segoe UI", Font.BOLD, 40));
			label.setBounds(516, 2, 30, 20);
			panel.add(label);
			
			JLabel lblX = new JLabel("X");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					//setVisible(false);
					if(JOptionPane.showConfirmDialog(null,"Do you want to Exit?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
						AdminHome.this.dispose();
					}
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lblX.setForeground(Color.RED);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblX.setForeground(Color.white);
				}
			});
			lblX.setForeground(new Color(255, 255, 255));
			lblX.setFont(new Font("Segoe UI", Font.BOLD, 22));
			lblX.setBounds(558, 3, 42, 33);
			panel.add(lblX);
			
			JLabel lblAdmin = new JLabel("ADMIN");
			lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdmin.setForeground(new Color(95, 158, 160));
			lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 34));
			lblAdmin.setBounds(0, 50, 580, 33);
			contentPane.add(lblAdmin);
			setUndecorated(true);
			
			JLabel lblNewLabel = new JLabel("Update and Delete User");
			lblNewLabel.setForeground(new Color(95, 158, 160));
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 85, 580, 25);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					AdminManageSupplier AMS = new AdminManageSupplier();
					AMS.setVisible(true);
				}
			});
			lblNewLabel_1.setBounds(219, 320, 150, 122);
			contentPane.add(lblNewLabel_1);
			lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/IT20119744/assets/SUPPLY.png")));
			contentPane.add(lblNewLabel_1);
			
	
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
					AdminManageStaff AMST = new AdminManageStaff();
					AMST.setVisible(true);
				}
			});
			lblNewLabel_3.setBounds(69, 150, 150, 137);
			contentPane.add(lblNewLabel_3);
			lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/IT20119744/assets/STAFF.png")));
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					AdminManageDoctor AMD = new AdminManageDoctor();
					AMD.setVisible(true);
				}
			});
			lblNewLabel_4.setBounds(380, 150, 150, 141);
			contentPane.add(lblNewLabel_4);
			lblNewLabel_4.setIcon(new ImageIcon(Home.class.getResource("/IT20119744/assets/DOCTOR.png")));
			contentPane.add(lblNewLabel_4);
			
			JLabel lblNewLabel_6 =new JLabel("");
			lblNewLabel_6.setBounds(0, 0, 600, 485);
			lblNewLabel_6.setIcon(new ImageIcon(profile.class.getResource("/IT20119744/assets/login.jpeg")));
			contentPane.add(lblNewLabel_6);
			
	}

}
