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
import javax.swing.JOptionPane;

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
	private JLabel lblViewStocks;
	private JLabel lblNewLabel;
	private JLabel lbl_order;
	private JLabel lblNewLabel_1;
	private JLabel lblRequestOrder;

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
		setBounds(100, 100, 1008, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("View Orders");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AllOrders all=new AllOrders();
				all.setVisible(true);
			}
			
		});
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(179, 565, 130, 25);
		contentPane.add(lblNewLabel_1);
		
		lblRequestOrder = new JLabel("Request Order");
		lblRequestOrder.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblRequestOrder.setForeground(new Color(255, 255, 255));
		lblRequestOrder.setBounds(179, 465, 130, 25);
		contentPane.add(lblRequestOrder);
		
		lbl_order = new JLabel("New label");
		lbl_order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderVaccine order=new OrderVaccine();
				order.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRequestOrder.setForeground(Color.RED);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRequestOrder.setForeground(Color.WHITE);

			}
		});
		lbl_order.setBounds(36, 435, 303, 92);
		contentPane.add(lbl_order);
		
		lbl_order.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/reuqestorder.png")));
		contentPane.add(lbl_order);
		
		lblNewLabel = new JLabel("View Users");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(187, 176, 122, 25);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 1008, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(ICONIFIED);
			}
		});
		lblNewLabel_2.setBounds(941, 11, 25, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null,"Do you want to exit from Staff Management?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
				dispose();
				Home home=new Home();
				home.setVisible(true);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setBounds(976, 11, 22, 14);
		panel.add(lblX);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lbl_suwasetha = new JLabel("STAFF MANAGEMENT PANEL");
		lbl_suwasetha.setBounds(10, -5, 345, 55);
		panel.add(lbl_suwasetha);
		lbl_suwasetha.setForeground(new Color(255, 255, 255));
		lbl_suwasetha.setFont(new Font("Nirmala UI", Font.BOLD, 23));
		
		JLabel lbl_logo = new JLabel("New label");
		lbl_logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 stock cstock=new stock();
				 cstock.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblViewStocks.setForeground(Color.RED);
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblViewStocks.setForeground(Color.WHITE);

			}
		});
		
		JLabel lbl_order_1 = new JLabel("New label");
		lbl_order_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				assign_details ad=new assign_details();
				ad.setVisible(true);
			}
		});
		lbl_order_1.setBounds(36, 329, 303, 92);
		contentPane.add(lbl_order_1);
		
		JLabel lbl_order_1_1 = new JLabel("New label");
		lbl_order_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			assign_dates as=new assign_dates();
			as.setVisible(true);
			}
		});
		lbl_order_1_1.setBounds(36, 234, 303, 92);
		contentPane.add(lbl_order_1_1);
		
		JLabel lblRequestOrder_1 = new JLabel("View Vaccing Assigns");
		lblRequestOrder_1.setForeground(Color.WHITE);
		lblRequestOrder_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblRequestOrder_1.setBounds(140, 359, 292, 25);
		contentPane.add(lblRequestOrder_1);
		
		JLabel lblAssignVaccineDate = new JLabel("Assign Vaccine Date ");
		lblAssignVaccineDate.setForeground(Color.WHITE);
		lblAssignVaccineDate.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAssignVaccineDate.setBounds(140, 264, 212, 25);
		contentPane.add(lblAssignVaccineDate);
		
		lblViewStocks = new JLabel("View Stocks");
		lblViewStocks.setForeground(new Color(255, 255, 255));
		lblViewStocks.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblViewStocks.setBounds(179, 87, 130, 25);
		contentPane.add(lblViewStocks);
		lbl_logo.setBounds(36, 44, 316, 119);
		contentPane.add(lbl_logo);
		
		lbl_logo.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/222.png")));
		contentPane.add(lbl_logo);
		
		lbl_order_1_1.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/viewassign.png")));
		contentPane.add(lbl_order_1_1);
		
		lbl_order_1.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/assignvaccine.png")));
		contentPane.add(lbl_order_1);
		
		JLabel lbl_people = new JLabel("New label");
		lbl_people.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserDetails user=new UserDetails();
				user.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.RED);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.WHITE);

			}
		});
		lbl_people.setBounds(36, 146, 305, 92);
		contentPane.add(lbl_people);
		
		lbl_people.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/viewusers.png")));
		contentPane.add(lbl_people);
		
		JLabel lbl_view = new JLabel("New label");
		lbl_view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AllOrders all=new AllOrders();
				all.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.RED);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.WHITE);

			}
		});
		lbl_view.setBounds(36, 538, 303, 86);
		contentPane.add(lbl_view);
		
		lbl_view.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/viewoders.png")));
		contentPane.add(lbl_view);
		

		
		
		JLabel lbl_new = new JLabel("New label");
		lbl_new.setBackground(new Color(255, 255, 255));
		lbl_new.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_new.setBounds(0, 40, 1021, 606);
		contentPane.add(lbl_new);
		setUndecorated(true);
		

		lbl_new.setIcon(new ImageIcon(StaffHome.class.getResource("/IT20198886/Assets/Outsourcing1.jpg")));
		contentPane.add(lbl_new);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
}