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

public class AdminUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

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
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		tabbedPane.addTab("Job Posting Approved", null, panel_4, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		tabbedPane.addTab("Audit Logs", null, panel_2, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		tabbedPane.addTab("Change Password", null, panel_5, null);
		
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
