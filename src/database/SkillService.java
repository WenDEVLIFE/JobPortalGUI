// File: database/SkillService.java
package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillService {

    private static volatile SkillService instance;

    public static SkillService getInstance() {
        if (instance == null) {
            synchronized (SkillService.class) {
                if (instance == null) {
                    instance = new SkillService();
                }
            }
        }
        return instance;
    }

    public void addSkill(int seekerId, String skillName, String proficiencyLevel) throws SQLException {
        String sql = "INSERT INTO seeker_skills (seeker_id, skill_name, proficiency_level) VALUES (?, ?, ?)";
        try (Connection conn = MYSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, seekerId);
            stmt.setString(2, skillName);
            stmt.setString(3, proficiencyLevel);
            stmt.executeUpdate();
        }
    }

    public List<String[]> getSkills(int seekerId) throws SQLException {
        List<String[]> skills = new ArrayList<>();
        String sql = "SELECT skill_name, proficiency_level FROM seeker_skills WHERE seeker_id = ?";
        try (Connection conn = MYSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, seekerId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    skills.add(new String[] {
                        rs.getString("skill_name"),
                        rs.getString("proficiency_level")
                    });
                }
            }
        }
        return skills;
    }

    // New: Delete skill
    public void deleteSkill(int seekerId, String skillName) throws SQLException {
        String sql = "DELETE FROM seeker_skills WHERE seeker_id = ? AND skill_name = ?";
        try (Connection conn = MYSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, seekerId);
            stmt.setString(2, skillName);
            stmt.executeUpdate();
        }
    }
}
