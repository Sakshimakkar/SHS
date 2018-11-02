package ssh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.FlowLayout;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Doctor_display {

	private String did;
	private JFrame frame;
	private JTextField dob;
	private JTextField from;
	private JTextField to;
	private final JPanel panel_2 = new JPanel();
	private JTable table;

	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		//this.did = did;
		this.did = did;
	}
	/**
	 * Launch the application.
	 */
	Doctor_display(String did)
	{
		this.did = did;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Doctor_display window = new Doctor_display();
					window.setDid("d100");
					System.out.println("did set as :"+window.getDid());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Doctor_display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	Connection con = null;
	Connection con1 = null;
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	PreparedStatement ps_depart = null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs_depart = null;
	Doctor doc = null;
	
	private void initialize() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.56.40:3306/shs", "akshat", "1234");
			con1 = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.56.40:3306/shs", "akshat", "1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 536, 380);
		frame.getContentPane().add(tabbedPane);
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("View profile", null, panel, null);
		tabbedPane.setEnabledAt(0, true);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 5, 86, 14);
		
		JLabel lblNewLabel_1 = new JLabel("DOB");
		lblNewLabel_1.setBounds(10, 25, 86, 14);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setBounds(10, 45, 86, 14);
		
		JLabel lblNewLabel_3 = new JLabel("Department");
		lblNewLabel_3.setBounds(10, 65, 86, 14);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(10, 85, 86, 14);
		
		JLabel lblNewLabel_5 = new JLabel("Contact No.");
		lblNewLabel_5.setBounds(10, 145, 86, 14);
		
		JLabel lblNewLabel_6 = new JLabel("Consultation Day");
		lblNewLabel_6.setBounds(10, 165, 86, 14);
		
		JLabel lblNewLabel_7 = new JLabel("Consultation Time");
		lblNewLabel_7.setBounds(10, 185, 86, 14);
		
		JLabel namelabel = new JLabel("");
		namelabel.setBounds(146, 5, 200, 14);
		
		dob = new JTextField();
		dob.setBounds(146, 22, 86, 20);
		dob.setColumns(10);
		
		JComboBox department = new JComboBox();
		department.setBounds(146, 62, 139, 20);
		
		JTextArea address = new JTextArea();
		address.setBounds(146, 90, 154, 41);
		
		JTextArea mobile = new JTextArea();
		mobile.setBounds(146, 140, 154, 20);
		
		JComboBox consulation = new JComboBox();
		consulation.setBounds(146, 162, 152, 20);
		
		from = new JTextField();
		from.setBounds(174, 182, 86, 20);
		from.setColumns(10);
		
		to = new JTextField();
		to.setBounds(303, 182, 86, 20);
		to.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("From");
		lblNewLabel_9.setBounds(140, 188, 35, 14);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(286, 188, 24, 14);
		
		JLabel genderlabel = new JLabel("");
		genderlabel.setBounds(146, 45, 46, 14);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(153, 301, 89, 23);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(10, 210, 86, 14);
		
		JLabel designation = new JLabel("");
		designation.setBounds(146, 210, 139, 14);
		
		JLabel lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setBounds(10, 238, 64, 14);
		
		JLabel spcialization = new JLabel("");
		spcialization.setBounds(146, 238, 118, 14);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(namelabel);
		panel.add(lblNewLabel_1);
		panel.add(dob);
		panel.add(lblNewLabel_2);
		panel.add(genderlabel);
		panel.add(lblNewLabel_3);
		panel.add(department);
		panel.add(lblNewLabel_4);
		panel.add(address);
		panel.add(lblNewLabel_5);
		panel.add(mobile);
		panel.add(lblNewLabel_6);
		panel.add(consulation);
		panel.add(lblNewLabel_7);
		panel.add(lblNewLabel_9);
		panel.add(from);
		panel.add(lblTo);
		panel.add(to);
		panel.add(btnNewButton);
		panel.add(lblDesignation);
		panel.add(lblSpecialization);
		panel.add(spcialization);
		panel.add(designation);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("View Patients", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(panel_2);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		table.setRowSelectionAllowed(false);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(201, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		String departments = "select distinct(department) from doctor";
		String docdetail = "select * from doctor where did = ?";
		try {
			String docid = "d100";
			ps =  (PreparedStatement) con.prepareStatement(docdetail);
			ps_depart = (PreparedStatement) con1.prepareStatement(departments);
			System.out.println("did"+docid);
			ps.setString(1, docid);
			rs = ps.executeQuery();
			rs_depart = ps_depart.executeQuery();
			if (rs.next())
			{
				namelabel.setText((rs.getString("dname")));
				dob.setText((rs.getString("dob")));
				genderlabel.setText(rs.getString("gender"));
				address.setText(rs.getString("address"));
				mobile.setText(rs.getString("contactno"));
				consulation.addItem(rs.getString("consulationday1"));
				consulation.addItem(rs.getString("consultationday2"));
				consulation.addItem(rs.getString("consultationday3"));
				from.setText(rs.getString("consultationtimefrom"));
				from.setText(rs.getString("consultationtimeto"));
				designation.setText(rs.getString("designation"));
				spcialization.setText(rs.getString("specialization"));
				
			}
			while(rs_depart.next())
			{
				department.addItem(rs_depart.getString("department"));
			}
			
			ps.close();
			rs.close();
			
			String patients = "select * from patient where did = ?";
			ps1 = (PreparedStatement) con.prepareStatement(patients);
			ps1.setString(1, docid);
			rs1 = ps1.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs1));
			
			ps1.close();
			rs1.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
	}
}
