package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import model.UserModel;

public class RegistrationService {

	public static volatile RegistrationService instance;
	
	public static RegistrationService getInstance() {
		if (instance == null) {
			synchronized (RegistrationService.class) {
				if (instance == null) {
					instance = new RegistrationService();
				}
			}
		}
		return instance;
	}
	
	public void RegisterUser(Map<String, Object> userDetails) {
	    String username = (String) userDetails.get("username");
	    String password = (String) userDetails.get("password");
	    String role = (String) userDetails.get("role");
	    String generatedId = null;
	    try {
	        Connection connection = MYSQL.getConnection();
	        if (connection != null) {
	            String query = "INSERT INTO users (username, password, role, status, createdAt) VALUES (?, ?, ?, ?, ?)";
	            LocalDateTime now = LocalDateTime.now();
	            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
	            preparedStatement.setString(3, role);
	            preparedStatement.setString(4, "Active");
	            preparedStatement.setObject(5, now.toString());

	            int rowsAffected = preparedStatement.executeUpdate();
	            if (rowsAffected > 0) {
	                ResultSet rs = preparedStatement.getGeneratedKeys();
	                if (rs.next()) {
	                    generatedId = rs.getString(1);
	                }
	                System.out.println("User registered successfully!");
	                JOptionPane.showMessageDialog(null, "Registration successful! You can now log in.", "Success", JOptionPane.INFORMATION_MESSAGE);
	                AuditLogService.getInstance().InsertAuditLog(generatedId, "Register User", "User registered with username: " + username);
	            } else {
	                System.out.println("Failed to register user.");
	                JOptionPane.showMessageDialog(null, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            System.out.println("Database connection failed.");
	            JOptionPane.showMessageDialog(null, "Database connection failed. Please check your connection settings.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public boolean isUserExists(String username) {
		try {
			Connection connection = MYSQL.getConnection();
			if (connection != null) {
				String query = "SELECT COUNT(*) FROM users WHERE username = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, username);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					int count = resultSet.getInt(1);
					return count > 0;
				}
			} else {
				System.out.println("Database connection failed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public List<UserModel> getAllUser() {
	    List<UserModel> users = new java.util.ArrayList<>();
	    String sql = "SELECT * FROM users";

	    try (Connection connection = MYSQL.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql);
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            String userId = resultSet.getString("user_id");
	            String username = resultSet.getString("username");
	            String password = resultSet.getString("password");
	            String role = resultSet.getString("role");
	            String status = resultSet.getString("status");
	            String createdAt = resultSet.getString("createdAt");

	            UserModel user = new UserModel(userId, username, password, role, status, createdAt);
	            users.add(user);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return users;
	}

	public boolean updateUser(Map<String, String> updatedDetails) {
		String userId = updatedDetails.get("userId");
		String username = updatedDetails.get("username");
		String password = updatedDetails.get("password");
		String role = updatedDetails.get("role");
		String status = updatedDetails.get("status");
	     System.out.println("Updating user with ID: " + userId);
	     System.out.println("New Username: " + username);
	     System.out.println("New Password: " + password);
	     System.out.println("New Role: " + role);
	     System.out.println("New Status: " + status);
	     
		
		String sql = "UPDATE users SET username = ?, password = ?, role = ?, status = ? WHERE user_id = ?";
		 try (Connection connection = MYSQL.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, role);
			preparedStatement.setString(4, status);
			preparedStatement.setString(5, userId);
			
			int rowsAffected = preparedStatement.executeUpdate();
			AuditLogService.getInstance().InsertAuditLog(userId, "Update User", "User details updated for user ID: " + userId);
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return false;
	}
	

	public boolean deleteUser(String userIds, int adminId) {
		String sql = "DELETE FROM users WHERE user_id = ?";
		try (Connection connection = MYSQL.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setString(1, userIds);
			int rowsAffected = preparedStatement.executeUpdate();
			
			String adminIds = String.valueOf(adminId);
			 AuditLogService.getInstance().InsertAuditLog(adminIds, "Delete User", "User deleted with ID: " + userIds);
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
