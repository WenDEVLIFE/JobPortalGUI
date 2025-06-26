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
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class EmployeeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable applicantTable;
	private JTextField textField_1;
	private JTable table;
	private JTable alertTable;
	private JTextField textField_2;
	private JTable table_1;

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
		
		JLabel lblWelcomeBack_1_1_1 = new JLabel("0");
		lblWelcomeBack_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1.setBounds(139, 89, 130, 38);
		panel_3.add(lblWelcomeBack_1_1_1);
		
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
		
		JLabel lblWelcomeBack_1_1_1_1 = new JLabel("0");
		lblWelcomeBack_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_1.setBounds(139, 89, 130, 38);
		panel_3_1.add(lblWelcomeBack_1_1_1_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(new Color(255, 128, 255));
		panel_3_2.setBounds(756, 79, 331, 172);
		panel.add(panel_3_2);
		
		JLabel lblWelcomeBack_1_1_3 = new JLabel("Total Job Denied");
		lblWelcomeBack_1_1_3.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3.setBounds(63, 40, 206, 38);
		panel_3_2.add(lblWelcomeBack_1_1_3);
		
		JLabel lblWelcomeBack_1_1_1_2 = new JLabel("0");
		lblWelcomeBack_1_1_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_2.setBounds(139, 89, 130, 38);
		panel_3_2.add(lblWelcomeBack_1_1_1_2);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setLayout(null);
		panel_3_2_1.setBackground(new Color(255, 128, 255));
		panel_3_2_1.setBounds(41, 306, 331, 172);
		panel.add(panel_3_2_1);
		
		JLabel lblWelcomeBack_1_1_3_1 = new JLabel("Total Job Pending");
		lblWelcomeBack_1_1_3_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3_1.setBounds(63, 40, 206, 38);
		panel_3_2_1.add(lblWelcomeBack_1_1_3_1);
		
		JLabel lblWelcomeBack_1_1_1_2_1 = new JLabel("0");
		lblWelcomeBack_1_1_1_2_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_2_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_2_1.setBounds(139, 89, 130, 38);
		panel_3_2_1.add(lblWelcomeBack_1_1_1_2_1);
		
		JPanel panel_3_2_1_1 = new JPanel();
		panel_3_2_1_1.setLayout(null);
		panel_3_2_1_1.setBackground(new Color(255, 128, 255));
		panel_3_2_1_1.setBounds(396, 306, 331, 172);
		panel.add(panel_3_2_1_1);
		
		JLabel lblWelcomeBack_1_1_3_1_1 = new JLabel("Total Job Open");
		lblWelcomeBack_1_1_3_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3_1_1.setBounds(63, 40, 206, 38);
		panel_3_2_1_1.add(lblWelcomeBack_1_1_3_1_1);
		
		JLabel lblWelcomeBack_1_1_1_2_1_1 = new JLabel("0");
		lblWelcomeBack_1_1_1_2_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_2_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_2_1_1.setBounds(139, 89, 130, 38);
		panel_3_2_1_1.add(lblWelcomeBack_1_1_1_2_1_1);
		
		JPanel panel_3_2_1_1_1 = new JPanel();
		panel_3_2_1_1_1.setLayout(null);
		panel_3_2_1_1_1.setBackground(new Color(255, 128, 255));
		panel_3_2_1_1_1.setBounds(756, 306, 331, 172);
		panel.add(panel_3_2_1_1_1);
		
		JLabel lblWelcomeBack_1_1_3_1_1_1 = new JLabel("Total Job Closed");
		lblWelcomeBack_1_1_3_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3_1_1_1.setBounds(63, 40, 206, 38);
		panel_3_2_1_1_1.add(lblWelcomeBack_1_1_3_1_1_1);
		
		JLabel lblWelcomeBack_1_1_1_2_1_1_1 = new JLabel("0");
		lblWelcomeBack_1_1_1_2_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_2_1_1_1.setBounds(139, 89, 130, 38);
		panel_3_2_1_1_1.add(lblWelcomeBack_1_1_1_2_1_1_1);
		
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
		btnViewApplicant_2.setForeground(Color.WHITE);
		btnViewApplicant_2.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewApplicant_2.setBackground(new Color(195, 143, 255));
		btnViewApplicant_2.setBounds(92, 431, 229, 53);
		panel_2.add(btnViewApplicant_2);
		
		JButton btnViewApplicant_2_1 = new JButton("Update Job");
		btnViewApplicant_2_1.setForeground(Color.WHITE);
		btnViewApplicant_2_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewApplicant_2_1.setBackground(new Color(195, 143, 255));
		btnViewApplicant_2_1.setBounds(436, 431, 229, 53);
		panel_2.add(btnViewApplicant_2_1);
		
		JButton btnViewApplicant_2_1_1 = new JButton("Delete Job");
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
		btnViewApplicant.setForeground(Color.WHITE);
		btnViewApplicant.setFont(new Font("Verdana", Font.BOLD, 11));
		btnViewApplicant.setBackground(new Color(195, 143, 255));
		btnViewApplicant.setBounds(392, 431, 337, 53);
		panel_1.add(btnViewApplicant);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		tabbedPane.addTab("Denied Applicants", null, panel_1_1, null);
		
		JLabel lblWelcomeBack_1_2_1 = new JLabel("Denied Applicants");
		lblWelcomeBack_1_2_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2_1.setBounds(10, 11, 303, 38);
		panel_1_1.add(lblWelcomeBack_1_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(323, 11, 748, 38);
		panel_1_1.add(textField_1);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(56, 60, 1046, 360);
		panel_1_1.add(table);
		
		JButton btnDeleteApplication = new JButton("Delete Application");
		btnDeleteApplication.setForeground(Color.WHITE);
		btnDeleteApplication.setFont(new Font("Verdana", Font.BOLD, 11));
		btnDeleteApplication.setBackground(new Color(195, 143, 255));
		btnDeleteApplication.setBounds(392, 431, 337, 53);
		panel_1_1.add(btnDeleteApplication);
		
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
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_1 = new JLabel("09912455343");
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_1.setBounds(25, 239, 450, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_1);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_1_1 = new JLabel("John Doe");
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_1_1.setBounds(25, 133, 450, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_1_1);
		
		JButton btnUpdateMyPassword = new JButton("Update My Password");
		btnUpdateMyPassword.setForeground(Color.WHITE);
		btnUpdateMyPassword.setFont(new Font("Verdana", Font.BOLD, 11));
		btnUpdateMyPassword.setBackground(new Color(195, 143, 255));
		btnUpdateMyPassword.setBounds(582, 435, 276, 46);
		panel_1_1_1.add(btnUpdateMyPassword);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_2 = new JLabel("TESTADDRESS");
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_2.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_2.setBounds(485, 239, 450, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_2);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3 = new JLabel("Industry:");
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3.setBounds(485, 84, 450, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3);
		
		JLabel lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3_1 = new JLabel("Industry");
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3_1.setBounds(485, 133, 450, 38);
		panel_1_1_1.add(lblWelcomeBack_1_2_1_1_2_1_1_1_1_1_3_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(25, 337, 434, 68);
		panel_1_1_1.add(textArea);
		
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

	}
}
