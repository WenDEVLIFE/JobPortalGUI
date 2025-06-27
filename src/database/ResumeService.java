package database;

import java.sql.*;
import java.util.*;

public class ResumeService {

    private static volatile ResumeService instance;

    public static ResumeService getInstance() {
        if (instance == null) {
            synchronized (ResumeService.class) {
                if (instance == null) {
                    instance = new ResumeService();
                }
            }
        }
        return instance;
    }

    public boolean addResume(int seekerId, String filePath) {
        String sql = "INSERT INTO resume (seeker_id, filepath, publishAt) VALUES (?, ?,  NOW())";
        try (Connection conn = MYSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             java.io.FileInputStream fis = new java.io.FileInputStream(filePath)) {
            stmt.setInt(1, seekerId);
            stmt.setBinaryStream(2, fis, new java.io.File(filePath).length());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getResumesForSeeker(int seekerId) {
        List<String> resumes = new ArrayList<>();
        String sql = "SELECT filepath FROM resume WHERE seeker_id = ?";
        try (Connection conn = MYSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, seekerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resumes.add(rs.getString("filepath"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumes;
    }

    public boolean removeResume(int seekerId, String filePath) {
        String sql = "DELETE FROM resume WHERE seeker_id = ? AND filepath = ?";
        try (Connection conn = MYSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, seekerId);
            stmt.setString(2, filePath);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
