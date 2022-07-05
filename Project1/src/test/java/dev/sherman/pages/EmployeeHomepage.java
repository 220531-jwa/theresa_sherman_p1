package dev.sherman.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeHomepage {

	
	//adding instance of WebDriver
	private WebDriver driver;
	
	//adding constructor creating an instance of this page, and also initializing the web elements on the page
	public EmployeeHomepage(WebDriver driver) {
		this.driver = driver;
		
	//adding next bit of code to work from the PageFactory
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//*[@id=\"getMyRequestsButton\"]")
	public WebElement getMyRequestsLink;
	
	@FindBy(xpath = "//*[@id=\"createNewRequestButton\"]")
	public WebElement createNewRequestsLink;
	
	@FindBy(xpath = "//*[@id=\"updateOpenRequestButton\"]")
	public WebElement updateOpenRequestLink;
}

