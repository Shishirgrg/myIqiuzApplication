package com.iquiz;

import java.awt.EventQueue;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class Chart extends ApplicationFrame {

   public Chart( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      Connection con = null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			 con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Quiz","root","");  
			
			System.out.println("Connection Successful");
			}
			catch(Exception e)
			{ 
				System.out.println("Connection UnSuccessful");
			}	 
		
      ArrayList<ForScore>users = new ArrayList<ForScore>();
      
      Statement st;
      
      ResultSet rs;
      
      ForScore f;
      
      try {
          st = con.createStatement();
          rs = st.executeQuery("SELECT * FROM leaderboard90 "/*where Username='"+user+"';*/);
          while(rs.next()){
              
              f = new ForScore(rs.getString("Username"),rs.getInt("Score"), rs.getInt("Time"));
              users.add(f);
          }         
      } catch (SQLException ex) {  
      }
      
      
            Object[][] rowData = new Object[users.size()][3];
      for(int p = 0; p < users.size(); p++){
          rowData[p][0] = users.get(p).uname;
          rowData[p][1] = users.get(p).time;
           rowData[p][2] = users.get(p).score;
             
      }
      DefaultCategoryDataset datasets = new DefaultCategoryDataset( );
      for(int j=0; j < users.size();j++)
      {
    	  datasets.addValue( (Number) rowData[j][2] , "Scores" , "Attempt: "+j );
    	      
      }
      for(int j=0; j < users.size();j++) {
    	  datasets.addValue( (Number) rowData[j][1] , "Time" , "Attempt: "+j );
    	  
      }
      
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Attempts","Obtained Marks",
         datasets,
         PlotOrientation.VERTICAL,
         true,true,false);
         Panel p=new Panel();
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 800 , 500 ) );
      getContentPane().add(p, BorderLayout.NORTH);
      p.add( chartPanel );
      chartPanel.setLayout(null);
      
      JButton btnNewButton = new JButton("New button");
      p.add(btnNewButton);
         
   }

   
   public static void main( String[ ] args ) {
      Chart chart = new Chart(
         "Graph Window" ,
         "Graph of Obtained marks");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible(true);
   }
}
