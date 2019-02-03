package com.region.us.issues.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.region.us.issues.model.Issue;
import com.region.us.issues.repository.IssueRepository;

@RestController
@RequestMapping("/api/issues")
public class IssueTrackerService {
	
	private static final Logger logger = LoggerFactory.getLogger(IssueTrackerService.class);
	
	@Autowired
	public IssueRepository issueRepository;
	
	public IssueTrackerService(IssueRepository issueRepository) {
		this.issueRepository = issueRepository;
	}
	
	@GetMapping("/alltickets")
	public List<Issue> getAllIssues() {
		return issueRepository.findAll();
	}
	
	
	@GetMapping("/locations")
	public List<String> getlocations() {
		List<Issue> issues =  issueRepository.findAll();
		List<String> locations = new ArrayList<String>();
		for(Issue issue: issues) {
			locations.add(issue.getLocation());
		}		
		return locations;
	}
	
	@GetMapping("/ticketid/{ticketid}")
	public Issue getIssueByTicketid(@PathVariable("ticketid") final String ticketid) {
		logger.info("ticketid" + ticketid);
		return issueRepository.findByTicketid(ticketid);
	}
	
	@GetMapping("/priority/{priority}")
	public List<Issue> getIssueByPriority(@PathVariable("priority") final String priority) {
		logger.info("priority" + priority);
		return issueRepository.findByPriority(priority).stream().collect(Collectors.toList());
	}
	
	@GetMapping("/severity/{severity}")
	public List<Issue> getIssueBySeverity(@PathVariable("severity") final String severity) {
		logger.info("ticketid" + severity);
		return issueRepository.findBySeverity(severity).stream().collect(Collectors.toList());
	}
	
	@GetMapping("/currentstatus/{currentstatus}")
	public List<Issue> getIssueByStatus(@PathVariable("currentstatus") final String currentstatus) {
		logger.info("currentstatus" + currentstatus);
		return issueRepository.findByCurrentstatus(currentstatus).stream().collect(Collectors.toList());
	}

	@GetMapping("/openeddate/{openeddate}")
	public List<Issue> getIssueByOpeneddate(@PathVariable("openeddate") final String openeddate) {
		logger.info("openeddate" + openeddate);
		return issueRepository.findByOpeneddate(openeddate).stream().collect(Collectors.toList());
	}
	
	@GetMapping("/closeddate/{closeddate}")
	public List<Issue> getIssueByCloseddate(@PathVariable("closeddate") final String closeddate) {
		logger.info("closeddate" + closeddate);
		return issueRepository.findByCloseddate(closeddate).stream().collect(Collectors.toList());
	}
	
	@GetMapping("/location/{location}")
	public List<Issue> getIssueByLocation(@PathVariable("location") final String location) {
		logger.info("location" + location);
		return issueRepository.findByLocation(location).stream().collect(Collectors.toList());
	}
	
	@GetMapping("/region/{region}")
	public List<Issue> getIssueByRegion(@PathVariable("region") final String region) {
		logger.info("region" + region);
		return issueRepository.findByRegion(region).stream().collect(Collectors.toList());
	}

	
	@PostMapping("/create")
	public Issue createTicket(@RequestBody final Issue issue) {
		issueRepository.save(issue);
		return getIssueByTicketid(issue.getTicketid());
	}
	
	
	@PostMapping("/createbulk")
	public List<Issue> createTicket(@RequestBody final List<Issue> issues) {
		
		List<Issue> tickets = new ArrayList<Issue>();		
		for(Issue issue:issues) {
			issueRepository.save(issue);
			tickets.add(getIssueByTicketid(issue.getTicketid()));
		}
		return tickets;
	}
	
	
	@PostMapping("/delete/{ticketid}")
	public Issue delete(@PathVariable("ticketid") final String ticketid) {
		Issue issue = issueRepository.findByTicketid(ticketid);
		issueRepository.delete(issue);		
		return getIssueByTicketid(ticketid);
	}
}
