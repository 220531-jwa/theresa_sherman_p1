package dev.sherman.runner;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.sherman.pages.LoginPage;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resouces", glue = "dev.sherman.steps")
public class LoginPageRunner {

	//adding driver and an instance of our LoginPage POM
	public static WebDriver driver;
	public static LoginPage loginPage;
	
	//adding chromedriver
	@BeforeAll
	public static void setup() {
	File chrome = new File("src/test/resources/chromedrive.exe");
	System.setProperty("Webdriver.chrome.driver", chrome.getAbsolutePath());
	
	driver = new ChromeDriver();
	//checking why program is terminating- possibly the driver?
	System.out.println("inside setup method");
	//initializing our page
	loginPage = new LoginPage(driver);
	}
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}
