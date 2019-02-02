package com.region.us.issues.model;

import java.util.List;

public class Issues {
	
	private String region;
	private String location;
	List<Issue> issues;
	
	public Issues() {
	}
	
	public Issues(String region, String location, List<Issue> issues) {
		this.region = region;
		this.location = location;
		this.issues = issues;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

}
