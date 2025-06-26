package database;

import javax.swing.*;
import java.awt.event.*;

public class UpdatePasswordDialog extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean succeeded;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private int employeeId;

    public UpdatePasswordDialog(JFrame parent, int employeeId) {
        super(parent, "Update Password", true);
        this.employeeId = employeeId;
        setLayout(null);
        setSize(350, 220);
        setLocationRelativeTo(parent);

        JLabel lblOld = new JLabel("Old Password:");
        lblOld.setBounds(30, 30, 100, 25);
        add(lblOld);

        oldPasswordField = new JPasswordField();
        oldPasswordField.setBounds(140, 30, 150, 25);
        add(oldPasswordField);

        JLabel lblNew = new JLabel("New Password:");
        lblNew.setBounds(30, 70, 100, 25);
        add(lblNew);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(140, 70, 150, 25);
        add(newPasswordField);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(50, 130, 100, 30);
        add(btnUpdate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(180, 130, 100, 30);
        add(btnCancel);

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your password update logic here
                String oldPassword = getOldPassword();
                String newPassword = getNewPassword();
                
                if (oldPassword.isEmpty() || newPassword.isEmpty()) {
					JOptionPane.showMessageDialog(UpdatePasswordDialog.this, "Please fill in both fields.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
                
                if (oldPassword.equals(newPassword)) {
					JOptionPane.showMessageDialog(UpdatePasswordDialog.this, "New password cannot be the same as old password.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Call the service to update the password
                String employeeIdStr = String.valueOf(employeeId);
				boolean success = RegistrationService.getInstance().updatePassword(employeeIdStr, oldPassword, newPassword);
				
				if (success) {
					succeeded = true;
					dispose();
				} else {
					JOptionPane.showMessageDialog(UpdatePasswordDialog.this, "Failed to update password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
				}
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                succeeded = false;
                dispose();
            }
        });
    }

    public String getOldPassword() {
        return new String(oldPasswordField.getPassword());
    }

    public String getNewPassword() {
        return new String(newPasswordField.getPassword());
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}
