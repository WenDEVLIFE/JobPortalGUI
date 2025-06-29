package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import database.AlertService;
import database.ApplicationService;
import database.JobService;
import database.ProfileService;
import database.UpdatePasswordDialog;
import functions.AddSkillDialog;
import functions.UpdateProfileDialog;
import functions.ViewJobDialog;
import functions.ViewResumeDialog;
import model.AlertModel;
import model.ApplicationModel;
import model.JobModel;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JobSeekerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchJobField;
	private JTable jobTable;
	DefaultTableModel tableModel;
	List<JobModel> jobList = new ArrayList<>();
	DefaultTableModel savedTableModel;
	List<JobModel> savedJobList = new ArrayList<>();
	DefaultTableModel alertTableModel;
	List<AlertModel> alertList = new ArrayList<>();
	DefaultTableModel myApplicationTableModel;
	List<ApplicationModel> myApplicationList = new ArrayList<>();
	private JTextField searchSavedJobField;
	private JTable saveJobTable;
	private JTextField textField;
	private JTable myApplicationTable;
	private JTable alertTable;
	private JLabel FullnameText;
	private JLabel LocationText;
	private JLabel ContactInfoText;
	private JLabel ApplicationText;
	private JLabel PendingApplication;
	private JLabel saveJobText;
	private JLabel approvedText;
	private int userId, seekerId;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
					JobSeekerUI frame = new JobSeekerUI();
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
	public JobSeekerUI() {
		setTitle("Job Portal System Job Seeker Portal");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1138, 537);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Home", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblWelcomeBack_1 = new JLabel("Welcome Back , User");
		lblWelcomeBack_1.setForeground(Color.WHITE);
		lblWelcomeBack_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1.setBounds(10, 11, 462, 38);
		panel_1.add(lblWelcomeBack_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 128, 255));
		panel_3.setBounds(29, 79, 331, 172);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomeBack_1_1 = new JLabel("Total Application");
		lblWelcomeBack_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1.setBounds(46, 39, 275, 38);
		panel_3.add(lblWelcomeBack_1_1);
		
		ApplicationText = new JLabel("0");
		ApplicationText.setForeground(Color.WHITE);
		ApplicationText.setFont(new Font("Verdana", Font.BOLD, 20));
		ApplicationText.setBounds(139, 89, 130, 38);
		panel_3.add(ApplicationText);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(255, 128, 255));
		panel_3_1.setBounds(401, 79, 331, 172);
		panel_1.add(panel_3_1);
		
		JLabel lblWelcomeBack_1_1_2 = new JLabel("Pending Application");
		lblWelcomeBack_1_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_2.setBounds(46, 39, 275, 38);
		panel_3_1.add(lblWelcomeBack_1_1_2);
		
		PendingApplication = new JLabel("0");
		PendingApplication.setForeground(Color.WHITE);
		PendingApplication.setFont(new Font("Verdana", Font.BOLD, 20));
		PendingApplication.setBounds(133, 88, 130, 38);
		panel_3_1.add(PendingApplication);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBackground(new Color(255, 128, 255));
		panel_3_1_1.setBounds(771, 79, 331, 172);
		panel_1.add(panel_3_1_1);
		
		JLabel lblWelcomeBack_1_1_2_1 = new JLabel("Saved Jobs");
		lblWelcomeBack_1_1_2_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_2_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_2_1.setBounds(99, 40, 140, 38);
		panel_3_1_1.add(lblWelcomeBack_1_1_2_1);
		
		saveJobText = new JLabel("0");
		saveJobText.setForeground(Color.WHITE);
		saveJobText.setFont(new Font("Verdana", Font.BOLD, 20));
		saveJobText.setBounds(159, 89, 130, 38);
		panel_3_1_1.add(saveJobText);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(new Color(255, 128, 255));
		panel_3_2.setBounds(401, 291, 331, 172);
		panel_1.add(panel_3_2);
		
		JLabel lblWelcomeBack_1_1_3 = new JLabel("Approved Application");
		lblWelcomeBack_1_1_3.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3.setBounds(46, 39, 275, 38);
		panel_3_2.add(lblWelcomeBack_1_1_3);
		
		approvedText = new JLabel("0");
		approvedText.setForeground(Color.WHITE);
		approvedText.setFont(new Font("Verdana", Font.BOLD, 20));
		approvedText.setBounds(139, 89, 130, 38);
		panel_3_2.add(approvedText);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Find a job", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblWelcomeBack_1_2 = new JLabel("Find a job");
		lblWelcomeBack_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_2.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2.setBounds(10, 25, 172, 38);
		panel.add(lblWelcomeBack_1_2);
		
		searchJobField = new JTextField();
		searchJobField.setBounds(192, 28, 863, 38);
		panel.add(searchJobField);
		searchJobField.setColumns(10);
		
		
		jobTable = new JTable();
		jobTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		jobTable.setBounds(39, 74, 1046, 360);
		panel.add(jobTable);
		
		JButton btnViewJob = new JButton("View Job");
		btnViewJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jobTable.getSelectedRow();
				if (selectedRow == -1) {
					
					JOptionPane.showMessageDialog(JobSeekerUI.this, "Please select a job to view.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JobModel jobModelInstance = jobList.get(selectedRow);
				if (jobModelInstance == null) {
					 JOptionPane.showMessageDialog(JobSeekerUI.this, "Selected job is not available.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				   ViewJobDialog dialog = new ViewJobDialog(JobSeekerUI.this, jobModelInstance, seekerId, userId);
			        dialog.setVisible(true);
			        if (dialog.isSaved()) {
			            JOptionPane.showMessageDialog(JobSeekerUI.this, "Job saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			            LoadDashboard();
			            LoadSavedJobData(); // Refresh the saved job data
			        }
			}
		});
		btnViewJob.setForeground(Color.WHITE);
		btnViewJob.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewJob.setBackground(new Color(195, 143, 255));
		btnViewJob.setBounds(375, 445, 337, 53);
		panel.add(btnViewJob);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Saved Job", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblWelcomeBack_1_2_1 = new JLabel("Saved Jobs");
		lblWelcomeBack_1_2_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2_1.setBounds(10, 11, 189, 38);
		panel_4.add(lblWelcomeBack_1_2_1);
		
		searchSavedJobField = new JTextField();
		searchSavedJobField.setColumns(10);
		searchSavedJobField.setBounds(206, 11, 863, 38);
		panel_4.add(searchSavedJobField);
		
		saveJobTable = new JTable();
		saveJobTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		saveJobTable.setBounds(39, 60, 1046, 360);
		panel_4.add(saveJobTable);
		
		JButton btnViewJob_1 = new JButton("View Job");
		btnViewJob_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = saveJobTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(JobSeekerUI.this, "Please select a saved job to view.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JobModel jobModelInstance = savedJobList.get(selectedRow);
				if (jobModelInstance == null) {
					JOptionPane.showMessageDialog(JobSeekerUI.this, "Selected job is not available.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				ViewJobDialog dialog = new ViewJobDialog(JobSeekerUI.this, jobModelInstance, seekerId, userId);
				dialog.setVisible(true);
				if (dialog.isSaved()) {
					JOptionPane.showMessageDialog(JobSeekerUI.this, "Job saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
					LoadSavedJobData();
					 LoadDashboard();
				}
			}
		});
		btnViewJob_1.setForeground(Color.WHITE);
		btnViewJob_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewJob_1.setBackground(new Color(195, 143, 255));
		btnViewJob_1.setBounds(130, 431, 337, 53);
		panel_4.add(btnViewJob_1);
		
		JButton btnViewJob_1_1 = new JButton("Delete");
		btnViewJob_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = saveJobTable.getSelectedRow();
				
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(JobSeekerUI.this, "Please select a saved job to delete.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				JobModel jobModelInstance = savedJobList.get(selectedRow);
				if (jobModelInstance == null) {
					JOptionPane.showMessageDialog(JobSeekerUI.this, "Selected job is not available.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int confirmation = JOptionPane.showConfirmDialog(JobSeekerUI.this, "Are you sure you want to delete this saved job?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
				if (confirmation == JOptionPane.YES_OPTION) {
					JobService.getInstance().deleteSavedJob(jobModelInstance.getJobId(), userId);
					JOptionPane.showMessageDialog(JobSeekerUI.this, "Saved job deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
					LoadSavedJobData(); // Refresh the saved job data
					 LoadDashboard();
				}
			}
		});
		btnViewJob_1_1.setForeground(Color.WHITE);
		btnViewJob_1_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewJob_1_1.setBackground(new Color(195, 143, 255));
		btnViewJob_1_1.setBounds(628, 431, 337, 53);
		panel_4.add(btnViewJob_1_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("My Application", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblWelcomeBack_1_2_1_1 = new JLabel("My Application");
		lblWelcomeBack_1_2_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2_1_1.setBounds(10, 25, 250, 38);
		panel_2.add(lblWelcomeBack_1_2_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(260, 25, 863, 38);
		panel_2.add(textField);
		
		myApplicationTable = new JTable();
		myApplicationTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		myApplicationTable.setBounds(53, 74, 1046, 360);
		panel_2.add(myApplicationTable);
		
		JButton btnViewJob_1_1_1 = new JButton("Cancel Application");
		btnViewJob_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = myApplicationTable.getSelectedRow();
				
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(JobSeekerUI.this, "Please select an application to cancel.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				ApplicationModel applicationModelInstance = myApplicationList.get(selectedRow);
				if (applicationModelInstance == null) {
					JOptionPane.showMessageDialog(JobSeekerUI.this, "Selected application is not available.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int confirmation = JOptionPane.showConfirmDialog(JobSeekerUI.this, "Are you sure you want to cancel this application?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);
				if (confirmation == JOptionPane.YES_OPTION) {
					ApplicationService.getInstance().cancelApplication(applicationModelInstance.getApplicationId());
					JOptionPane.showMessageDialog(JobSeekerUI.this, "Application cancelled successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
					LoadMyApplicationData(); // Refresh the application data
					 LoadDashboard();
				}
			}
		});
		btnViewJob_1_1_1.setForeground(Color.WHITE);
		btnViewJob_1_1_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewJob_1_1_1.setBackground(new Color(195, 143, 255));
		btnViewJob_1_1_1.setBounds(401, 445, 337, 53);
		panel_2.add(btnViewJob_1_1_1);
		
		JPanel panel_1_1 = new JPanel();
		tabbedPane.addTab("Alert", null, panel_1_1, null);
		panel_1_1.setLayout(null);
		
		JLabel lblWelcomeBack_1_2_1_1_1 = new JLabel("Alerts");
		lblWelcomeBack_1_2_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2_1_1_1.setBounds(10, 11, 250, 38);
		panel_1_1.add(lblWelcomeBack_1_2_1_1_1);
		
		alertTable = new JTable();
		alertTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		alertTable.setBounds(20, 60, 1103, 422);
		panel_1_1.add(alertTable);
		
		JPanel panel_1_1_1 = new JPanel();
		tabbedPane.addTab("My Profile", null, panel_1_1_1, null);
		panel_1_1_1.setLayout(null);
		
		JLabel lblWelcomeBack_1_2_1_1_2 = new JLabel("My Profile");
		lblWelcomeBack_1_2_1_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2_1_1_2.setBounds(25, 21, 250, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1 = new JLabel("Full Name:");
		lblWelcomeBack_1_2_1_1_2_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1.setBounds(25, 114, 179, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1);
		
		// This will update the profile details
		JButton btnUpdateProfileDetails = new JButton("Update Profile Details");
		btnUpdateProfileDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateProfileDialog dialog = new UpdateProfileDialog(JobSeekerUI.this, userId);
				dialog.setVisible(true);
				 if (dialog.isSucceeded()) {
					JOptionPane.showMessageDialog(JobSeekerUI.this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
					LoadProfile();
				}
			}
		});
		btnUpdateProfileDetails.setForeground(Color.WHITE);
		btnUpdateProfileDetails.setFont(new Font("Verdana", Font.BOLD, 11));
		btnUpdateProfileDetails.setBackground(new Color(195, 143, 255));
		btnUpdateProfileDetails.setBounds(774, 113, 276, 46);
		panel_1_1_1.add(btnUpdateProfileDetails);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1_1 = new JLabel("Contact Info");
		lblWelcomeBack_1_2_1_1_2_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1_1.setBounds(25, 227, 467, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1_1);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1_1_1 = new JLabel("Location:");
		lblWelcomeBack_1_2_1_1_2_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1_1_1.setBounds(25, 344, 122, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1_1_1);
		
	    LocationText = new JLabel("TestAddress City");
		LocationText.setForeground(Color.WHITE);
		LocationText.setFont(new Font("Verdana", Font.BOLD, 20));
		LocationText.setBounds(25, 393, 450, 38);
		panel_1_1_1.add(LocationText);
		
		ContactInfoText = new JLabel("09912455343");
		ContactInfoText.setForeground(Color.WHITE);
		ContactInfoText.setFont(new Font("Verdana", Font.BOLD, 20));
		ContactInfoText.setBounds(25, 276, 450, 38);
		panel_1_1_1.add(ContactInfoText);
		
		FullnameText = new JLabel("John Doe");
		FullnameText.setForeground(Color.WHITE);
		FullnameText.setFont(new Font("Verdana", Font.BOLD, 20));
		FullnameText.setBounds(25, 164, 450, 38);
		panel_1_1_1.add(FullnameText);
		
		JButton btnViewMyResume = new JButton("View My Resume");
		btnViewMyResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewResumeDialog dialog = new ViewResumeDialog(JobSeekerUI.this, seekerId, "Manage Resumes", true);
				dialog.setVisible(true);
			}
		});
		btnViewMyResume.setForeground(Color.WHITE);
		btnViewMyResume.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewMyResume.setBackground(new Color(195, 143, 255));
		btnViewMyResume.setBounds(774, 192, 276, 46);
		panel_1_1_1.add(btnViewMyResume);
		
		JButton btnViewMySkills = new JButton("View My Skills");
		btnViewMySkills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSkillDialog skillDialog = new AddSkillDialog(JobSeekerUI.this, seekerId, "Add Skills", true);
				skillDialog.setVisible(true);
			}
		});
		btnViewMySkills.setForeground(Color.WHITE);
		btnViewMySkills.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewMySkills.setBackground(new Color(195, 143, 255));
		btnViewMySkills.setBounds(774, 266, 276, 46);
		panel_1_1_1.add(btnViewMySkills);
		
		JButton btnUpdateMyPassword = new JButton("Update My Password");
		btnUpdateMyPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 UpdatePasswordDialog dialog = new UpdatePasswordDialog(JobSeekerUI.this, userId);
			        dialog.setVisible(true);
			        if (dialog.isSucceeded()) {
			            JOptionPane.showMessageDialog(JobSeekerUI.this, "Password updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			        }
			        else {
			            JOptionPane.showMessageDialog(JobSeekerUI.this, "Password update failed", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			}
		});
		btnUpdateMyPassword.setForeground(Color.WHITE);
		btnUpdateMyPassword.setFont(new Font("Verdana", Font.BOLD, 11));
		btnUpdateMyPassword.setBackground(new Color(195, 143, 255));
		btnUpdateMyPassword.setBounds(774, 336, 276, 46);
		panel_1_1_1.add(btnUpdateMyPassword);
		
		JPanel panel_1_1_2 = new JPanel();
		tabbedPane.addTab("Logout", null, panel_1_1_2, null);
		panel_1_1_2.setLayout(null);
		
		JLabel lblWelcomeBack = new JLabel("Are you sure you want to logout?");
		lblWelcomeBack.setBounds(301, 36, 633, 38);
		lblWelcomeBack.setForeground(Color.WHITE);
		lblWelcomeBack.setFont(new Font("Verdana", Font.BOLD, 30));
		panel_1_1_2.add(lblWelcomeBack);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose(); // Close the current window
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(195, 143, 255));
		btnNewButton.setBounds(438, 197, 301, 53);
		panel_1_1_2.add(btnNewButton);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				JOptionPane.showMessageDialog(null, "Logout cancelled.", "Info", JOptionPane.INFORMATION_MESSAGE);
				   tabbedPane.setSelectedIndex(0); // Switch to the Home tab
			}
		});
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNo.setBackground(new Color(195, 143, 255));
		btnNo.setBounds(438, 301, 301, 53);
		panel_1_1_2.add(btnNo);
		
		String [] columnNames = {"Job ID", "Job Title", "Company Name", "Posted Date", "Status", "Expiration Date"};
		String [] alertColumnNames = {"Alert ID", "Description", "Timestamp",};
		String [] savedColumnNames = {"Job ID", "Job Title", "Company Name", "Posted Date", "Status", "Expiration Date"};
		String [] myApplicationColumnNames = {"Application ID", "Job Title", "Company Name", "Application Date", "Status"};
		tableModel = new DefaultTableModel(columnNames, 0);
		savedTableModel = new DefaultTableModel(columnNames, 0);
		alertTableModel = new DefaultTableModel(alertColumnNames, 0);
		jobTable.setModel(tableModel);
		saveJobTable.setModel(savedTableModel);
		alertTable.setModel(alertTableModel);
		myApplicationTableModel = new DefaultTableModel(myApplicationColumnNames, 0);
		myApplicationTable.setModel(myApplicationTableModel);
		
		
		LoadJobData();
		LoadSavedJobData();
		LoadMyApplicationData();
		
		// This is for the search functionality
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
		jobTable.setRowSorter(sorter);

		searchJobField.getDocument().addDocumentListener(new DocumentListener() {
		    public void insertUpdate(DocumentEvent e) { filter(); }
		    public void removeUpdate(DocumentEvent e) { filter(); }
		    public void changedUpdate(DocumentEvent e) { filter(); }
		    private void filter() {
		        String text = searchJobField.getText();
		        if (text.trim().length() == 0) {
		        	LoadJobData(); // Reload all data if search field is empty
		        	JOptionPane.showMessageDialog(null, "No jobs found.", "Info", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		        }
		    }
		});
		
		TableRowSorter<DefaultTableModel> savedSorter = new TableRowSorter<>(savedTableModel);
		saveJobTable.setRowSorter(savedSorter);
		searchSavedJobField.getDocument().addDocumentListener(new DocumentListener() {
		    public void insertUpdate(DocumentEvent e) { filterSaved(); }
		    public void removeUpdate(DocumentEvent e) { filterSaved(); }
		    public void changedUpdate(DocumentEvent e) { filterSaved(); }
		    private void filterSaved() {
		        String text = searchSavedJobField.getText();
		        if (text.trim().length() == 0) {
		        	LoadSavedJobData(); // Reload all data if search field is empty
		        	JOptionPane.showMessageDialog(null, "No saved jobs found.", "Info", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            savedSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		        }
		    }
		});
		
		
		LoadAlertData();
	 

		Timer notificationTimer = new Timer(5000, e -> {
		    AlertService.getInstance().notifyUserIfNeeded(userId);
		});
		notificationTimer.start();
	}
	
	// This will load the job
	void LoadJobData() {
		jobList.clear();
		
		tableModel.setRowCount(0); // Clear existing rows in the table model
	
	 	jobList = JobService.getInstance().getAllJobs();	 
		
		for (JobModel job : jobList) {
  			Object[] rowData = {
				job.getJobId(),
				job.getJobTitle(),
				job.getCompanyName(),
				job.getPostedDate(),
				job.getStatus(),
				job.getExpirationDate()
			};
			tableModel.addRow(rowData);
		}
	}
	
	// This will load the saved job
	public void LoadSavedJobData() {
		savedJobList.clear();
		
		savedTableModel.setRowCount(0); // Clear existing rows in the table model
		
	  savedJobList = JobService.getInstance().getSavedJobs(userId);
		
		for (JobModel job : savedJobList) {
			Object[] rowData = {
				job.getJobId(),
				job.getJobTitle(),
				job.getCompanyName(),
				job.getPostedDate(),
				job.getStatus(),
				job.getExpirationDate()
			};
			savedTableModel.addRow(rowData);
		}
	}
	
	public void LoadAlertData() {
		alertList.clear();
		
		alertTableModel.setRowCount(0); // Clear existing rows in the table model
		
		alertList = AlertService.getInstance().getAlertsByUserId(seekerId);
		for (AlertModel alert : alertList) {
			Object[] rowData = {
				alert.getAlertId(),
				alert.getDescription(),
				alert.getTimestamp()
			};
			alertTableModel.addRow(rowData);
		}
	}
	
	
	public void LoadMyApplicationData() {
		myApplicationList.clear();
		
		myApplicationTableModel.setRowCount(0); // Clear existing rows in the table model
		
		String convertedSeekerId = String.valueOf(seekerId);
		myApplicationList = ApplicationService.getInstance().getApplicationsByJobId(convertedSeekerId);
		
		for (ApplicationModel application : myApplicationList) {
			Object[] rowData = {
				application.getApplicationId(),
				application.getJobTitle(),
				application.getCompanyName(),
				application.getAppliedAt(),
				application.getStatus()
			};
			myApplicationTableModel.addRow(rowData);
		}
	}
	
	public void LoadProfile() {
		
		String fullname = ProfileService.getInstance().getFullName(userId);
		String location = ProfileService.getInstance().getLocation(userId);
		String contactInfo = ProfileService.getInstance().getContactInfo(userId);
		
		FullnameText.setText(fullname != null ? fullname : "N/A");
		LocationText.setText(location != null ? location : "N/A");
		ContactInfoText.setText(contactInfo != null ? contactInfo : "N/A");
		this.seekerId = ProfileService.getInstance().getSeekerId(String.valueOf(userId));
		
		System.out.println("Profile loaded for user ID: " + userId);
		 System.out.println("Full Name: " + FullnameText.getText());
		 System.out.println("Location: " + LocationText.getText());
		 System.out.println("Contact Info: " + ContactInfoText.getText());
		  System.out.println("Seeker ID: " + seekerId);
	}
	
	
	public void setData(int userId) {
		this.userId = userId;
		System.out.println("User ID set to: " + userId);
	}
	
	public void LoadDashboard() {
		
		int totalApplications = ApplicationService.getInstance().getTotalApplicationsByUserId(userId);
		int pendingApplications = ApplicationService.getInstance().getPendingApplicationsByUserId(userId);
		int approvedApplications = ApplicationService.getInstance().getApprovedApplicationsByUserId(userId);
		int savedJobs = JobService.getInstance().getSavedJobsCount(userId);
		ApplicationText.setText(String.valueOf(totalApplications));
		PendingApplication.setText(String.valueOf(pendingApplications));
		approvedText.setText(String.valueOf(approvedApplications));
		saveJobText.setText(String.valueOf(savedJobs));
		
	}
}
