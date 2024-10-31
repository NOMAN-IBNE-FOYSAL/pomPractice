/**
 * 
 */
package org.openweathermap.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author noman
 *
 */
public class Login {
	WebDriver driver;
	
	By useremail = By.id("user_email");
	By password = By.id("user_password");
	By loginButton = By.name("commit");
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	public void typeUserName(String userEmail) {
		driver.findElement(useremail).sendKeys(userEmail); //jepaga9375@wowcg.com
	}
	
    public void typePassword(String passWord) {
    	driver.findElement(password).sendKeys(passWord); //vtH5Dmfp9HKj322
	}
    
    public void clickSubmit() {
    	driver.findElement(loginButton).click();
	}
	
    public void enterWebsite(String userMail,String pass) {
    	driver.findElement(useremail).sendKeys(userMail); //jepaga9375@wowcg.com
    	driver.findElement(password).sendKeys(pass); //vtH5Dmfp9HKj322
    	driver.findElement(loginButton).click();
    }
	
	

}
