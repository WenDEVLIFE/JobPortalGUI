package model;

public class UserModel {

	 String id;
	
	 String username;
	
	 String password;
	 String role;
	
 	 String status;
 	
 	 String createdAt;
 	
 	public UserModel(String id, String username, String password, String role, String status, String createdAt) {
 		this.id = id;
 		this.username = username;
 		this.password = password;
 		this.role = role;
 		this.status = status;
 		this.createdAt = createdAt;
 	}
 	
 	public String getId() {
 		return id;
 	}
 	
 	public String getUsername() {
 		return username;
 	}
 	
 	public String getPassword() {
 		return password;
 	}
 	
 	public String getRole() {
 		return role;
 	}
 	
 	public String getStatus() {
 		return status;
 	}
 	
 	public String getCreatedAt() {
 		return createdAt;
 	}
 	
 	
}
