package IT20137946;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Appointment extends JFrame {

	private JPanel contentPane;
	private JTextField txt_aptdate;
	private JTextField txt_aptime;
	private JTextField txt_reason;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment frame = new Appointment();
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
	public Appointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appoint to Doctor \r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(226, 10, 203, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelectDoctor = new JLabel("Select Doctor ");
		lblSelectDoctor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectDoctor.setBounds(25, 66, 203, 43);
		contentPane.add(lblSelectDoctor);
		
		JLabel lblAppointDate = new JLabel("Appoint Date \r\n");
		lblAppointDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAppointDate.setBounds(25, 132, 203, 43);
		contentPane.add(lblAppointDate);
		
		JLabel lblAppointTime = new JLabel("Appoint Time");
		lblAppointTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAppointTime.setBounds(25, 182, 203, 43);
		contentPane.add(lblAppointTime);
		
		JLabel lblReason = new JLabel("Reason \r\n");
		lblReason.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReason.setBounds(25, 235, 203, 43);
		contentPane.add(lblReason);
		
		txt_aptdate = new JTextField();
		txt_aptdate.setBounds(213, 138, 293, 35);
		contentPane.add(txt_aptdate);
		txt_aptdate.setColumns(10);
		
		txt_aptime = new JTextField();
		txt_aptime.setColumns(10);
		txt_aptime.setBounds(213, 190, 293, 35);
		contentPane.add(txt_aptime);
		
		txt_reason = new JTextField();
		txt_reason.setColumns(10);
		txt_reason.setBounds(213, 249, 377, 69);
		contentPane.add(txt_reason);
		
		JButton btn_apt = new JButton("Make Appointment \r\n");
		btn_apt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myappointments frame = new myappointments();
				frame.setVisible(true);
				dispose();
			}
		});
		btn_apt.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_apt.setBounds(81, 348, 170, 42);
		contentPane.add(btn_apt);
		
		JButton btn_back = new JButton("Back ");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home frame = new Home();
				frame.setVisible(true);
				dispose();
			}
		});
		btn_back.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_back.setBounds(336, 348, 170, 42);
		contentPane.add(btn_back);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(213, 79, 177, 30);
		contentPane.add(comboBox);
	}
}
