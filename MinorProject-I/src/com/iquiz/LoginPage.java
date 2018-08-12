package com.iquiz;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class LoginPage extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtUsersname;
	private JPasswordField passwordField;
	public JLabel errorLabel = new JLabel("");
	Connection conn;
	Statement stmt;
	ResultSet rs;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		//UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
			
				//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
				
			//	UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
	addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
			    int a=JOptionPane.showConfirmDialog(frame,"Are you sure?","",JOptionPane.INFORMATION_MESSAGE);  
			if(a==JOptionPane.YES_OPTION){  
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			}  
			}  
			
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 790,490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(LoginPage.class.getResource("/com/iquiz/IquizImages/Webp.net-compress-image (6).png")));
		label_1.setBounds(348, 23, 75, 66);
		contentPane.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(202, 48, 376, 302);
		panel.setBackground(new Color(0,0,0,20));
		contentPane.add(panel);
		
		txtUsersname = new JTextField();
		txtUsersname.setBounds(89, 80, 260, 35);
		txtUsersname.setEditable(false);
		txtUsersname.setBackground(new Color(255, 255, 224));
		txtUsersname.setBorder(null);
		txtUsersname.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				txtUsersname.setText("");
				txtUsersname.setEditable(true);
				
			}
		});
		panel.setLayout(null);
		txtUsersname.setPreferredSize(txtUsersname.getPreferredSize());
		txtUsersname.setText("Username");
		panel.add(txtUsersname);
		txtUsersname.setColumns(10);
		
		JLabel lblLogIn = new JLabel("Log in");
		lblLogIn.setBounds(144, 45, 86, 24);
		lblLogIn.setForeground(new Color(25, 25, 112));
		lblLogIn.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblLogIn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(89, 115, 260, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(89, 179, 260, 2);
		panel.add(separator_1);
		
		passwordField = new JPasswordField();
		passwordField.setText("!*?;^$@&");
		passwordField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent ae) {
				passwordField.setText("");
			}
		});
		passwordField.setBounds(89, 146, 260, 35);
		panel.add(passwordField);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(29, 80, 46, 35);
		label_2.setIcon(new ImageIcon(LoginPage.class.getResource("/com/iquiz/IquizImages/Webp.net-compress-image (7).png")));
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(29, 146, 46, 35);
		label_3.setIcon(new ImageIcon(LoginPage.class.getResource("/com/iquiz/IquizImages/Webp.net-compress-s(8).png")));
		panel.add(label_3);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {    				
    				String username = txtUsersname.getText();
    				String password = passwordField.getText();
    				
    				
    				Class.forName("com.mysql.cj.jdbc.Driver");
    				String url = "jdbc:mysql://localhost:3306/Quiz";
    				conn = DriverManager.getConnection(url, "root", "");
    				System.out.println("Connected");
    				stmt = conn.createStatement();
    				String sql= "select Username,Password from Users where Username ='"+txtUsersname.getText()+"' and  Password = '"+passwordField.getText()+"'";
    				ResultSet rs = stmt.executeQuery(sql);

    				 if(username.isEmpty() && password.isEmpty()  ){
    					//System.out.println("Username and password are left empty");
    					errorLabel.setText("Username and Password field are left empty.");
    					
    				}
    				else if(username.isEmpty()){
    					//System.out.println("Username field left empty");
    					errorLabel.setText("Username field is left empty.");
    				}
    				else if (password.isEmpty()) {
    					//System.out.println("Password field is lfet empty.");
    					errorLabel.setText("Password field is left empty.");
    					
    				}
    				else {
    					//System.out.println("Uname and Password donot match..");
    					errorLabel.setText("Username and Password donot match..!");
    				}
    			
    				int count =0;
    				while(rs.next()) {
    					count++;
    				}
    				if(count==1) {
    					rs.close();
    					//System.out.println("Hello");
    					setVisible(false);
    					PlayGame pg = new PlayGame();
    					pg.initComponents(username);
    					pg.setVisible(true);
    					pg.setLocationRelativeTo(null);
    				}
    				
    			}
    		
    		catch(Exception e) {
    			System.out.println(e);
    		}
    		
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(29, 221, 320, 46);
		panel.add(btnNewButton);
		
		errorLabel.setBackground(new Color(0,0,0,40));
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(89, 192, 260, 17);
		panel.add(errorLabel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(255, 255, 255));
		separator_2.setBounds(202, 379, 376, 2);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Don't have an account?");
		lblNewLabel.setBackground(new Color(169, 169, 169));
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel.setBounds(267, 409, 126, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblRegisterHere = new JLabel("<html><u>REGISTER HERE</u></html>");
		lblRegisterHere.setForeground(Color.BLUE);
		lblRegisterHere.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				RegisterPage rp =  new RegisterPage();
				rp.setVisible(true);
				rp.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblRegisterHere.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblRegisterHere.setBounds(396, 409, 102, 14);
		contentPane.add(lblRegisterHere);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 784, 461);
		label.setIcon(new ImageIcon(LoginPage.class.getResource("/com/iquiz/IquizImages/Webp.net-compress-image (3).jpg")));
		contentPane.add(label);
	}
}