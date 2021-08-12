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

public class EditOrders extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditOrders frame = new EditOrders();
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
	public EditOrders() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 650, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(620, 0, 30, 33);
		panel.add(lblX);
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
		lblX_1.setBounds(597, 0, 30, 33);
		panel.add(lblX_1);
		
		JLabel lblEditOrders = new JLabel("Edit Orders");
		lblEditOrders.setForeground(new Color(95, 158, 160));
		lblEditOrders.setFont(new Font("Calibri", Font.BOLD, 28));
		lblEditOrders.setBounds(261, 44, 131, 26);
		contentPane.add(lblEditOrders);
		
		table = new JTable();
		table.setBounds(36, 81, 580, 282);
		contentPane.add(table);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 34, 650, 352);
		contentPane.add(label);
		setUndecorated(true);
		label.setIcon(new ImageIcon(EditOrders.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
