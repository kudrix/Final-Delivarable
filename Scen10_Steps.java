/*
Feature: Invite a friend

As a user
I want to invite a friend
So that he can join the site 

Scenario: Successful invite
Given the user is logged in
When user clicks ‘Invite a friend’ link
And types ‘svk6@pitt.edu’ in ‘To’ text window
And clicks ‘Send invite in email’ button
Then the system should display message: ‘Your invitation has been successfully sent.
 You will be notified when the invitee joins the site.’

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


public class Scen10_Steps {
	
	  private WebDriver driver;
	  private String baseUrl;
	  
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://pinrn.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  	  
	  @Given("^the user is logged in$")
	  public void the_user_is_logged_in() throws Throwable {
		    driver.get(baseUrl + "/pinboard/");
		    driver.findElement(By.linkText("Log in")).click();
		    driver.findElement(By.id("edit-name")).clear();
			driver.findElement(By.id("edit-name")).sendKeys("user1");
			driver.findElement(By.id("edit-pass")).clear();
			driver.findElement(By.id("edit-pass")).sendKeys("pass1");
			driver.findElement(By.id("edit-submit")).click();

	  }
	  

	  @When("^user clicks ‘Invite a friend’ link$")
	  public void user_clicks_Invite_a_friend_link() throws Throwable {
		    driver.findElement(By.linkText("Invite a friend")).click();
	  }


	  @When("^types ‘svk6@pitt.edu’ in ‘To’ text window$")
	  public void types_kudrix_bk_ru_in_To_text_window() throws Throwable {
		  driver.findElement(By.id("edit-email")).clear();
		  driver.findElement(By.id("edit-email")).sendKeys("svk6@pitt.edu");
	  }

	  @When("^clicks ‘Send invite in email’ button$")
	  public void clicks_Send_invite_in_email_button() throws Throwable {
		    driver.findElement(By.id("edit-submit")).click();
	  }
	  @Then("^the system should display message: ‘Your invitation has been successfully sent. You will be notified when the invitee joins the site.’$")
	  public void the_system_should_display_message_The_following_recipient_is_already_a_member() throws Throwable {
		    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Your invitation has been successfully sent. You will be notified when the invitee joins the site.[\\s\\S]*$"));

	  }
	 
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }

	  
}
	

