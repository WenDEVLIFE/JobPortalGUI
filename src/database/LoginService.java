package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.mindrot.bcrypt.BCrypt;

import ui.AdminUI;
import ui.EmployeeUI;
import ui.JobSeekerUI;
import ui.Login;

public class LoginService {

    private static volatile LoginService instance;

    public static LoginService getInstance() {
        if (instance == null) {
            synchronized (LoginService.class) {
                if (instance == null) {
                    instance = new LoginService();
                }
            }
        }
        return instance;
    }

    public void validateLogin(String username, String password, Login login) {
        String SQL = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = MYSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");
                if (BCrypt.checkpw(password, hashedPassword)) {
                    String role = resultSet.getString("role");
                    String userId = resultSet.getString("user_id");
                    int userIdInt = Integer.parseInt(userId);
                    AuditLogService.getInstance().InsertAuditLog(userId, "Login", "User logged in with role: " + role);

                    if (role.equalsIgnoreCase("admin")) {
                        login.dispose();
                        AdminUI adminUI = new AdminUI();
                        adminUI.setVisible(true);
                        adminUI.setData(userIdInt);
                    } else if (role.equalsIgnoreCase("job seeker")) {
                        login.dispose();
                        JobSeekerUI jobSeekerUI = new JobSeekerUI();
                        jobSeekerUI.setVisible(true);
                        jobSeekerUI.setData(userIdInt);
                        jobSeekerUI.LoadProfile();
                    } else if (role.equalsIgnoreCase("employer") || role.equalsIgnoreCase("recruiter")) {
                        login.dispose();
                        EmployeeUI employerUI = new EmployeeUI();
                        employerUI.setVisible(true);
                        employerUI.setData(userIdInt);
                        employerUI.LoadEmployeeProfile();
                        employerUI.LoadJobData();
                  
                    } else {
                        JOptionPane.showMessageDialog(login, "Unknown role: " + role, "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(login, " Invalid password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(login, "Invalid username", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
