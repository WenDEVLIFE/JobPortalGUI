package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AuditModel;

public class AuditLogService {

	private static volatile AuditLogService instance;
	
	public static AuditLogService getInstance() {
		if (instance == null) {
			synchronized (AuditLogService.class) {
				if (instance == null) {
					instance = new AuditLogService();
				}
			}
		}
		return instance;
	}
	
	public void InsertAuditLog(String userId, String action, String details) {	
		String SQL = "INSERT INTO audit_logs (user_id, action_type, resource_type, timestamp) VALUES (?, ?, ?, NOW())";
		
		try (Connection connection = MYSQL.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
			
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, action);
			preparedStatement.setString(3, details);
			
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Audit log inserted successfully.");
			} else {
				System.out.println("Failed to insert audit log.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error inserting audit log: " + e.getMessage());
		}
	}
	
	public List<AuditModel> getAllAudits(){
		String SQL = "SELECT * FROM audit_logs";
		String UserSQL = "SELECT username FROM users WHERE user_id = ?";
		List<AuditModel> auditLogs = new ArrayList<>();
		
		try (Connection connection = MYSQL.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				
				String auditId = resultSet.getString("log_id");
				String userId = resultSet.getString("user_id");
				String actionType = resultSet.getString("action_type");
				String resourceType = resultSet.getString("resource_type");
				java.sql.Timestamp timestamp = resultSet.getTimestamp("timestamp");
				
				// Retrieve username from users table
				String username = null;
				
				try (PreparedStatement userStatement = connection.prepareStatement(UserSQL)) {
					userStatement.setString(1, userId);
					ResultSet userResultSet = userStatement.executeQuery();
					if (userResultSet.next()) {
						username = userResultSet.getString("username");
					}
					else {
						username = "Deleted User";
					}
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error retrieving username: " + e.getMessage());
				}
				
				// Create AuditModel object and add to the list
				AuditModel auditLog = new AuditModel(auditId, username, actionType, resourceType, timestamp.toString());
				auditLogs.add(auditLog);
				
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error retrieving audit logs: " + e.getMessage());
		}
		
		return auditLogs;
		
	}
}
