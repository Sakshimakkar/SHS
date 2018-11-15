package ssh;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Patient {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private final JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient window = new Patient();
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
	public Patient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistrationForPatient = new JLabel("Registration For Patient");
		lblRegistrationForPatient.setBounds(134, 31, 164, 14);
		frame.getContentPane().add(lblRegistrationForPatient);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(95, 69, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(82, 112, 46, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(82, 137, 59, 14);
		frame.getContentPane().add(lblMobileNo);
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegister.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				try {
				Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.56.40:3306/shs","akshat","1234");
		           
		           String sql = "insert into patient(name,age,address,mobileno,gender,pid)  values(?,?,?,?,?,?)";
		           PreparedStatement statement = conn.prepareStatement(sql);
		         
		          
		          
		           statement.setString(1, textField.getText());
		           statement.setString(2,textField_4.getText());
		           statement.setString(3,textField_1.getText());
		           statement.setString(4,textField_2.getText());
		           statement.setString(5,"M");
		           statement.setString(6,"1");
		          
		           
		           
		           int row=  statement.executeUpdate();
		           if (row> 0) {
		               System.out.println("Insert in Database successfully done.");
		           }
		           conn.close();
		       } 
			catch (SQLException ex) {
		           ex.printStackTrace();
		      
		
				
				
				
			} 
			}
			
		});
		btnRegister.setBounds(155, 215, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		textField = new JTextField();
		textField.setBounds(151, 66, 86, 14);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 110, 147, 17);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(151, 135, 93, 16);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAge = new JLabel("  Age");
		lblAge.setBounds(95, 87, 46, 14);
		frame.getContentPane().add(lblAge);
		
		textField_4 = new JTextField();
		textField_4.setBounds(151, 87, 86, 14);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		rdbtnNewRadioButton.setBounds(155, 157, 59, 31);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(227, 161, 59, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(95, 162, 46, 14);
		frame.getContentPane().add(lblGender);
		
		}
}
