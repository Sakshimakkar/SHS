package ssh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class Department {

	private JFrame frame;
	private JTextField department;
	private JTextField docid;

	/**
	 * Launch the application.
	 */
	public void DepartmentScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Department window = new Department();
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
	public Department() {
		initialize();
	}

	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNameOfThe = new JLabel("Name of the Department");
		
		JLabel lblHod = new JLabel("HOD Id");
		
		department = new JTextField();
		department.setColumns(10);
		
		docid = new JTextField();
		docid.setColumns(10);
		
		JButton btnAddDepartment = new JButton("Add Department");
		
		JLabel lblBack = new JLabel("back");
		lblBack.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBack.setForeground(Color.BLUE);
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			new Admin().AdminScreen();
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNameOfThe)
								.addComponent(lblHod))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(docid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(department, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(103)
							.addComponent(btnAddDepartment)))
					.addContainerGap(134, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(346, Short.MAX_VALUE)
					.addComponent(lblBack)
					.addGap(42))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNameOfThe)
								.addComponent(department, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHod)
								.addComponent(docid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addComponent(btnAddDepartment))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBack)))
					.addContainerGap(129, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		btnAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getDid = "select max(departid) from department";
				String update_department = "Insert into department (dname,hodid,departid) values(?,?,?)";
				try {
					ps=(PreparedStatement)  con.prepareStatement(getDid);
					rs = ps.executeQuery();
					int did = rs.getInt("departid");
					did = did+1;
					ps = (PreparedStatement) con.prepareStatement(update_department);
					ps.setString(1, department.getText());
					ps.setString(2,docid.getText());
					ps.setInt(3,did);
					ps.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			
			}
		});
		
	}
}
