package com.region.us.issues.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="issues", catalog="ittickets")
public class Issue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="ticketid")
	private String ticketid;
	@Column(name="description")
	private String description;
	@Column(name="priority")
	private String priority;
	@Column(name="severity")
	private String severity;
	@Column(name="currentstatus")
	private String currentstatus;
	@Column(name="openeddate")
	private String openeddate;
	@Column(name="closeddate")
	private String closeddate;
	@Column(name="location")
	private String location;
	@Column(name="region")
	private String region;
	
	public Issue() {
	}
	
	public Issue(String ticketid, String description, String priority, String severity,
			String currentstatus, String openeddate, String closeddate, String location, String region) {
		this.ticketid = ticketid;
		this.description = description;
		this.priority = priority;
		this.severity = severity;
		this.currentstatus = currentstatus;
		this.openeddate = openeddate;
		this.closeddate = closeddate;
		this.location = location;
		this.region = region;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTicketid() {
		return ticketid;
	}
	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getCurrentstatus() {
		return currentstatus;
	}
	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}
	public String getOpeneddate() {
		return openeddate;
	}
	public void setOpeneddate(String openeddate) {
		this.openeddate = openeddate;
	}
	public String getCloseddate() {
		return closeddate;
	}
	public void setCloseddate(String closeddate) {
		this.closeddate = closeddate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
}
