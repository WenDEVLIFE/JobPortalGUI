package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.JobModel;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class JobSeekerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable jobTable;
	DefaultTableModel tableModel;
	List<JobModel> jobList = new ArrayList<>();
	

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
		
		JLabel lblWelcomeBack_1_1_1 = new JLabel("0");
		lblWelcomeBack_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1.setBounds(139, 89, 130, 38);
		panel_3.add(lblWelcomeBack_1_1_1);
		
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
		
		JLabel lblWelcomeBack_1_1_1_1 = new JLabel("0");
		lblWelcomeBack_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_1.setBounds(133, 88, 130, 38);
		panel_3_1.add(lblWelcomeBack_1_1_1_1);
		
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
		
		JLabel lblWelcomeBack_1_1_1_1_1 = new JLabel("0");
		lblWelcomeBack_1_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_1_1.setBounds(159, 89, 130, 38);
		panel_3_1_1.add(lblWelcomeBack_1_1_1_1_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(new Color(255, 128, 255));
		panel_3_2.setBounds(196, 295, 331, 172);
		panel_1.add(panel_3_2);
		
		JLabel lblWelcomeBack_1_1_3 = new JLabel("Approved Application");
		lblWelcomeBack_1_1_3.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3.setBounds(46, 39, 275, 38);
		panel_3_2.add(lblWelcomeBack_1_1_3);
		
		JLabel lblWelcomeBack_1_1_1_2 = new JLabel("0");
		lblWelcomeBack_1_1_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_2.setBounds(139, 89, 130, 38);
		panel_3_2.add(lblWelcomeBack_1_1_1_2);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setLayout(null);
		panel_3_2_1.setBackground(new Color(255, 128, 255));
		panel_3_2_1.setBounds(560, 295, 331, 172);
		panel_1.add(panel_3_2_1);
		
		JLabel lblWelcomeBack_1_1_3_1 = new JLabel("Denied Application");
		lblWelcomeBack_1_1_3_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3_1.setBounds(46, 39, 275, 38);
		panel_3_2_1.add(lblWelcomeBack_1_1_3_1);
		
		JLabel lblWelcomeBack_1_1_1_2_1 = new JLabel("0");
		lblWelcomeBack_1_1_1_2_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_2_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_2_1.setBounds(139, 89, 130, 38);
		panel_3_2_1.add(lblWelcomeBack_1_1_1_2_1);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Find a job", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblWelcomeBack_1_2 = new JLabel("Find a job");
		lblWelcomeBack_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_2.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2.setBounds(10, 25, 172, 38);
		panel.add(lblWelcomeBack_1_2);
		
		textField = new JTextField();
		textField.setBounds(192, 28, 863, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		jobTable = new JTable();
		jobTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		jobTable.setBounds(39, 74, 1046, 360);
		panel.add(jobTable);
		
		JButton btnViewJob = new JButton("View Job");
		btnViewJob.setForeground(Color.WHITE);
		btnViewJob.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewJob.setBackground(new Color(195, 143, 255));
		btnViewJob.setBounds(375, 445, 337, 53);
		panel.add(btnViewJob);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Saved Job", null, panel_4, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("My Application", null, panel_2, null);
		
		JPanel panel_1_1_1 = new JPanel();
		tabbedPane.addTab("My Profile", null, panel_1_1_1, null);
		
		JPanel panel_1_1 = new JPanel();
		tabbedPane.addTab("Alert", null, panel_1_1, null);
		
		JPanel panel_1_1_2 = new JPanel();
		tabbedPane.addTab("Logout", null, panel_1_1_2, null);
		panel_1_1_2.setLayout(null);
		
		JLabel lblWelcomeBack = new JLabel("Are you sure you want to logout?");
		lblWelcomeBack.setBounds(301, 36, 633, 38);
		lblWelcomeBack.setForeground(Color.WHITE);
		lblWelcomeBack.setFont(new Font("Verdana", Font.BOLD, 30));
		panel_1_1_2.add(lblWelcomeBack);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(195, 143, 255));
		btnNewButton.setBounds(438, 197, 301, 53);
		panel_1_1_2.add(btnNewButton);
		
		JButton btnNo = new JButton("No");
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNo.setBackground(new Color(195, 143, 255));
		btnNo.setBounds(438, 301, 301, 53);
		panel_1_1_2.add(btnNo);
		
		String [] columnNames = {"Job ID", "Job Title", "Company Name", "Posted Date", "Status", "Expiration Date"};
		tableModel = new DefaultTableModel(columnNames, 0);
		jobTable.setModel(tableModel);
		
		LoadJobData();
	 

	}
	
	void LoadJobData() {
		// This method can be used to load job data from a database or any other source
		// For now, we are using hardcoded data in the constructor
		// In a real application, you would fetch this data from a database or an API
	 		jobList.add(new JobModel("1", "Software Engineer", "Tech Company", "Develop software applications", "Remote", "Java, Spring Boot", "Full-time", "50000", "70000", "2023-10-01", "2024-01-01", "Open"));
		
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
}
