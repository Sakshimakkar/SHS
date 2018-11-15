package ssh;

import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTable category_table;
	
	private void initialize() {
		String patientid = "p100";
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
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// go to login screen
			}
		});
		btnLogout.setBounds(330, 5, 89, 23);
		panel.add(btnLogout);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Search By Department", null, panel_1, null);
		
		JComboBox department = new JComboBox();
		department.setBounds(181, 11, 167, 20);
		
		JLabel lblSelectDepartment = new JLabel("Select Department");
		lblSelectDepartment.setBounds(51, 11, 140, 14);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(124, 36, 89, 23);
		
		table = new JTable();
		table.setBounds(0, 70, 429, 163);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel_1.setLayout(null);
		panel_1.setLayout(null);
		panel_1.add(department);
		panel_1.add(lblSelectDepartment);
		panel_1.add(btnSubmit);
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 60, 429, 150);
		scrollPane.setVisible(true);
		panel_1.add(scrollPane);
        //tabs.add(header, BorderLayout.NORTH);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		JButton button = new JButton("Book Appointment");
		button.setBounds(0, 210, 429, 23);
		panel_1.add(button);
    
		
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String depart = department.getSelectedItem().toString();
				String doctors = "select did,dname,address,contactno,consulationday1,consultationday2,consultationday3,consultationtimefrom,consultationtimeto from doctor where department = ?";
				try {
				ps1 = (PreparedStatement) con.prepareStatement(doctors);
				ps1.setString(1, depart);
				rs1 = ps1.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs1));
				table.setAutoCreateRowSorter(true);
				scrollPane.setViewportView(table);
				
				ps1.close();
				rs1.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Search By Category", null, panel_2, null);
		
		JComboBox category = new JComboBox();
		category.setBounds(181, 11, 167, 20);
		JLabel lblSelectCategory = new JLabel("Select Category");
		lblSelectCategory.setBounds(51, 11, 140, 14);
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.setBounds(124, 36, 89, 23);
		btnSubmit_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String categ = category.getSelectedItem().toString();
				String doc_cat =  "select did,dname,address,contactno,consulationday1,consultationday2,consultationday3,consultationtimefrom,consultationtimeto from doctor where designation = ?";
				try {
					ps1 = (PreparedStatement) con.prepareStatement(doc_cat);
					ps1.setString(1, categ);	
					rs1 = ps1.executeQuery();
					category_table.setModel(DbUtils.resultSetToTableModel(rs1));
					ps1.close();
					rs1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		category_table = new JTable();
		panel_2.setLayout(null);
		panel_2.setLayout(null);
		panel_2.add(category);
		panel_2.add(lblSelectCategory);
		panel_2.add(btnSubmit_1);
		
		JScrollPane scrollPane_1 = new JScrollPane(category_table);
		scrollPane_1.setBounds(0, 60, 429, 150);
		scrollPane_1.setVisible(true);

	
		
		panel_2.add(scrollPane_1);
		JButton button_1 = new JButton("Book Appointment");
		button_1.setBounds(0, 210, 429, 23);
		
		
			
		panel_2.add(button_1);
    
		
		String departments = "select distinct(department) from doctor";
		
		
		String categories = "select distinct(designation) from doctor";
		String patientdata = "select * from patient where pid = ?";
		try {
			
			ps =  (PreparedStatement) con.prepareStatement(patientdata);
			ps.setString(1, patientid);
			rs = ps.executeQuery();
			
			if (rs.next())
			{
				namepatient.setText((rs.getString("name")));
				age.setText((rs.getString("age")));
				gender.setText(rs.getString("gender"));
				address.setText(rs.getString("address"));
				mobile.setText(rs.getString("mobileno"));
				//email.setText(rs.getString("emailid"));
				
			}
			
			
			ps.close();
			rs.close();
			
			ps_depart = (PreparedStatement) con1.prepareStatement(departments);
			rs_depart = ps_depart.executeQuery();
			while(rs_depart.next())
			{

				department.addItem(rs_depart.getString("department"));
			}
			ps_depart.close();
			rs_depart.close();
			
			ps = (PreparedStatement) con1.prepareStatement(categories);
			rs = ps.executeQuery();
			while(rs.next())
			{
				category.addItem(rs.getString("designation"));
			}
			
			ps.close();
			rs.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TableModel model = table.getModel();
					
					int index = table.getSelectedRow();
					
					
					String doc_id =   (String) model.getValueAt(index, 0);
					
					String update_doc = "update patient set did='"+doc_id+"' where pid = ?";
					try {
					ps =  (PreparedStatement) con.prepareStatement(update_doc);
					ps.setString(1, patientid);
					int success = ps.executeUpdate();
					if (success!=0)
					{
						JOptionPane.showMessageDialog(panel_1,"Appointment Booked");  
					}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}	
			});
			
			
			button_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TableModel model = category_table.getModel();
					int index = category_table.getSelectedRow();
					String doc_id =   (String) model.getValueAt(index, 0);

					String update_doc = "update patient set did='"+doc_id+"' where pid = ?";
					try {
					ps =  (PreparedStatement) con.prepareStatement(update_doc);
					ps.setString(1, patientid);
					int success = ps.executeUpdate();
					if (success!=0)
					{
						JOptionPane.showMessageDialog(panel_2,"Appointment Booked");
						
					}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			});
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String update_details = "update patient set address='"+address.getText()+"',mobileno='"+mobile.getText()+"' where pid = ?";
					try {
						System.out.println("patient id is "+patientid);
						ps1 = (PreparedStatement) con.prepareStatement(update_details);
						ps1.setString(1, patientid);
						int success = ps1.executeUpdate();
						if(success > 0)
						{
							JOptionPane.showMessageDialog(panel_1,"Details Updated");  
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});

		
}
}
