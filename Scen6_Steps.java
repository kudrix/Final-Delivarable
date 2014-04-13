/*
Feature 3: Search for a Pin 

As a user
I want to search for a specific Pin
So that I can get needed information

Scenario: Successful Pin search (exact match)

Given PinRn.com is loaded 
When the user types ‘An Introduction to Green Parenting’ in the search window
And clicks Enter
Then the system should display the ‘An Introduction to Green Parenting’ post
*/	

package com.bdd.PinRN_test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;


public class Scen6_Steps {
	
	  private WebDriver driver;
	  private String baseUrl;
	  
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://pinrn.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  	  
	  @Given("^PinRn.com is loaded$")
	  public void PinRn_com_is_loaded_and_the_user_is_NOT_logged() {
		    driver.get(baseUrl + "/pinboard/");
		    driver.findElement(By.linkText("Log in")).click();
		    driver.findElement(By.id("edit-name")).clear();
			driver.findElement(By.id("edit-name")).sendKeys("user1");
			driver.findElement(By.id("edit-pass")).clear();
			driver.findElement(By.id("edit-pass")).sendKeys("pass1");
			driver.findElement(By.id("edit-submit")).click();

	  }
	  
	  @When("^the user types ‘An Introduction to Green Parenting’ in the search window$")
	  public void the_user_types_An_Introduction_to_Green_Parenting_in_the_search_window() throws Throwable {
		    driver.findElement(By.linkText("Home")).click();
		    driver.findElement(By.id("edit-body-value")).clear();
		    driver.findElement(By.id("edit-body-value")).sendKeys("An Introduction to Green Parenting");
	  }

	  @When("^clicks Enter$")
	  public void clicks_Enter() throws Throwable {
		  driver.findElement(By.id("edit-submit-search")).click();

}

	  @Then("^the system should display the ‘An Introduction to Green Parenting’ post$")
	  public void the_system_should_display_the_An_Introduction_to_Green_Parenting_post() throws Throwable {
		    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*An Introduction to Green Parenting[\\s\\S]*$"));
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }

	  
}
	

