package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.AlertModel;

public class AlertService {
    private static volatile AlertService instance;

    public static AlertService getInstance() {
        if (instance == null) {
            synchronized (AlertService.class) {
                if (instance == null) {
                    instance = new AlertService();
                }
            }
        }
        return instance;
    }

    public boolean insertAlert(String description, int userId) {
        String query = "INSERT INTO alerts (description, timestamp, isNotify, user_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = MYSQL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, description);
            pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            pstmt.setBoolean(3, false); // isNotify default to false
            pstmt.setInt(4, userId);
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<AlertModel> getAlertsByUserId(int userId) {
		List<AlertModel> alerts = new ArrayList<>();
		String query = "SELECT * FROM alerts WHERE user_id = ? ORDER BY timestamp DESC";
		try (Connection conn = MYSQL.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String alertId = rs.getString("alert_id");
				String description = rs.getString("description");
				String timestamp = rs.getString("timestamp");
				AlertModel alert = new AlertModel(alertId, description, timestamp);
				alerts.add(alert);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alerts;
	}

	public void InsertAlert(int seekerId, String string, String string2) {
		String query = "INSERT INTO alerts (user_id, description, timestamp, isNotify) VALUES (?, ?, ?, ?)";
		try (Connection conn = MYSQL.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, seekerId);
			pstmt.setString(2, string2);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setBoolean(4, false); // isNotify default to false
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void notifyUserIfNeeded(int userId) {
	    String selectQuery = "SELECT alert_id, description FROM alerts WHERE user_id = ? AND isNotify = false";
	    String updateQuery = "UPDATE alerts SET isNotify = true WHERE alert_id = ?";
	    try (Connection conn = MYSQL.getConnection();
	         PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
	         PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
	        selectStmt.setInt(1, userId);
	        ResultSet rs = selectStmt.executeQuery();
	        while (rs.next()) {
	            String alertId = rs.getString("alert_id");
	            String description = rs.getString("description");
	            // Show alert in a dialog
	            JOptionPane.showMessageDialog(null, description, "Notification", JOptionPane.INFORMATION_MESSAGE);
	            // Mark as notified
	            updateStmt.setString(1, alertId);
	            updateStmt.executeUpdate();
	        }
	   
	     
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
