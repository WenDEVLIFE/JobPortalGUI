package functions;

import javax.swing.*;
import java.awt.*;
import database.ProfileService;
import ui.JobSeekerUI;
import database.ApplicationService;

public class ViewApplicantDialog extends JDialog {
	
	public boolean isApproved = false;
    public ViewApplicantDialog(JFrame parent, int seekerId, String jobId) {
        super(parent, "Applicant Information", true);
        setLayout(null);
        setSize(400, 370);
        setLocationRelativeTo(parent);

        // Retrieve applicant info
        String fullName = ProfileService.getInstance().getFullName(seekerId);
        String contact = ProfileService.getInstance().getContactInfo(seekerId);
        String location = ProfileService.getInstance().getLocation(seekerId);
        String userId = ProfileService.getInstance().getUserId(seekerId);

        JLabel lblFullName = new JLabel("Full Name: " + (fullName != null ? fullName : "N/A"));
        lblFullName.setBounds(30, 30, 340, 25);
        add(lblFullName);

        JLabel lblContact = new JLabel("Contact: " + (contact != null ? contact : "N/A"));
        lblContact.setBounds(30, 65, 340, 25);
        add(lblContact);

        JLabel lblLocation = new JLabel("Location: " + (location != null ? location : "N/A"));
        lblLocation.setBounds(30, 100, 340, 25);
        add(lblLocation);

        JLabel lblSeekerId = new JLabel("Seeker ID: " + seekerId);
        lblSeekerId.setBounds(30, 135, 340, 25);
        add(lblSeekerId);

        JButton btnViewResume = new JButton("View Resume");
        btnViewResume.setBounds(30, 180, 150, 30);
        btnViewResume.addActionListener(e -> {
    
            ViewResumeDialog dialog = new ViewResumeDialog(parent, seekerId, "Applicant Resumes", false);
			dialog.setVisible(true);
        });
        add(btnViewResume);

        JButton btnViewSkills = new JButton("View Skills");
        btnViewSkills.setBounds(220, 180, 150, 30);
        btnViewSkills.addActionListener(e -> {
         
            AddSkillDialog skillDialog = new AddSkillDialog(parent, seekerId, "Applicant Skills", false);
			skillDialog.setVisible(true);
        });
        add(btnViewSkills);

        JButton btnApproveApplicant = new JButton("Approve Applicant");
        btnApproveApplicant.setBounds(30, 230, 340, 30);
        btnApproveApplicant.addActionListener(e -> {
            boolean success = ApplicationService.getInstance().updateStatus(jobId, seekerId, "Approved");
            if (success) {
                JOptionPane.showMessageDialog(this, "Applicant approved successfully.");
                dispose();
                isApproved = true;
            } else {
                JOptionPane.showMessageDialog(this, "Failed to approve applicant.", "Error", JOptionPane.ERROR_MESSAGE);
                isApproved = false;
            }
        });
        add(btnApproveApplicant);

        JButton closeBtn = new JButton("Close");
        closeBtn.setBounds(140, 280, 100, 30);
        closeBtn.addActionListener(e -> dispose());
        add(closeBtn);
    }
    
    public boolean isApproved() {
		return isApproved;
    }
}
