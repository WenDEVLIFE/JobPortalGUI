package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;

import database.LoginService;
import functions.SaveCredentials;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.util.ArrayList;
 

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	private boolean rememberMe = false; // Variable to store remember me state
	private String savedUsername;
	private String savedPassword;
	List<String> savedCredentials = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Job Portal System Login");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 128, 252));
		panel.setBounds(710, 0, 386, 537);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setBounds(162, 24, 117, 73);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
		
				
				if (username.isEmpty() || password.isEmpty()) {
					System.out.println("Username or Password cannot be empty.");
				} else {
					LoginService.getInstance().validateLogin(username, password, Login.this);
					
					if (rememberMe) {
						// Save credentials if remember me is checked
						SaveCredentials.getInstance().saveCredentials(username, password);
					} else {
						// Clear saved credentials if remember me is not checked
						SaveCredentials.getInstance().ClearCredentials();
					}
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(195, 143, 255));
		btnNewButton.setBounds(119, 356, 158, 46);
		panel.add(btnNewButton);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Verdana", Font.BOLD, 20));
		lblUsername.setBounds(22, 103, 117, 32);
		panel.add(lblUsername);
		
		JLabel lblUsername_1 = new JLabel("Password");
		lblUsername_1.setForeground(Color.WHITE);
		lblUsername_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblUsername_1.setBounds(22, 215, 117, 32);
		panel.add(lblUsername_1);
		
		usernameField = new JTextField();
		usernameField.setBounds(22, 146, 354, 46);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(21, 258, 355, 46);
		panel.add(passwordField);
		
		JLabel lblUsername_1_1 = new JLabel("Dont have an account? Sign Up Here");
		lblUsername_1_1.setForeground(Color.WHITE);
		lblUsername_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblUsername_1_1.setBounds(49, 413, 327, 32);
		panel.add(lblUsername_1_1);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open the registration UI
				RegistrationUI registrationUI = new RegistrationUI();
				registrationUI.setVisible(true);
				dispose(); // Close the login window
			}
		});
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Verdana", Font.BOLD, 11));
		btnSignUp.setBackground(new Color(195, 143, 255));
		btnSignUp.setBounds(119, 456, 158, 46);
		panel.add(btnSignUp);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Handle the remember me functionality here
				if (chckbxNewCheckBox.isSelected()) {
					System.out.println("Remember me selected.");
					 rememberMe = true; // Set remember me to true
					 SaveCredentials.getInstance().saveCredentials(
							usernameField.getText(), 
							new String(passwordField.getPassword())
						);
					// Logic to remember user credential
				} else {
					System.out.println("Remember me deselected.");
					// Logic to clear remembered credentials
					rememberMe = false; // Set remember me to false
					SaveCredentials.getInstance().ClearCredentials();// Clear saved credentials
				}
			}
		});
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Verdana", Font.BOLD, 11));
		chckbxNewCheckBox.setBackground(new Color(234, 128, 252));
		chckbxNewCheckBox.setBounds(31, 311, 227, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("JOB PORTAL SYSTEM");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/pictures/busines.svg")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel_1.setBounds(186, 137, 381, 146);
		contentPane.add(lblNewLabel_1);
		
		// Load saved credentials if available
		List<String> savedCredentials = SaveCredentials.getInstance().loadAllCredentials();
		if (!savedCredentials.isEmpty()) {
			String[] credentials = savedCredentials.get(0).split(":");
			if (credentials.length == 2) {
				savedUsername = credentials[0];
				savedPassword = credentials[1];
				usernameField.setText(savedUsername);
				passwordField.setText(savedPassword);
				rememberMe = true; // Set remember me to true if credentials are loaded
				chckbxNewCheckBox.setSelected(true); // Check the remember me checkbox
			}
		}
		

	}
}
