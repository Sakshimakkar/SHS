package ssh;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.FlowLayout;
import java.awt.Window;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import java.sql.ResultSet;  

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	String id,pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
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
		
		textField = new JTextField();
		textField.setBounds(142, 39, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 70, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		 // pass= .toString();
		 
		// System.out.println("hey" +pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
			           Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.56.40:3306/shs","akshat","1234");
			           
			           String sql = "select * from doctor where password = ? and did= ?";
			           PreparedStatement statement = conn.prepareStatement(sql);
			         
			           System.out.println("hey" +textField_1.getText());
			          
			           statement.setString(1, textField_1.getText());
			           statement.setString(2,textField.getText());
			           
			           
			           ResultSet  row= (ResultSet) statement.executeQuery();
			           if (row.next()) {
			               System.out.println("Insert in Database successfully done.");
			               
			               JOptionPane.showMessageDialog(null, "Login succesfull", "InfoBox: " + "login status", JOptionPane.INFORMATION_MESSAGE);
			           }
			           conn.close();
			       } catch (SQLException ex) {
			           ex.printStackTrace();
			       } 
			}
		});
		btnNewButton.setBounds(142, 162, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(378, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("ID:");
		lblName.setBounds(61, 45, 46, 14);
		frame.getContentPane().add(lblName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Doctor", "Customer"}));
		comboBox.setSelectedIndex(0);
		comboBox.setToolTipText("Admin");
		comboBox.setBounds(142, 111, 86, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(61, 73, 69, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblLoginIn = new JLabel("Login In");
		lblLoginIn.setBounds(168, 11, 46, 14);
		frame.getContentPane().add(lblLoginIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				Signin a = new Signin();
				
				
			}
		});
		btnSignUp.setBounds(335, 2, 89, 23);
		frame.getContentPane().add(btnSignUp);
		
	}
}
