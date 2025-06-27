package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
        String filename = new File(filePath).getName();
        String sql = "INSERT INTO resume (seeker_id, filename, publishAt, filepath) VALUES (?, ?, NOW(), ?)";
        try (Connection conn = MYSQL.getConnection();
        	     PreparedStatement stmt = conn.prepareStatement(sql);
        	     FileInputStream fis = new FileInputStream(filePath)) {

        	    stmt.setInt(1, seekerId);                            // seeker_id
        	    stmt.setString(2, filename);                         // filename
        	    stmt.setBinaryStream(3, fis, new File(filePath).length()); // filepath ← BLOB goes here
        	    // publishAt handled by NOW()
        	    return stmt.executeUpdate() > 0;
        	} catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // Returns a list of String arrays: [filepath, filename]
    public List<String[]> getResumesForSeeker(int seekerId) {
        List<String[]> resumes = new ArrayList<>();
        String sql = "SELECT filepath, filename FROM resume WHERE seeker_id = ?";
        try (Connection conn = MYSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, seekerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resumes.add(new String[] {
                    rs.getString("filepath"),
                    rs.getString("filename")
                });
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

    public boolean downloadResume(int seekerId, String filePath, File destination, byte[] fileData, boolean isBase64) {
        if (fileData == null) {
            System.err.println("No file data to write.");
            return false;
        }
        try (OutputStream out = new FileOutputStream(destination)) {
            byte[] decodedData = fileData;
            if (isBase64) {
                decodedData = java.util.Base64.getDecoder().decode(fileData);
            }
            out.write(decodedData);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    
    public byte[] getResumeBlob(int seekerId, String filename) {
        try (Connection conn = MYSQL.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT filepath FROM resume WHERE seeker_id=? AND filename=?")) {
            ps.setInt(1, seekerId);
            ps.setString(2, filename);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getBytes("filepath"); // ← BLOB
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



   
}
