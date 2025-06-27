package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DashboardService {

	
	private static volatile DashboardService instance;
	
	public static DashboardService getInstance() {
		if (instance == null) {
			synchronized (DashboardService.class) {
				if (instance == null) {
					instance = new DashboardService();
				}
			}
		}
		return instance;
	}
	
    public int getAdminCount() {
		String query = "SELECT COUNT(*) FROM users WHERE role = 'Admin'";
		try (Connection conn = MYSQL.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(query)) {
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    		return 0;
    }
    
    public int getJobSeekerCount() {
    	  		String query = "SELECT COUNT(*) FROM users WHERE role = 'Job Seeker'";
    	  				try (Connection conn = MYSQL.getConnection(); 
		  						PreparedStatement pstmt = conn.prepareStatement(query)) {
		  					ResultSet rs = pstmt.executeQuery();
		  					if (rs.next()) {
		  						return rs.getInt(1);
		  					}
		  				} catch (Exception e) {
		  					e.printStackTrace();
		  				}
		  		return 0;
    	  						
    	  								
    	  						
    }
    
    public int getEmployeeAndRecruiterCount() {
    	 		String query = "SELECT COUNT(*) FROM users WHERE role IN ('Employee', 'Recruiter')";
    	 		try (Connection conn = MYSQL.getConnection(); 
						PreparedStatement pstmt = conn.prepareStatement(query)) {
    	 			 
    	 				ResultSet rs = pstmt.executeQuery();
		 				if (rs.next()) {
		 					return rs.getInt(1);
		 				}
		 			} catch (Exception e) {
		 				e.printStackTrace();
		 			}
		 			return 0;
    }
    
    public int getJobOpeningsCount() {
    	 
    		String query = "SELECT COUNT(*) FROM jobs WHERE status = 'Open'";
			try (Connection conn = MYSQL.getConnection(); 
						PreparedStatement pstmt = conn.prepareStatement(query)) {
		 			ResultSet rs = pstmt.executeQuery();
		 			if (rs.next()) {
		 				return rs.getInt(1);
		 			}
		 	} catch (Exception e) {
		 			e.printStackTrace();
		 	}
		 	return 0;
    }
    
    public int getApplicationsCount() {
			String query = "SELECT COUNT(*) FROM applications";
			try (Connection conn = MYSQL.getConnection(); 
						PreparedStatement pstmt = conn.prepareStatement(query)) {
		 			ResultSet rs = pstmt.executeQuery();
		 			if (rs.next()) {
		 				return rs.getInt(1);
		 			}
		 	} catch (Exception e) {
		 			e.printStackTrace();
		 	}
					 	return 0;
	}
    
    
    public int getPendingJobsCount() {
		String query = "SELECT COUNT(*) FROM jobs WHERE status = 'Pending'";
		try (Connection conn = MYSQL.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(query)) {
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
    
     public int getApprovedJobsCount() {
		String query = "SELECT COUNT(*) FROM jobs WHERE status = 'Open'";
		try (Connection conn = MYSQL.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(query)) {
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
     
    public int getJobClosedCount() {
    	
    			String query = "SELECT COUNT(*) FROM jobs WHERE status = 'Closed'";
    			try (Connection conn = MYSQL.getConnection(); 
						PreparedStatement pstmt = conn.prepareStatement(query)) {
					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) {
						return rs.getInt(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
    							return 0;
    }
    	 				
    	 				
    	 				
   
    
}
