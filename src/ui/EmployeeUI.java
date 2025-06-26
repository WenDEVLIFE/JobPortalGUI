package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class EmployeeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable applicantTable;

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

	}
}
