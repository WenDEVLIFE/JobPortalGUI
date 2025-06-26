package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.JobModel;

public class JobService {

	private static volatile JobService instance;
	
	public static JobService getInstance() {
		if (instance == null) {
			synchronized (JobService.class) {
				if (instance == null) {
					instance = new JobService();
				}
			}
		}
		return instance;
	}
	
	
	public boolean addJob(Map<String, Object> jobDetails) {
	    String jobTitle = String.valueOf(jobDetails.get("jobTitle"));
	    String jobDescription = String.valueOf(jobDetails.get("jobDescription"));
	    String requirements = String.valueOf(jobDetails.get("requirements"));
	    String jobLocation = String.valueOf(jobDetails.get("jobLocation"));
	    String jobType = String.valueOf(jobDetails.get("jobType"));
	    String salaryMin = String.valueOf(jobDetails.get("salaryMin"));
	    String salaryMax = String.valueOf(jobDetails.get("salaryMax"));
	    String postedAt = String.valueOf(jobDetails.get("postedAt"));
	    String expiresAt = String.valueOf(jobDetails.get("expiresAt"));
	    String status = String.valueOf(jobDetails.get("status"));
	    String employeeId = String.valueOf(jobDetails.get("employeeId"));

	    String query = "INSERT INTO jobs (employee_id, job_title, description, requirements, location, job_type, salary_min, salary_max, posted_at, expires_at, status) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (java.sql.Connection conn = MYSQL.getConnection();
	         java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {

	        int salaryMinInt = Integer.parseInt(salaryMin);
	        int salaryMaxInt = Integer.parseInt(salaryMax);
	        int employeeIdInt = Integer.parseInt(employeeId);
	        pstmt.setInt(1, employeeIdInt);
	        pstmt.setString(2, jobTitle);
	        pstmt.setString(3, jobDescription);
	        pstmt.setString(4, requirements);
	        pstmt.setString(5, jobLocation);
	        pstmt.setString(6, jobType);
	        pstmt.setInt(7, salaryMinInt);
	        pstmt.setInt(8, salaryMaxInt);
	        pstmt.setString(9, postedAt);
	        pstmt.setString(10, expiresAt);
	        pstmt.setString(11, status);

	        int rowsAffected = pstmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public List<JobModel> getAllJobs() {
	    List<JobModel> jobs = new ArrayList<>();
	    String query = "SELECT * FROM jobs";

	    try (java.sql.Connection conn = MYSQL.getConnection();
	         java.sql.PreparedStatement pstmt = conn.prepareStatement(query);
	         java.sql.ResultSet rs = pstmt.executeQuery()) {

	        while (rs.next()) {
	            String jobId = rs.getString("job_id");
	            String employeeId = rs.getString("employee_id");
	            String jobTitle = rs.getString("job_title");
	            String companyName = rs.getString("company_name");
	            String jobDescription = rs.getString("description");
	            String jobLocation = rs.getString("location");
	            String requirements = rs.getString("requirements");
	            String jobType = rs.getString("job_type");
	            String salaryMin = rs.getString("salary_min");
	            String salaryMax = rs.getString("salary_max");
	            String postedDate = rs.getString("posted_at");
	            String expirationDate = rs.getString("expires_at");
	            String status = rs.getString("status");

	            JobModel job = new JobModel(jobId, jobTitle, companyName, jobDescription, jobLocation,
	                    requirements, jobType, salaryMin, salaryMax, postedDate, expirationDate, status);
	            jobs.add(job);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    	return jobs;
	}

}
