package Main;
import java.awt.EventQueue;

import javafx.scene.control.Label;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Info.Company;

import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GUI2 extends JFrame {
	
	private JPanel contentPane;
	private JButton btnSave;
	private JLabel companyName,tutar,username,tip,not;
	private JTextField txtTutar,txtUsername,txtNot;
	private JComboBox<Company> txtCompanyName;
	private JComboBox<String> txtTip;
	
	//private Object[] columns={"ÝÞLEM NO","TARÝH","ÞÝRKET ADI","TUTAR","TESLÝM EDEN","ÝÞLEM TÝPÝ"};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 frame = new GUI2();
					frame.setVisible(true);
				} catch (Exception e) {	
					e.printStackTrace();
				}
			}
		});
	}

	public GUI2() throws FontFormatException, IOException, SQLException {
	
		Font myFont = new Font("Serif", Font.BOLD, 25);
		Font myFont2 = new Font("Serif", Font.BOLD, 40);
		
		companyName=new JLabel("Sirket Ýsmi : ");
		companyName.setFont(myFont);
		tutar=new JLabel("Tutar : ");
		tutar.setFont(myFont);
		username=new JLabel("Teslim Alan : ");
		username.setFont(myFont);
		tip=new JLabel("Tip : ");
		tip.setFont(myFont);
		not=new JLabel("Not : ");
		not.setFont(myFont);
		
		
		Connection conn = Functions.getConnection();
		Statement statement = conn.createStatement();
		String query = "select *from company";
		ResultSet rs= statement.executeQuery(query);
		int count=0;
		while(rs.next()){
			count++;
		}
		ResultSet rs2= statement.executeQuery(query);
		Company[] c = new Company[count];
		count=0;
		while(rs2.next()){
			Company cc=new Company(rs2.getString("companyid"),rs2.getString("companyname"));
			c[count]=cc;
			count++;
		}
		txtCompanyName=new JComboBox<Company>();
		
		ComboBoxModel<Company> a = new DefaultComboBoxModel(c);
		txtCompanyName.setModel(a);
		
		String[] t =new String[5];
		t[0]="NAKIT";
		t[1]="CEK";
		t[2]="SENET";
		t[3]="KREDIKARTI";
		t[4]="YOK";
		
		txtCompanyName.setFont(myFont);
		txtTutar=new JTextField();
		txtTutar.setFont(myFont2);
		txtUsername=new JTextField();
		txtUsername.setFont(myFont);
		txtTip=new JComboBox<String>(t);
		txtTip.setFont(myFont);
		txtNot=new JTextField();
		txtNot.setFont(myFont);
		
		btnSave=new JButton("KAYDET");
		
		setSize(200, 400);
		setBackground(Color.ORANGE);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 443);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(6, 2));
		setContentPane(contentPane);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		contentPane.add(companyName);
		contentPane.add(txtCompanyName);
		contentPane.add(tutar);
		contentPane.add(txtTutar);
		contentPane.add(username);
		contentPane.add(txtUsername);
		contentPane.add(tip);
		contentPane.add(txtTip);
		contentPane.add(not);
		contentPane.add(txtNot);
		contentPane.add(new JLabel(""));
		contentPane.add(btnSave);
		// ACTION LISTENER
		btnSave.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Company co=(Company) txtCompanyName.getSelectedItem();
					String cn=co.getcompanyName();
					String cid= co.getCompanyId();
					String tt= txtTutar.getText();
					String un=txtUsername.getText();
					String tip=txtTip.getSelectedItem().toString();
					String not=txtNot.getText();
					
					Connection conn=Functions.getConnection();
					Statement statement = conn.createStatement();
					String query = "insert into islemler (companyid,tutar,username,[not],tipid) values ("+cid+","+tt+",'"+un+"','"+not+"',1)";
					statement.executeUpdate(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		
	}

}
