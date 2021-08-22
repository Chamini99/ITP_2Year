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
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EditStock extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStock frame = new EditStock();
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
	public EditStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 622, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		lblX.setBounds(594, 0, 28, 33);
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
		lblX_1.setBounds(572, 0, 28, 33);
		panel.add(lblX_1);
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		table = new JTable();
		table.setBounds(21, 92, 580, 228);
		contentPane.add(table);
		
		JLabel lblEditStock = new JLabel("Edit Stock");
		lblEditStock.setForeground(new Color(95, 158, 160));
		lblEditStock.setFont(new Font("Calibri", Font.BOLD, 24));
		lblEditStock.setBounds(263, 44, 98, 30);
		contentPane.add(lblEditStock);
		
		JButton btnAddNewVaccine = new JButton("Add New Vaccine");
		btnAddNewVaccine.setBackground(new Color(95, 158, 160));
		btnAddNewVaccine.setForeground(new Color(255, 255, 255));
		btnAddNewVaccine.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnAddNewVaccine.setBounds(210, 344, 196, 33);
		contentPane.add(btnAddNewVaccine);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 33, 622, 371);
		contentPane.add(label);
		setUndecorated(true);
		label.setIcon(new ImageIcon(EditStock.class.getResource("/IT20123840/Assets/login.jpeg")));
	}
}
