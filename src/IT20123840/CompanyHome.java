package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class CompanyHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyHome frame = new CompanyHome();
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
	public CompanyHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 379);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		lblX.setBounds(543, 0, 27, 32);
		panel.add(lblX);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX_1 = new JLabel("  -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX_1.setBounds(520, 0, 27, 32);
		panel.add(lblX_1);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 44, 107, 78);
		contentPane.add(label);
		setUndecorated(true);
		label.setIcon(new ImageIcon(CompanyHome.class.getResource("/IT20123840/Assets/user.jpg")));
		
		JLabel lbl_CompanyName = new JLabel("Home");
		lbl_CompanyName.setForeground(new Color(95, 158, 160));
		lbl_CompanyName.setFont(new Font("Calibri", Font.BOLD, 28));
		lbl_CompanyName.setBounds(273, 53, 70, 33);
		contentPane.add(lbl_CompanyName);
		
		
		JButton btn_EditStock = new JButton("Edit Stock");
		btn_EditStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditStock es = new EditStock();
				es.setVisible(true);
				setVisible(false);
			}
		});
		
		btn_EditStock.setBackground(new Color(95, 158, 160));
		btn_EditStock.setForeground(new Color(255, 255, 255));
		btn_EditStock.setFont(new Font("Calibri", Font.PLAIN, 20));
		btn_EditStock.setBounds(10, 191, 167, 42);
		contentPane.add(btn_EditStock);
		
		JButton btnEditOrders = new JButton("Edit Orders");
		btnEditOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditOrders eo = new EditOrders();
				eo.setVisible(true);
				setVisible(false);
			}
		});
		btnEditOrders.setBackground(new Color(95, 158, 160));
		btnEditOrders.setForeground(new Color(255, 255, 255));
		btnEditOrders.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnEditOrders.setBounds(207, 191, 167, 42);
		contentPane.add(btnEditOrders);
		
		JButton btnDelivery = new JButton("Delivery");
		btnDelivery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeliveryRequest dr = new DeliveryRequest();
				dr.setVisible(true);
				setVisible(false);
			}
		});
		btnDelivery.setBackground(new Color(95, 158, 160));
		btnDelivery.setForeground(new Color(255, 255, 255));
		btnDelivery.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnDelivery.setBounds(403, 191, 167, 42);
		contentPane.add(btnDelivery);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SupplyHome sh = new SupplyHome();
				sh.frame.setVisible(true);
				setVisible(false);

			}
		});
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(95, 158, 160));
		btnLogout.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnLogout.setBounds(317, 264, 167, 42);
		contentPane.add(btnLogout);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(537, 96, 33, 26);
		contentPane.add(label_2);
		label_2.setIcon(new ImageIcon(CompanyHome.class.getResource("/IT20123840/Assets/search.PNG")));
		
		JButton btnMyProfile_1 = new JButton("My Profile");
		btnMyProfile_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyProfile mp = new MyProfile();
				mp.setVisible(true);
				setVisible(false);
			}
		});
		btnMyProfile_1.setForeground(Color.WHITE);
		btnMyProfile_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnMyProfile_1.setBackground(new Color(95, 158, 160));
		btnMyProfile_1.setBounds(120, 264, 167, 42);
		contentPane.add(btnMyProfile_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Search s = new Search();
				s.setVisible(true);
				setVisible(false);
			}
		});
		btnSearch.setForeground(new Color(95, 158, 160));
		btnSearch.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSearch.setBounds(448, 96, 89, 26);
		contentPane.add(btnSearch);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 33, 580, 346);
		contentPane.add(label_1);
		label_1.setIcon(new ImageIcon(CompanyHome.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
