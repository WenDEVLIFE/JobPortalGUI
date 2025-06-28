package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ApplicationModel;

public class ApplicationService {

	
	private static volatile ApplicationService instance;

	public static ApplicationService getInstance() {
		if (instance == null) {
			synchronized (ApplicationService.class) {
				if (instance == null) {
					instance = new ApplicationService();
				}
			}
		}
		return instance;
	}
	
	public List<ApplicationModel> getApplicationsByJobId(String seekerId) {
	    List<ApplicationModel> applications = new ArrayList<>();
	    String query = "SELECT a.application_id, a.job_id, a.seeker_id, s.fullname AS seeker_name, a.applied_at, a.status, e.company_name, j.job_title " +
	                   "FROM application a " +
	                   "JOIN seeker_profile s ON a.seeker_id = s.seeker_id " +
	                   "JOIN jobs j ON a.job_id = j.job_id " +
	                   "JOIN employee_profile e ON j.employee_id = e.employee_id " +
	                   "WHERE a.seeker_id = ?";

	    try (Connection conn = MYSQL.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {
	        pstmt.setString(1, seekerId);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            String applicationId = rs.getString("application_id");
	            String jobId = rs.getString("job_id");
	            String seekerName = rs.getString("seeker_name");
	            String appliedAt = rs.getString("applied_at");
	            String status = rs.getString("status");
	            String companyName = rs.getString("company_name");
	            String jobTitle = rs.getString("job_title");

	            ApplicationModel application = new ApplicationModel(applicationId, jobId, seekerId, seekerName, appliedAt, status, companyName, jobTitle);
	            applications.add(application);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return applications;
	}
	


	public void cancelApplication(String applicationId) {
		String query = "DELETE FROM application WHERE application_id = ?";
		try (Connection conn = MYSQL.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, applicationId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	public List<ApplicationModel> getApplicationByEmployee(int employeeId) {
	    List<ApplicationModel> applications = new ArrayList<>();
	    String query = "SELECT a.application_id, a.job_id, a.seeker_id, s.fullname AS seeker_name, a.applied_at, a.status, e.company_name, j.job_title " +
	                   "FROM application a " +
	                   "JOIN seeker_profile s ON a.seeker_id = s.seeker_id " +
	                   "JOIN jobs j ON a.job_id = j.job_id " +
	                   "JOIN employee_profile e ON j.employee_id = e.employee_id " +
	                   "WHERE j.employee_id = ?";

	    try (Connection conn = MYSQL.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {
	        pstmt.setInt(1, employeeId);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            String applicationId = rs.getString("application_id");
	            String jobId = rs.getString("job_id");
	            String seekerId = rs.getString("seeker_id");
	            String seekerName = rs.getString("seeker_name");
	            String appliedAt = rs.getString("applied_at");
	            String status = rs.getString("status");
	            String companyName = rs.getString("company_name");
	            String jobTitle = rs.getString("job_title");

	            ApplicationModel application = new ApplicationModel(applicationId, jobId, seekerId, seekerName, appliedAt, status, companyName, jobTitle);
	            applications.add(application);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return applications;
	}



}
