package model;

public class AlertModel {

	private String alertId;
	
	private String description;
	
	private String timestamp;
	
	
	public AlertModel(String alertId, String description, String timestamp) {
		this.alertId = alertId;
		this.description = description;
		this.timestamp = timestamp;
	}
	
	
	public String getAlertId() {
		return alertId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	


}
