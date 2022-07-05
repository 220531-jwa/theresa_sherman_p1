package dev.sherman.runner;

	import java.io.File;

	import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.BeforeAll;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import dev.sherman.pages.FinanceManagerHomepage;
	import io.cucumber.junit.CucumberOptions;
	
	@CucumberOptions(features = "src/test/resources", glue = "dev.sherman.steps")
	public class FinanceManagerHomepageRunner {

		//adding driver and an instance of our FinanceManagerHomepage POM
		public static WebDriver driver;
		public static FinanceManagerHomepage financeManagerHomepage;
		
		//adding chromedriver
		@BeforeAll
		public static void setup() {
		File chrome = new File("src/test/resources/chromedrive.exe");
		System.setProperty("Webdriver.chrome.driver", chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		//initializing our page
		financeManagerHomepage = new FinanceManagerHomepage(driver);
		}
		@AfterAll
		public static void teardown() {
			driver.quit();
		}
	}


