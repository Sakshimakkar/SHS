package ssh;

import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Patient_display {

	private String pid;
	private JFrame frame;
	private JTextField age;
	private JTextField mobile;

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
	Patient_display(String pid)
	{
		this.pid = pid;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_display window = new Patient_display();
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
	public Patient_display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	Connection con = null;
	Connection con1 = null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	PreparedStatement ps1=null;
	PreparedStatement ps_depart = null;
	ResultSet rs1=null;
	ResultSet rs_depart=null;
	private JTable table;
	
	private void initialize() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.56.40:3306/", "akshat", "1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("View/Edit Details", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(82, 34, 27, 14);
		panel.add(lblName);
		
		JLabel lblRegistrationForPatient = new JLabel("Edit Details");
		lblRegistrationForPatient.setBounds(151, 9, 73, 14);
		panel.add(lblRegistrationForPatient);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(82, 59, 39, 14);
		panel.add(lblAddress);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(82, 132, 50, 14);
		panel.add(lblMobileNo);
		
		
		JButton btnRegister = new JButton("Update");
		btnRegister.setBounds(151, 199, 73, 23);
		panel.add(btnRegister);
		
		
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(82, 104, 46, 14);
		panel.add(lblAge);
		
		age = new JTextField();
		age.setBounds(142, 101, 86, 20);
		panel.add(age);
		age.setColumns(10);
		
		JTextArea address = new JTextArea();
		address.setBounds(142, 54, 103, 36);
		panel.add(address);
		
		mobile = new JTextField();
		mobile.setBounds(142, 129, 86, 20);
		panel.add(mobile);
		mobile.setColumns(10);
		
		JLabel namepatient = new JLabel("");
		namepatient.setBounds(142, 34, 103, 14);
		panel.add(namepatient);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(82, 157, 46, 14);
		panel.add(lblGender);
		
		JLabel gender = new JLabel("");
		gender.setBounds(142, 157, 62, 14);
		panel.add(gender);
		
		JLabel lblEmailId = new JLabel("Email id");
		lblEmailId.setBounds(82, 180, 46, 14);
		panel.add(lblEmailId);
		
		JLabel email = new JLabel("");
		email.setBounds(142, 175, 129, 14);
		panel.add(email);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("View Doctors", null, panel_1, null);
		panel_1.setLayout(null);
		
		JComboBox department = new JComboBox();
		department.setBounds(181, 11, 167, 20);
		panel_1.add(department);
		
		JLabel lblSelectDepartment = new JLabel("Select Department");
		lblSelectDepartment.setBounds(51, 11, 140, 14);
		panel_1.add(lblSelectDepartment);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String depart = department.getSelectedItem().toString();
				String doctors = "select distinct(name) from doctor where department = ?";
				try {
				ps1 = (PreparedStatement) con.prepareStatement(doctors);
				ps.setString(1, depart);
				rs1 = ps1.executeQuery();
				
				ps1.close();
				rs1.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSubmit.setBounds(124, 36, 89, 23);
		panel_1.add(btnSubmit);
		
		table = new JTable();
		table.setBounds(10, 180, 409, -87);
		panel_1.add(table);
		
		String departments = "select distinct(department) from doctor";
		String patientdata = "select * from patient where pid = ?";
		try {
			
			ps =  (PreparedStatement) con.prepareStatement(patientdata);
			ps.setString(1, getPid());
			rs = ps.executeQuery();
			
			if (rs.next())
			{
				namepatient.setText((rs.getString("name")));
				age.setText((rs.getString("age")));
				gender.setText(rs.getString("gender"));
				address.setText(rs.getString("address"));
				mobile.setText(rs.getString("contactno"));
				email.setText(rs.getString("emailid"));
				
			}
			table.setModel(DbUtils.resultSetToTableModel(rs1));
			ps.close();
			rs.close();
			
			ps_depart = (PreparedStatement) con1.prepareStatement(departments);
			rs_depart = ps_depart.executeQuery();
			while(rs_depart.next())
			{
				department.addItem(rs_depart.getString("1"));
			}
			ps_depart.close();
			rs_depart.close();
			
			
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
}
}
