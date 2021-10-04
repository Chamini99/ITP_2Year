package IT20122782;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DocHome extends JFrame {

	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocHome frame = new DocHome();
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
	public DocHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    setUndecorated(true);
	    setLocationRelativeTo(null);
		
		JButton btn_myprofile = new JButton("My Profile");
		btn_myprofile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocProfile m = new DocProfile();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btn_myprofile.setForeground(Color.WHITE);
		btn_myprofile.setBackground(new Color(95, 158, 160));
		btn_myprofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_myprofile.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_myprofile.setBounds(99, 130, 167, 42);
		contentPane.add(btn_myprofile);
		
		JButton btn_appointments = new JButton("Appointments");
		btn_appointments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocAppoin m = new DocAppoin();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btn_appointments.setForeground(Color.WHITE);
		btn_appointments.setBackground(new Color(95, 158, 160));
		btn_appointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_appointments.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_appointments.setBounds(336, 130, 179, 42);
		contentPane.add(btn_appointments);
		
		JButton btn_dtmanage = new JButton("Date & Time Management");
		btn_dtmanage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Docdtmanage m = new Docdtmanage();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btn_dtmanage.setForeground(Color.WHITE);
		btn_dtmanage.setBackground(new Color(95, 158, 160));
		btn_dtmanage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_dtmanage.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_dtmanage.setBounds(151, 200, 329, 42);
		contentPane.add(btn_dtmanage);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setForeground(new Color(95, 158, 160));
		lblDoctor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDoctor.setBounds(249, 46, 103, 25);
		contentPane.add(lblDoctor);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				setVisible(false);
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblX.setBounds(548, 13, 32, 16);
		panel.add(lblX);
		
		JLabel lblX_1 = new JLabel("-");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblX_1.setBounds(524, 13, 32, 16);
		panel.add(lblX_1);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DocLogin a = new DocLogin();
				 a.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(438, 284, 111, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DocLogin.class.getResource("/IT20122782/Image/login.jpeg")));
		lblNewLabel.setBounds(0, 34, 580, 301);
		contentPane.add(lblNewLabel);
		
		
		
		

}
}
