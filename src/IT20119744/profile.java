package IT20119744;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
		setBounds(100, 100, 580, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
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
		label.setBounds(495, 2, 30, 20);
		panel.add(label);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//setVisible(false);
				if(JOptionPane.showConfirmDialog(null,"Do you want to Exit?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					profile.this.dispose();
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
		lblX.setBounds(540, 2, 42, 33);
		panel.add(lblX);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setForeground(new Color(95, 158, 160));
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblAdmin.setBounds(0, 58, 580, 33);
		contentPane.add(lblAdmin);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Update and Delete User");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 100, 580, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				manageSupplier mSu = new manageSupplier();
				mSu.setVisible(true);
			}
		});
		lblNewLabel_1.setBounds(69, 317, 150, 104);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/IT20119744/assets/Color logo - no backgroundSupplier.png")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				manageAdmin mA = new manageAdmin();
				mA.setVisible(true);
			}
		});
		lblNewLabel_2.setBounds(360, 317, 150, 104);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/IT20119744/assets/Color logo - no backgroundadmin.png")));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				manageStaff mS = new manageStaff();
				mS.setVisible(true);
			}
		});
		lblNewLabel_3.setBounds(69, 176, 150, 104);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/IT20119744/assets/Color logo - no backgroundstaff.png")));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				manageDoctor mD = new manageDoctor();
				mD.setVisible(true);
			}
		});
		lblNewLabel_4.setBounds(360, 176, 150, 104);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(Home.class.getResource("/IT20119744/assets/Color logo - no backgrounddoctor.png")));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 =new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 580, 450);
		lblNewLabel_6.setIcon(new ImageIcon(profile.class.getResource("/IT20119744/assets/login.jpeg")));
		contentPane.add(lblNewLabel_6);
		
		
	}
}
