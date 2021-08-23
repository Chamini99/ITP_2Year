package IT20123840;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DeliveryRequest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryRequest frame = new DeliveryRequest();
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
	public DeliveryRequest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 380, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblX.setBounds(349, 0, 28, 33);
		panel.add(lblX);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX_1 = new JLabel("  -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX_1.setBounds(330, 0, 28, 33);
		panel.add(lblX_1);
		
		JLabel lblDeliveryRequest = new JLabel("Delivery Request");
		lblDeliveryRequest.setForeground(new Color(95, 158, 160));
		lblDeliveryRequest.setFont(new Font("Calibri", Font.BOLD, 28));
		lblDeliveryRequest.setBounds(91, 44, 197, 25);
		contentPane.add(lblDeliveryRequest);
		
		JLabel lblDeliveryNumber = new JLabel("Delivery Number");
		lblDeliveryNumber.setForeground(new Color(95, 158, 160));
		lblDeliveryNumber.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDeliveryNumber.setBounds(54, 104, 108, 19);
		contentPane.add(lblDeliveryNumber);
		
		JLabel lblVaccineType = new JLabel("Vaccine Type");
		lblVaccineType.setForeground(new Color(95, 158, 160));
		lblVaccineType.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVaccineType.setBounds(54, 146, 86, 19);
		contentPane.add(lblVaccineType);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(95, 158, 160));
		lblQuantity.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblQuantity.setBounds(54, 188, 56, 19);
		contentPane.add(lblQuantity);
		
		JLabel lblDateOfDelivery = new JLabel("Date of Delivery");
		lblDateOfDelivery.setForeground(new Color(95, 158, 160));
		lblDateOfDelivery.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDateOfDelivery.setBounds(54, 231, 108, 19);
		contentPane.add(lblDateOfDelivery);
		
		textField = new JTextField();
		textField.setBounds(219, 103, 108, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(219, 145, 108, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 187, 108, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 230, 108, 20);
		contentPane.add(textField_3);
		
		JButton btnSend = new JButton("Send");
		btnSend.setForeground(Color.WHITE);
		btnSend.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSend.setBackground(new Color(95, 158, 160));
		btnSend.setBounds(54, 291, 102, 33);
		contentPane.add(btnSend);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnCancel.setBackground(new Color(95, 158, 160));
		btnCancel.setBounds(225, 291, 102, 33);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 380, 333);
		contentPane.add(label);
		setUndecorated(true);
		label.setIcon(new ImageIcon(DeliveryRequest.class.getResource("/IT20123840/Assets/login.jpeg")));
	}

}
