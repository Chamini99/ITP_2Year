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
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Stock extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
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
	public Stock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 702);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX_1 = new JLabel("   -");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblX_1.setBounds(521, 0, 35, 33);
		panel.add(lblX_1);
		
		JLabel lblX = new JLabel("   X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblX.setBounds(545, 0, 35, 33);
		panel.add(lblX);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setForeground(new Color(95, 158, 160));
		lblStock.setFont(new Font("Calibri", Font.BOLD, 28));
		lblStock.setBounds(256, 44, 63, 26);
		contentPane.add(lblStock);
		
		table = new JTable();
		table.setBounds(29, 93, 521, 170);
		contentPane.add(table);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setForeground(new Color(95, 158, 160));
		lblCompanyName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCompanyName.setBounds(29, 67, 117, 26);
		contentPane.add(lblCompanyName);
		
		table_1 = new JTable();
		table_1.setBounds(29, 299, 521, 170);
		contentPane.add(table_1);
		
		JLabel lblCompanyName_1 = new JLabel("Company Name");
		lblCompanyName_1.setForeground(new Color(95, 158, 160));
		lblCompanyName_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCompanyName_1.setBounds(29, 274, 117, 26);
		contentPane.add(lblCompanyName_1);
		
		JLabel lblCompanyName_2 = new JLabel("Company Name");
		lblCompanyName_2.setForeground(new Color(95, 158, 160));
		lblCompanyName_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCompanyName_2.setBounds(29, 490, 117, 23);
		contentPane.add(lblCompanyName_2);
		
		table_2 = new JTable();
		table_2.setBounds(29, 513, 521, 170);
		contentPane.add(table_2);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 580, 667);
		contentPane.add(label);
		setUndecorated(true);
		label.setIcon(new ImageIcon(Stock.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
