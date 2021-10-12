package IT20137946;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txt_na;
	private JTextField txt_ni;
	private JTextField txt_emai;
	private JTextField txt_gend;
	private JTextField txt_age;
	private JTextField txt_vacty;
	private JTextField txt_tel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAccount frame = new MyAccount();
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
	public MyAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Account \r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(184, 26, 193, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(28, 94, 70, 35);
		contentPane.add(lblName);
		
		JLabel lblNic = new JLabel("NIC");
		lblNic.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNic.setBounds(28, 150, 70, 35);
		contentPane.add(lblNic);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(28, 210, 70, 35);
		contentPane.add(lblEmail);
		
		JLabel lblGender = new JLabel("Gender ");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(309, 94, 193, 35);
		contentPane.add(lblGender);
		
		JLabel lblAge = new JLabel("Age ");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(309, 150, 193, 35);
		contentPane.add(lblAge);
		
		JLabel lblVaccineType = new JLabel("Vaccine Type ");
		lblVaccineType.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVaccineType.setBounds(309, 195, 193, 35);
		contentPane.add(lblVaccineType);
		
		JLabel lblTelephone = new JLabel("Telephone ");
		lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTelephone.setBounds(309, 238, 193, 35);
		contentPane.add(lblTelephone);
		
		JButton btn_lgout = new JButton("Log Out ");
		btn_lgout.setBounds(21, 323, 140, 35);
		contentPane.add(btn_lgout);
		
		JButton btn_update = new JButton("Update ");
		btn_update.setBounds(201, 323, 140, 35);
		contentPane.add(btn_update);
		
		JButton btn_delete = new JButton("Delete ");
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_na.setText("");
				txt_ni.setText("");
				txt_emai.setText("");
				txt_gend.setText("");
				txt_age.setText("");
				txt_vacty.setText("");
				txt_tel.setText("");
			}
		});
		btn_delete.setBounds(399, 323, 140, 35);
		contentPane.add(btn_delete);
		
		txt_na = new JTextField();
		txt_na.setBounds(109, 94, 169, 29);
		contentPane.add(txt_na);
		txt_na.setColumns(10);
		
		txt_ni = new JTextField();
		txt_ni.setColumns(10);
		txt_ni.setBounds(108, 160, 169, 29);
		contentPane.add(txt_ni);
		
		txt_emai = new JTextField();
		txt_emai.setColumns(10);
		txt_emai.setBounds(108, 220, 169, 29);
		contentPane.add(txt_emai);
		
		txt_gend = new JTextField();
		txt_gend.setColumns(10);
		txt_gend.setBounds(439, 94, 169, 29);
		contentPane.add(txt_gend);
		
		txt_age = new JTextField();
		txt_age.setColumns(10);
		txt_age.setBounds(439, 155, 169, 29);
		contentPane.add(txt_age);
		
		txt_vacty = new JTextField();
		txt_vacty.setColumns(10);
		txt_vacty.setBounds(439, 201, 169, 29);
		contentPane.add(txt_vacty);
		
		txt_tel = new JTextField();
		txt_tel.setColumns(10);
		txt_tel.setBounds(439, 248, 169, 29);
		contentPane.add(txt_tel);
		
		JButton btn_back = new JButton("Back ");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home frame = new Home();
				frame.setVisible(true);
				dispose();
			}
		});
		btn_back.setBounds(566, 323, 81, 35);
		contentPane.add(btn_back);
	}
}

