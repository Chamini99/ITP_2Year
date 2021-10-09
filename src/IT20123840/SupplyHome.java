package IT20123840;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SupplyHome {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplyHome window = new SupplyHome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupplyHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 222);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		JLabel lbl_SupplyMgt = new JLabel("Supply Management");
		lbl_SupplyMgt.setForeground(new Color(95, 158, 160));
		lbl_SupplyMgt.setFont(new Font("Calibri", Font.BOLD, 28));
		lbl_SupplyMgt.setBounds(172, 56, 240, 28);
		frame.getContentPane().add(lbl_SupplyMgt);
		
		JButton btn_Stock = new JButton("Stock");
		btn_Stock.setIcon(new ImageIcon(SupplyHome.class.getResource("/IT20123840/Assets/Stock.PNG")));
		btn_Stock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stock s = new Stock();
				s.setVisible(true);
				frame.setVisible(false);
			}
		});
		btn_Stock.setBackground(new Color(95, 158, 160));
		btn_Stock.setForeground(new Color(255, 255, 255));
		btn_Stock.setFont(new Font("Calibri", Font.PLAIN, 20));
		btn_Stock.setBounds(52, 127, 131, 37);
		frame.getContentPane().add(btn_Stock);
		
		JButton btn_Orders = new JButton("Orders");
		btn_Orders.setIcon(new ImageIcon(SupplyHome.class.getResource("/IT20123840/Assets/Odrers.PNG")));
		btn_Orders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Orders o = new Orders();
				o.setVisible(true);
				frame.setVisible(false);
			}
		});
		btn_Orders.setForeground(new Color(255, 255, 255));
		btn_Orders.setBackground(new Color(95, 158, 160));
		btn_Orders.setFont(new Font("Calibri", Font.PLAIN, 20));
		btn_Orders.setBounds(226, 127, 131, 37);
		frame.getContentPane().add(btn_Orders);
		
		JButton btn_Login = new JButton("Login");
		btn_Login.setIcon(new ImageIcon(SupplyHome.class.getResource("/IT20123840/Assets/Login.PNG")));
		btn_Login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SupplierLogin s = new SupplierLogin();
				s.setVisible(true);
				frame.setVisible(false);
			}
		});
		btn_Login.setFont(new Font("Calibri", Font.PLAIN, 20));
		btn_Login.setBackground(new Color(95, 158, 160));
		btn_Login.setForeground(new Color(255, 255, 255));
		btn_Login.setBounds(401, 127, 131, 37);
		frame.getContentPane().add(btn_Login);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_X = new JLabel("  X");
		lbl_X.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		lbl_X.setForeground(new Color(255, 255, 255));
		lbl_X.setBounds(549, 0, 21, 20);
		panel.add(lbl_X);
		lbl_X.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lbl_1 = new JLabel("  -");
		lbl_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(frame.ICONIFIED);
			}
		});
		lbl_1.setForeground(new Color(255, 255, 255));
		lbl_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_1.setBounds(522, 0, 21, 20);
		panel.add(lbl_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 32, 580, 190);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(CreateAccount.class.getResource("/IT20123840/Assets/login.jpeg")));
	}

}
