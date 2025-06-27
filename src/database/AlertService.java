package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

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
}
