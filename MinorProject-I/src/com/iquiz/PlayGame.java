package com.iquiz;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.Label;

public class PlayGame extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	static int seconds=90;
	static int chooseTime = seconds;
	
	public static void main(String[] args) {
		System.out.println(seconds);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					PlayGame frame = new PlayGame();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PlayGame() {
		
	}
	
	  	public void initComponents(String user) {
	  		
	  		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {  
				    int a=JOptionPane.showConfirmDialog(frame,"Are you sure?","",JOptionPane.INFORMATION_MESSAGE);  
				if(a==JOptionPane.YES_OPTION){  
				    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				}  
				}  
				
			});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 790, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(307, 39, 169, 155);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(PlayGame.class.getResource("/com/iquiz/IquizImages/images (2).png")));
		panel.add(label_1);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(183, 97, 419, 317);
		panel_1.setBackground(new Color(0,0,0,15));		
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnPlayGame = new JButton("Play Game");
		btnPlayGame.setBounds(102, 253, 227, 41);
		panel_1.add(btnPlayGame);
		btnPlayGame.setForeground(new Color(0, 0, 255));
		btnPlayGame.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		
		Choice choice = new Choice();
		choice.add("90 sec");
		choice.add("180 sec");
		choice.add("270 sec");
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ae) {
				if(choice.getSelectedItem() == "90 sec") {
					seconds = 90;
				}
				else if(choice.getSelectedItem()=="180 sec") {
					seconds = 180;
				}
				else {
					seconds = 270;
				}
			}
		});
		choice.setBounds(201, 204, 98, 24);
		
		panel_1.add(choice);
		
		
		JLabel lblSelectTime = new JLabel("Select Time:");
		lblSelectTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTime.setForeground(new Color(240, 255, 255));
		lblSelectTime.setFont(new Font("Script MT Bold", Font.PLAIN, 20));
		lblSelectTime.setBounds(73, 204, 122, 24);
		panel_1.add(lblSelectTime);
		
		JLabel lblWelcome = new JLabel("Welcome: "+user);
		lblWelcome.setBounds(-138, 109, 690, 79);
		panel_1.add(lblWelcome);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(240, 255, 255));
		lblWelcome.setFont(new Font("Script MT Bold", Font.PLAIN, 40));
		btnPlayGame.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent ae) {
				GameWindow gw = new GameWindow();
				
//				gw.setVisible(true);
				setVisible(false);		
				gw.start();
				gw.initComponents(user);
				gw.setLocationRelativeTo(null);
			}
			
		});
		
		
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 784, 461);
		label.setForeground(new Color(245, 255, 250));
		label.setIcon(new ImageIcon(PlayGame.class.getResource("/com/iquiz/IquizImages/1 (1).jpg")));
		panel.add(label);
	}
}
