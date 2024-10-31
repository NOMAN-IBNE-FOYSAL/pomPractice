package org.openweathermap.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openweathermap.ExtentManager.ExtentManager;
import org.openweathermap.Pages.HomePF;
import org.openweathermap.Pages.LoginPF;
import org.openweathermap.Utility.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class EntryExitActionsPF {
	
	
	
	@Test(priority=1,groups={"login.loginAction"},description="test case for login action")
	public void verifyValidLoginPF() {
		
		WebDriver driver=BrowserFactory.startBrowser("chrome", "urlGlobal");
		LoginPF loginPF=PageFactory.initElements(driver, LoginPF.class);
		String userEmail = BrowserFactory.getData(0, 0, 0);
		String password = BrowserFactory.getData(0, 0, 1);
		loginPF.enterWebsitePF(userEmail,password);
		driver.quit();
		
	}
	@Test(priority=2,groups={"login.loginLogoutAction"},description="test case for login, assert and logout action")
	public void verifyValidLoginLogoutPF() {
		WebDriver driver=BrowserFactory.startBrowser("firefox", "urlGlobal");
		LoginPF loginPF=PageFactory.initElements(driver, LoginPF.class);
		HomePF homePF=PageFactory.initElements(driver, HomePF.class);
		String userEmail = BrowserFactory.getData(0, 0, 0);
		String password = BrowserFactory.getData(0, 0, 1);
		loginPF.enterWebsitePF(userEmail,password);
		Assert.assertTrue(homePF.loginSuccessNotice.isDisplayed());
		homePF.exitWebsitePF();
		driver.quit();
	}
	

}
