package com.iquiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;

public class WelcomeScreen extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen frame = new WelcomeScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WelcomeScreen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
			    int a=JOptionPane.showConfirmDialog(frame,"Are you sure?","",JOptionPane.INFORMATION_MESSAGE);  
			if(a==JOptionPane.YES_OPTION){  
			   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			}  
			}  
			
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 790,490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcomeToIquiz = new JLabel("Welcome Abroad",JLabel.CENTER);
		lblWelcomeToIquiz.setFont(new Font("Edwardian Script ITC", Font.BOLD, 60));
		lblWelcomeToIquiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToIquiz.setBounds(151, 35, 451, 75);
		panel.add(lblWelcomeToIquiz);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(WelcomeScreen.class.getResource("/com/iquiz/IquizImages/Webp.net-resizeimage (1).png")));
		label_1.setBounds(151, 231, 136, 121);
		panel.add(label_1);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				AloginPage alg;
				try {
					alg = new AloginPage();
					alg.setVisible(true);
					alg.setLocationRelativeTo(null);
					setVisible(false);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAdmin.setBounds(167, 374, 89, 23);
		panel.add(btnAdmin);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(WelcomeScreen.class.getResource("/com/iquiz/IquizImages/Webp.net-compress-image.png")));
		label_2.setBounds(491, 231, 136, 121);
		panel.add(label_2);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPage lg = new LoginPage();
				lg.setVisible(true);
				lg.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnUser.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnUser.setBounds(513, 374, 89, 23);
		panel.add(btnUser);
		
		JLabel lblTo = new JLabel("To",JLabel.CENTER);
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("Goudy Old Style", Font.ITALIC, 20));
		lblTo.setBounds(374, 121, 46, 23);
		panel.add(lblTo);
		
		JLabel lblIquiz = new JLabel("IQuiz??",JLabel.CENTER);
		lblIquiz.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 30));
		lblIquiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblIquiz.setBounds(328, 155, 155, 54);
		panel.add(lblIquiz);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(WelcomeScreen.class.getResource("/com/iquiz/IquizImages/fondo-1024x576.jpg")));
		label.setBounds(0, 0, 784, 460);
		panel.add(label);
	}
}
