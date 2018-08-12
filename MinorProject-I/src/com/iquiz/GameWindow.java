package com.iquiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javafx.scene.layout.Border;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComboBox;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class GameWindow extends JFrame {
	private JFrame frame;
	boolean end;
	String uname;
	int points;
	//stores timer value
	int timeValue;
	
	private JPanel contentPane;
	public 	JLabel counter = new JLabel("");
	JTextArea textArea;
	JRadioButton rdbtnOption_1 ,rdbtnOption_2,rdbtnOption_3,rdbtnOption_4;
	ButtonGroup bg;
	JButton btnNext;
	JLabel lblQuestion, lblNewLabel;
	
	Statement stmt;
	Connection conn;
	
	ResultSet rs ;
	
	String question[] [];
	String qstnWithAns[] [];
	int score;
	int quizQstn= 0;
	int index;
	int count;
	
	
	int num[];
	
	String choice1,choice2,choice3,choice4,ans,choice;
	
	////////////////////////////////////////////////////////////////////////
	
	PlayGame pg = new PlayGame();
	int sec = pg.seconds;
	int quizTime = sec;
	
	
	Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			counter.setText(Integer.toString(quizTime));
			counter.setFont(new Font("Times New Roman", Font.BOLD, 25));
			quizTime--;
			timeValue = quizTime;
			if(end == true) {
				JOptionPane.showMessageDialog(null, "Congratulations you've finished all the questions.","Completion ",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				points = score;
				System.out.println(sec);
				addScoreToDatabase();
				Scores frame = new Scores();
				try
				{
					frame.initComponents(uname,points,timeValue);
					frame.setLocationRelativeTo(null);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				cancel();
				dispose();
				
				
			}
			else if(quizTime<=9 ) {
				counter.setFont(new Font("Times New Roman", Font.BOLD, 28));
				counter.setForeground(Color.RED);
				
				
				if(quizTime<=0) {
					cancel();
					JOptionPane.showMessageDialog(null, "Time up", "",  JOptionPane.INFORMATION_MESSAGE);
					dispose();
					points = score;
					addScoreToDatabase();
					Scores frame = new Scores();
					try
					{
						frame.initComponents(uname,points,timeValue);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
			}
			

	}
	};
	public void start() {
		timer.schedule(task, 1000,1000);
	}

	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		//UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
		//UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		//UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		//UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GameWindow() {
		
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
		setVisible(true);
		setResizable(false);
		uname = user;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 790,490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		

		score = 0;
		count = 1;
		
		
		
		ArrayList <Question> qstn = new ArrayList<Question> ();
		
		Question q;
		
		
		
		
		// Set some question from database here on the label 
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Quiz";
			Connection conn = DriverManager.getConnection(url, "root", "");
		
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Questions");
			while(rs.next()) {
				  q = new Question(rs.getString("Question"),rs.getString("Choice1"),rs.getString("Choice2"),rs.getString("Choice3"),rs.getString("Choice4"),rs.getString("Answer"));
				  qstn.add(q);
			}
			
			
			
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		question = new String [qstn.size()][6];
		System.out.println(qstn.size());
		for(int p = 0; p <qstn.size(); p++){
	        
	        	
	       question[p][0] = qstn.get(p).qstn;
	       question[p][1] = qstn.get(p).choice1;
	       question[p][2] = qstn.get(p).choice2;
	       question[p][3] = qstn.get(p).choice3;
	       question[p][4] = qstn.get(p).choice4;
	       question[p][5] = qstn.get(p).answer;
	      // System.out.println(question[p][5]);
	    
	        }
		
		
		//Shuffling the numbers
				num = new int[qstn.size()];
				
				 ArrayList numbers = new ArrayList();
				for(int i=0; i<qstn.size(); i++) {
					numbers.add(i);
				}
				Collections.shuffle(numbers);
				System.out.println(numbers);
				for(int j =0; j < qstn.size(); j++)
			    {
			    num[j]= (int) numbers.get(j);
			    System.out.println(num[j]);
			    }
		
		 rdbtnOption_1 = new JRadioButton("");
		 rdbtnOption_1.setForeground(new Color(255, 255, 255));
		rdbtnOption_1.setBackground(new Color(230, 230, 250));
		rdbtnOption_1.setOpaque(false);
		rdbtnOption_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		rdbtnOption_1.setBounds(79, 267, 222, 38);
		panel.add(rdbtnOption_1);
		
		rdbtnOption_2 = new JRadioButton("");
		rdbtnOption_2.setForeground(new Color(255, 255, 255));
		rdbtnOption_2.setBackground(new Color(230, 230, 250));
		rdbtnOption_2.setOpaque(false);
		rdbtnOption_2.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		rdbtnOption_2.setBounds(524, 267, 222, 38);
		panel.add(rdbtnOption_2);
		
		 rdbtnOption_3 = new JRadioButton("");
		 rdbtnOption_3.setForeground(new Color(255, 255, 255));
		rdbtnOption_3.setBackground(new Color(230, 230, 250));
		rdbtnOption_3.setOpaque(false);
		rdbtnOption_3.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		rdbtnOption_3.setBounds(79, 333, 222, 38);
		panel.add(rdbtnOption_3);
		
		
		
		rdbtnOption_4 = new JRadioButton("");
		rdbtnOption_4.setForeground(new Color(255, 255, 255));
		rdbtnOption_4.setBackground(new Color(230, 230, 250));
		rdbtnOption_4.setOpaque(false);
		rdbtnOption_4.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		rdbtnOption_4.setBounds(527, 333, 219, 38);
		panel.add(rdbtnOption_4);
		
		bg = new ButtonGroup();
		bg.add(rdbtnOption_1);
		bg.add(rdbtnOption_2);
		bg.add(rdbtnOption_3);
		bg.add(rdbtnOption_4);
		
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					choice = getSelectedButtonText(bg);
					ans = question[index][5];
					//System.out.println(choice);
					//System.out.println(ans);
				
					if(choice.equals(ans) ) {
						System.out.println("Score badne bitra gayo");
						score = score+10;
					}
					if(count >=qstn.size()) {
						end = true;
					}
					else
					{
						count++;
						lblNewLabel.setText("Score: "+score);
						lblQuestion.setText("Question: "+count+"/"+qstn.size());
						quizQstn++;
						index = num[quizQstn];
						start(index); 
						
					}
							
							
					 
				}
				catch(NullPointerException ne) {
					JOptionPane.showMessageDialog(null, "Please select an answer","",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(ArrayIndexOutOfBoundsException ae) {
						end = true;
						//addScoreToDatabase();
						/*JOptionPane.showMessageDialog(null, "Congratulations you've finished all the questions.","Completion ",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						Scores frame = new Scores();
						frame.setVisible(true);
					*/
					
				}
			
					
			}

			
		});
		btnNext.setBounds(325, 388, 105, 38);
		btnNext.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnNext.setAlignmentY(Component.CENTER_ALIGNMENT);
		panel.add(btnNext);
		
		
		 lblQuestion = new JLabel("Questions:"+count+"/"+qstn.size());
		lblQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuestion.setForeground(Color.WHITE);
		lblQuestion.setBounds(23, 98, 138, 32);
		panel.add(lblQuestion);
		
		JLabel lblTimer = new JLabel("Timer:");
		lblTimer.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTimer.setForeground(Color.WHITE);
		lblTimer.setBounds(339, 92, 65, 38);
		panel.add(lblTimer);
		
		lblNewLabel = new JLabel("Score: "+score);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(644, 106, 102, 24);
		panel.add(lblNewLabel);
		counter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
	
		counter.setBounds(410, 92, 65, 38);
		panel.add(counter);
		
		JLabel lblPlaying = new JLabel("playing: "+user );
		lblPlaying.setForeground(Color.WHITE);
		lblPlaying.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPlaying.setBounds(10, 64, 236, 24);
		panel.add(lblPlaying);
		
		 textArea = new JTextArea();
//		 textArea.setAlignmentX(10);
//		 textArea.setAlignmentY(10);
		 textArea.setAlignmentX(JTextField.CENTER);
		 textArea.setAlignmentY(JTextField.CENTER);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBorder(new LineBorder(null, 2, true));
		textArea.setBounds(20, 141, 726, 114);
		panel.add(textArea);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 784, 461);
		label.setIcon(new ImageIcon(GameWindow.class.getResource("/com/iquiz/IquizImages/1 (1).jpg")));
		panel.add(label);
		
		index=num[quizQstn];
		start(index);
		
		
	}
	String getSelectedButtonText(ButtonGroup buttonGroup) {
	    for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	        AbstractButton button = (AbstractButton) buttons.nextElement();

	        if (button.isSelected()) {
	            return button.getText();
	           
	        }
	       
	    }

	    return null;
	    }
		public void start(int q) {
			textArea.setText(question[q][0]);
			rdbtnOption_1.setText(question[q][1]);
			rdbtnOption_2.setText(question[q][2]);
			rdbtnOption_3.setText(question[q][3]);
			rdbtnOption_4.setText(question[q][4]);
			
			
			
			
			
		}
		public void addScoreToDatabase() {
			System.out.println("Yedi questions haru sabai solve garyo bhane pani db ma ta pathaunu paryo ni.");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/Quiz";
				Connection conn = DriverManager.getConnection(url, "root", "");
			
				stmt = conn.createStatement();
		
				
				//3  ota leaderboard
				if(sec==90) {
					String sql = "insert into leaderboard90 (Username,Score,Time) values('"+uname+"','"+score+"','"+timeValue+"') ";
					stmt.executeUpdate(sql);
				}
				else if(sec==180){
					String sql = "insert into leaderboard180 (Username,Score,Time) values('"+uname+"','"+score+"','"+timeValue+"') ";
					stmt.executeUpdate(sql);
				}
				else {
					String sql = "insert into leaderboard270 (Username,Score,Time) values('"+uname+"','"+score+"','"+timeValue+"') ";
					stmt.executeUpdate(sql);
				}
			//	String sql = "insert into leaderboard (Username,Score,Time) values('"+uname+"','"+score+"','"+timeValue+"') ";
//				stmt.executeUpdate(sql);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
}
