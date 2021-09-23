package IT20119744;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.Frame;
import java.awt.Image;


public class SplashWindow extends JFrame {

	private JPanel contentPane;
	JProgressBar Load;
	JLabel Loading;
	private JLabel lblNo;
	private JLabel lblTp;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) throws InterruptedException{
		SplashWindow splash=new SplashWindow();
		
		
		
		
		for (int i = 0;i<=100;i++) {
			Thread.sleep(40);
			splash.setVisible(true);
			splash.Loading.setText("Loading.." +i+"%");
			splash.Load.setValue(i);
				
		
		if(i==100) {
			Home home=new Home();
			home.setVisible(true);
			splash.dispose();
		}
		}
	}
	

	private void setContentPane(ImageIcon imageIcon) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Create the frame.
	 */
	public SplashWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 362);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setForeground(UIManager.getColor("ToolBar.floatingForeground"));
		contentPane.setIgnoreRepaint(true);
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    JLabel lblNewLabel_1 = new JLabel("Suwasetha Medical Center");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Source Sans Pro Light", Font.BOLD, 30));
        lblNewLabel_1.setBounds(207, 11, 411, 56);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2_1 = new JLabel("No.356,Kandy Road,Kadawatha");
        lblNewLabel_2_1.setForeground(new Color(230, 230, 250));
        lblNewLabel_2_1.setFont(new Font("Source Sans Pro ExtraLight", Font.PLAIN, 14));
        lblNewLabel_2_1.setBounds(433, 213, 291, 26);
        contentPane.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2 = new JLabel("Vaccine Management System");
        lblNewLabel_2.setFont(new Font("Source Sans Pro ExtraLight", Font.PLAIN, 21));
        lblNewLabel_2.setForeground(new Color(230, 230, 250));
        lblNewLabel_2.setBounds(245, 63, 291, 26);
        contentPane.add(lblNewLabel_2);
        
        Load = new JProgressBar();
        Load.setBorder(null);
        Load.setBorderPainted(false);
        Load.setEnabled(false);
        Load.setBackground(new Color(255, 255, 255));
        Load.setForeground(new Color(95, 158, 160));
        Load.setBounds(117, 278, 560, 14);
        contentPane.add(Load);
        
        JLabel lblNewLabel_2_1_2 = new JLabel("Main Branch");
        lblNewLabel_2_1_2.setForeground(new Color(230, 230, 250));
        lblNewLabel_2_1_2.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 16));
        lblNewLabel_2_1_2.setBounds(410, 185, 291, 26);
        contentPane.add(lblNewLabel_2_1_2);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("+94 11 2 750 979");
        lblNewLabel_2_1_1.setForeground(new Color(230, 230, 250));
        lblNewLabel_2_1_1.setFont(new Font("Source Sans Pro ExtraLight", Font.PLAIN, 14));
        lblNewLabel_2_1_1.setBounds(433, 241, 291, 26);
        contentPane.add(lblNewLabel_2_1_1);

        
             
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(0, 0, 787, 362);
        contentPane.add(lblNewLabel);
        
        lblNewLabel.setIcon(new ImageIcon(SplashWindow.class.getResource("/IT20119744/assets/splashbackground.jpg")));
        contentPane.add(lblNewLabel);
		
		Loading = new JLabel("Loading..");
		Loading.setForeground(new Color(128, 0, 128));
		Loading.setBackground(new Color(105, 105, 105));
		Loading.setBounds(10, 20, 122, 14);
		contentPane.add(Loading);
		Loading.setFont(new Font("TomeOfTheUnknown", Font.BOLD, 16));
		Loading.setBackground(new Color(51, 51, 51));
		

		label = new JLabel("");
		label.setBounds(0, 0, 580, 267);
		label.setIcon(new ImageIcon("/IT20119744/assets/splashbackground.jpg"));
		
		
		contentPane.add(label);
		//Image img=new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\log.png");
		
		setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		}

	
	
	
	protected JProgressBar getLoad() {
		return Load;
	}
	protected JLabel Loading() {
		return Loading;
	}
}



