package functions;

import javax.swing.*;

import database.ProfileService;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class UpdateEmployeeProfileDialog extends JDialog {
    private JTextField txtEmployeeName;
    private JTextField txtCompanyName;
    private JTextArea txtDescription;
    private JTextField txtIndustry;
    private JTextField txtLocation;
    private int employeeId;
    private boolean succeeded;

    public UpdateEmployeeProfileDialog(Frame parent, int employeeId) {
        super(parent, "Update Profile", true);
    	this.employeeId =  employeeId;
        setLayout(null);

        JLabel lblEmployeeName = new JLabel("Employee Name:");
        lblEmployeeName.setBounds(20, 20, 120, 25);
        add(lblEmployeeName);

        txtEmployeeName = new JTextField(20);
        txtEmployeeName.setBounds(150, 20, 200, 25);
        add(txtEmployeeName);

        JLabel lblCompanyName = new JLabel("Company Name:");
        lblCompanyName.setBounds(20, 60, 120, 25);
        add(lblCompanyName);

        txtCompanyName = new JTextField(20);
        txtCompanyName.setBounds(150, 60, 200, 25);
        add(txtCompanyName);

        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setBounds(20, 100, 120, 25);
        add(lblDescription);

        txtDescription = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtDescription);
        scroll.setBounds(150, 100, 200, 60);
        add(scroll);

        JLabel lblIndustry = new JLabel("Industry:");
        lblIndustry.setBounds(20, 180, 120, 25);
        add(lblIndustry);

        txtIndustry = new JTextField(20);
        txtIndustry.setBounds(150, 180, 200, 25);
        add(txtIndustry);

        JLabel lblLocation = new JLabel("Location:");
        lblLocation.setBounds(20, 220, 120, 25);
        add(lblLocation);

        txtLocation = new JTextField(20);
        txtLocation.setBounds(150, 220, 200, 25);
        add(txtLocation);

        JButton btnOK = new JButton("OK");
        btnOK.setBounds(80, 270, 80, 30);
        add(btnOK);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 270, 100, 30);
        add(btnCancel);

        btnOK.addActionListener(e -> {
              String employeeName = txtEmployeeName.getText();
              String companyName = txtCompanyName.getText();
              String description = txtDescription.getText();
              String industry = txtIndustry.getText();
              String location = txtLocation.getText();
               if (employeeName.isEmpty() || companyName.isEmpty() || description.isEmpty() || industry.isEmpty() || location.isEmpty()) {
				  JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
			  } else {
				  // Here you would typically call a service to update the employee data
				  Map <String, Object> employeeData = new HashMap<>();
				  String employeeIds = String.valueOf(this.employeeId);
				  employeeData.put("employeeId", employeeIds);
				  employeeData.put("employeeName", employeeName);
				  employeeData.put("companyName", companyName);
				  employeeData.put("description", description);
				  employeeData.put("industry", industry);
				  employeeData.put("location", location);
				 
				  
				  ProfileService.getInstance().updateEmployeeData(employeeData);
				  succeeded = true;
				  dispose();
			  }
        });

        btnCancel.addActionListener(e -> {
            succeeded = false;
            dispose();
        });

        setSize(400, 350);
        setLocationRelativeTo(parent);
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}
