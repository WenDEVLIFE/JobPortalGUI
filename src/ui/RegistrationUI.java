package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import database.RegistrationService;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RegistrationUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	List<String> roles = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
					RegistrationUI frame = new RegistrationUI();
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
	public RegistrationUI() {
	
		// Initialize roles
		roles.add("Job Seeker");
		roles.add("Employer");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(234, 128, 252));
		panel.setBounds(712, 0, 386, 558);
		contentPane.add(panel);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Verdana", Font.BOLD, 30));
		lblSignUp.setBounds(117, 11, 160, 73);
		panel.add(lblSignUp);
		

		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Verdana", Font.BOLD, 20));
		lblUsername.setBounds(22, 95, 117, 32);
		panel.add(lblUsername);
		
		JLabel lblUsername_1 = new JLabel("Password");
		lblUsername_1.setForeground(Color.WHITE);
		lblUsername_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblUsername_1.setBounds(22, 195, 117, 32);
		panel.add(lblUsername_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(22, 138, 354, 46);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(21, 232, 355, 46);
		panel.add(passwordField);
		
		JLabel lblUsername_1_1 = new JLabel("Already have an account? Sign In Here");
		lblUsername_1_1.setForeground(Color.WHITE);
		lblUsername_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblUsername_1_1.setBounds(22, 458, 354, 32);
		panel.add(lblUsername_1_1);
		
		JButton btnSignUp = new JButton("Sign In");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
				dispose(); // Close the registration frame
			}
		});
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Verdana", Font.BOLD, 11));
		btnSignUp.setBackground(new Color(195, 143, 255));
		btnSignUp.setBounds(132, 501, 158, 46);
		panel.add(btnSignUp);
		
		JComboBox roleComboBox = new JComboBox();
		roleComboBox.setBounds(22, 336, 354, 49);
		panel.add(roleComboBox);
		
		// Populate the JComboBox with roles
		for (String role : roles) {
			roleComboBox.addItem(role);
		}
		
		JLabel lblUsername_1_2 = new JLabel("Select a user type");
		lblUsername_1_2.setForeground(Color.WHITE);
		lblUsername_1_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblUsername_1_2.setBounds(22, 289, 210, 32);
		panel.add(lblUsername_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("JOB PORTAL SYSTEM ");
		lblNewLabel_1.setIcon(new ImageIcon(RegistrationUI.class.getResource("/pictures/busines.svg")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel_1.setBounds(188, 137, 381, 146);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				String role = (String) roleComboBox.getSelectedItem();
				
				if (username.isEmpty() || password.isEmpty() || role == null) {
					System.out.println("Please fill in all fields.");
					JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
				} 
				
				if(RegistrationService.getInstance().isUserExists(username)) {
					System.out.println("Username already exists. Please choose a different username.");
					JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					// Create a map to hold user details
					
					String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
					
					Map<String, Object> userDetails = new HashMap<>();
					userDetails.put("username", username);
					userDetails.put("password", hashedPassword);
					userDetails.put("role", role);
					
					
					
					// Call the registration method
					RegistrationService.getInstance().RegisterUser(userDetails);
					textField.setText("");
					passwordField.setText("");
					roleComboBox.setSelectedIndex(-1); // Reset the combo box selection
				}
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(195, 143, 255));
		btnNewButton.setBounds(132, 396, 158, 46);
		panel.add(btnNewButton);

	}
}
