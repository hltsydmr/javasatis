package Main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

//import jxl.read.biff.BiffException;










import Info.Islem;

import com.sun.glass.ui.Window;
import com.sun.media.sound.ModelAbstractChannelMixer;



public class GUI extends JFrame {
	
	private JPanel contentPane;
	private TextArea txt;
	private JTable table;
	private JTextField txtCompanyName; 
	private JButton btnRefresh, btnNew;
	private Object[] columns={"ÝÞLEM NO","TARÝH","ÞÝRKET ADI","TUTAR","TESLÝM EDEN","ÝÞLEM TÝPÝ"};
	static String conStr = "jdbc:sqlserver://localhost:1433;databaseName=SOYDEMIR;user=sa;password=123456";
	private static Connection conn;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {	
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() throws FontFormatException, IOException {
		
		setBackground(Color.ORANGE);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 443);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		// KULLANILMAYAN PANEL
		//JPanel panel = new JPanel();
		//panel.setBackground(Color.ORANGE);
		//panel.setForeground(Color.BLACK);
		//contentPane.add(panel, BorderLayout.SOUTH);
		
	    //	COMPANYNAME TEXTFIELD
		txtCompanyName = new JTextField();
		Font myFont = new Font("Serif", Font.BOLD, 25);
		txtCompanyName.setFont(myFont);
		txtCompanyName.setText("GEÇERSÝZ KÝÞÝ-GEÇERSÝZ KÝÞÝ-GEÇERSÝZ KÝÞÝ");
		txtCompanyName.setEditable(false);
		
		//	NEW BUTTON
		btnNew = new JButton("NEW");
		btnNew.setFont(myFont);
		
		//	REFRESH BUTTON
		btnRefresh = new JButton("REFRESH");
		btnRefresh.setFont(myFont);
		
		//	JTABLE
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(columns);
		table = new JTable();
		table.setModel(dtm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		
		//dtm.addRow(new Object[]{"first row","first row","first row"});
		//	PANEL NORTH
		Panel panelNorth = new Panel();
		Panel panelNorthInside = new Panel();
		panelNorth.setLayout(new GridLayout(1,2,20,10));
		panelNorthInside.setLayout(new GridLayout(1,3,20,10));
		panelNorth.add(txtCompanyName);
		panelNorthInside.add(new JLabel(""));
		panelNorthInside.add(btnNew);
		panelNorthInside.add(btnRefresh);
		panelNorth.add(panelNorthInside);
			
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		//	PANEL WEST
		//Panel panelWest = new Panel();
		//contentPane.add(panelWest, BorderLayout.WEST);
		
		//	PANEL EAST
		//Panel panelEast = new Panel();
		//contentPane.add(panelEast, BorderLayout.EAST);
		
		//	PANEL SOUTH
		//Panel panelSouth = new  Panel() ;
		//contentPane.add(panelEast, BorderLayout.SOUTH);
		
		//	PANEL CENTER
		Panel panelCenter = new  Panel() ;
		panelCenter.add(table);
		contentPane.add(panelCenter, BorderLayout.CENTER);
	
		panelCenter.add(new JScrollPane(table));      
		
		// ACTION LISTENER
		btnRefresh.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dtm.setRowCount(0);
				try {
					//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					//conn = DriverManager.getConnection(conStr);
					//Class.forName("com.microsoft.sqlserver.jdbc");
					//String dbUrl = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=SOYDEMIR";
					//Connection conn = DriverManager.getConnection(dbUrl,"sa","123456");
					Connection conn = Functions.getConnection();
					Statement statement = conn.createStatement();
					String query = "select islemid,tarih,companyname,tutar,username,tip,[not],companyid from islemler";
					ResultSet rs = statement.executeQuery(query);
					while(rs.next()){
						//Islem ii=new Islem(Integer.parseInt(rs.getString("islemid")), rs.getString("tarih"), rs.getString("companyname"), Integer.parseInt(rs.getString("companyid")), Float.parseFloat(rs.getString("tutar")), rs.getString("username"), rs.getString("not"), rs.getString("tip"));
						dtm.addRow(new Object[]{rs.getString("islemid"),rs.getString("tarih"),rs.getString("companyname"),Float.parseFloat(rs.getString("tutar")),rs.getString("username"), rs.getString("tip")});
					}
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
btnNew.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			try {
				GUI2 G=new GUI2();
				G.show();
			} catch (FontFormatException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
	}

}
