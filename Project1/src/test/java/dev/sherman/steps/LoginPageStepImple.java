package dev.sherman.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import dev.sherman.pages.LoginPage;
import dev.sherman.runner.LoginPageRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepImple {
	//adding glue code
	//add the WebDriver
	private static WebDriver driver = LoginPageRunner.driver;
	private static LoginPage loginPage = LoginPageRunner.loginPage;
	
	@Given("the employee is on the ERS login page")
	public void the_employee_is_on_the_ers_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.get("file:///C:/Users/tsher/Desktop/Project_1/theresa_sherman_p1/Project1/HTML/loginpage.html");
	}

	@When("the employee clicks on the login button as a Representative")
	public void the_employee_clicks_on_the_login_button_as_a_representative() {
	    // Write code here that turns the phrase above into concrete actions
	   loginPage.loginLink.click();
	}

	@Then("the title of the web page should be ERS Employee Home Page")
	public void the_title_of_the_web_page_should_be_ers_employee_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("the employee clicks on the login button as a Finance Manager")
	public void the_employee_clicks_on_the_login_button_as_a_finance_manager() {
	    // Write code here that turns the phrase above into concrete actions
	   assertEquals("Employee Reimbursement System", driver.getTitle());
	}

	@Then("the title of the web page should be ERS Finance Manager Home Page")
	public void the_title_of_the_web_page_should_be_ers_finance_manager_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

}
