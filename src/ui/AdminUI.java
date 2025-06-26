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
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class AdminUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_1;
	private JTable table_2;
	private JTextField textField_2;
	private JTable table_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
		panel_3_1.setBounds(30, 290, 331, 172);
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
		panel_3_1_2.setBounds(394, 290, 331, 172);
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
		
		JPanel panel_3_1_2_1 = new JPanel();
		panel_3_1_2_1.setLayout(null);
		panel_3_1_2_1.setBackground(new Color(255, 128, 255));
		panel_3_1_2_1.setBounds(751, 290, 331, 172);
		panel.add(panel_3_1_2_1);
		
		JLabel lblWelcomeBack_1_1_3_1 = new JLabel("Denied Job Listing");
		lblWelcomeBack_1_1_3_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_3_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_3_1.setBounds(41, 38, 267, 38);
		panel_3_1_2_1.add(lblWelcomeBack_1_1_3_1);
		
		JLabel lblWelcomeBack_1_1_1_2_1 = new JLabel("0");
		lblWelcomeBack_1_1_1_2_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_1_1_2_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcomeBack_1_1_1_2_1.setBounds(139, 89, 130, 38);
		panel_3_1_2_1.add(lblWelcomeBack_1_1_1_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		tabbedPane.addTab("Users", null, panel_1, null);
		
		JLabel lblWelcomeBack_1_2_3 = new JLabel("Users");
		lblWelcomeBack_1_2_3.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_3.setFont(new Font("Verdana", Font.BOLD, 30));
		lblWelcomeBack_1_2_3.setBounds(74, 11, 104, 38);
		panel_1.add(lblWelcomeBack_1_2_3);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(25, 60, 1046, 360);
		panel_1.add(table);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(208, 11, 863, 38);
		panel_1.add(textField);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setForeground(Color.WHITE);
		btnAddUser.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAddUser.setBackground(new Color(195, 143, 255));
		btnAddUser.setBounds(66, 445, 301, 53);
		panel_1.add(btnAddUser);
		
		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.setForeground(Color.WHITE);
		btnEditUser.setFont(new Font("Verdana", Font.BOLD, 11));
		btnEditUser.setBackground(new Color(195, 143, 255));
		btnEditUser.setBounds(405, 445, 301, 53);
		panel_1.add(btnEditUser);
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setForeground(Color.WHITE);
		btnDeleteUser.setFont(new Font("Verdana", Font.BOLD, 11));
		btnDeleteUser.setBackground(new Color(195, 143, 255));
		btnDeleteUser.setBounds(733, 445, 301, 53);
		panel_1.add(btnDeleteUser);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		tabbedPane.addTab("Job Posting Pending", null, panel_3, null);
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setBounds(41, 61, 1046, 360);
		panel_3.add(table_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(434, 11, 648, 38);
		panel_3.add(textField_1);
		
		JButton btnApproved = new JButton("Approved");
		btnApproved.setForeground(Color.WHITE);
		btnApproved.setFont(new Font("Verdana", Font.BOLD, 11));
		btnApproved.setBackground(new Color(195, 143, 255));
		btnApproved.setBounds(194, 445, 301, 53);
		panel_3.add(btnApproved);
		
		JButton btnDelete = new JButton("Delete");
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		tabbedPane.addTab("Job Posting Approved", null, panel_4, null);
		
		JButton btnApproved_1 = new JButton("Approved");
		btnApproved_1.setForeground(Color.WHITE);
		btnApproved_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnApproved_1.setBackground(new Color(195, 143, 255));
		btnApproved_1.setBounds(194, 445, 301, 53);
		panel_4.add(btnApproved_1);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setForeground(Color.WHITE);
		btnDelete_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnDelete_1.setBackground(new Color(195, 143, 255));
		btnDelete_1.setBounds(589, 445, 301, 53);
		panel_4.add(btnDelete_1);
		
		table_2 = new JTable();
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setBounds(41, 61, 1046, 360);
		panel_4.add(table_2);
		
		JLabel lblWelcomeBack_1_2_3_1_1 = new JLabel("Search Title, Company & etc");
		lblWelcomeBack_1_2_3_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_3_1_1.setFont(new Font("Verdana", Font.BOLD, 24));
		lblWelcomeBack_1_2_3_1_1.setBounds(33, 12, 402, 38);
		panel_4.add(lblWelcomeBack_1_2_3_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(445, 12, 642, 38);
		panel_4.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		tabbedPane.addTab("Audit Logs", null, panel_2, null);
		
		JButton btnDeleteAuditLogs = new JButton("Delete Audit Logs");
		btnDeleteAuditLogs.setForeground(Color.WHITE);
		btnDeleteAuditLogs.setFont(new Font("Verdana", Font.BOLD, 11));
		btnDeleteAuditLogs.setBackground(new Color(195, 143, 255));
		btnDeleteAuditLogs.setBounds(354, 445, 301, 53);
		panel_2.add(btnDeleteAuditLogs);
		
		table_3 = new JTable();
		table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_3.setBounds(34, 61, 1046, 360);
		panel_2.add(table_3);
		
		JLabel lblWelcomeBack_1_2_3_1_1_1_1 = new JLabel("Audit Logs");
		lblWelcomeBack_1_2_3_1_1_1_1.setForeground(Color.WHITE);
		lblWelcomeBack_1_2_3_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 24));
		lblWelcomeBack_1_2_3_1_1_1_1.setBounds(34, 11, 402, 38);
		panel_2.add(lblWelcomeBack_1_2_3_1_1_1_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		tabbedPane.addTab("Change Password", null, panel_5, null);
		
		JButton btnUpdatePassword = new JButton("Update Password");
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

	}
}
