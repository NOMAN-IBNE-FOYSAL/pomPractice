package org.openweathermap.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class HomePF {
	
WebDriver driver;
	
	public HomePF(WebDriver localDriver) {
		this.driver=localDriver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Signed in successfully')]")
    @CacheLookup
	public
    WebElement loginSuccessNotice;
	
	@FindBy(how = How.LINK_TEXT, using = "New Products")
    @CacheLookup
    WebElement newProductsMenu;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Services')]")
    @CacheLookup
    WebElement servicesMenu;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Billing plans')]")
    @CacheLookup
    WebElement billingPlansMenu;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Payments')]")
    @CacheLookup
    WebElement paymentsMenu;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Block logs')]")
    @CacheLookup
    WebElement blockLogsMenu;

	
	@FindBy(how = How.ID, using = "user-dropdown")
    @CacheLookup
    WebElement usernameDropdown;
	
	@FindBy(how = How.XPATH, using = "/html/body/nav/ul[1]/div/ul/li[11]/ul/li[5]/a")
    @CacheLookup
    WebElement logoutButton;
	
	public void exitWebsitePF() {
		usernameDropdown.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logoutButton.click();
	}
	
	public void menuElementsClickPF() throws InterruptedException,IOException {
		List<WebElement> menuItems = Arrays.asList(newProductsMenu, servicesMenu, billingPlansMenu,
				paymentsMenu, blockLogsMenu);
		 for (WebElement menuItem : menuItems) {
	            menuItem.click();
	            Thread.sleep(500);
				/*
				 * Thread.sleep(1000); // Scroll down the page JavascriptExecutor js =
				 * (JavascriptExecutor) driver;
				 * js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				 * 
				 * // Scroll up the page Thread.sleep(500);
				 * js.executeScript("window.scrollTo(0, 0);"); Thread.sleep(500);
				 */

		 }
	}
	
	
  
}
