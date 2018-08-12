package com.iquiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;


public class RegisterPage extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;
	Connection conn;
	Statement stmt;
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					RegisterPage frame = new RegisterPage();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public RegisterPage() {
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
		setBounds(100, 100, 795, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegisterPage.class.getResource("/com/iquiz/IquizImages/Webp.net-compress-image (1).png")));
		label.setBounds(678, 11, 96, 65);
		panel.add(label);
		
		JLabel lblRegisterNow = new JLabel("Register ");
		lblRegisterNow.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblRegisterNow.setBounds(29, 11, 170, 29);
		panel.add(lblRegisterNow);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 784, 89);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_3 = new JLabel("Experience the  thrill of quiz");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		label_3.setBounds(29, 45, 210, 14);
		panel_1.add(label_3);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(29, 100, 70, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPassword.setBounds(29, 156, 56, 20);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(29, 187, 548, 20);
		panel.add(passwordField);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblConfirmPassword.setBounds(28, 218, 107, 14);
		panel.add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(29, 243, 548, 20);
		panel.add(passwordField_1);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblEmail.setBounds(29, 274, 46, 14);
		panel.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(29, 299, 548, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(29, 125, 548, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblError_1 = new JLabel("");
		lblError_1.setForeground(new Color(255, 69, 0));
		lblError_1.setBounds(610, 128, 164, 14);
		panel.add(lblError_1);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 69, 0));
		lblError.setBounds(610, 190, 164, 14);
		panel.add(lblError);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(new Color(255, 69, 0));
		label_1.setBounds(610, 246, 164, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(new Color(255, 69, 0));
		label_2.setBounds(610, 302, 164, 14);
		panel.add(label_2);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					String username = textField_1.getText().trim();
					String password = passwordField.getText().trim();
					String configpassword = passwordField_1.getText().trim();
					String email = textField.getText().trim();
					boolean validUser = false, validPassword=false, validConfigpassword=false, validEmail=false;
					boolean validPass=false;
					
					if(username.equals("")) {
						lblError_1.setText("Username is empty");
					}else {
						lblError_1.setText("");
						validUser = true;
					}
					
					if(password.equals("")) {
						lblError.setText("Password is empty");
					}else {
						lblError.setText("");
						validPassword = true;
					}
					
					if(configpassword.equals("")) {
						label_1.setText("Confirm password is empty");
					}else {
						label_1.setText("");
						validConfigpassword = true;
					}
					
					if(email.equals("")) {
						label_2.setText("Email is empty");
					}else if(validateEmail(email)==false) {
						label_2.setText("Email is not valid");
					}
					else {
						label_2.setText("");
						validEmail = true;
					}
					
					if(password.equals("") && configpassword.equals("")) {
						lblError.setText("Please enter password");
						label_1.setText("Please enter password");
					}
					else if(password.equals(configpassword)){
						validPass =  true;
						lblError.setText("");
						label_1.setText("");
					}
					else {
						lblError.setText("Passwords donot match");
						label_1.setText("Passwords donot match");
					}
					
					if(validUser==true && validPassword==true && validConfigpassword==true && validEmail==true && validPass==true) {
						Class.forName("com.mysql.cj.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3306/quiz";
						conn = DriverManager.getConnection(url, "root", "");
						stmt = conn.createStatement();
						
						
						//checking if user already exits
						String query = "SELECT * FROM users WHERE Username='"+username+"'";
						ResultSet rs = stmt.executeQuery(query);
						if(!rs.next()) {
							//insert values in database and new user is registerd
							stmt.executeUpdate("INSERT INTO users ( Username,Password,Email) VALUES ('"+username+"','"+password+"','"+email+"')");
							reset();
							JOptionPane.showMessageDialog(null, "Successfully Registered","", JOptionPane.INFORMATION_MESSAGE);
							LoginPage lp = new  LoginPage();
							dispose();
							lp.setVisible(true);
							lp.setLocationRelativeTo(null);
						}
						else {
							//System.out.println("yipee");
							
							JOptionPane.showMessageDialog(null, "Username already exits","", JOptionPane.INFORMATION_MESSAGE);
							
							
						}		
					}
					
					
				} catch (Exception e) {
					System.out.println("Error:"+e);
				}
			}
		});
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnRegister.setBackground(new Color(100, 149, 237));
		btnRegister.setBounds(29, 336, 548, 35);
		panel.add(btnRegister);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 392, 784, 2);
		panel.add(separator);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			LoginPage lp = new  LoginPage();
			lp.setVisible(true);
			lp.setLocationRelativeTo(null);
			setVisible(false);
			dispose();
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnLogin.setBackground(new Color(100, 149, 237));
		btnLogin.setBounds(29, 415, 548, 35);
		panel.add(btnLogin);
	}
	public void reset() {
		textField_1.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
		textField.setText("");
	
	}
	public static boolean validateEmail(String Email) {
		boolean status = false;
		String email_pattern =   "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern =  Pattern.compile(email_pattern,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(Email);
		if(matcher.matches()) {
			status = true;
		}
		else {
			status = false;
		}
		return status;

	}
	
	
}
