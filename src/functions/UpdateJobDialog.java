package functions;

import javax.swing.*;
import database.JobService;
import model.JobModel;
import java.awt.event.*;
import java.text.*;
import java.util.*;

public class UpdateJobDialog extends JDialog {
    private JTextField titleField, descriptionField, requirementsField, locationField, jobTypeField, salaryMinField, salaryMaxField, statusField;
    private JFormattedTextField postedAtField, expiresAtField;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private boolean succeeded = false;
    private String jobId;

    public UpdateJobDialog(JFrame parent, JobModel job) {
        super(parent, "Update Job", true);
        this.jobId = job.getJobId();
        setLayout(null);
        setSize(400, 500);
        setLocationRelativeTo(parent);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(20, 20, 100, 25);
        add(titleLabel);
        titleField = new JTextField(job.getJobTitle());
        titleField.setBounds(130, 20, 220, 25);
        add(titleField);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(20, 60, 100, 25);
        add(descriptionLabel);
        descriptionField = new JTextField(job.getJobDescription());
        descriptionField.setBounds(130, 60, 220, 25);
        add(descriptionField);

        JLabel requirementsLabel = new JLabel("Requirements:");
        requirementsLabel.setBounds(20, 100, 100, 25);
        add(requirementsLabel);
        requirementsField = new JTextField(job.getRequirements());
        requirementsField.setBounds(130, 100, 220, 25);
        add(requirementsField);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(20, 140, 100, 25);
        add(locationLabel);
        locationField = new JTextField(job.getJobLocation());
        locationField.setBounds(130, 140, 220, 25);
        add(locationField);

        JLabel jobTypeLabel = new JLabel("Job Type:");
        jobTypeLabel.setBounds(20, 180, 100, 25);
        add(jobTypeLabel);
        jobTypeField = new JTextField(job.getJobType());
        jobTypeField.setBounds(130, 180, 220, 25);
        add(jobTypeField);

        JLabel salaryMinLabel = new JLabel("Salary Min:");
        salaryMinLabel.setBounds(20, 220, 100, 25);
        add(salaryMinLabel);
        salaryMinField = new JTextField(job.getSalaryMin());
        salaryMinField.setBounds(130, 220, 220, 25);
        add(salaryMinField);

        JLabel salaryMaxLabel = new JLabel("Salary Max:");
        salaryMaxLabel.setBounds(20, 260, 100, 25);
        add(salaryMaxLabel);
        salaryMaxField = new JTextField(job.getSalaryMax());
        salaryMaxField.setBounds(130, 260, 220, 25);
        add(salaryMaxField);

        JLabel postedAtLabel = new JLabel("Posted At:");
        postedAtLabel.setBounds(20, 300, 100, 25);
        add(postedAtLabel);
        postedAtField = new JFormattedTextField(dateFormat);
        postedAtField.setBounds(130, 300, 220, 25);
        postedAtField.setText(job.getPostedDate());
        add(postedAtField);

        JLabel expiresAtLabel = new JLabel("Expires At:");
        expiresAtLabel.setBounds(20, 340, 100, 25);
        add(expiresAtLabel);
        expiresAtField = new JFormattedTextField(dateFormat);
        expiresAtField.setBounds(130, 340, 220, 25);
        expiresAtField.setText(job.getExpirationDate());
        add(expiresAtField);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(20, 380, 100, 25);
        add(statusLabel);
        statusField = new JTextField(job.getStatus());
        statusField.setBounds(130, 380, 220, 25);
        add(statusField);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(130, 420, 100, 30);
        add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jobTitle = titleField.getText();
                String jobDescription = descriptionField.getText();
                String requirements = requirementsField.getText();
                String jobLocation = locationField.getText();
                String jobType = jobTypeField.getText();
                String salaryMinStr = salaryMinField.getText();
                String salaryMaxStr = salaryMaxField.getText();
                String postedAtStr = postedAtField.getText();
                String expiresAtStr = expiresAtField.getText();
                String statusStr = statusField.getText();

                if (jobTitle.isEmpty() || jobDescription.isEmpty() || requirements.isEmpty() ||
                    jobLocation.isEmpty() || jobType.isEmpty() || salaryMinStr.isEmpty() ||
                    salaryMaxStr.isEmpty() || postedAtStr.isEmpty() || expiresAtStr.isEmpty() || statusStr.isEmpty()) {
                    JOptionPane.showMessageDialog(UpdateJobDialog.this, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int salaryMin, salaryMax;
                try {
                    salaryMin = Integer.parseInt(salaryMinStr);
                    salaryMax = Integer.parseInt(salaryMaxStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(UpdateJobDialog.this, "Salary fields must be valid integers.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (salaryMin > salaryMax) {
                    JOptionPane.showMessageDialog(UpdateJobDialog.this, "Salary Min must be less than or equal to Salary Max.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Date today = resetTime(new Date());
                Date postedAt, expiresAt;
                try {
                    postedAt = dateFormat.parse(postedAtStr);
                    expiresAt = dateFormat.parse(expiresAtStr);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(UpdateJobDialog.this, "Date format must be yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (postedAt.before(today)) {
                    JOptionPane.showMessageDialog(UpdateJobDialog.this, "Posted At date cannot be in the past.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (expiresAt.before(today)) {
                    JOptionPane.showMessageDialog(UpdateJobDialog.this, "Expires At date cannot be in the past.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (expiresAt.before(postedAt)) {
                    JOptionPane.showMessageDialog(UpdateJobDialog.this, "Expires At date cannot be before Posted At date.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Map<String, Object> jobDetails = new HashMap<>();
                jobDetails.put("jobId", jobId);
                jobDetails.put("jobTitle", jobTitle);
                jobDetails.put("jobDescription", jobDescription);
                jobDetails.put("requirements", requirements);
                jobDetails.put("jobLocation", jobLocation);
                jobDetails.put("jobType", jobType);
                jobDetails.put("salaryMin", salaryMin);
                jobDetails.put("salaryMax", salaryMax);
                jobDetails.put("postedAt", dateFormat.format(postedAt));
                jobDetails.put("expiresAt", dateFormat.format(expiresAt));
                jobDetails.put("status", statusStr);

                boolean success = JobService.getInstance().updateJob(jobDetails);
                if (success) {
                    succeeded = true;
                    JOptionPane.showMessageDialog(UpdateJobDialog.this, "Job updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });
    }

    private Date resetTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}

