package model;

public class  AuditModel {

	String auditId;
	
	String Username;
	
	String actionType;
	
	String resourceType;
	
	String timestamp; 
	
	 public AuditModel(String auditId, String Username, String actionType, String resourceType, String timestamp) {
		this.auditId = auditId;
		this.Username = Username;
		this.actionType = actionType;
		this.resourceType = resourceType;
		this.timestamp = timestamp;
	}
	 
	 public String getAuditId() {
		return auditId;
	}
	 
	 public String getUsername() {
		return Username;
	}
	 
	 public String getActionType() {
		 return actionType;
	 }
	 
	 public String getResourceType() {
		 return resourceType;
	 }
	 
	 public String getTimestamp() {
		 return timestamp;
	 }
	 
	 
	 
} 
