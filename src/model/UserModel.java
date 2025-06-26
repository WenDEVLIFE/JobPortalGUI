package model;

public class UserModel {

	private String id;
	
	private String username;
	
	private String password;
	
	private String role;
	
 	private String status;
 	
 	public UserModel(String id, String username, String password, String role, String status) {
 		this.id = id;
 		this.username = username;
 		this.password = password;
 		this.role = role;
 		this.status = status;
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
 	
 	
}
