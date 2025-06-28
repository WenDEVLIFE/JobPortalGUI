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
	    String userId = String.valueOf(jobDetails.get("userId"));

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
	    String query = "SELECT j.*, e.company_name FROM jobs j " +
	                   "JOIN employee_profile e ON j.employee_id = e.employee_id";

	    try (java.sql.Connection conn = MYSQL.getConnection();
	         java.sql.PreparedStatement pstmt = conn.prepareStatement(query);
	         java.sql.ResultSet rs = pstmt.executeQuery()) {

	        while (rs.next()) {
	            String jobId = rs.getString("job_id");
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

	
	public List<JobModel> getAllJobsByEmployeeId(int employeeId) {
	    List<JobModel> jobs = new ArrayList<>();
	    String query = "SELECT j.*, e.company_name FROM jobs j " +
	                   "JOIN employee_profile e ON j.employee_id = e.employee_id " +
	                   "WHERE j.employee_id = ?";

	    try (java.sql.Connection conn = MYSQL.getConnection();
	         java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {

	        pstmt.setInt(1, employeeId);
	        try (java.sql.ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                String jobId = rs.getString("job_id");
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
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return jobs;
	}

	
	public boolean updateJob(Map<String, Object> jobDetails) {
	    String jobId = String.valueOf(jobDetails.get("jobId"));
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

	    String query = "UPDATE jobs SET job_title=?, description=?, requirements=?, location=?, job_type=?, salary_min=?, salary_max=?, posted_at=?, expires_at=?, status=? WHERE job_id=?";

	    try (java.sql.Connection conn = MYSQL.getConnection();
	         java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {

	        pstmt.setString(1, jobTitle);
	        pstmt.setString(2, jobDescription);
	        pstmt.setString(3, requirements);
	        pstmt.setString(4, jobLocation);
	        pstmt.setString(5, jobType);
	        pstmt.setInt(6, Integer.parseInt(salaryMin));
	        pstmt.setInt(7, Integer.parseInt(salaryMax));
	        pstmt.setString(8, postedAt);
	        pstmt.setString(9, expiresAt);
	        pstmt.setString(10, status);
	        pstmt.setString(11, jobId);

	        int rowsAffected = pstmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}


	public boolean deleteJob(String jobId) {
		 	String query = "DELETE FROM jobs WHERE job_id = ?";

	try (java.sql.Connection conn = MYSQL.getConnection();
		 java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {

		pstmt.setString(1, jobId);
		int rowsAffected = pstmt.executeUpdate();
		return rowsAffected > 0;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}


	public List<JobModel> getAllPendingJobs() {
		List<JobModel> jobs = new ArrayList<>();
		String query = "SELECT j.*, e.company_name FROM jobs j " +
		               "JOIN employee_profile e ON j.employee_id = e.employee_id " +
		               "WHERE j.status = 'Pending'";
		try (java.sql.Connection conn = MYSQL.getConnection();
						     java.sql.PreparedStatement pstmt = conn.prepareStatement(query);
		     java.sql.ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				String jobId = rs.getString("job_id");
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
	
	public List<JobModel> getAllApprovedJobs() {
		List<JobModel> jobs = new ArrayList<>();
		String query = "SELECT j.*, e.company_name FROM jobs j " +
		               "JOIN employee_profile e ON j.employee_id = e.employee_id " +
		               "WHERE j.status = 'Open'";
		try (java.sql.Connection conn = MYSQL.getConnection();
						     java.sql.PreparedStatement pstmt = conn.prepareStatement(query);
		     java.sql.ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				String jobId = rs.getString("job_id");
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


	public boolean approveJobPosting(String jobId, int adminID) {
	    String getEmployeeQuery = "SELECT employee_id FROM jobs WHERE job_id = ?";
	    String getUserQuery = "SELECT user_id FROM employee_profile WHERE employee_id = ?";
	    String updateJobQuery = "UPDATE jobs SET status = 'Open' WHERE job_id = ?";
	    try (java.sql.Connection conn = MYSQL.getConnection()) {
	        // Get employee_id from jobs
	        int employeeId = -1;
	        try (java.sql.PreparedStatement pstmt = conn.prepareStatement(getEmployeeQuery)) {
	            pstmt.setString(1, jobId);
	            try (java.sql.ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    employeeId = rs.getInt("employee_id");
	                }
	            }
	        }
	        if (employeeId == -1) return false;

	        // Get user_id from employee_profile
	        int userId = -1;
	        try (java.sql.PreparedStatement pstmt = conn.prepareStatement(getUserQuery)) {
	            pstmt.setInt(1, employeeId);
	            try (java.sql.ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    userId = rs.getInt("user_id");
	                }
	            }
	        }
	        if (userId == -1) return false;

	        // Approve the job
	        try (java.sql.PreparedStatement pstmt = conn.prepareStatement(updateJobQuery)) {
	            pstmt.setString(1, jobId);
	            int rowsAffected = pstmt.executeUpdate();
	            if (rowsAffected > 0) {
	                AuditLogService.getInstance().InsertAuditLog(String.valueOf(adminID), "Job Approval", "Job ID: " + jobId + " approved.");
	                AlertService.getInstance().insertAlert("Your job posting (ID: " + jobId + ") has been approved.", userId);
	                return true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}


	public boolean deleteJobPosting(String jobId, int adminID) {
	  		String getEmployeeQuery = "SELECT employee_id FROM jobs WHERE job_id = ?";
		String getUserQuery = "SELECT user_id FROM employee_profile WHERE employee_id = ?";
		String deleteJobQuery = "DELETE FROM jobs WHERE job_id = ?";
		try (java.sql.Connection conn = MYSQL.getConnection()) {
			// Get employee_id from jobs
			int employeeId = -1;
			try (java.sql.PreparedStatement pstmt = conn.prepareStatement(getEmployeeQuery)) {
				pstmt.setString(1, jobId);
				try (java.sql.ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						employeeId = rs.getInt("employee_id");
					}
				}
			}
			if (employeeId == -1) return false;

			// Get user_id from employee_profile
			int userId = -1;
			try (java.sql.PreparedStatement pstmt = conn.prepareStatement(getUserQuery)) {
				pstmt.setInt(1, employeeId);
				try (java.sql.ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						userId = rs.getInt("user_id");
					}
				}
			}
			if (userId == -1) return false;

			// Delete the job
			try (java.sql.PreparedStatement pstmt = conn.prepareStatement(deleteJobQuery)) {
				pstmt.setString(1, jobId);
				int rowsAffected = pstmt.executeUpdate();
				if (rowsAffected > 0) {
					AuditLogService.getInstance().InsertAuditLog(String.valueOf(adminID), "Job Deletion", "Job ID: " + jobId + " deleted.");
					AlertService.getInstance().insertAlert("Your job posting (ID: " + jobId + ") has been deleted.", userId);
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean applyForJob(String jobId, int seekerId, int userId) {
	    String getEmployeeIdQuery = "SELECT employee_id FROM jobs WHERE job_id = ?";
	    String checkQuery = "SELECT COUNT(*) FROM application WHERE job_id = ? AND seeker_id = ?";
	    String insertQuery = "INSERT INTO application (job_id, seeker_id, employee_id, applied_at, status, recruiter_comments) VALUES (?, ?, ?, NOW(), 'Pending', 'n/a')";
	    try (java.sql.Connection conn = MYSQL.getConnection()) {
	        // Get employee_id from jobs
	        int employeeId = -1;
	        try (java.sql.PreparedStatement empStmt = conn.prepareStatement(getEmployeeIdQuery)) {
	            empStmt.setString(1, jobId);
	            try (java.sql.ResultSet rs = empStmt.executeQuery()) {
	                if (rs.next()) {
	                    employeeId = rs.getInt("employee_id");
	                }
	            }
	        }
	        if (employeeId == -1) return false;

	        // Check for existing application
	        try (java.sql.PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
	            checkStmt.setString(1, jobId);
	            checkStmt.setInt(2, seekerId);
	            try (java.sql.ResultSet rs = checkStmt.executeQuery()) {
	                if (rs.next() && rs.getInt(1) > 0) {
	                    // Application already exists
	                    return false;
	                }
	            }
	        }
	        // Insert new application
	        try (java.sql.PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
	            insertStmt.setString(1, jobId);
	            insertStmt.setInt(2, seekerId);
	            insertStmt.setInt(3, employeeId);
	            int rowsAffected = insertStmt.executeUpdate();
	            if (rowsAffected > 0) {
	                AlertService.getInstance().insertAlert("Applied for job ID: " + jobId, seekerId);
	                return true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	// In JobService.java

	public boolean saveJob(String jobId, int userId) {
	    String checkQuery = "SELECT COUNT(*) FROM saved_job WHERE job_id = ? AND user_id = ?";
	    String insertQuery = "INSERT INTO saved_job (job_id, user_id) VALUES (?, ?)";
	    try (java.sql.Connection conn = MYSQL.getConnection()) {
	        try (java.sql.PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
	            checkStmt.setString(1, jobId);
	            checkStmt.setInt(2, userId);
	            try (java.sql.ResultSet rs = checkStmt.executeQuery()) {
	                if (rs.next() && rs.getInt(1) > 0) {
	                    // Already saved
	                    return false;
	                }
	            }
	        }
	        try (java.sql.PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
	            insertStmt.setString(1, jobId);
	            insertStmt.setInt(2, userId);
	            int rowsAffected = insertStmt.executeUpdate();
	            return rowsAffected > 0;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}


	public List<JobModel> getSavedJobs(int userId) {
	    List<JobModel> jobs = new ArrayList<>();
	    String query = "SELECT j.*, e.company_name FROM saved_job s " +
	                   "JOIN jobs j ON s.job_id = j.job_id " +
	                   "JOIN employee_profile e ON j.employee_id = e.employee_id " +
	                   "WHERE s.user_id = ?";
	    try (java.sql.Connection conn = MYSQL.getConnection();
	         java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
	        pstmt.setInt(1, userId);
	        try (java.sql.ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                JobModel job = new JobModel(
	                    rs.getString("job_id"),
	                    rs.getString("job_title"),
	                    rs.getString("company_name"),
	                    rs.getString("description"),
	                    rs.getString("location"),
	                    rs.getString("requirements"),
	                    rs.getString("job_type"),
	                    rs.getString("salary_min"),
	                    rs.getString("salary_max"),
	                    rs.getString("posted_at"),
	                    rs.getString("expires_at"),
	                    rs.getString("status")
	                );
	                jobs.add(job);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return jobs;
	}



	public void deleteSavedJob(String jobId, int userId) {
		String query = "DELETE FROM saved_job WHERE job_id = ? AND user_id = ?";
		try (java.sql.Connection conn = MYSQL.getConnection();
		     java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, jobId);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public int getTotalJobsCreatedByEmployee(int employeeId) {
			String query = "SELECT COUNT(*) FROM jobs WHERE employee_id = ?";
	try (java.sql.Connection conn = MYSQL.getConnection();
		 java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
		pstmt.setInt(1, employeeId);
		try (java.sql.ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				return rs.getInt(1);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
	}


	public int getTotalJobsApprovedByEmployee(int employeeId) {
		String query = "SELECT COUNT(*) FROM jobs WHERE employee_id = ? AND status = 'Open'";
		try (java.sql.Connection conn = MYSQL.getConnection();
		 java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) { 
			
			pstmt.setInt(1, employeeId);
			try (java.sql.ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	public int getTotalJobsPendingByEmployee(int employeeId) {
		String query = "SELECT COUNT(*) FROM jobs WHERE employee_id = ? AND status = 'Pending'";
		try (java.sql.Connection conn = MYSQL.getConnection();
		 java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, employeeId);
			try (java.sql.ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	public int getTotalJobsOpenByEmployee(int employeeId) {
		String query = "SELECT COUNT(*) FROM jobs WHERE employee_id = ? AND status = 'Open'";
		try (java.sql.Connection conn = MYSQL.getConnection();
		 java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, employeeId);
			try (java.sql.ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}


	public int getTotalJobsClosedEmployee(int employeeId) {
	 		String query = "SELECT COUNT(*) FROM jobs WHERE employee_id = ? AND status = 'Closed'";
		try (java.sql.Connection conn = MYSQL.getConnection();
		 java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, employeeId);
			try (java.sql.ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


}
