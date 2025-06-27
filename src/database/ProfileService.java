package database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ProfileService {

    private static volatile ProfileService instance;

    public static ProfileService getInstance() {
        if (instance == null) {
            synchronized (ProfileService.class) {
                if (instance == null) {
                    instance = new ProfileService();
                }
            }
        }
        return instance;
    }

    public boolean updateEmployeeData(java.util.Map<String, Object> employeeData) {
        String userId = (String) employeeData.get("employeeId");
        String employeeName = (String) employeeData.get("employeeName");
        String companyName = (String) employeeData.get("companyName");
        String description = (String) employeeData.get("description");
        String industry = (String) employeeData.get("industry");
        String location = (String) employeeData.get("location");

        try (Connection conn = MYSQL.getConnection()) {
            String checkSql = "SELECT 1 FROM employee_profile WHERE user_id = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setString(1, userId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    String updateSql = "UPDATE employee_profile SET employee_name=?, company_name=?, description=?, industry=?, location=? WHERE user_id=?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                        updateStmt.setString(1, employeeName);
                        updateStmt.setString(2, companyName);
                        updateStmt.setString(3, description);
                        updateStmt.setString(4, industry);
                        updateStmt.setString(5, location);
                        updateStmt.setString(6, userId);
                        return updateStmt.executeUpdate() > 0;
                    }
                } else {
                    String insertSql = "INSERT INTO employee_profile (user_id, employee_name, company_name, description, industry, location) VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                        insertStmt.setString(1, userId);
                        insertStmt.setString(2, employeeName);
                        insertStmt.setString(3, companyName);
                        insertStmt.setString(4, description);
                        insertStmt.setString(5, industry);
                        insertStmt.setString(6, location);
                        return insertStmt.executeUpdate() > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getEmployeeName(String userId) {
        return getFieldByUserId(userId, "employee_name");
    }

    public String getCompanyName(String userId) {
        return getFieldByUserId(userId, "company_name");
    }

    public String getDescription(String userId) {
        return getFieldByUserId(userId, "description");
    }

    public String getIndustry(String userId) {
        return getFieldByUserId(userId, "industry");
    }

    public String getLocation(String userId) {
        return getFieldByUserId(userId, "location");
    }

    private String getFieldByUserId(String userId, String fieldName) {
        String sql = "SELECT " + fieldName + " FROM employee_profile WHERE user_id = ?";
        try (Connection conn = MYSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(fieldName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean updateProfileData(Map<String, Object> userData) {
        int userId = (int) userData.get("userId");
        String fullName = (String) userData.get("fullName");
        String contactInfo = (String) userData.get("contactInfo");
        String location = (String) userData.get("location");

        try (Connection conn = MYSQL.getConnection()) {
            // Check if record exists
            String checkSql = "SELECT 1 FROM seeker_profile WHERE user_id = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setInt(1, userId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    // Update if exists
                    String updateSql = "UPDATE seeker_profile SET fullname = ?, contact_info = ?, location = ?, visibility = ? WHERE user_id = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                        updateStmt.setString(1, fullName);
                        updateStmt.setString(2, contactInfo);
                        updateStmt.setString(3, location);
                        updateStmt.setBoolean(4, true); // Assuming visibility is always true for updates
                        updateStmt.setInt(5, userId);
                        return updateStmt.executeUpdate() > 0;
                    }
                } else {
                    // Insert if not exists (fixed: 5 placeholders)
                    String insertSql = "INSERT INTO seeker_profile (user_id, fullname, contact_info, location, visibility) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                        insertStmt.setInt(1, userId);
                        insertStmt.setString(2, fullName);
                        insertStmt.setString(3, contactInfo);
                        insertStmt.setString(4, location);
                        insertStmt.setBoolean(5, true); 
                        return insertStmt.executeUpdate() > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



}
