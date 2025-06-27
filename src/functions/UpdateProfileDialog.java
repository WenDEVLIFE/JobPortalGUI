package functions;

import javax.swing.*;

import database.ProfileService;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class UpdateProfileDialog extends JDialog {
    private JTextField fullNameField;
    private JTextField contactInfoField;
    private JTextField locationField;
    private boolean succeeded;
    private int userId;

    public UpdateProfileDialog(Frame parent, int userId) {
        super(parent, "Update Profile", true);
        this.userId = userId;
        setLayout(null);
        setSize(350, 250);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(30, 30, 80, 25);
        add(nameLabel);

        fullNameField = new JTextField(20);
       // fullNameField.setText(fullName);
        fullNameField.setBounds(120, 30, 180, 25);
        add(fullNameField);

        JLabel contactLabel = new JLabel("Contact Info:");
        contactLabel.setBounds(30, 70, 80, 25);
        add(contactLabel);

        contactInfoField = new JTextField(20);
        ///contactInfoField.setText(contactInfo);
        contactInfoField.setBounds(120, 70, 180, 25);
        add(contactInfoField);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(30, 110, 80, 25);
        add(locationLabel);

        locationField = new JTextField(20);
       // locationField.setText(location);
        locationField.setBounds(120, 110, 180, 25);
        add(locationField);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(70, 160, 80, 30);
        add(btnSave);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(180, 160, 80, 30);
        add(btnCancel);

        btnSave.addActionListener(e -> {
          String fullName = fullNameField.getText().trim();
          String contactInfo = contactInfoField.getText().trim();
           String location = locationField.getText().trim();

			if (fullName.isEmpty() || contactInfo.isEmpty() || location.isEmpty()) {
				JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Assuming ProfileService is a class that handles profile updates
			String userIdStr = String.valueOf(userId);
			Map <String, Object> userData = new HashMap<>();
			userData.put("userId", userId);
			userData.put("fullName", fullName);
			userData.put("contactInfo", contactInfo);
			userData.put("location", location);
			 
		
			
			boolean success = ProfileService.getInstance().updateProfileData(userData);

			if (success) {
				succeeded = true;
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Failed to update profile.", "Error", JOptionPane.ERROR_MESSAGE);
			}
        });

        btnCancel.addActionListener(e -> {
            succeeded = false;
            setVisible(false);
        });

        setLocationRelativeTo(parent);
    }
    public boolean isSucceeded() { return succeeded; }
}
