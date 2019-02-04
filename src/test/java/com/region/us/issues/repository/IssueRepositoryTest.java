package com.region.us.issues.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.region.us.issues.model.Issue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IssueRepositoryTest {
	
//    @Autowired
//    private TestEntityManager entityManager;
    
    @Autowired
    private IssueRepository issueRepository;
    
    public void saveTest() throws Exception {
    	Issue issue = new Issue("Test001", "Interation Test001", "P02", "S03", 
    			"Test Staus", "02-03-2019", "", "41.711562, -122.448632", "US");
    	issueRepository.save(issue);
    	Assert.assertNotNull(issueRepository.findByTicketid("Test001"));
    }
    
    public List<String> getLocationTest() throws Exception {
    	List<String> locations = new ArrayList<String>();
    	Assert.assertNotNull(issueRepository.findAll());
    	List<Issue> issues = issueRepository.findAll();
    	for(Issue issue: issues) {
    		locations.add(issue.getLocation());
    	}
    	Assert.assertNotNull(locations);
    	return locations;
    }
}
