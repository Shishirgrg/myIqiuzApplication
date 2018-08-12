package com.iquiz;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class HomePage extends JFrame {
	private JPanel contentPane;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					HomePage frame = new HomePage();
//					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public HomePage() {
	}
	public void  initComponents(String admin) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
			    int a=JOptionPane.showConfirmDialog(frame,"Are you sure?","",JOptionPane.INFORMATION_MESSAGE);  
			if(a==JOptionPane.YES_OPTION){  
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			}  
			}  
			
		});
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 780,480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(0, 0, 784, 510);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAddQuestions = new JButton("Add Questions");
		btnAddQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Addpage frame1 = new Addpage();
				frame1.initComponents(admin);
				frame1.setLocationRelativeTo(null);
			}
		});
		
		JLabel lblWelcome = new JLabel("Welcome: "+admin);
		lblWelcome.setForeground(new Color(0,0,0));
		lblWelcome.setBounds(169, 135, 459, 59);
		panel_1.add(lblWelcome);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 34));
		btnAddQuestions.setBackground(new Color(255, 255, 255));
		btnAddQuestions.setForeground(new Color(100, 149, 237));
		btnAddQuestions.setFont(new Font("Rockwell", Font.PLAIN, 18));
		btnAddQuestions.setBounds(245, 229, 321, 31);
		panel_1.add(btnAddQuestions);
		
		JButton btnQuestion = new JButton("List of Questions");
		btnQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Editingpage frame = new Editingpage();
				frame.initComponents(admin);
				frame.setLocationRelativeTo(null);
			}
		});
		btnQuestion.setBackground(new Color(255, 255, 255));
		btnQuestion.setForeground(new Color(100, 149, 237));
		btnQuestion.setFont(new Font("Rockwell", Font.PLAIN, 18));
		btnQuestion.setBounds(245, 296, 321, 31);
		panel_1.add(btnQuestion);
		
		JButton btnSignOut_1 = new JButton("Sign out");
		btnSignOut_1.setFont(new Font("Rockwell", Font.PLAIN, 18));
		btnSignOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WelcomeScreen frame;
				try {
					frame = new WelcomeScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnSignOut_1.setHorizontalAlignment(SwingConstants.CENTER);
		btnSignOut_1.setForeground(new Color(100, 149, 237));
		btnSignOut_1.setEnabled(true);
		btnSignOut_1.setBackground(new Color(255, 255, 255));
		btnSignOut_1.setBounds(349, 381, 111, 31);
		panel_1.add(btnSignOut_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HomePage.class.getResource("/com/iquiz/IquizImages/logo.png")));
		label_1.setBounds(0, 0, 305, 141);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(HomePage.class.getResource("/com/iquiz/IquizImages/Webp.net-resizeimage (2).png")));
		label_2.setBounds(603, 15, 151, 126);
		panel_1.add(label_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(HomePage.class.getResource("/com/iquiz/IquizImages/Webp.net-compress-image (10).jpg")));
		label.setBounds(0, 0, 774, 440);
		panel_1.add(label);
	}
}
