package com.region.us.issues.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.region.us.issues.model.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {
	
	Issue findByTicketid(String ticketid);
	List<Issue> findByPriority(String priority);
	List<Issue> findBySeverity(String severity);
	List<Issue> findByCurrentstatus(String currentstatus);
	List<Issue> findByOpeneddate(String openeddate);
	List<Issue> findByCloseddate(String closeddate);
	List<Issue> findByLocation(String location);
	List<Issue> findByRegion(String region);

}
