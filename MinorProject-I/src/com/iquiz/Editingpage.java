package com.iquiz;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Editingpage extends JFrame {
	private JFrame frame;
	protected static final String String = null;
	private JPanel contentPane;
	JTable table;
	Connection con;
	java.sql.Statement st;
     
	String something;
     ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Editingpage frame = new Editingpage();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Editingpage() {
	}
	public void initComponents(String hero) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
			    int a=JOptionPane.showConfirmDialog(frame,"Are you sure?","",JOptionPane.INFORMATION_MESSAGE);  
			if(a==JOptionPane.YES_OPTION){  
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			}  
			}  
			
		});
		something = hero;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz","root","");

            
        	
		}
		catch(Exception e) {
			System.out.println("Connection unsuccessful");
		}
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 790,490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Added scrollPane
		ArrayList <I_values>users  = new ArrayList<I_values>();
        
       
        
        I_values i;
        
        try {
        	
        	st =  con.createStatement();
            rs = st.executeQuery("SELECT * FROM Questions where visibility=1");
//            if(rs!= null) {
//            	System.out.println("result set was not null");
//            }
            while(rs.next()){
               // System.out.println(rs.getString("Question"));
                i = new I_values(rs.getString("Question"), rs.getString("Choice1"), rs.getString("Choice2"), rs.getString("Choice3"), rs.getString("Choice4"), rs.getString("Answer"),  rs.getString("Category"));
   
                users.add(i);
            }         
        } catch (SQLException ex) {  
        	
        	
        }
        
       /* String[] columnsName = new String[4];*/
        
        
        
      /*columnsName[0] = "S.no";
        columnsName[1] = "Questions";
        columnsName[2] = "Answer";
        columnsName[3] = "Categories";*/
        
        String[] columnsName = new String[3];
        columnsName[0] = "Questions";
        columnsName[1] = "Answer";
        columnsName[2] = "Categories";
        

       /* Object[][] rowData = new Object[users.size()][4];*/
        Object[][] rowData = new Object[users.size()][3];
     //   System.out.println("No of questions inDB:"+users.size());
        for(int p = 0; p <users.size(); p++){
           /* rowData[p][0] = users.get(p).sno;
            rowData[p][1] = users.get(p).que;
             rowData[p][2] = users.get(p).ans;
              rowData[p][3] = users.get(p).cate;*/
        	
        	rowData[p][0] = users.get(p).que;
            rowData[p][1] = users.get(p).ans;
             rowData[p][2] = users.get(p).cate;
        }
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 140, 764, 255);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(rowData,columnsName) {
		
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	
		/*table.getColumnModel().getColumn(0).setPreferredWidth(2);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(360);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);*/
		
		table.getColumnModel().getColumn(0).setPreferredWidth(360);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		
	
		scrollPane.setViewportView(table);
		
		Connection incon = con;
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				int row = table.getSelectedRow();
				String D_value =(String) table.getModel().getValueAt(row, 1);
				try {
					System.out.println("Delete bhayo db bata");
					System.out.println(D_value);
					//ERROR AAYO AAUTA : delete the bhayo tara sno 1 bata na aarera tei bata continue bhayo
					
					PreparedStatement st = incon.prepareStatement("UPDATE Questions set visibility=0 where answer='"+D_value+"';");
					st.executeUpdate();
				}
				catch(SQLException esx) {
					System.out.println(esx);
					
				}
				JOptionPane.showMessageDialog(null, "Successfully deleted.","Question Deletion",JOptionPane.INFORMATION_MESSAGE);
				model.removeRow(row);
			}
		});
		btnDelete.setBounds(433, 406, 108, 33);
		contentPane.add(btnDelete);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomePage frame = new HomePage();
				frame.initComponents(something);
				frame.setLocationRelativeTo(null);
			}
		});
		btnReturn.setBounds(583, 406, 108, 33);
		contentPane.add(btnReturn);
		
		JLabel lblNewLabel = new JLabel("List of Questions");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Vivaldi", Font.PLAIN, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(206, 35, 374, 89);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Editingpage.class.getResource("/com/iquiz/IquizImages/4486-light-blue-blurred-background.jpg")));
		label.setBounds(0, 0, 784, 461);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 461);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		setVisible(true);

	}
}
