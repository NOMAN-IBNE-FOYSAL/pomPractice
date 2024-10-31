package org.openweathermap.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPF {
	
	WebDriver driver;
	
	public LoginPF(WebDriver localDriver) {
		this.driver=localDriver;
	}
	
	@FindBy(id="user_email")
	//@CacheLookup
	WebElement uEmail;
	
	@FindBy(how=How.ID,using="user_password")
	//@CacheLookup
	WebElement uPass;
	
	@FindBy(how=How.NAME,using="commit")
	//@CacheLookup
	WebElement submitButton;
	
	
	
	
	public void enterWebsitePF(String userEmail, String userPassword) {
		uEmail.sendKeys(userEmail);
		uPass.sendKeys(userPassword);
		submitButton.click();
	}
	

}
