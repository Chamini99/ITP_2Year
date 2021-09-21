package IT20198886;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Toolkit;





public class StaffHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffHome frame = new StaffHome();
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
	public StaffHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("View Orders");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AllOrders all=new AllOrders();
				all.setVisible(true);
			}
			
		});
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(179, 390, 130, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblRequestOrder = new JLabel("Request Order");
		lblRequestOrder.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblRequestOrder.setForeground(new Color(255, 255, 255));
		lblRequestOrder.setBounds(179, 290, 130, 25);
		contentPane.add(lblRequestOrder);
		
		JLabel lbl_order = new JLabel("New label");
		lbl_order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				OrderVaccine order=new OrderVaccine();
				order.setVisible(true);
			}
		});
		lbl_order.setBounds(36, 260, 303, 92);
		contentPane.add(lbl_order);
		
		lbl_order.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/reuqestorder.png")));
		contentPane.add(lbl_order);
		
		JLabel lblNewLabel = new JLabel("View Users");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(179, 187, 122, 25);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 720, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(ICONIFIED);
			}
		});
		lblNewLabel_2.setBounds(674, 11, 25, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Home home=new Home();
				home.setVisible(true);
			}
		});
		lblX.setBounds(698, 11, 22, 14);
		panel.add(lblX);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lbl_suwasetha = new JLabel("STAFF MANAGEMENT");
		lbl_suwasetha.setBounds(10, -5, 345, 55);
		panel.add(lbl_suwasetha);
		lbl_suwasetha.setForeground(new Color(255, 255, 255));
		lbl_suwasetha.setFont(new Font("Nirmala UI", Font.BOLD, 23));
		
		JLabel lbl_userlogo = new JLabel("New label");
		lbl_userlogo.setBounds(612, 0, 45, 45);
		panel.add(lbl_userlogo);
		lbl_userlogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				profile Profile=new profile();
				Profile.setVisible(true);
			}
			
		});
		
		lbl_userlogo.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/ulogos.png")));
		
		JLabel lbl_logo = new JLabel("New label");
		lbl_logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				 stock cstock=new stock();
				 cstock.setVisible(true);
			}
		});
		
		JLabel lblViewStocks = new JLabel("View Stocks");
		lblViewStocks.setForeground(new Color(255, 255, 255));
		lblViewStocks.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblViewStocks.setBounds(179, 87, 130, 25);
		contentPane.add(lblViewStocks);
		lbl_logo.setBounds(36, 44, 316, 119);
		contentPane.add(lbl_logo);
		
		
		lbl_logo.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/222.png")));
		contentPane.add(lbl_logo);
		
		JLabel lbl_people = new JLabel("New label");
		lbl_people.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				UserDetails user=new UserDetails();
				user.setVisible(true);
			}
		});
		lbl_people.setBounds(36, 157, 305, 92);
		contentPane.add(lbl_people);
		
		lbl_people.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/viewusers.png")));
		contentPane.add(lbl_people);
		
		JLabel lbl_view = new JLabel("New label");
		lbl_view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AllOrders all=new AllOrders();
				all.setVisible(true);
			}
		});
		lbl_view.setBounds(36, 363, 303, 86);
		contentPane.add(lbl_view);
		
		lbl_view.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/viewoders.png")));
		contentPane.add(lbl_view);
		

		
		
		JLabel lbl_new = new JLabel("New label");
		lbl_new.setBackground(new Color(255, 255, 255));
		lbl_new.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_new.setBounds(0, 36, 720, 439);
		contentPane.add(lbl_new);
		setUndecorated(true);
		

		lbl_new.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/Outsourcing.jpg")));
		contentPane.add(lbl_new);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
}