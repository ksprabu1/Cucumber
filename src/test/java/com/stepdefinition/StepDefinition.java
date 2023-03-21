package com.stepdefinition;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;

import com.baseclass.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StepDefinition extends BaseClass {
	@Given("User Launch the url")
	public void user_launch_the_url() {
		getDriver("chrome");
		getUrl("https://www.google.co.in/");
	    
	}

	@When("User Click the Search box")
	public void user_click_the_search_box() {
		driver.findElement(By.xpath("//input[@name='q']")).click();
	    
	}

	@When("User Enter a term of {string}")
	public void user_enter_a_term_of(String string) {
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(string);
	}

	@When("User click the Enter button")
	public void user_click_the_enter_button() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	@Then("User Validate the page")
	public void user_validate_the_page() {
	    
		String actual = driver.getTitle();
		String Expected = "Google";
		Assert.assertEquals(Expected, actual);
	}

}
