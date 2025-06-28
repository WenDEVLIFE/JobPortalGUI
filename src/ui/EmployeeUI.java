package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import database.AlertService;
import database.ApplicationService;
import database.JobService;
import database.ProfileService;
import database.UpdatePasswordDialog;
import functions.AddCreateJobDialog;
import functions.UpdateEmployeeProfileDialog;
import functions.UpdateJobDialog;
import functions.ViewApplicantDialog;
import model.AlertModel;
import model.ApplicationModel;
import model.JobModel;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class EmployeeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable applicantTable;
	private JTable alertTable;
	private JTextField textField_2;
	private JLabel employeeText;
	private JLabel companyText;
	private JLabel locationText;
	 private JLabel industryText;
	 private JTextArea descriptionArea;
	private JTable table_1;
	private JLabel totalJobtext;
	private JLabel totalApprovedJob;
	private JLabel TotalJobPending;
	private JLabel totalJobOpenText;
	private JLabel TotalJobClosed;
	private int userId, employeeId;
	

	DefaultTableModel jobTableModel, alertTableModel, applicantTableModel;
	List<JobModel> jobList = new ArrayList<>();
	List <AlertModel> alertList = new ArrayList<>();
	List <ApplicationModel> applicationList = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
					EmployeeUI frame = new EmployeeUI();
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
	public EmployeeUI() {
		setTitle("Job Portal System Employee Portal");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1133, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1117, 537);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Home", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblWelcomeBack_1 = new JLabel("Welcome Back , User");
		lblWelcomeBack_1.setForeground(Color.WHITE);
		lblWelcomeBack_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1.setBounds(22, 11, 462, 38);
		panel.add(lblWelcomeBack_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 128, 255));
		panel_3.setBounds(41, 79, 331, 172);
		panel.add(panel_3);
		
	
		JLabel lblWelcomeBack_1_1 = new JLabel("Total Job Seeker Applied");
		lblWelcomeBack_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1.setBounds(20, 39, 311, 38);
		panel_3.add(lblWelcomeBack_1_1);
		
		totalJobtext = new JLabel("0");
		totalJobtext.setForeground(Color.WHITE);
		totalJobtext.setFont(new Font("Verdana", Font.BOLD, 20));
		totalJobtext.setBounds(139, 89, 130, 38);
		panel_3.add(totalJobtext);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(255, 128, 255));
		panel_3_1.setBounds(396, 79, 331, 172);
		panel.add(panel_3_1);
		
		JLabel lblWelcomeBack_1_1_2 = new JLabel("Total Job Approved");
		lblWelcomeBack_1_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_2.setBounds(54, 40, 241, 38);
		panel_3_1.add(lblWelcomeBack_1_1_2);
		
		totalApprovedJob = new JLabel("0");
		totalApprovedJob.setForeground(Color.WHITE);
		totalApprovedJob.setFont(new Font("Verdana", Font.BOLD, 20));
		totalApprovedJob.setBounds(139, 89, 130, 38);
		panel_3_1.add(totalApprovedJob);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setLayout(null);
		panel_3_2_1.setBackground(new Color(255, 128, 255));
		panel_3_2_1.setBounds(756, 79, 331, 172);
		panel.add(panel_3_2_1);
		
		JLabel lblWelcomeBack_1_1_3_1 = new JLabel("Total Job Pending");
		lblWelcomeBack_1_1_3_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3_1.setBounds(63, 40, 206, 38);
		panel_3_2_1.add(lblWelcomeBack_1_1_3_1);
		
		TotalJobPending = new JLabel("0");
		TotalJobPending.setForeground(Color.WHITE);
		TotalJobPending.setFont(new Font("Verdana", Font.BOLD, 20));
		TotalJobPending.setBounds(139, 89, 130, 38);
		panel_3_2_1.add(TotalJobPending);
		
		JPanel panel_3_2_1_1 = new JPanel();
		panel_3_2_1_1.setLayout(null);
		panel_3_2_1_1.setBackground(new Color(255, 128, 255));
		panel_3_2_1_1.setBounds(264, 306, 331, 172);
		panel.add(panel_3_2_1_1);
		
		JLabel lblWelcomeBack_1_1_3_1_1 = new JLabel("Total Job Open");
		lblWelcomeBack_1_1_3_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3_1_1.setBounds(63, 40, 206, 38);
		panel_3_2_1_1.add(lblWelcomeBack_1_1_3_1_1);
		
		totalJobOpenText = new JLabel("0");
		totalJobOpenText.setForeground(Color.WHITE);
		totalJobOpenText.setFont(new Font("Verdana", Font.BOLD, 20));
		totalJobOpenText.setBounds(139, 89, 130, 38);
		panel_3_2_1_1.add(totalJobOpenText);
		
		JPanel panel_3_2_1_1_1 = new JPanel();
		panel_3_2_1_1_1.setLayout(null);
		panel_3_2_1_1_1.setBackground(new Color(255, 128, 255));
		panel_3_2_1_1_1.setBounds(627, 306, 331, 172);
		panel.add(panel_3_2_1_1_1);
		
		JLabel lblWelcomeBack_1_1_3_1_1_1 = new JLabel("Total Job Closed");
		lblWelcomeBack_1_1_3_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3_1_1_1.setBounds(63, 40, 206, 38);
		panel_3_2_1_1_1.add(lblWelcomeBack_1_1_3_1_1_1);
		
		TotalJobClosed = new JLabel("0");
		TotalJobClosed.setForeground(Color.WHITE);
		TotalJobClosed.setFont(new Font("Verdana", Font.BOLD, 20));
		TotalJobClosed.setBounds(139, 89, 130, 38);
		panel_3_2_1_1_1.add(TotalJobClosed);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Jobs", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblWelcomeBack_1_2_3 = new JLabel("Jobs");
		lblWelcomeBack_1_2_3.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_3.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2_3.setBounds(104, 11, 88, 38);
		panel_2.add(lblWelcomeBack_1_2_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(222, 11, 863, 38);
		panel_2.add(textField_2);
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setBounds(39, 60, 1046, 360);
		panel_2.add(table_1);
		
		
		JButton btnViewApplicant_2 = new JButton("Create a Job");
		btnViewApplicant_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(employeeId <= 0) {
					 JOptionPane.showMessageDialog(EmployeeUI.this, "Please update your profile to create jobs.", "Profile Required", JOptionPane.WARNING_MESSAGE);
					 return;
				 }
				 
				 AddCreateJobDialog createJobDialog = new AddCreateJobDialog(EmployeeUI.this, userId, employeeId);
					createJobDialog.setVisible(true);
					if (createJobDialog.isSucceeded()) {
						// Refresh the job table or perform any other necessary actions
						JOptionPane.showMessageDialog(EmployeeUI.this, "Job created successfully!");
					} else {
						JOptionPane.showMessageDialog(EmployeeUI.this, "Failed to create job.");
					}
			}
		});
		btnViewApplicant_2.setForeground(Color.WHITE);
		btnViewApplicant_2.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewApplicant_2.setBackground(new Color(195, 143, 255));
		btnViewApplicant_2.setBounds(92, 431, 229, 53);
		panel_2.add(btnViewApplicant_2);
		
		// update the job
		JButton btnViewApplicant_2_1 = new JButton("Update Job");
		btnViewApplicant_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table_1.getSelectedRow();
				
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(EmployeeUI.this, "Please select a job to update.", "No Job Selected", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if (employeeId <= 0) {
					JOptionPane.showMessageDialog(EmployeeUI.this, "Please update your profile to manage jobs.", "Profile Required", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				JobModel selectedJob = jobList.get(selectedRow);
				if (selectedJob == null) {
					JOptionPane.showMessageDialog(EmployeeUI.this, "No job data available for the selected row.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				UpdateJobDialog updateJobDialog = new UpdateJobDialog(EmployeeUI.this, selectedJob);
				updateJobDialog.setVisible(true);
				if (updateJobDialog.isSucceeded()) {
					JOptionPane.showMessageDialog(EmployeeUI.this, "Job updated successfully!");
					LoadJobData(); // Refresh the job data after update
					// Optionally, refresh the job table or perform any other necessary actions
				} 
			}
		});
		btnViewApplicant_2_1.setForeground(Color.WHITE);
		btnViewApplicant_2_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewApplicant_2_1.setBackground(new Color(195, 143, 255));
		btnViewApplicant_2_1.setBounds(436, 431, 229, 53);
		panel_2.add(btnViewApplicant_2_1);
		
		JButton btnViewApplicant_2_1_1 = new JButton("Delete Job");
		btnViewApplicant_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table_1.getSelectedRow();
				
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(EmployeeUI.this, "Please select a job to delete.", "No Job Selected", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				JobModel selectedJob = jobList.get(selectedRow);
				if (selectedJob == null) {
					JOptionPane.showMessageDialog(EmployeeUI.this, "No job data available for the selected row.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int confirm = JOptionPane.showConfirmDialog(EmployeeUI.this, "Are you sure you want to delete this job?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					JobService jobService = JobService.getInstance();
					boolean success = jobService.deleteJob(selectedJob.getJobId());
					if (success) {
						JOptionPane.showMessageDialog(EmployeeUI.this, "Job deleted successfully!");
						LoadJobData(); // Refresh the job data after deletion
					} else {
						JOptionPane.showMessageDialog(EmployeeUI.this, "Failed to delete job.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnViewApplicant_2_1_1.setForeground(Color.WHITE);
		btnViewApplicant_2_1_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewApplicant_2_1_1.setBackground(new Color(195, 143, 255));
		btnViewApplicant_2_1_1.setBounds(800, 431, 229, 53);
		panel_2.add(btnViewApplicant_2_1_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Applicants", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblWelcomeBack_1_2 = new JLabel("Applicants");
		lblWelcomeBack_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_2.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2.setBounds(27, 11, 202, 38);
		panel_1.add(lblWelcomeBack_1_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(228, 11, 863, 38);
		panel_1.add(textField);
		
		applicantTable = new JTable();
		applicantTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		applicantTable.setBounds(56, 60, 1046, 360);
		panel_1.add(applicantTable);
		
		JButton btnViewApplicant = new JButton("View Applicant");
		btnViewApplicant.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = applicantTable.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(EmployeeUI.this, "Please select an applicant.", "No Applicant Selected", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
		        ApplicationModel selectedApp = applicationList.get(selectedRow);
	  		        if (selectedApp == null) {
		            JOptionPane.showMessageDialog(EmployeeUI.this, "No applicant data available for the selected row.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
	  		        
	  		    String seekerId = selectedApp.getSeekerId();
	  		    int seekerIdInt = Integer.parseInt(seekerId);
		        ViewApplicantDialog dialog = new ViewApplicantDialog(EmployeeUI.this, seekerIdInt, selectedApp.getJobId());
		        dialog.setVisible(true);
		        
		        if (dialog.isApproved) {
		            // If the applicant was approved, refresh the application data
		            LoadApplicationData();
		            JOptionPane.showMessageDialog(EmployeeUI.this, "Applicant approved successfully!");
		        } 
		    }
		});

		btnViewApplicant.setForeground(Color.WHITE);
		btnViewApplicant.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewApplicant.setBackground(new Color(195, 143, 255));
		btnViewApplicant.setBounds(392, 431, 337, 53);
		panel_1.add(btnViewApplicant);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		tabbedPane.addTab("My Profile", null, panel_1_1_1, null);
		
		JLabel lblWelcomeBack_1_2_1_1_2 = new JLabel("My Profile");
		lblWelcomeBack_1_2_1_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2_1_1_2.setBounds(25, 21, 250, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1 = new JLabel("Employee Name:");
		lblWelcomeBack_1_2_1_1_2_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1.setBounds(25, 84, 250, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1);
		
		JButton btnUpdateProfileDetails = new JButton("Update Profile Details");
		btnUpdateProfileDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmployeeProfileDialog updateProfileDialog = new UpdateEmployeeProfileDialog(EmployeeUI.this, userId);
				updateProfileDialog.setVisible(true);
				if (updateProfileDialog.isSucceeded()) {
					JOptionPane.showMessageDialog(EmployeeUI.this, "Profile updated successfully!");
					LoadEmployeeProfile();
					// Optionally, refresh the profile data displayed in the UI
				} 
			}
		});
		btnUpdateProfileDetails.setForeground(Color.WHITE);
		btnUpdateProfileDetails.setFont(new Font("Verdana", Font.BOLD, 11));
		btnUpdateProfileDetails.setBackground(new Color(195, 143, 255));
		btnUpdateProfileDetails.setBounds(190, 435, 276, 46);
		panel_1_1_1.add(btnUpdateProfileDetails);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1_1 = new JLabel("Company Name:");
		lblWelcomeBack_1_2_1_1_2_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1_1.setBounds(25, 190, 467, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1_1);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1_1_1 = new JLabel("Description:");
		lblWelcomeBack_1_2_1_1_2_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1_1_1.setBounds(25, 288, 169, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1_1_1);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1_1_1_1 = new JLabel("Location:");
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1.setBounds(485, 182, 450, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1_1_1_1);
		
		companyText = new JLabel("09912455343");
		companyText.setForeground(Color.WHITE);
		companyText.setFont(new Font("Verdana", Font.BOLD, 20));
		companyText.setBounds(25, 239, 450, 38);
		panel_1_1_1.add(companyText);
		
		employeeText = new JLabel("John Doe");
		employeeText.setForeground(Color.WHITE);
		employeeText.setFont(new Font("Verdana", Font.BOLD, 20));
		employeeText.setBounds(25, 133, 450, 38);
		panel_1_1_1.add(employeeText);
		
		JButton btnUpdateMyPassword = new JButton("Update My Password");
		btnUpdateMyPassword.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        UpdatePasswordDialog dialog = new UpdatePasswordDialog(EmployeeUI.this, userId);
		        dialog.setVisible(true);
		        if (dialog.isSucceeded()) {
		            JOptionPane.showMessageDialog(EmployeeUI.this, "Password updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		        }
		        else {
		            JOptionPane.showMessageDialog(EmployeeUI.this, "Password update failed", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		

		btnUpdateMyPassword.setForeground(Color.WHITE);
		btnUpdateMyPassword.setFont(new Font("Verdana", Font.BOLD, 11));
		btnUpdateMyPassword.setBackground(new Color(195, 143, 255));
		btnUpdateMyPassword.setBounds(582, 435, 276, 46);
		panel_1_1_1.add(btnUpdateMyPassword);
		
		locationText = new JLabel("TESTADDRESS");
		locationText.setForeground(Color.WHITE);
		locationText.setFont(new Font("Verdana", Font.BOLD, 20));
		locationText.setBounds(485, 239, 450, 38);
		panel_1_1_1.add(locationText);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3 = new JLabel("Industry:");
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3.setBounds(485, 84, 450, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3);
		
		industryText = new JLabel("Industry");
		industryText.setForeground(Color.WHITE);
		industryText.setFont(new Font("Verdana", Font.BOLD, 20));
		industryText.setBounds(485, 133, 450, 38);
		panel_1_1_1.add(industryText);
		
		descriptionArea = new JTextArea();
		descriptionArea.setFont(new Font("Verdana", Font.BOLD, 14));
		descriptionArea.setBounds(25, 337, 434, 68);
		panel_1_1_1.add(descriptionArea);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		tabbedPane.addTab("Alerts", null, panel_1_2, null);
		
		JLabel lblWelcomeBack_1_2_2 = new JLabel("Alerts");
		lblWelcomeBack_1_2_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_2.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2_2.setBounds(27, 11, 202, 38);
		panel_1_2.add(lblWelcomeBack_1_2_2);
		
		alertTable = new JTable();
		alertTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		alertTable.setBounds(56, 60, 1046, 360);
		panel_1_2.add(alertTable);
		
		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setLayout(null);
		tabbedPane.addTab("Logout", null, panel_1_1_2_1, null);
		
		JLabel lblWelcomeBack_2 = new JLabel("Are you sure you want to logout?");
		lblWelcomeBack_2.setForeground(Color.WHITE);
		lblWelcomeBack_2.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_2.setBounds(301, 36, 633, 38);
		panel_1_1_2_1.add(lblWelcomeBack_2);
		
		JButton btnNewButton_1 = new JButton("Yes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
				dispose(); // Close the current frame
				JOptionPane.showMessageDialog(null, "You have successfully logged out.", "Logout Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_1.setBackground(new Color(195, 143, 255));
		btnNewButton_1.setBounds(438, 197, 301, 53);
		panel_1_1_2_1.add(btnNewButton_1);
		
		JButton btnNo_1 = new JButton("No");
		btnNo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Close the logout confirmation panel and return to the previous tab
				JOptionPane.showMessageDialog(null, "Logout cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				tabbedPane.setSelectedIndex(0); // Assuming 0 is the index of the Home tab
			}
		});
		btnNo_1.setForeground(Color.WHITE);
		btnNo_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNo_1.setBackground(new Color(195, 143, 255));
		btnNo_1.setBounds(438, 301, 301, 53);
		panel_1_1_2_1.add(btnNo_1);

		 String [] columnNames = {"Job ID", "Job Title", "Company Name", "Posted Date", "Status", "Expiration Date"};
		 String [] alertColumnNames = {"Alert ID", "Description", "Timestamp"};
		 String [] applicantColumnNames = {"Application ID", "Job Title", "Company Name", "Status", "Applied At"};
		 jobTableModel = new DefaultTableModel(columnNames, 0);
		 alertTableModel = new DefaultTableModel(alertColumnNames, 0);
		 applicantTableModel = new DefaultTableModel(applicantColumnNames, 0);
		 table_1.setModel(jobTableModel);
		 alertTable.setModel(alertTableModel);
		 applicantTable.setModel(applicantTableModel);
		 
		
	 LoadJobData();
	 LoadEmployeeProfile();
	 LoadJobData();
	 LoadAlertData();
	 
		Timer notificationTimer = new Timer(5000, e -> {
		    AlertService.getInstance().notifyUserIfNeeded(userId);
		});
		notificationTimer.start();
	}
	
	
	public void setData(int userId) {
		this.userId = userId;
		System.out.println("Employee ID set to: " + userId);
		
		 // Start notification timer after userId is set
	    Timer notificationTimer = new Timer(5000, e -> {
	        AlertService.getInstance().notifyUserIfNeeded(this.userId);
	    });
	    notificationTimer.start();
	}
	
	public void LoadAlertData() {
		alertList.clear();
		
		alertTableModel.setRowCount(0); // Clear existing rows in the table model
		
		alertList = AlertService.getInstance().getAlertsByUserId(userId);
		for (AlertModel alert : alertList) {
			Object[] rowData = {
				alert.getAlertId(),
				alert.getDescription(),
				alert.getTimestamp()
			};
			alertTableModel.addRow(rowData);
		}
	}
	
	// This will load the job
		public void LoadJobData() {
			jobList.clear();
			
			jobTableModel.setRowCount(0); // Clear existing rows in the table model
		
		 	jobList = JobService.getInstance().getAllJobsByEmployeeId(employeeId);
			
			for (JobModel job : jobList) {
	  			Object[] rowData = {
					job.getJobId(),
					job.getJobTitle(),
					job.getCompanyName(),
					job.getPostedDate(),
					job.getStatus(),
					job.getExpirationDate()
				};
	  			jobTableModel.addRow(rowData);
			}
		}
		
		public void LoadApplicationData() {
			 applicationList.clear();
			
			 applicantTableModel.setRowCount(0); // Clear existing rows in the table model
			 
			 applicationList = ApplicationService.getInstance().getApplicationByEmployee(employeeId);
			 
			 for (ApplicationModel application : applicationList) {
				 Object[] rowData = {
					 application.getApplicationId(),
					 application.getJobTitle(),
					 application.getCompanyName(),
					 application.getStatus(),
					 application.getAppliedAt()
				 };
				 applicantTableModel.addRow(rowData);
			 }
		}
		
		
		public void LoadEmployeeProfile() {
			System.out.println("Loading employee profile for userId: " + userId);

			String employeeName = ProfileService.getInstance().getEmployeeName(String.valueOf(userId));
			String companyName = ProfileService.getInstance().getCompanyName(String.valueOf(userId));
			String description = ProfileService.getInstance().getDescription(String.valueOf(userId));
			String industry = ProfileService.getInstance().getIndustry(String.valueOf(userId));
			String location = ProfileService.getInstance().getLocation(String.valueOf(userId));
			
			this.employeeId = ProfileService.getInstance().getEmployeeId(String.valueOf(userId));
		

		    employeeText.setText(employeeName != null ? employeeName : "N/A");
		    companyText.setText(companyName != null ? companyName : "N/A");
		    descriptionArea.setText(description != null ? description : "N/A");
		    descriptionArea.setEditable(false); // Make JTextArea uneditable
		    industryText.setText(industry != null ? industry : "N/A");
		    locationText.setText(location != null ? location : "N/A");
		}
		
		
		
		public void LoadDashboard() {
			
			int totalJobsCreatedByEmployee = JobService.getInstance().getTotalJobsCreatedByEmployee(employeeId);
			int totalJobsApproved = JobService.getInstance().getTotalJobsApprovedByEmployee(employeeId);
			int totalJobsPending = JobService.getInstance().getTotalJobsPendingByEmployee(employeeId);
			int totalJobsOpen = JobService.getInstance().getTotalJobsOpenByEmployee(employeeId);
			int totalJobsClosed = JobService.getInstance().getTotalJobsClosedEmployee(employeeId);
			
			// Update the labels with the fetched data
			 totalJobtext.setText(String.valueOf(totalJobsCreatedByEmployee));
			 totalApprovedJob.setText(String.valueOf(totalJobsApproved));
			 TotalJobPending.setText(String.valueOf(totalJobsPending));
			 totalJobOpenText.setText(String.valueOf(totalJobsOpen));
			 TotalJobClosed.setText(String.valueOf(totalJobsClosed));
			
			
			
		}
	
		

		
}
