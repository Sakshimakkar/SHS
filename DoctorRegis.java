package ssh;
import java.awt.EventQueue;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.FlowLayout;
import java.sql.DriverManager;
import java.sql.SQLException;



import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorRegis {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorRegis window = new DoctorRegis();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	PreparedStatement ps=null;
	PreparedStatement ps1=null;

	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	

	/**
	 * Create the application.
	 */
	public DoctorRegis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(62, 60, 35, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Specilaization");
		lblNewLabel_1.setBounds(44, 211, 64, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Designation");
		lblNewLabel_2.setBounds(44, 230, 64, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(62, 273, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(158, 58, 86, 17);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		String name =  textField.getText();
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 211, 86, 14);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		String spec =  textField_1.getText();
		
		textField_2 = new JTextField();
		textField_2.setBounds(158, 230, 86, 14);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		String des= textField_2.getText();
		textField_3 = new JTextField();
		textField_3.setBounds(158, 273, 86, 14);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		//String des= textField_3.getText();
		JLabel lblNewLabel_4 = new JLabel("Registration for Doctor");
		lblNewLabel_4.setBounds(129, 21, 138, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
			           Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.56.40:3306/shs","akshat","1234");
			           
			           String sql = "insert into doctor  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			           PreparedStatement statement = conn.prepareStatement(sql);
			         
			          
			          
			           statement.setString(1, textField_4.getText());
			           statement.setString(2,textField.getText());
			           statement.setString(3,textField_5.getText());
			           statement.setString(4,textField_6.getText());
			           statement.setString(5,textField_13.getText());
			           statement.setString(6,textField_12.getText());
			           statement.setString(7,textField_7.getText());
			           statement.setString(8,textField_8.getText());
			           statement.setString(9,textField_9.getText());
			           statement.setString(10,textField_10.getText());
			           statement.setString(11,textField_11.getText());
			           statement.setString(12,textField_1.getText());
			           statement.setString(13,textField_2.getText());
			           statement.setString(14,textField_4.getText());
			           statement.setString(15,"M");
			           statement.setString(16,textField_14.getText());
			           
			           
			           int row=  statement.executeUpdate();
			           if (row> 0) {
			               System.out.println("Insert in Database successfully done.");
			           }
			           conn.close();
			       } catch (SQLException ex) {
			           ex.printStackTrace();
			       } 
			}
			
		});
		btnRegister.setBounds(155, 422, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setBounds(73, 86, 11, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(158, 86, 86, 14);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		String pass= textField_4.getText();
		JLabel lblAge = new JLabel("DOB");
		lblAge.setBounds(64, 111, 25, 14);
		frame.getContentPane().add(lblAge);
		
		textField_5 = new JTextField();
		textField_5.setBounds(158, 111, 86, 14);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		String dob= textField_5.getText();
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(157, 285, 64, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(236, 285, 75, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(62, 287, 35, 19);
		frame.getContentPane().add(lblGender);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(51, 255, 57, 14);
		frame.getContentPane().add(lblDepartment);
		
		textField_6 = new JTextField();
		textField_6.setBounds(158, 255, 86, 14);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		String dep= textField_6.getText();
		JLabel lblConsulataion = new JLabel("Consultation Day 1");
		lblConsulataion.setBounds(28, 317, 95, 14);
		frame.getContentPane().add(lblConsulataion);
		
		textField_7 = new JTextField();
		textField_7.setBounds(158, 317, 86, 14);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		String c1= textField_7.getText();
		JLabel lblConsultationDay = new JLabel("Consultation Day 2");
		lblConsultationDay.setBounds(28, 342, 95, 14);
		frame.getContentPane().add(lblConsultationDay);
		
		JLabel lblConsultationDay_1 = new JLabel("Consultation Day 3");
		lblConsultationDay_1.setBounds(28, 367, 106, 14);
		frame.getContentPane().add(lblConsultationDay_1);
		
		textField_9 = new JTextField();
		textField_9.setBounds(158, 367, 86, 14);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		String c3= textField_9.getText();
		textField_8 = new JTextField();
		textField_8.setBounds(158, 342, 86, 14);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		String c2= textField_8.getText();
		JLabel lblConsultationTime = new JLabel("Consultation Time");
		lblConsultationTime.setBounds(44, 392, 95, 14);
		frame.getContentPane().add(lblConsultationTime);
		
		textField_10 = new JTextField();
		textField_10.setBounds(158, 391, 86, 16);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("To");
		lblNewLabel_6.setBounds(254, 392, 35, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_11 = new JTextField();
		textField_11.setBounds(299, 392, 86, 14);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Mobile No");
		lblNewLabel_7.setBounds(62, 161, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setBounds(62, 186, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_12 = new JTextField();
		textField_12.setBounds(158, 161, 86, 14);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(158, 186, 153, 14);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(62, 136, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textField_14 = new JTextField();
		textField_14.setBounds(158, 136, 86, 14);
		frame.getContentPane().add(textField_14);
		textField_14.setColumns(10);
		
	}
}
