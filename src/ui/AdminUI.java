package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import database.AuditLogService;
import database.JobService;
import database.RegistrationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import functions.AddUserDialog;
import functions.EditUserDialog;
import model.AuditModel;
import model.JobModel;
import model.UserModel;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class AdminUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable userTable;
	private JTextField searchUserField;
	private JTable PendingJobTable;
	private JTextField searchPendingJob;
	private JTable ApprovedTable;
	private JTextField searchApproveJob;
	private JTable auditTable;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private int adminID;
	
	DefaultTableModel userTableModel, auditTableModel, pendingJobTableModel, approvedJobTableModel;
	List<UserModel> userList = new ArrayList<>();
	List<AuditModel> auditList = new ArrayList<>();
	private List<JobModel> pendingJobList = new ArrayList<>();
	private List<JobModel> approvedJobList = new ArrayList<>();
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
					AdminUI frame = new AdminUI();
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
	public AdminUI() {
		setTitle("Job Portal System Admin Portal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1114, 537);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Home", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(255, 128, 255));
		panel_3_1.setBounds(213, 290, 331, 172);
		panel.add(panel_3_1);
		
		JLabel lblWelcomeBack_1_1 = new JLabel("Peding Job Posting");
		lblWelcomeBack_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1.setBounds(54, 38, 215, 38);
		panel_3_1.add(lblWelcomeBack_1_1);
		
		JLabel lblWelcomeBack_1_1_1 = new JLabel("0");
		lblWelcomeBack_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1.setBounds(139, 89, 130, 38);
		panel_3_1.add(lblWelcomeBack_1_1_1);
		
		JLabel lblWelcomeBack_1 = new JLabel("Welcome Back , User");
		lblWelcomeBack_1.setForeground(Color.WHITE);
		lblWelcomeBack_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1.setBounds(10, 11, 462, 38);
		panel.add(lblWelcomeBack_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBackground(new Color(255, 128, 255));
		panel_3_1_1.setBounds(30, 74, 331, 172);
		panel.add(panel_3_1_1);
		
		JLabel lblWelcomeBack_1_1_2 = new JLabel("Administrator");
		lblWelcomeBack_1_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_2.setBounds(94, 40, 215, 38);
		panel_3_1_1.add(lblWelcomeBack_1_1_2);
		
		JLabel lblWelcomeBack_1_1_1_1 = new JLabel("0");
		lblWelcomeBack_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_1.setBounds(139, 89, 130, 38);
		panel_3_1_1.add(lblWelcomeBack_1_1_1_1);
		
		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.setLayout(null);
		panel_3_1_1_1.setBackground(new Color(255, 128, 255));
		panel_3_1_1_1.setBounds(394, 74, 331, 172);
		panel.add(panel_3_1_1_1);
		
		JLabel lblWelcomeBack_1_1_2_1 = new JLabel("Job Seeker");
		lblWelcomeBack_1_1_2_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_2_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_2_1.setBounds(72, 40, 215, 38);
		panel_3_1_1_1.add(lblWelcomeBack_1_1_2_1);
		
		JLabel lblWelcomeBack_1_1_1_1_1 = new JLabel("0");
		lblWelcomeBack_1_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_1_1.setBounds(139, 89, 130, 38);
		panel_3_1_1_1.add(lblWelcomeBack_1_1_1_1_1);
		
		JPanel panel_3_1_1_1_1 = new JPanel();
		panel_3_1_1_1_1.setLayout(null);
		panel_3_1_1_1_1.setBackground(new Color(255, 128, 255));
		panel_3_1_1_1_1.setBounds(751, 74, 331, 172);
		panel.add(panel_3_1_1_1_1);
		
		JLabel lblWelcomeBack_1_1_2_1_1 = new JLabel("Employee/ Recruiter");
		lblWelcomeBack_1_1_2_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_2_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_2_1_1.setBounds(38, 40, 311, 38);
		panel_3_1_1_1_1.add(lblWelcomeBack_1_1_2_1_1);
		
		JLabel lblWelcomeBack_1_1_1_1_1_1 = new JLabel("0");
		lblWelcomeBack_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_1_1_1.setBounds(139, 89, 130, 38);
		panel_3_1_1_1_1.add(lblWelcomeBack_1_1_1_1_1_1);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setLayout(null);
		panel_3_1_2.setBackground(new Color(255, 128, 255));
		panel_3_1_2.setBounds(581, 290, 331, 172);
		panel.add(panel_3_1_2);
		
		JLabel lblWelcomeBack_1_1_3 = new JLabel("Approved Job Listing");
		lblWelcomeBack_1_1_3.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3.setBounds(41, 38, 267, 38);
		panel_3_1_2.add(lblWelcomeBack_1_1_3);
		
		JLabel lblWelcomeBack_1_1_1_2 = new JLabel("0");
		lblWelcomeBack_1_1_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_2.setBounds(139, 89, 130, 38);
		panel_3_1_2.add(lblWelcomeBack_1_1_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		tabbedPane.addTab("Users", null, panel_1, null);
		
		JLabel lblWelcomeBack_1_2_3 = new JLabel("Users");
		lblWelcomeBack_1_2_3.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_3.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2_3.setBounds(74, 11, 104, 38);
		panel_1.add(lblWelcomeBack_1_2_3);
		
		userTable = new JTable();
		userTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		userTable.setBounds(25, 60, 1046, 360);
		panel_1.add(userTable);
		
		searchUserField = new JTextField();
		searchUserField.setColumns(10);
		searchUserField.setBounds(208, 11, 863, 38);
		panel_1.add(searchUserField);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				   AddUserDialog dialog = new AddUserDialog(AdminUI.this);
			        dialog.setVisible(true);
			        if (dialog.isSucceeded()) {
			          
			        }
			}
		});
		btnAddUser.setForeground(Color.WHITE);
		btnAddUser.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAddUser.setBackground(new Color(195, 143, 255));
		btnAddUser.setBounds(66, 445, 301, 53);
		panel_1.add(btnAddUser);
		
		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int selectedRow = userTable.getSelectedRow();
			        if (selectedRow == -1) {
			            JOptionPane.showMessageDialog(AdminUI.this, "Please select a user to edit.", "Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
			        UserModel selectedUser = userList.get(selectedRow);
			        String userId = selectedUser.getId();
			        String username = selectedUser.getUsername();
			        String password = selectedUser.getPassword(); // Get password here
			        String role = selectedUser.getRole();
			        String status = selectedUser.getStatus();
			        
			        Map<String, String> userDetails = new HashMap<>();
			        userDetails.put("id", userId);
			        userDetails.put("username", username);
			        userDetails.put("password", password); // Include password in the details
			        userDetails.put("role", role);
			        userDetails.put("status", status);
			        

			        EditUserDialog dialog = new EditUserDialog(AdminUI.this, userDetails);
			        dialog.setVisible(true);
			        if (dialog.isSucceeded()) {
			            loadUserData();
			        }
				
			}
		});
		btnEditUser.setForeground(Color.WHITE);
		btnEditUser.setFont(new Font("Verdana", Font.BOLD, 11));
		btnEditUser.setBackground(new Color(195, 143, 255));
		btnEditUser.setBounds(405, 445, 301, 53);
		panel_1.add(btnEditUser);
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = userTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(AdminUI.this, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int confirm = JOptionPane.showConfirmDialog(AdminUI.this, "Are you sure you want to delete this user?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					UserModel selectedUser = userList.get(selectedRow);
					String userIds = selectedUser.getId();
					String adminIDs = String.valueOf(AdminUI.this.adminID); // Get the admin ID from the AdminUI instance
					
					
                      if (adminIDs.equals(userIds)) {
						  JOptionPane.showMessageDialog(AdminUI.this, "You cannot delete your own account.", "Error", JOptionPane.ERROR_MESSAGE);
						  return;
					  }
                      

                  	
  					boolean success = RegistrationService.getInstance().deleteUser(userIds, adminID);	
  					
  					if (success) {
  						JOptionPane.showMessageDialog(AdminUI.this, "User deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
  						loadUserData(); // Refresh the user table
  					} else {
  						JOptionPane.showMessageDialog(AdminUI.this, "Failed to delete user.", "Error", JOptionPane.ERROR_MESSAGE);
  					}
				}
			}
		});
		btnDeleteUser.setForeground(Color.WHITE);
		btnDeleteUser.setFont(new Font("Verdana", Font.BOLD, 11));
		btnDeleteUser.setBackground(new Color(195, 143, 255));
		btnDeleteUser.setBounds(733, 445, 301, 53);
		panel_1.add(btnDeleteUser);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		tabbedPane.addTab("Job Posting Pending", null, panel_3, null);
		
		PendingJobTable = new JTable();
		PendingJobTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		PendingJobTable.setBounds(41, 61, 1046, 360);
		panel_3.add(PendingJobTable);
		
		searchPendingJob = new JTextField();
		searchPendingJob.setColumns(10);
		searchPendingJob.setBounds(434, 11, 648, 38);
		panel_3.add(searchPendingJob);
		
		JButton btnApproved = new JButton("Approved");
		btnApproved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = PendingJobTable.getSelectedRow();
				
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(AdminUI.this, "Please select a job posting to approve.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JobModel selectedJob = pendingJobList.get(selectedRow);
				
				String jobId = selectedJob.getJobId();
				
		        int confirm = JOptionPane.showConfirmDialog(AdminUI.this, "Are you sure you want to approve this job posting?", "Confirm Approval", JOptionPane.YES_NO_OPTION);
		        if (confirm == JOptionPane.YES_OPTION) {
		        					
		         boolean success = JobService.getInstance().approveJobPosting(jobId, adminID);
		         
		         if (success) {
		        	 JOptionPane.showMessageDialog(AdminUI.this, "Job posting approved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		        		LoadJobDataPending();
		        		LoadJobDataApproved();
		        		
		         } else {
		        	 JOptionPane.showMessageDialog(AdminUI.this, "Failed to approve job posting.", "Error", JOptionPane.ERROR_MESSAGE);
		         }
		        					
		        }
			}
		});
		btnApproved.setForeground(Color.WHITE);
		btnApproved.setFont(new Font("Verdana", Font.BOLD, 11));
		btnApproved.setBackground(new Color(195, 143, 255));
		btnApproved.setBounds(194, 445, 301, 53);
		panel_3.add(btnApproved);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = PendingJobTable.getSelectedRow();
				
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(AdminUI.this, "Please select a job posting to delete.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int confirm = JOptionPane.showConfirmDialog(AdminUI.this, "Are you sure you want to delete this job posting?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					JobModel selectedJob = pendingJobList.get(selectedRow);
					String jobId = selectedJob.getJobId();
					
					boolean success = JobService.getInstance().deleteJobPosting(jobId, adminID);
					
					if (success) {
						JOptionPane.showMessageDialog(AdminUI.this, "Job posting deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
						LoadJobDataPending(); // Refresh the pending job table
					} else {
						JOptionPane.showMessageDialog(AdminUI.this, "Failed to delete job posting.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Verdana", Font.BOLD, 11));
		btnDelete.setBackground(new Color(195, 143, 255));
		btnDelete.setBounds(589, 445, 301, 53);
		panel_3.add(btnDelete);
		
		JLabel lblWelcomeBack_1_2_3_1_1_1 = new JLabel("Search Title, Company & etc");
		lblWelcomeBack_1_2_3_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_3_1_1_1.setFont(new Font("Verdana", Font.BOLD, 24));
		lblWelcomeBack_1_2_3_1_1_1.setBounds(41, 11, 402, 38);
		panel_3.add(lblWelcomeBack_1_2_3_1_1_1);
		
		JPanel ApprovePane = new JPanel();
		ApprovePane.setLayout(null);
		tabbedPane.addTab("Job Posting Approved", null, ApprovePane, null);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = ApprovedTable.getSelectedRow();
				
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(AdminUI.this, "Please select a job posting to delete.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int confirm = JOptionPane.showConfirmDialog(AdminUI.this, "Are you sure you want to delete this job posting?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					JobModel selectedJob = approvedJobList.get(selectedRow);
					String jobId = selectedJob.getJobId();
					
					boolean success = JobService.getInstance().deleteJobPosting(jobId, adminID);
					
					if (success) {
						JOptionPane.showMessageDialog(AdminUI.this, "Job posting deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
						LoadJobDataApproved(); // Refresh the approved job table
					} else {
						JOptionPane.showMessageDialog(AdminUI.this, "Failed to delete job posting.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnDelete_1.setForeground(Color.WHITE);
		btnDelete_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnDelete_1.setBackground(new Color(195, 143, 255));
		btnDelete_1.setBounds(376, 445, 301, 53);
		ApprovePane.add(btnDelete_1);
		
		ApprovedTable = new JTable();
		ApprovedTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		ApprovedTable.setBounds(41, 61, 1046, 360);
		ApprovePane.add(ApprovedTable);
		
		JLabel lblWelcomeBack_1_2_3_1_1 = new JLabel("Search Title, Company & etc");
		lblWelcomeBack_1_2_3_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_3_1_1.setFont(new Font("Verdana", Font.BOLD, 24));
		lblWelcomeBack_1_2_3_1_1.setBounds(33, 12, 402, 38);
		ApprovePane.add(lblWelcomeBack_1_2_3_1_1);
		
		searchApproveJob = new JTextField();
		searchApproveJob.setColumns(10);
		searchApproveJob.setBounds(445, 12, 642, 38);
		ApprovePane.add(searchApproveJob);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		tabbedPane.addTab("Audit Logs", null, panel_2, null);
		
		auditTable = new JTable();
		auditTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		auditTable.setBounds(34, 61, 1046, 360);
		panel_2.add(auditTable);
		
		JLabel lblWelcomeBack_1_2_3_1_1_1_1 = new JLabel("Audit Logs");
		lblWelcomeBack_1_2_3_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_3_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 24));
		lblWelcomeBack_1_2_3_1_1_1_1.setBounds(34, 11, 402, 38);
		panel_2.add(lblWelcomeBack_1_2_3_1_1_1_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		tabbedPane.addTab("Change Password", null, panel_5, null);
		
		JButton btnUpdatePassword = new JButton("Update Password");
		btnUpdatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String oldPassword = new String(passwordField.getPassword());
				String newPassword = new String(passwordField_1.getPassword());
				
				if (oldPassword.isEmpty() || newPassword.isEmpty()) {
					JOptionPane.showMessageDialog(AdminUI.this, "Please fill in both fields.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (oldPassword.equals(newPassword)) {
					JOptionPane.showMessageDialog(AdminUI.this, "New password cannot be the same as old password.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// Call the service to update the password
				String employeeIdStr = String.valueOf(adminID);
				boolean success = RegistrationService.getInstance().updatePassword(employeeIdStr, oldPassword, newPassword);
				
				if (success) {
					JOptionPane.showMessageDialog(AdminUI.this, "Password updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
					passwordField.setText("");
					passwordField_1.setText("");
					tabbedPane.setSelectedIndex(0); // Switch back to the Home tab
				} else {
					JOptionPane.showMessageDialog(AdminUI.this, "Failed to update password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnUpdatePassword.setForeground(Color.WHITE);
		btnUpdatePassword.setFont(new Font("Verdana", Font.BOLD, 11));
		btnUpdatePassword.setBackground(new Color(195, 143, 255));
		btnUpdatePassword.setBounds(251, 413, 301, 53);
		panel_5.add(btnUpdatePassword);
		
		JLabel lblWelcomeBack_1_2_3_1_1_1_2 = new JLabel("Change Password");
		lblWelcomeBack_1_2_3_1_1_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_3_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 24));
		lblWelcomeBack_1_2_3_1_1_1_2.setBounds(53, 22, 402, 38);
		panel_5.add(lblWelcomeBack_1_2_3_1_1_1_2);
		
		JLabel lblWelcomeBack_1_2_3_1_1_1_2_1 = new JLabel("Enter Your Old Password");
		lblWelcomeBack_1_2_3_1_1_1_2_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_3_1_1_1_2_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_3_1_1_1_2_1.setBounds(132, 117, 402, 38);
		panel_5.add(lblWelcomeBack_1_2_3_1_1_1_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(134, 176, 617, 53);
		panel_5.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(134, 303, 617, 53);
		panel_5.add(passwordField_1);
		
		JLabel lblWelcomeBack_1_2_3_1_1_1_2_1_1 = new JLabel("Enter Your New Password");
		lblWelcomeBack_1_2_3_1_1_1_2_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_3_1_1_1_2_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_3_1_1_1_2_1_1.setBounds(132, 254, 402, 38);
		panel_5.add(lblWelcomeBack_1_2_3_1_1_1_2_1_1);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		tabbedPane.addTab("Logout", null, panel_1_1_2, null);
		
		JLabel lblWelcomeBack = new JLabel("Are you sure you want to logout?");
		lblWelcomeBack.setForeground(Color.WHITE);
		lblWelcomeBack.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack.setBounds(301, 36, 633, 38);
		panel_1_1_2.add(lblWelcomeBack);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
				dispose(); // Close the AdminUI frame
				JOptionPane.showMessageDialog(null, "You have successfully logged out.", "Logout", JOptionPane.INFORMATION_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "Logout cancelled.", "Logout", JOptionPane.INFORMATION_MESSAGE);
				// Optionally, you can navigate back to the previous tab or perform any other action
				tabbedPane.setSelectedIndex(0); // Switch back to the Home tab
			}
		});
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNo.setBackground(new Color(195, 143, 255));
		btnNo.setBounds(438, 301, 301, 53);
		panel_1_1_2.add(btnNo);
		
		String [] columnNames = {"ID", "Username", "Role", "Status", "Created At"};
		String [] columnNamesAudit = {"ID", "Username", "Action Type", "Resources Type", "Timestamp"};
		userTableModel = new DefaultTableModel(columnNames, 0);
		auditTableModel = new DefaultTableModel(columnNamesAudit, 0);
		userTable.setModel(userTableModel);
		auditTable.setModel(auditTableModel);
		
		loadUserData();
		loadAuditData();
		
		TableRowSorter<DefaultTableModel> userSorter = new TableRowSorter<>(userTableModel);
		userTable.setRowSorter(userSorter);
		
		searchUserField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			
			@Override
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				filterUserTable();
			}

			@Override
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				filterUserTable();
			}

			@Override
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
				filterUserTable();
			}
			
			private void filterUserTable() {
				String searchText = searchUserField.getText().toLowerCase();
				if (searchText.trim().isEmpty()) {
					loadUserData(); // Reload all data if search text is empty
				} else {
					userSorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + searchText));
				}
			}
		});
		
		String [] columnNamesPendingJob = {"Job ID", "Job Title", "Company Name", "Posted Date", "Status", "Expiration Date"};
		pendingJobTableModel = new DefaultTableModel(columnNamesPendingJob, 0);
		approvedJobTableModel = new DefaultTableModel(columnNamesPendingJob, 0);
		PendingJobTable.setModel(pendingJobTableModel);
		 ApprovedTable.setModel(approvedJobTableModel);
		
		TableRowSorter<DefaultTableModel> pendingJobSorter = new TableRowSorter<>(pendingJobTableModel);
		PendingJobTable.setRowSorter(pendingJobSorter);
		
		searchPendingJob.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			
			@Override
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				filterPendingJobTable();
			}

			@Override
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				filterPendingJobTable();
			}

			@Override
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
				filterPendingJobTable();
			}
			
			private void filterPendingJobTable() {
				String searchText = searchPendingJob.getText().toLowerCase();
				if (searchText.trim().isEmpty()) {
					LoadJobDataPending(); // Reload all data if search text is empty
				} else {
					pendingJobSorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + searchText));
				}
			}
		});
		
		
		TableRowSorter<DefaultTableModel> approvedJobSorter = new TableRowSorter<>(approvedJobTableModel);
		ApprovedTable.setRowSorter(approvedJobSorter);
		searchApproveJob.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			
			@Override
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				filterApprovedJobTable();
			}

			@Override
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				filterApprovedJobTable();
			}

			@Override
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
				filterApprovedJobTable();
			}
			
			private void filterApprovedJobTable() {
				String searchText = searchApproveJob.getText().toLowerCase();
				if (searchText.trim().isEmpty()) {
					LoadJobDataApproved(); // Reload all data if search text is empty
				} else {
					approvedJobSorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + searchText));
				}
			}
		});
		
		
		
		LoadJobDataPending();
		LoadJobDataApproved();
		
		

	}
	
	public void LoadJobDataPending() {
		pendingJobList.clear();
		
		pendingJobTableModel.setRowCount(0); // Clear existing rows in the table model
	
		pendingJobList = JobService.getInstance().getAllPendingJobs();
		
		for (JobModel job : pendingJobList) {
  			Object[] rowData = {
				job.getJobId(),
				job.getJobTitle(),
				job.getCompanyName(),
				job.getPostedDate(),
				job.getStatus(),
				job.getExpirationDate()
			};
  			pendingJobTableModel.addRow(rowData);
		}
	}
	
	
	public void LoadJobDataApproved() {
		approvedJobList.clear();
		
		approvedJobTableModel.setRowCount(0); // Clear existing rows in the table model
	
		approvedJobList = JobService.getInstance().getAllApprovedJobs();
		
		for (JobModel job : approvedJobList) {
  			Object[] rowData = {
				job.getJobId(),
				job.getJobTitle(),
				job.getCompanyName(),
				job.getPostedDate(),
				job.getStatus(),
				job.getExpirationDate()
			};
  			approvedJobTableModel.addRow(rowData);
		}
	}
	
	
	void loadUserData() {
		userList.clear();
		
		userTableModel.setRowCount(0);
		
		
		try {
			 
			userList = RegistrationService.getInstance().getAllUser();
			
		       			for (UserModel user : userList) {
				Object[] row = {
					user.getId(),
					user.getUsername(),
					user.getRole(),
					user.getStatus(),
					user.getCreatedAt()
				};
				userTableModel.addRow(row);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Failed to load user data.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	
	void loadAuditData() {
		auditList.clear();
		auditTableModel.setRowCount(0);
		
		try {
			auditList = AuditLogService.getInstance().getAllAudits();
			
			for (AuditModel log : auditList) {
				Object[] row = {
					log.getAuditId(),
					log.getUsername(),
					log.getActionType(),
					log.getResourceType(),
					log.getTimestamp()
				};
				auditTableModel.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Failed to load audit logs.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void setData(int adminId) {
		this.adminID = adminId;
	
		// You can use the adminID to fetch and display admin-specific data if needed
		// For example, you might want to load admin-specific information or settings here
		// This is just a placeholder for demonstration purposes
		System.out.println("Admin ID set: " + adminID);
		
		// Optionally, you can load user data or perform other actions based on the admin ID
		loadUserData();
		
	}
}
