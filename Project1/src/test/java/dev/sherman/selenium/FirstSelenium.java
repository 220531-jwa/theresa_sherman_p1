package dev.sherman.selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {

	public static void main(String[] args) {
		File chrome = new File("src/test/resources/chromedrive.exe");
		System.setProperty("Webdriver.chrome.driver", chrome.getAbsolutePath());
		
		WebDriver driver = new ChromeDriver();
		
		//load a web page in our automated browser
		driver.get("http://localhost:8081/login/");
		
		WebElement usernameInput = driver.findElement(By.xpath("//*[@id="usernameInput"]"));
		
		usernameInput.sendKeys("tsherman" + Keys.ENTER);
//		
//		// if you want to visually verify yourself that it's working
//		// you could use thread.sleep() but better to use a wait 
//		// for DEMONSTRATION ONLY
//		// Thread.sleep(3000);
//		
//		// but there is a way to take a screen shot - if you did want to store images to manually or visually verify anything
//		
//		// just like with our Scanner - we need to close resources when we're done with them.
//		// WebDriver has two methods
//		// .close() - will close the current browser window only
//		// .quit() - will close the cureent browser window - along with any other windows that are open - and 'destroy' the driver instance
		driver.quit();
//	}

}
}
