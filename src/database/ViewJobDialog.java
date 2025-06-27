package database;

import javax.swing.*;
import java.awt.*;
import model.JobModel;

public class ViewJobDialog extends JDialog {
    public ViewJobDialog(Frame parent, JobModel job, int seekerId, int userId) {
        super(parent, "Job Details", true);
        setLayout(null);

        int labelWidth = 120;
        int valueWidth = 250;
        int height = 25;
        int gap = 10;
        int y = 20;

        String[] labels = {
          "Title:", "Company:", "Description:", "Location:",
            "Requirements:", "Type:", "Salary Min:", "Salary Max:",
            "Posted Date:", "Expiration Date:", "Status:"
        };
        String[] values = {
           job.getJobTitle(), job.getCompanyName(), job.getJobDescription(),
            job.getJobLocation(), job.getRequirements(), job.getJobType(), job.getSalaryMin(),
            job.getSalaryMax(), job.getPostedDate(), job.getExpirationDate(), job.getStatus()
        };

        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = new JLabel(labels[i]);
            lbl.setBounds(20, y, labelWidth, height);
            add(lbl);

            JLabel val = new JLabel(values[i]);
            val.setBounds(20 + labelWidth + 10, y, valueWidth, height);
            add(val);

            y += height + gap;
        }

        JButton btnApply = new JButton("Apply");
        btnApply.setBounds(20, y + 10, 100, 30);
        btnApply.addActionListener(e -> {
             if (JobService.getInstance().applyForJob(job.getJobId(), seekerId, userId)) {
				AlertService.getInstance().insertAlert("Applied for job: " + job.getJobTitle(), seekerId);
				JOptionPane.showMessageDialog(this, "Application submitted successfully.");
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "You Already applied for this job.", "Error", JOptionPane.ERROR_MESSAGE);
			}
        });
        add(btnApply);

        setSize(420, y + 170);
        setLocationRelativeTo(parent);
    }
}
