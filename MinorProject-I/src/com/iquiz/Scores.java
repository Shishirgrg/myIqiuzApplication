package com.iquiz;

import java.sql.*;
//error in this page
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

public class Scores extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	Statement stmt;
	Connection conn;
	ResultSet rs;
	
	PlayGame pg = new PlayGame();
	int sec = pg.seconds;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		//UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Scores frame = new Scores();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Scores() {
	}
	
	public void initComponents(String user, int points, int timeValue) throws Exception{
		setUndecorated(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
			    int a=JOptionPane.showConfirmDialog(frame,"Are you sure?","",JOptionPane.INFORMATION_MESSAGE);  
			if(a==JOptionPane.YES_OPTION){  
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			}  
			}  
			
		});
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz","root","");

            
        	
		}
		catch(Exception e) {
			
		}
		
		System.out.println(timeValue);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 790,640);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 784, 611);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(new Color(100, 149, 237));
		panel_2.setBounds(0, 0, 784, 612);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 137, 673, 363);
		scrollPane.setBackground(new Color(0,0,0,80));
		panel_2.add(scrollPane);
		
		//ArrayList <I_values>users  = new ArrayList<I_values>();
		ArrayList <ForScore> users = new ArrayList<ForScore>();
		//Object of the forScore type
		ForScore obj;
		 try {
	        	
	        	stmt =  conn.createStatement();
	        	if(sec==90) {
	           // rs = stmt.executeQuery("SELECT  username, max(score),time from leaderboard90 group by username order by max(score) desc, time desc ");
	        		 rs = stmt.executeQuery("SELECT  * from leaderboard90 order by score desc  ");
	            
	            while(rs.next()){
	                
	            	//System.out.println(""+rs.getString("Username")+""+rs.getInt("Score")+""+rs.getInt("Time"));
	                obj = new ForScore(rs.getString("Username"),rs.getInt("Score"),rs.getInt("Time"));
	                users.add(obj);
	            }    
	        }
	        	else if(sec==180) {
		           // rs = stmt.executeQuery("SELECT  username, max(score),time from leaderboard180 group by username order by max(score) desc, time desc  ");
	        		 rs = stmt.executeQuery("SELECT  * from leaderboard180 order by score desc  ");
			        	
		            
		            while(rs.next()){
		                
		            	//System.out.println(""+rs.getString("Username")+""+rs.getInt("Score")+""+rs.getInt("Time"));
		                obj = new ForScore(rs.getString("Username"),rs.getInt("Score"),rs.getInt("Time"));
		                users.add(obj);
		            }    
		        }
	        	else  {
		         //   rs = stmt.executeQuery("SELECT  username, max(score),time from leaderboard270 group by username order by max(score) desc, time desc ");
		        	
	        		 rs = stmt.executeQuery("SELECT  * from leaderboard270 order by score desc  ");
		            while(rs.next()){
		                
		            	//System.out.println(""+rs.getString("Username")+""+rs.getInt("Score")+""+rs.getInt("Time"));
		                obj = new ForScore(rs.getString("Username"),rs.getInt("Score"),rs.getInt("Time"));
		                users.add(obj);
		            }    
		        }
		 
		 
		 
		 
		 } catch (SQLException ex) {  
	        	
	        	
	        }
		
      String[] columnsName = new String[3];
     /* columnsName[0] = "S.no";
      columnsName[1] = "Player's Name";
      columnsName[2] = "Scores";
      */
      columnsName[0] = "Player's name";
      columnsName[1] = "Score";
      columnsName[2] = "Time Left";
     
      Object[][] rowData = new Object[users.size()][3];
      
      for(int p = 0; p <users.size(); p++){
          rowData[p][0] = users.get(p).uname;
          rowData[p][1] = users.get(p).time;
          rowData[p][2] = users.get(p).score;
          
             
      }
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBackground(Color.WHITE);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(rowData,columnsName) {
			boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
	  
		scrollPane.setViewportView(table);
		
		JLabel lblLeadershipBoard = new JLabel("Leadership Board");
		lblLeadershipBoard.setForeground(new Color(100, 149, 237));
		lblLeadershipBoard.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblLeadershipBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeadershipBoard.setBounds(234, 11, 313, 76);
		panel_2.add(lblLeadershipBoard);
		
		JButton btnNewButton = new JButton("Play Again");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				PlayGame pg = new PlayGame();
				pg.initComponents(user);
				pg.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setBounds(585, 531, 158, 43);
		panel_2.add(btnNewButton);
		
		JLabel lblSocre = new JLabel("Socre:");
		lblSocre.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSocre.setBounds(96, 106, 53, 20);
		panel_2.add(lblSocre);
		
		JLabel scoreLabel = new JLabel(""+points);
		scoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		scoreLabel.setForeground(new Color(255, 0, 0));
		scoreLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scoreLabel.setBounds(148, 106, 68, 20);
		panel_2.add(scoreLabel);
		
		JLabel lblTimeLeft = new JLabel("Time left:");
		lblTimeLeft.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTimeLeft.setBounds(503, 106, 75, 20);
		panel_2.add(lblTimeLeft);
		
		JLabel timeLabel = new JLabel(""+timeValue);
		timeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		timeLabel.setForeground(new Color(255, 0, 0));
		timeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		timeLabel.setBounds(577, 106, 75, 20);
		panel_2.add(timeLabel);
		
		
		///////////////////////////////////////////////////////////
		//Action listener add garne
//		JButton btnShowGraph = new JButton("Show Graph");
//		btnShowGraph.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				Chart c = new Chart(user, user);
//				c.setVisible(true);
//			}
//		});
//		btnShowGraph.setForeground(Color.WHITE);
//		btnShowGraph.setFont(new Font("Stencil", Font.PLAIN, 20));
//		btnShowGraph.setBackground(new Color(100, 149, 237));
//		btnShowGraph.setBounds(404, 531, 158, 43);
//		panel_2.add(btnShowGraph);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 784, 623);
		label.setIcon(new ImageIcon(Scores.class.getResource("/com/iquiz/IquizImages/white-and-blue-lines-wallpaper-1.jpg")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label);
		
		
		
		setVisible(true);
	}
}

