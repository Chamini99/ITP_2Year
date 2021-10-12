package IT20137946;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
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
		setBounds(100, 100, 632, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JButton btn_profile = new JButton("My Account ");
		btn_profile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyAccount sp = new MyAccount();
				sp.setVisible(true);
				dispose();
				
			}
		});
		btn_profile.setBounds(70, 257, 120, 34);
		contentPane.add(btn_profile);
		
		JButton btn_apt = new JButton("Make Appointment");
		btn_apt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Appointment sp = new Appointment();
				sp.setVisible(true);
				dispose();
			}
		});
		btn_apt.setBounds(226, 257, 159, 34);
		contentPane.add(btn_apt);
		
		JButton btn_vdate = new JButton("Vaccine Date");
		btn_vdate.setBounds(412, 257, 124, 34);
		contentPane.add(btn_vdate);
	}

}
