package com.iquiz;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ApplicationIquiz {
	
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		//UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
		SplashScreen sc = new SplashScreen();
		WelcomeScreen ws = new  WelcomeScreen();
		 try {
	            for(int i=0;i<=100;i++){
	                Thread.sleep(35);
	                sc.setVisible(true);
	                sc.progressBar.setValue(i);
	            //  sc.percBar.setText(Integer.toString(i)+"%");
	            }
	        } catch (Exception e) {
	        }
		 sc.setVisible(false);
		 ws.setVisible(true);
		 ws.setLocationRelativeTo(null);
		 sc.dispose();
	}

}
