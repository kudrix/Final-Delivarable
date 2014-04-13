/*
Feature 1: Login

As a user
I want to be able to login to the site
So that I can use the site.

Scenario: Unsuccessful Login (invalid password)
		Given PinRN.com is loaded
		And login page is open
		When username is user1 
		And password is foo
		Then user should get an error message: Sorry, unrecognized username or password.
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


public class Scen2_Steps {
	
	  private WebDriver driver;
	  private String baseUrl;
	  
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://pinrn.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Given("^PinRN.com is loaded$")
	  public void PinRN_com_is_loaded()  {
		    driver.get(baseUrl + "/pinboard/");
	  }

	  @Given("^login page is open$")
	  public void login_page_is_open() {
		    driver.findElement(By.linkText("Log in")).click();
	  }
	  
	  @When("^username is user(\\d+)$")
	  public void username_is_user(int arg1)  {
		   driver.findElement(By.id("edit-name")).clear();
		   driver.findElement(By.id("edit-name")).sendKeys("user1");
	  }

	  @When("^password is pass(\\d+)$")
	  public void password_is_pass(int arg1)  {
		  driver.findElement(By.id("edit-pass")).clear();
		  driver.findElement(By.id("edit-pass")).sendKeys("foo");
		  driver.findElement(By.id("edit-submit")).click();
	  }

	  @Then("^user should get an error message$")
	  public void user_should_get_an_error_message() {
		    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sorry, unrecognized username or password.[\\s\\S]*$"));
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }

	  
}
	

