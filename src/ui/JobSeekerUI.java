package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.JobModel;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JobSeekerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchJobField;
	private JTable jobTable;
	DefaultTableModel tableModel;
	List<JobModel> jobList = new ArrayList<>();
	DefaultTableModel savedTableModel;
	List<JobModel> savedJobList = new ArrayList<>();
	private JTextField searchSavedJobField;
	private JTable saveJobTable;
	private JTextField textField;
	private JTable table;
	

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
		
		searchJobField = new JTextField();
		searchJobField.setBounds(192, 28, 863, 38);
		panel.add(searchJobField);
		searchJobField.setColumns(10);
		
		
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
		btnViewJob_1.setForeground(Color.WHITE);
		btnViewJob_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewJob_1.setBackground(new Color(195, 143, 255));
		btnViewJob_1.setBounds(130, 431, 337, 53);
		panel_4.add(btnViewJob_1);
		
		JButton btnViewJob_1_1 = new JButton("Delete");
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
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(53, 74, 1046, 360);
		panel_2.add(table);
		
		JButton btnViewJob_1_2 = new JButton("View Application");
		btnViewJob_1_2.setForeground(Color.WHITE);
		btnViewJob_1_2.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewJob_1_2.setBackground(new Color(195, 143, 255));
		btnViewJob_1_2.setBounds(144, 445, 337, 53);
		panel_2.add(btnViewJob_1_2);
		
		JButton btnViewJob_1_1_1 = new JButton("Delete Application");
		btnViewJob_1_1_1.setForeground(Color.WHITE);
		btnViewJob_1_1_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewJob_1_1_1.setBackground(new Color(195, 143, 255));
		btnViewJob_1_1_1.setBounds(642, 445, 337, 53);
		panel_2.add(btnViewJob_1_1_1);
		
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
		savedTableModel = new DefaultTableModel(columnNames, 0);
		jobTable.setModel(tableModel);
		saveJobTable.setModel(savedTableModel);
		
		LoadJobData();
		LoadSavedJobData();
		
		
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
		
		

	 

	}
	
	// This will load the job
	void LoadJobData() {
		jobList.clear();
		
		tableModel.setRowCount(0); // Clear existing rows in the table model
	
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
	
	// This will load the saved job
	void LoadSavedJobData() {
		savedJobList.clear();
		
		DefaultTableModel savedTableModel = (DefaultTableModel) saveJobTable.getModel();
		savedTableModel.setRowCount(0); // Clear existing rows in the table model
		
		savedJobList.add(new JobModel("1", "Software Engineer", "Tech Company", "Develop software applications", "Remote", "Java, Spring Boot", "Full-time", "50000", "70000", "2023-10-01", "2024-01-01", "Open"));
		
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
}
