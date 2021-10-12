package IT20119744;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class email_send extends JFrame {

	private JPanel contentPane;
	private JTextField to_email;
	private JTextField from_email;
	private JTextField subject_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					email_send frame = new email_send();
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
	public email_send() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 580, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setForeground(Color.WHITE);
			}
		});
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Segoe UI", Font.BOLD, 40));
		label.setBounds(495, 2, 30, 20);
		panel.add(label);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//setVisible(false);
				if(JOptionPane.showConfirmDialog(null,"Do you want to Exit?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					email_send.this.dispose();
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
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblX.setBounds(540, 2, 42, 33);
		panel.add(lblX);
		
		JLabel label_1 = new JLabel("<<");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addAdmin aA= new addAdmin ();
				aA.setVisible(true);				
				setVisible(false);
			}
		});
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		label_1.setBounds(23, 0, 40, 33);
		panel.add(label_1);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setForeground(new Color(95, 158, 160));
		lblTo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTo.setBounds(43, 81, 56, 33);
		contentPane.add(lblTo);
		
		JLabel lblFrom = new JLabel("FROM");
		lblFrom.setForeground(new Color(95, 158, 160));
		lblFrom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblFrom.setBounds(43, 141, 110, 33);
		contentPane.add(lblFrom);
		
		JLabel lblSubject = new JLabel("SUBJECT");
		lblSubject.setForeground(new Color(95, 158, 160));
		lblSubject.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSubject.setBounds(43, 200, 110, 33);
		contentPane.add(lblSubject);
		
		JLabel lblMessage = new JLabel("MESSAGE");
		lblMessage.setForeground(new Color(95, 158, 160));
		lblMessage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMessage.setBounds(43, 264, 120, 33);
		contentPane.add(lblMessage);
		
		to_email = new JTextField();
		to_email.setForeground(new Color(95, 158, 160));
		to_email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		to_email.setBounds(200, 88, 350, 33);
		contentPane.add(to_email);
		to_email.setColumns(10);
		
		JTextArea message_email = new JTextArea();
		message_email.setForeground(new Color(95, 158, 160));
		message_email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		message_email.setBounds(200, 264, 350, 189);
		contentPane.add(message_email);
		
		from_email = new JTextField();
		from_email.setForeground(new Color(95, 158, 160));
		from_email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		from_email.setText("suwasethavaccine2021@gmail.com");
		from_email.setColumns(10);
		from_email.setBounds(200, 141, 350, 33);
		contentPane.add(from_email);
		
		subject_email = new JTextField();
		subject_email.setForeground(new Color(95, 158, 160));
		subject_email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		subject_email.setColumns(10);
		subject_email.setBounds(200, 200, 350, 33);
		contentPane.add(subject_email);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ToEmail = to_email.getText();
				String FromEmail = from_email.getText();
				String FromEmailPassword = "suwavacc2021@";
				String Subjects = subject_email.getText();
				
				Properties properties = new Properties();
				properties.put("mail.smtp.auth","true");
				properties.put("mail.smtp.starttls.enable","true");
				properties.put("mail.smtp.host","smtp.gmail.com");
				properties.put("mail.smtp.port","587");
				
				Session session =Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(FromEmail, FromEmailPassword);
					}
				});
				
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(FromEmail));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
					message.setSubject(Subjects);
					message.setText(message_email.getText());
					Transport.send(message);
				}catch(Exception ex) {
					System.out.println(""+ex);
				}
			}
		});
		btnSend.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnSend.setBackground(new Color(95, 158, 160));
		btnSend.setForeground(new Color(255, 255, 255));
		btnSend.setBounds(230, 513, 150, 44);
		contentPane.add(btnSend);
		
		JLabel lblNewLabel_11 =new JLabel("");
		lblNewLabel_11.setBounds(0, 0, 580, 580);
		lblNewLabel_11.setIcon(new ImageIcon(email_send.class.getResource("/IT20119744/assets/login.jpeg")));
		contentPane.add(lblNewLabel_11);
		
	}
}
