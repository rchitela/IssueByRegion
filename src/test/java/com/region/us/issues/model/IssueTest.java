package com.region.us.issues.model;

import com.region.us.issues.assertions.AssertAnnotations;
import com.region.us.issues.assertions.ReflectTool;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.junit.Assert;
import org.junit.Test;

public class IssueTest {
	
	  @Test
	  public void typeAnnotations() {
		  // assert
		  AssertAnnotations.assertType(Issue.class, Entity.class, Table.class);
	  }
	  
	  @Test
	  public void fieldAnnotations() {
	    // assert
	    AssertAnnotations.assertField(Issue.class, "id");
	    AssertAnnotations.assertField(Issue.class, "ticketid");
	    AssertAnnotations.assertField(Issue.class, "description");
	    AssertAnnotations.assertField(Issue.class, "priority");	    
	    AssertAnnotations.assertField(Issue.class, "severity");
	    AssertAnnotations.assertField(Issue.class, "currentstatus");
	    AssertAnnotations.assertField(Issue.class, "openeddate");
	    AssertAnnotations.assertField(Issue.class, "closeddate");
	    AssertAnnotations.assertField(Issue.class, "location");
	    AssertAnnotations.assertField(Issue.class, "region");
	  }
	  

	  @Test
	  public void methodAnnotations() {
		  // assert
		  AssertAnnotations.assertMethod(
				  Issue.class, "getId", Id.class, GeneratedValue.class);
		  AssertAnnotations.assertMethod(
				  Issue.class, "getTicketid", Column.class);
		  AssertAnnotations.assertMethod(
				  Issue.class, "getDescription", Column.class);
		  AssertAnnotations.assertMethod(
				  Issue.class, "getPriority", Column.class);
		  AssertAnnotations.assertMethod(
				  Issue.class, "getSeverity", Column.class);
		  AssertAnnotations.assertMethod(
				  Issue.class, "getCurrentstatus", Column.class);
		  AssertAnnotations.assertMethod(
				  Issue.class, "getOpeneddate", Column.class);
		  AssertAnnotations.assertMethod(
				  Issue.class, "getCloseddate", Column.class);
		  AssertAnnotations.assertMethod(
				  Issue.class, "getLocation", Column.class);
		  AssertAnnotations.assertMethod(
				  Issue.class, "getRegion", Column.class);	
	    
	  }
	  

	  @Test
	  public void entity() {
		  // setup
		  Entity entity = ReflectTool.getClassAnnotation(Issue.class, Entity.class);
		  // assert
		  Assert.assertEquals("", entity.name());
	  }	  

	  @Test
	  public void table() {
		  // setup
		  Table table = ReflectTool.getClassAnnotation(Issue.class, Table.class);
		  // assert
		  Assert.assertEquals("issues", table.name());
	  }	  

	  @Test
	  public void id() {
		  // setup
		  GeneratedValue value = ReflectTool.getMethodAnnotation(
				  Issue.class, "getId", GeneratedValue.class);
		  // assert
		  Assert.assertEquals("", value.generator());
		  Assert.assertEquals(GenerationType.AUTO, value.strategy());
	  }
	  

	  @Test
	  public void ticketid() {
		  // setup
		  Column column = ReflectTool.getMethodAnnotation(
				  Issue.class, "getTicketid", Column.class);
		  // assert
		  Assert.assertEquals("ticketid", column.name());
	  }

}
