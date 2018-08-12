package com.iquiz;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

public class Addpage extends JFrame {
	private JFrame frame;
	String adminname;
	private JPanel contentPane;
	private JTextField txtOption;
	private JTextField txtChoice;
	private JTextField txtChoice_1;
	private JTextField txtChoice_2;
	private JTextField txtCorrectAnswer;
	private JTextField txtEnterCatagory;
	private JLabel lblAnswer;
	private JLabel lblCategory;
	private JButton btnAdd;
	private JButton btnReset;
	private JButton btnReturn;
	
	
	Statement stmt;
	Connection conn;
	private JTextArea txtrEnterSomeQuestions;
	private JLabel label;
	private JLabel lblAddSomeQuestions;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Addpage frame1 = new Addpage();
//					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Addpage() {
	}
	public void initComponents(String admin) {
	
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
			    int a=JOptionPane.showConfirmDialog(frame,"Are you sure?","",JOptionPane.INFORMATION_MESSAGE);  
			if(a==JOptionPane.YES_OPTION){  
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			}  
			}  
			
		});
//		setLocationRelativeTo(null);
		adminname =  admin;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		setResizable(false);
		setBounds(100, 100, 790,490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(0, 0, 784, 461);
		contentPane.add(panel_1);
		
		txtOption = new JTextField();
		txtOption.setForeground(new Color(169, 169, 169));
		txtOption.setFont(new Font("Monotype Corsiva", Font.BOLD, 17));
		txtOption.setBounds(86, 222, 212, 31);
		txtOption.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				txtOption.setText("");
				txtOption.setForeground(new Color(0,0,0));
			}
		});
		panel_1.setLayout(null);
		txtOption.setText("Choice1");
		panel_1.add(txtOption);
		txtOption.setColumns(10);
		
		txtChoice = new JTextField();
		txtChoice.setForeground(new Color(169, 169, 169));
		txtChoice.setFont(new Font("Monotype Corsiva", Font.BOLD, 17));
		txtChoice.setBounds(86, 276, 212, 31);
		txtChoice.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				txtChoice.setText("");
				txtChoice.setForeground(new Color(0,0,0));
			}
		});
		txtChoice.setText("Choice3");
		txtChoice.setColumns(10);
		panel_1.add(txtChoice);
		
		txtChoice_1 = new JTextField();
		txtChoice_1.setForeground(new Color(169, 169, 169));
		txtChoice_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 17));
		txtChoice_1.setBounds(466, 222, 212, 31);
		txtChoice_1.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				txtChoice_1.setText("");
				txtChoice_1.setForeground(new Color(0,0,0));
			}
		});
		txtChoice_1.setText("Choice2");
		txtChoice_1.setColumns(10);
		panel_1.add(txtChoice_1);
		
		txtChoice_2 = new JTextField();
		txtChoice_2.setForeground(new Color(169, 169, 169));
		txtChoice_2.setFont(new Font("Monotype Corsiva", Font.BOLD, 17));
		txtChoice_2.setBounds(466, 276, 212, 31);
		txtChoice_2.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				txtChoice_2.setText("");
				txtChoice_2.setForeground(new Color(0,0,0));
			}
		});
		txtChoice_2.setText("Choice4");
		txtChoice_2.setColumns(10);
		panel_1.add(txtChoice_2);
		
		txtCorrectAnswer = new JTextField();
		txtCorrectAnswer.setForeground(new Color(169, 169, 169));
		txtCorrectAnswer.setFont(new Font("Monotype Corsiva", Font.BOLD, 17));
		txtCorrectAnswer.setBounds(86, 335, 212, 31);
		txtCorrectAnswer.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				txtCorrectAnswer.setText("");
				txtCorrectAnswer.setForeground(new Color(0,0,0));
			}
		});
		txtCorrectAnswer.setText("Correct Answer");
		txtCorrectAnswer.setColumns(10);
		panel_1.add(txtCorrectAnswer);
		
		txtEnterCatagory = new JTextField();
		txtEnterCatagory.setForeground(new Color(169, 169, 169));
		txtEnterCatagory.setFont(new Font("Monotype Corsiva", Font.BOLD, 17));
		txtEnterCatagory.setBounds(466, 330, 212, 31);
		txtEnterCatagory.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				txtEnterCatagory.setText("");
				txtEnterCatagory.setForeground(new Color(0,0,0));
			}
		});
		txtEnterCatagory.setText("Enter category");
		txtEnterCatagory.setColumns(10);
		panel_1.add(txtEnterCatagory);
		
		lblAnswer = new JLabel("Answer:");
		lblAnswer.setBounds(10, 348, 61, 14);
		lblAnswer.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblAnswer);
		
		lblCategory = new JLabel("Category:");
		lblCategory.setBounds(379, 339, 80, 20);
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		panel_1.add(lblCategory);
		
		btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(65, 105, 225));
		btnAdd.setBounds(86, 404, 134, 36);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opt1,opt2,opt3,opt4,ans,catg,qstn;
				qstn = txtrEnterSomeQuestions.getText();
				opt1 = txtOption.getText();
				opt2 = txtChoice.getText();
				opt3 = txtChoice_1.getText();
				opt4 = txtChoice_2.getText();
				ans = txtCorrectAnswer.getText();
				catg = txtEnterCatagory.getText();
				
				/// blank validation for adding question
				if(qstn.equals("") && opt1.equals("") && opt2.equals("")&& opt3.equals("") && opt4.equals("") &&  ans.equals("") && catg.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter the empty fields","Error",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else if(qstn.equals("") || opt1.equals("") || opt2.equals("") || opt3.equals("") || opt4.equals("") ||  ans.equals("") ||  catg.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter the empty fields","Error",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else if(qstn.equals("Enter some questions here!!!") || opt1.equals("Choice1") || opt2.equals("Choice2") || opt3.equals("Choice3") || opt4.equals("Choice4") ||  ans.equals("Correct Answer") ||  catg.equals("Enter Category")){
					JOptionPane.showMessageDialog(null,"Enter the empty fields","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				/*if(qstn.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter the empty field","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				if(opt1.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter the empty field","Error",JOptionPane.INFORMATION_MESSAGE);
				}if( opt2.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter the empty field","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				if(opt3.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter the empty field","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				if(opt4.equals("") ) {
					JOptionPane.showMessageDialog(null,"Enter the empty field","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				if(ans.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter the empty field","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				if( catg.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter the empty field","Error",JOptionPane.INFORMATION_MESSAGE);
				}*/
				else {
				
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz","root","");
						stmt = conn.createStatement();
						stmt.executeUpdate("INSERT INTO Questions (Question,Choice1,Choice2,Choice3,Choice4,Answer,Category) VALUES ('"+txtrEnterSomeQuestions.getText()+"','"+txtOption.getText()+"','"+txtChoice.getText()+"','"+txtChoice_1.getText()+"','"+txtChoice_2.getText()+"','"+txtCorrectAnswer.getText()+"','"+txtEnterCatagory.getText()+"')");
						JOptionPane.showMessageDialog(null,"Succesfully added","Question addition",JOptionPane.INFORMATION_MESSAGE);
						
						
						//After adding the question to database setting the values back to null on the textFields
						txtrEnterSomeQuestions.setText("");
						txtOption.setText("");
						txtChoice.setText("");
						txtChoice_1.setText("");
						txtChoice_2.setText("");
						txtCorrectAnswer.setText("");
						txtEnterCatagory.setText("");
									
						
					}
					catch(Exception ex) {
						System.out.println(ex);
					}
				}
			}
		});
		panel_1.add(btnAdd);
		
		btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(65, 105, 225));
		btnReset.setBounds(309, 404, 134, 36);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrEnterSomeQuestions.setText("");
				txtOption.setText("");
				txtChoice.setText("");
				txtChoice_1.setText("");
				txtChoice_2.setText("");
				txtCorrectAnswer.setText("");
				txtEnterCatagory.setText("");
							
				
			}
		});
		panel_1.add(btnReset);
		
		btnReturn = new JButton("Return");
		btnReturn.setForeground(new Color(255, 255, 255));
		btnReturn.setBackground(new Color(65, 105, 225));
		btnReturn.setBounds(542, 404, 134, 36);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomePage frame = new HomePage();
				frame.setVisible(true);
				frame.initComponents(adminname);
				frame.setLocationRelativeTo(null);
				
			}
		});
		panel_1.add(btnReturn);
		
		txtrEnterSomeQuestions = new JTextArea();
		txtrEnterSomeQuestions.setBackground(new Color(255, 255, 255));
		txtrEnterSomeQuestions.setForeground(new Color(169, 169, 169));
		txtrEnterSomeQuestions.setFont(new Font("Monotype Corsiva", Font.BOLD, 17));
		txtrEnterSomeQuestions.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null)); 
		txtrEnterSomeQuestions.setBounds(10, 122, 764, 78);
		txtrEnterSomeQuestions.setToolTipText("");
		txtrEnterSomeQuestions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtrEnterSomeQuestions.setText("");
				txtrEnterSomeQuestions.setForeground(new Color(0,0,0));
			}
		});
		txtrEnterSomeQuestions.setLineWrap(true);
		txtrEnterSomeQuestions.setText("Enter some  questions  here!!!");
		panel_1.add(txtrEnterSomeQuestions);
		
		lblAddSomeQuestions = new JLabel("Add Some Questions Here");
		lblAddSomeQuestions.setForeground(Color.RED);
		lblAddSomeQuestions.setFont(new Font("Footlight MT Light", Font.BOLD, 31));
		lblAddSomeQuestions.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddSomeQuestions.setBounds(197, 27, 390, 50);
		panel_1.add(lblAddSomeQuestions);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Webp.net-resizeimage.png"));
		label_1.setBounds(632, 11, 88, 78);
		panel_1.add(label_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Addpage.class.getResource("/com/iquiz/IquizImages/Webp.net-resizeimage (3).jpg")));
		label.setBounds(0, 0, 784, 461);
		panel_1.add(label);
		
		setVisible(true);
	}


}
