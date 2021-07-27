package IT20198886;

import java.awt.*;
import javax.swing.*;

public class SplashWindow {

    public static void main(String[] args) {
        final int MAX = 100;
        final JFrame frame = new JFrame("JProgress Demo");
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Suwasetha Medical Center");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Source Sans Pro Light", Font.BOLD, 30));
        lblNewLabel_1.setBounds(207, 11, 411, 56);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2_1 = new JLabel("No.356,Kandy Road,Kadawatha");
        lblNewLabel_2_1.setForeground(new Color(230, 230, 250));
        lblNewLabel_2_1.setFont(new Font("Source Sans Pro ExtraLight", Font.PLAIN, 14));
        lblNewLabel_2_1.setBounds(375, 213, 291, 26);
        frame.getContentPane().add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2 = new JLabel("Vaccine Management System");
        lblNewLabel_2.setFont(new Font("Source Sans Pro ExtraLight", Font.PLAIN, 21));
        lblNewLabel_2.setForeground(new Color(230, 230, 250));
        lblNewLabel_2.setBounds(245, 63, 291, 26);
        frame.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1_2 = new JLabel("Main Branch");
        lblNewLabel_2_1_2.setForeground(new Color(230, 230, 250));
        lblNewLabel_2_1_2.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 16));
        lblNewLabel_2_1_2.setBounds(352, 185, 291, 26);
        frame.getContentPane().add(lblNewLabel_2_1_2);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("+94 11 2 750 979");
        lblNewLabel_2_1_1.setForeground(new Color(230, 230, 250));
        lblNewLabel_2_1_1.setFont(new Font("Source Sans Pro ExtraLight", Font.PLAIN, 14));
        lblNewLabel_2_1_1.setBounds(375, 241, 291, 26);
        frame.getContentPane().add(lblNewLabel_2_1_1);

        
                // creates progress bar
                final JProgressBar pb = new JProgressBar();
                pb.setBounds(202, 278, 379, 23);
                pb.setMinimum(0);
                pb.setMaximum(MAX);
                pb.setStringPainted(true);
                frame.getContentPane().add(pb);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(0, 0, 782, 330);
        frame.getContentPane().add(lblNewLabel);
        
        lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/IT20198886/Assets/splashbackground.jpg")));
		frame.getContentPane().add(lblNewLabel);
		
frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(782, 330);
        frame.setVisible(true);

        // update progressbar
        for (int i = 0; i <= MAX; i++) {
            final int currentValue = i;
            try {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        pb.setValue(currentValue);
                    }
                });
                java.lang.Thread.sleep(100);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        }

    }
}