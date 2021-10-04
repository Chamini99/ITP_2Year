package IT20122782;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class DocAppoin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocAppoin frame = new DocAppoin();
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
	public DocAppoin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("My Appoinments");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(297, 37, 188, 35);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(51, 111, 660, 365);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DocHome m = new DocHome();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(35, 489, 113, 35);
		contentPane.add(btnNewButton);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch.setText("   Search");
		txtSearch.setBounds(572, 69, 101, 29);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
	}
}
