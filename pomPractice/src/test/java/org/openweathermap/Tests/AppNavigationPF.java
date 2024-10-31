package org.openweathermap.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openweathermap.Pages.LoginPF;
import org.openweathermap.Pages.HomePF;
import org.openweathermap.Utility.BrowserFactory;
import org.testng.annotations.Test;

public class AppNavigationPF {
	@Test(priority=3,groups={"navigation.menuNavigation"},description="test case for app navigation action")
	public void verifyMenuNavigationPF() {
		
		WebDriver driver=BrowserFactory.startBrowser("chrome", "urlGlobal");
		LoginPF loginPF=PageFactory.initElements(driver, LoginPF.class);
		HomePF homePF=PageFactory.initElements(driver, HomePF.class);
		String userEmail = BrowserFactory.getData(0, 0, 0);
		String password = BrowserFactory.getData(0, 0, 1);
		loginPF.enterWebsitePF(userEmail,password);
		try {
			//for clicking
			homePF.menuElementsClickPF();
		} catch (InterruptedException e) {
			// stack trace for interrupted exception
			e.printStackTrace();
		} catch (IOException e) {
			// stack trace for for IO exception 
			e.printStackTrace();
		}
		driver.quit();
		
	}
}
