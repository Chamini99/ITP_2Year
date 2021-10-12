package IT20137946;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_nic;
	private JTextField txt_email;
	private JTextField txt_pwd;
	private JTextField txt_age;
	private JTextField txt_telephone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(248, 10, 94, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(28, 104, 116, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NIC");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(28, 157, 116, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(28, 216, 116, 31);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(28, 289, 116, 31);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gender ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(380, 104, 116, 31);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Age ");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(380, 157, 116, 31);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Vaccine Type ");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(380, 216, 116, 31);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Telephone");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7.setBounds(380, 270, 116, 31);
		contentPane.add(lblNewLabel_1_7);
		
		txt_name = new JTextField();
		txt_name.setBounds(168, 104, 174, 31);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_nic = new JTextField();
		txt_nic.setColumns(10);
		txt_nic.setBounds(168, 157, 174, 31);
		contentPane.add(txt_nic);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(168, 216, 174, 31);
		contentPane.add(txt_email);
		
		txt_pwd = new JTextField();
		txt_pwd.setColumns(10);
		txt_pwd.setBounds(168, 278, 174, 31);
		contentPane.add(txt_pwd);
		
		txt_age = new JTextField();
		txt_age.setColumns(10);
		txt_age.setBounds(506, 157, 174, 31);
		contentPane.add(txt_age);
		
		txt_telephone = new JTextField();
		txt_telephone.setColumns(10);
		txt_telephone.setBounds(506, 270, 174, 31);
		contentPane.add(txt_telephone);
		
		JComboBox comboBox_gender = new JComboBox();
		comboBox_gender.setBounds(506, 111, 116, 24);
		contentPane.add(comboBox_gender);
		
		comboBox_gender.addItem("Female");
		comboBox_gender.addItem("Male");
		
		
		JComboBox comboBox_vactype = new JComboBox();
		comboBox_vactype.setBounds(506, 223, 116, 24);
		contentPane.add(comboBox_vactype);
		
		comboBox_vactype.addItem("Moderna");
		comboBox_vactype.addItem("Pfizer");
		comboBox_vactype.addItem("Sputnik V");
		comboBox_vactype.addItem("Sinovac");
		
		JButton btn_conf = new JButton("Confirm ");
		btn_conf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				MyAccount c = new MyAccount();
			
				c.setVisible(true);
				dispose();
				
			}
		});
		btn_conf.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_conf.setBounds(119, 390, 179, 47);
		contentPane.add(btn_conf);
		
		JButton btn_dele = new JButton("Delete ");
		btn_dele.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_name.setText("");
				txt_nic.setText("");
				txt_email.setText("");
				txt_pwd.setText("");
				txt_pwd.setText("");
				txt_age .setText("");
				txt_telephone.setText("");
				
			}
		});
		btn_dele.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_dele.setBounds(367, 390, 179, 47);
		contentPane.add(btn_dele);
	}
}
