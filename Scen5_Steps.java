/*
Feature 2: Add a new Pin
	As a user
	I want to post a new pin
	So that I can share it with other users

Scenario 5: Unsuccessful Pin posting (user not logged in)
    Given PinRn.com is loaded 
	When user clicks ‘Add+’ button
	Then the system should redirect user to the login page
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


public class Scen5_Steps {
	
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
	  }
	  
	  @When("^user clicks ‘Add+’ button$")
	  public void user_clicks_Add_button()  {
		  driver.findElement(By.linkText("+ Add")).click();
	  }
	  
	  @Then("^the system should redirect user to the login page$")
	  public void the_system_should_redirect_user_to_the_registration_page() throws Throwable {
		    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Enter your PinRN username.[\\s\\S]*$"));
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }

	  
}
	

