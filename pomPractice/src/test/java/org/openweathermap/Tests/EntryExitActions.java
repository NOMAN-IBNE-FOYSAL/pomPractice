/**
 * 
 */
package org.openweathermap.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openweathermap.Pages.Login;
import org.testng.annotations.Test;

/**
 * @author noman
 *
 */
public class EntryExitActions {
	@Test
	public void verifyValidLogin() {
		System.setProperty("webdriver.gecko.driver", "D:\\eclipse\\drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://home.openweathermap.org/users/sign_in");
		
		Login login = new Login(driver);
		
		/*
		 * login.typeUserName("jepaga9375@wowcg.com");
		 * login.typePassword("vtH5Dmfp9HKj322"); login.clickSubmit();
		 */
		
		login.enterWebsite("jepaga9375@wowcg.com", "vtH5Dmfp9HKj322");
		
		driver.quit();
		
	}

}
