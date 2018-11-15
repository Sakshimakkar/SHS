package ssh;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class Refer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void ReferSreen(String pid,String did) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Refer window = new Refer( pid, did);
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
	public Refer()
	{
		
	}
	/**
	 * @wbp.parser.constructor
	 */

	public Refer(String pid,String did) {
		try {
			initialize(pid,did);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	Connection con = null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	PreparedStatement ps1=null;
	ResultSet rs1=null;
	
	private void initialize(String pid,String did) throws SQLException {
		try {
			System.out.println("did in refer"+did);
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.56.40:3306/shs", "akshat", "1234");
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
		
		JLabel label = new JLabel("Select Doctor");
		label.setBounds(28, 33, 124, 14);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(109, 84, 65, 23);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(label);
		frame.getContentPane().add(btnSubmit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(162, 30, 107, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblBack = new JLabel("back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblBack.setForeground(Color.BLUE);
		lblBack.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBack.setBounds(357, 11, 46, 14);
		frame.getContentPane().add(lblBack);
		
		String getDesig = "select designation,department from doctor where did= ?";
		ps = (PreparedStatement) con.prepareStatement(getDesig);
		ps.setString(1, did);
		String desig =  null;
		String depart = null;
		
		rs = ps.executeQuery();
		if(rs.next()) {
		desig = (rs.getString("designation"));
		depart = (rs.getString("department"));
		}
		String departments = null;
		if(desig.equalsIgnoreCase("junior"))
		{
			departments = "select dname from doctor where department = ? and designation='senior' and did <> ?	";
			ps = (PreparedStatement) con.prepareStatement(departments);
			ps.setString(1, depart);
			ps.setString(2, did);
		}
		else if (desig.equalsIgnoreCase("senior"))
		{
			departments = "select dname from doctor where designation='senior' and did <> ?";
			ps = (PreparedStatement) con.prepareStatement(departments);
			ps.setString(2, did);
		}
		rs = ps.executeQuery();
		while(rs.next())
		{
			comboBox.addItem(rs.getString("dname"));
		}
		
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String did_new = null;
				String getDid = "select did from doctor where dname = ?";
				String update_doctor = "update patient set did = ? where pid = ?";
				try {
					ps = (PreparedStatement) con.prepareStatement(getDid);
					ps.setString(1, (String) comboBox.getSelectedItem());
					rs = ps.executeQuery();
					if(rs.next()){
					did_new = rs.getString("did");
					}
					ps1 = (PreparedStatement) con.prepareStatement(update_doctor);
					ps1.setString(1, did_new);
					ps1.setString(2, pid);
					ps1.executeUpdate();
					
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		ps.close();
		rs.close();
	}
}
