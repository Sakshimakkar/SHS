package ssh;

import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Font;


public class Patient_details {

	private String pid;
	private JFrame frame;
	private static Logger logger = Logger.getAnonymousLogger();

	/**
	 * Launch the application.
	 */
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * Launch the application.
	 */
	public static void patient_details_display(String pid,String did) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_details window = new Patient_details(pid,did);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					logger.log(Level.SEVERE,"Exception!", e);
				}
			}
			});
		}
	

	/**
	 * Create the application.
	 */
	Patient_details()
	{
		
	}
	/**
	 * @throws SQLException 
	 * @wbp.parser.constructor
	 */
	public Patient_details(String pid,String did) throws SQLException {
		initialize(pid,did);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	java.sql.Connection con = null;
	java.sql.PreparedStatement ps=null;
	ResultSet rs=null;


	private JTable table;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtDdmmyy;
	private JTextField txtDdmmyy_1;
	
	private void initialize(String pid, String did) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.56.40:3306/shs","akshat","1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(Level.SEVERE,"Exception!", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(Level.SEVERE,"Exception!", e);
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(tabbedPane);
		
		
		String t[]=	{"OPD","Local"};
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Doctor_display().DoctorScreen(did);
			}
		});
		tabbedPane.addTab("Add Patient Details", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Pid");
		lblName.setBounds(12, 23, 62, 14);
		panel.add(lblName);
		
		JLabel lblAddress = new JLabel("Department");
		lblAddress.setBounds(12, 49, 94, 14);
		panel.add(lblAddress);
		
		JLabel lblMobileNo = new JLabel("Disease IDentified");
		lblMobileNo.setBounds(12, 97, 149, 14);
		panel.add(lblMobileNo);
		
		JLabel lblAge = new JLabel("Doctor ID");
		lblAge.setBounds(12, 75, 86, 14);
		panel.add(lblAge);
		
		JLabel lblGender = new JLabel("Medicines Prescribed");
		lblGender.setBounds(13, 123, 163, 14);
		panel.add(lblGender);
		
	
//		JRadioButton rdbtnNewRadioButton = new JRadioButton("Local");
//		rdbtnNewRadioButton.setBounds(103, 4, 73, 14);
//		panel.add(rdbtnNewRadioButton);
//		
//		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("OPD");
//		rdbtnNewRadioButton_1.setBounds(180, 4, 149, 14);
//		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblTreatmentStartDate = new JLabel("Treatment From");
		lblTreatmentStartDate.setBounds(12, 174, 163, 15);
		panel.add(lblTreatmentStartDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 47, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(179, 95, 114, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(180, 121, 114, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(180, 147, 114, 19);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		txtDdmmyy = new JTextField();
		txtDdmmyy.setText("dd-mm-yy");
		txtDdmmyy.setBounds(142, 172, 94, 19);
		panel.add(txtDdmmyy);
		txtDdmmyy.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Test Advised");
		lblNewLabel.setBounds(12, 149, 138, 15);
		panel.add(lblNewLabel);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(274, 174, 70, 15);
		panel.add(lblTo);
		
		txtDdmmyy_1 = new JTextField();
		txtDdmmyy_1.setText("dd-mm-yy");
		txtDdmmyy_1.setBounds(315, 172, 102, 19);
		panel.add(txtDdmmyy_1);
		txtDdmmyy_1.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(152, 211, 120, 23);
		panel.add(btnUpdate);
		JComboBox type1 = new JComboBox(t);
		type1.setBounds(331, 49, 86, 24);
		panel.add(type1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(180, 17, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("back");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(371, 23, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(180, 75, 46, 14);
		panel.add(lblNewLabel_3);
		  
		
		lblNewLabel_1.setText(pid);
		lblNewLabel_3.setText(did);
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String details ="Insert into Patient_details values(?,?,?,?,?,?,?,?,?)";
				try {
				ps = con.prepareStatement(details);
				ps.setString(1, pid);
				ps.setString(2, textField_1.getText());
				ps.setString(3, textField_3.getText());
				ps.setString(9, did);
				ps.setString(4, textField_4.getText());
				ps.setString(5, textField_5.getText());
				ps.setString(6, txtDdmmyy.getText());
				ps.setString(7, txtDdmmyy_1.getText());
				String str=(String)type1.getItemAt(type1.getSelectedIndex());  
				if(str=="OPD")
					ps.setString(8, "OPD");
				else
					ps.setString(8, "Local");
				int i = ps.executeUpdate();
				if(i!=0)
					JOptionPane.showMessageDialog(frame,"Details Added");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					logger.log(Level.SEVERE,"Exception!", e1);
				}
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("View History", null, panel_1, null);
		
	
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		table.setRowSelectionAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVisible(true);
		panel_1.add(scrollPane);
		
		
		String patients = "select * from patient where did = ?";
		ps = con.prepareStatement(patients);
		ps.setString(1, did);
		rs = ps.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		
		
	}	
}