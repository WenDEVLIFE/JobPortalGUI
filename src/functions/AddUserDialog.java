package functions;

import javax.swing.*;

import org.mindrot.jbcrypt.BCrypt;

import database.RegistrationService;

import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class AddUserDialog extends JDialog {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleCombo;
    private JComboBox<String> statusCombo;
    private boolean succeeded = false;

    public AddUserDialog(JFrame parent) {
        super(parent, "Add User", true);
        setLayout(null);
        setBounds(100, 100, 350, 300);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(30, 30, 80, 25);
        add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(120, 30, 180, 25);
        add(usernameField);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30, 70, 80, 25);
        add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 180, 25);
        add(passwordField);

        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(30, 110, 80, 25);
        add(lblRole);

        roleCombo = new JComboBox<>(new String[] { "Admin", "Job Seeker",  "Recruiter",  "Employee", });
        roleCombo.setBounds(120, 110, 180, 25);
        add(roleCombo);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(30, 150, 80, 25);
        add(lblStatus);

        statusCombo = new JComboBox<>(new String[] { "Active", "Inactive" });
        statusCombo.setBounds(120, 150, 180, 25);
        add(statusCombo);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(50, 200, 100, 30);
        btnAdd.addActionListener(e -> {
            String username = usernameField.getText();
			String password = new String(passwordField.getPassword());
			String role = (String) roleCombo.getSelectedItem();
			String status = (String) statusCombo.getSelectedItem();

			if (username.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Username and Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
			} 
			
			if (RegistrationService.getInstance().isUserExists(username)) {
				JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
			} 
			
			else if (password.length() < 6) {
				JOptionPane.showMessageDialog(this, "Password must be at least 6 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
			} 
			
			else if (role == null || role.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please select a valid role.", "Error", JOptionPane.ERROR_MESSAGE);
			} 
			
			else if (status == null || status.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please select a valid status.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
			
				String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
				
				Map<String, Object> userDetails = new HashMap<>();
				userDetails.put("username", username);
				userDetails.put("password", hashedPassword);
				userDetails.put("role", role);
				
				RegistrationService.getInstance().RegisterUser(userDetails);
				succeeded = true;
				dispose();
			}
        });
        add(btnAdd);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(180, 200, 100, 30);
        btnCancel.addActionListener(e -> dispose());
        add(btnCancel);
    }

    public String getUsername() { return usernameField.getText(); }
    public String getPassword() { return new String(passwordField.getPassword()); }
    public String getRole() { return (String) roleCombo.getSelectedItem(); }
    public String getStatus() { return (String) statusCombo.getSelectedItem(); }
    public boolean isSucceeded() { return succeeded; }
}
