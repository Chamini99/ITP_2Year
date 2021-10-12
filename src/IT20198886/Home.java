package IT20198886;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_logo;
	private JLabel lbl;

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
		setBounds(100, 100, 1358, 765);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(32767, 33167));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));

		panel.setBounds(0, 0, 1374, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbl = new JLabel("X");
		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Do you want to exit from the system?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					System.exit(20);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl.setForeground(Color.RED);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl.setForeground(Color.WHITE);

			}
		});

		lbl.setForeground(new Color(255, 255, 255));
		lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl.setBounds(1323, 11, 22, 14);
		panel.add(lbl);

		lbl_1.setForeground(new Color(255, 255, 255));
		lbl_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_1.setBounds(1331, 11, 22, 14);
		panel.add(lbl_1);

		
		JLabel lbl_2 = new JLabel("-");
		lbl_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);

				
			}
		});
		lbl_2.setForeground(new Color(255, 255, 255));
		lbl_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_2.setBounds(1291, 11, 22, 14);
		panel.add(lbl_2);
		
		lbl_logo = new JLabel("");
		lbl_logo.setForeground(new Color(95, 158, 160));
		lbl_logo.setFont(new Font("Tahoma", Font.BOLD, 23));
		lbl_logo.setBounds(448, 34, 495, 165);
		contentPane.add(lbl_logo);
		
		lbl_logo.setIcon(new ImageIcon(Home.class.getResource("/IT20198886/Assets/logosu.png")));
		contentPane.add(lbl_logo);
		
		
		JLabel lbl_image1 = new JLabel("");
		lbl_image1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		lbl_image1.setBounds(132, 228, 144, 144);
		contentPane.add(lbl_image1);
		
		lbl_image1.setIcon(new ImageIcon(Home.class.getResource("/IT20198886/Assets/people.png")));
		contentPane.add(lbl_image1);
		
		JLabel lbl_4 = new JLabel("People Management");
		lbl_4.setForeground(new Color(47, 79, 79));
		lbl_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_4.setBounds(132, 364, 189, 48);
		contentPane.add(lbl_4);
		
		JLabel lbl_image2 = new JLabel("New label");
		lbl_image2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login slogin = new Login();
				slogin.setVisible(true);
			}
		});
		lbl_image2.setBounds(615, 233, 139, 139);
		contentPane.add(lbl_image2);
		setUndecorated(true);
		
		lbl_image2.setIcon(new ImageIcon(Home.class.getResource("/IT20198886/Assets/staffmgt.png")));
		contentPane.add(lbl_image2);
		
		JLabel lblNewLabel_1 = new JLabel("Staff Management");
		lblNewLabel_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(615, 374, 144, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl_image3 = new JLabel("New label");
		lbl_image3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				IT20122782.DocLogin slogin = new IT20122782.DocLogin();
				slogin.setVisible(true);
			}
		});
		lbl_image3.setBounds(1053, 225, 144, 144);
		contentPane.add(lbl_image3);
		
		lbl_image3.setIcon(new ImageIcon(Home.class.getResource("/IT20198886/Assets/doctormgt.png")));
		contentPane.add(lbl_image3);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor Management");
		lblNewLabel_2.setForeground(new Color(47, 79, 79));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(1063, 379, 154, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbl_image4 = new JLabel("New label");
		lbl_image4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				IT20123840.SupplierLogin slogin = new IT20123840.SupplierLogin();
				slogin.setVisible(true);
				
			}
		});
		lbl_image4.setBounds(132, 483, 139, 139);
		contentPane.add(lbl_image4);
		
		lbl_image4.setIcon(new ImageIcon(Home.class.getResource("/IT20198886/Assets/supplymgt.png")));
		contentPane.add(lbl_image4);
		

		JLabel lblNewLabel = new JLabel("Supply Management");
		lblNewLabel.setForeground(new Color(95, 158, 160));

		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(147, 653, 154, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_image5 = new JLabel("New label");
		lbl_image5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//lbl_image5.setBounds(550, 300, 0, 0);
			    //this.repaint();
			}
		});
		lbl_image5.setBounds(610, 480, 144, 144);
		contentPane.add(lbl_image5);
		
		lbl_image5.setIcon(new ImageIcon(Home.class.getResource("/IT20198886/Assets/deliverymgt.png")));
		contentPane.add(lbl_image5);
		
		JLabel lblNewLabel_4 = new JLabel("Delivery Management");
		lblNewLabel_4.setForeground(new Color(47, 79, 79));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(598, 657, 178, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lbl_image6 = new JLabel("New label");
		lbl_image6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				IT20119744.adminLogin slogin1 = new IT20119744.adminLogin();
				slogin1.frame.setVisible(true);
			}
		});
		lbl_image6.setBounds(1053, 483, 144, 139);
		contentPane.add(lbl_image6);
		
		lbl_image6.setIcon(new ImageIcon(Home.class.getResource("/IT20198886/Assets/adminmgt.png")));
		contentPane.add(lbl_image6);
		
		JLabel lblNewLabel_5 = new JLabel("Admin Management");
		lblNewLabel_5.setForeground(new Color(47, 79, 79));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(1053, 653, 154, 29);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 29, 1358, 725);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/IT20198886/Assets/homebg2.jpg")));
		contentPane.add(lblNewLabel_3);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

	}
}
