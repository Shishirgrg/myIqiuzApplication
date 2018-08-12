package com.iquiz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.TextField;
import java.awt.TextArea;
import java.awt.*;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Text extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Text frame = new Text();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Text() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		JTextPane textpane = new JTextPane();
		
		
		
//		StyledDocument doc = textpane.getStyledDocument();
//		SimpleAttributeSet center = new SimpleAttributeSet();
//		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
//		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
	
		JTextArea textArea = new JTextArea();
		textArea.setAlignmentX(80);
		textArea.setAlignmentY(60);
//		 textArea.setLineWrap(true);
//	        textArea.setWrapStyleWord(true);
//	        textArea.setComponentOrientation(ComponentOrientation.Center_to_center);
		textArea.setText("adasfasdfasd");
		textArea.setBounds(200, 103, 260, 88);
		contentPane.add(textArea);
	}
}
