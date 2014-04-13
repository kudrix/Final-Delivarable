/*
Feature 2: Add a new Pin
	As a user
	I want to post a new pin
	So that I can share it with other users

Scenario: Successful pin posting
    Given PinRN.com is loaded
	And user is logged in
	When Add button is clicked
	And ‘Add a Pin’ is chosen 
	And following URL is pasted ‘http://healthychild.org/easy-steps/skip-the-triclosan-and-other-antibacterial-products/’
	And image selected
	And board name selected
	And Save is clicked
	Then user should be informed that Pin has been created
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


public class Scen4_Steps {
	
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

	  @Given("^user is logged in$")
	  public void the_user_is_logged_in() throws Throwable {
		  driver.get(baseUrl + "/pinboard/");
		  driver.findElement(By.linkText("Log in")).click();
		  driver.findElement(By.id("edit-name")).clear();
		  driver.findElement(By.id("edit-name")).sendKeys("user1");
		  driver.findElement(By.id("edit-pass")).clear();
		  driver.findElement(By.id("edit-pass")).sendKeys("pass1");
		  driver.findElement(By.id("edit-submit")).click();
	  }
	  
	  @When("^Add button is clicked$")
	  public void Add_button_is_clicked() throws Throwable {
		  driver.findElement(By.linkText("+ Add")).click();
	  }

	  @When("^‘Add a Pin’ is chosen$")
	  public void _Add_a_Pin_is_chosen() throws Throwable {
		    driver.findElement(By.cssSelector("div.PinButtonB > a > span")).click();

	  }
	  @When("^following URL is pasted ‘http://healthychild.org/easy-steps/skip-the-triclosan-and-other-antibacterial-products/’$")
	  public void following_URL_is_pasted_http_healthychild_org_easy_steps_skip_the_triclosan_and_other_antibacterial_products_() throws Throwable {
		  driver.findElement(By.id("edit-urlimg")).clear();
		    driver.findElement(By.id("edit-urlimg")).sendKeys("http://healthychild.org/easy-steps/skip-the-triclosan-and-other-antibacterial-products/");
		    driver.findElement(By.id("edit-submit")).click();
	  }
	  @When("^image selected$")
	  public void image_selected() throws Throwable {
		    driver.findElement(By.cssSelector("div.blkfn > a > img")).click();	    
	  }
	  
	  @When("^board name selected$")
	  public void board_name_selected() throws Throwable {
		  driver.findElement(By.id("edit-pinboard-board")).clear();
		  driver.findElement(By.id("edit-pinboard-board")).sendKeys("Chemicals");  
	  }

	  @When("^Save is clicked$")
	  public void Save_is_clicked() throws Throwable {
		    driver.findElement(By.id("edit-submit")).click();

	  }
	  @Then("^user should be informed that Pin has been created$")
	  public void user_should_be_informed_that_Pin_has_been_created() throws Throwable {
		    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My account[\\s\\S]*$"));
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }

	  
}
	

