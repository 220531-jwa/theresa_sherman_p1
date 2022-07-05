package dev.sherman.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	//adding instance of WebDriver
	private WebDriver driver;
	
	//adding constructor creating an instance of this page, and also initializing the web elements on the page
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	//adding next bit of code to work from the PageFactory
		PageFactory.initElements(driver,this);
	}
	@FindBy(id ="loginButton")
	public WebElement loginLink;
}
