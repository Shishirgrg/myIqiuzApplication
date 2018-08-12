
package com.iquiz;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.SwingConstants;


public class SplashScreen extends javax.swing.JFrame {
	public JProgressBar progressBar;
   
    public SplashScreen() {
    	setResizable(false);
    	setLocationRelativeTo(null);
        initComponents();
    }
    
    
                        
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setSize(new java.awt.Dimension(785, 460));
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 784, 461);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblLoading = new JLabel("Loading...");
        lblLoading.setForeground(new Color(176, 196, 222));
        lblLoading.setFont(new Font("Poor Richard", Font.ITALIC, 21));
        lblLoading.setBounds(349, 412, 96, 27);
        panel.add(lblLoading);
        
       
        progressBar = new JProgressBar();
        progressBar.setForeground(new Color(31, 41, 45));
        progressBar.setBounds(109, 374, 580, 20);
        panel.add(progressBar);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(SplashScreen.class.getResource("/com/iquiz/IquizImages/Untitled-1.png")));
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(0, 0, 784, 461);
        panel.add(label);
        setUndecorated(true);
        
    }                        

    
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    	UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               SplashScreen sc =  new SplashScreen();
               sc.setUndecorated(true);
            }
        });
    }
}
