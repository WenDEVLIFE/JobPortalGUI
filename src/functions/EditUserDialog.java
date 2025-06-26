package functions;

import javax.swing.*;

import org.mindrot.jbcrypt.BCrypt;

import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class EditUserDialog extends JDialog {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleCombo;
    private JComboBox<String> statusCombo;
    private boolean succeeded = false;

    public EditUserDialog(JFrame parent, Map<String, String> userDetails) {
        super(parent, "Edit User", true);
        setLayout(null);
        setBounds(100, 100, 350, 300);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(30, 30, 80, 25);
        add(lblUsername);

        String username = userDetails.get("username");
        String role = userDetails.get("role");
        String status = userDetails.get("status");
        String password = userDetails.get("password");

        usernameField = new JTextField(username);
        usernameField.setBounds(120, 30, 180, 25);
        usernameField.setEditable(false);
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

        roleCombo = new JComboBox<>(new String[] { "Admin", "Job Seeker", "Recruiter", "Employee" });
        roleCombo.setBounds(120, 110, 180, 25);
        roleCombo.setSelectedItem(role);
        add(roleCombo);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(30, 150, 80, 25);
        add(lblStatus);

        statusCombo = new JComboBox<>(new String[] { "Active", "Inactive" });
        statusCombo.setBounds(120, 150, 180, 25);
        statusCombo.setSelectedItem(status);
        add(statusCombo);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(50, 200, 100, 30);
        btnSave.addActionListener(e -> {
            String newRole = (String) roleCombo.getSelectedItem();
            String newStatus = (String) statusCombo.getSelectedItem();
            String newPassword = new String(passwordField.getPassword());

            if (newRole == null || newRole.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a valid role.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (newStatus == null || newStatus.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a valid status.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (newPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Update user in database (add password to updateUser if needed)
            	
            	Map<String, String> updatedDetails = new HashMap<>();
            	updatedDetails.put("username", usernameField.getText());
            	
            	String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            	updatedDetails.put("password", hashedPassword);
            	updatedDetails.put("role", newRole);
            	updatedDetails.put("status", newStatus);
            	updatedDetails.put("userId", userDetails.get("id")); // Assuming userId is passed in userDetails
                boolean updated = database.RegistrationService.getInstance().updateUser(updatedDetails);
                if (updated) {
                    succeeded = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update user.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(btnSave);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(180, 200, 100, 30);
        btnCancel.addActionListener(e -> dispose());
        add(btnCancel);
    }

    public boolean isSucceeded() { return succeeded; }
    public String getPassword() { return new String(passwordField.getPassword()); }
}
