package model;

public class JobModel {
	
	private String jobId;
	
	private String jobTitle;
	
	private String companyName;
	
	private String jobDescription;
	
	private String jobLocation;
	
	private String requirements;
	
	private String jobType;
	
	private String salaryMin;
	
	private String salaryMax;
	
	private String postedDate;
	
	private String expirationDate;
	
	private String status;
	
	public JobModel(String jobId, String jobTitle, String companyName, String jobDescription, String jobLocation,
			String requirements, String jobType, String salaryMin, String salaryMax, String postedDate,
			String expirationDate, String status) {
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.requirements = requirements;
		this.jobType = jobType;
		this.salaryMin = salaryMin;
		this.salaryMax = salaryMax;
		this.postedDate = postedDate;
		this.expirationDate = expirationDate;
		this.status = status;
	}
	
	public String getJobId() {
		return jobId;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public String getJobDescription() {
		return jobDescription;
	}
	
	public String getJobLocation() {
		return jobLocation;
	}
	
	public String getRequirements() {
		return requirements;
	}
	
	public String getJobType() {
		return jobType;
	}
	
	public String getSalaryMin() {
		return salaryMin;
	}
	
	
	public String getSalaryMax() {
		return salaryMax;
	}
	
	public String getPostedDate() {
		return postedDate;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	

	
	

}
