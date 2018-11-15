package ssh;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Critical {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Critical window = new Critical();
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
	public Critical() {
		initialize();
		frame.getContentPane().setLayout(null);
		JLabel lblState = new JLabel("State");
		lblState.setBounds(82, 59, 33, 14);
		frame.getContentPane().add(lblState);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Critical");
		rdbtnNewRadioButton.setBounds(143, 55, 66, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Non-Critical");
		rdbtnNewRadioButton_1.setBounds(226, 55, 102, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel = new JLabel("Location");
		lblNewLabel.setBounds(82, 95, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnOpd = new JRadioButton("O.P.D");
		rdbtnOpd.setBounds(143, 91, 59, 23);
		frame.getContentPane().add(rdbtnOpd);
		
		JRadioButton rdbtnIcu = new JRadioButton("Local");
		rdbtnIcu.setBounds(226, 82, 76, 40);
		frame.getContentPane().add(rdbtnIcu);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(143, 144, 89, 23);
		frame.getContentPane().add(btnSubmit);
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
