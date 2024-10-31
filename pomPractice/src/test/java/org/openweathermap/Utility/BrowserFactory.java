package org.openweathermap.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	static Properties pro;
	static XSSFWorkbook wb;
	static XSSFSheet sheet1;
	public static void readConfig() {
		try {
			File src=new File("./Configuration/Configuration.property");
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void readExcel() {
		//reading configuration
				readConfig();
		try {
			File src1=new File(pro.getProperty("excelPath"));
			FileInputStream fis1=new FileInputStream(src1);
			wb=new XSSFWorkbook(fis1);
			
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
	
	public static String getData(int sheetNumber,int row,int column) {
		//reading excel
		readExcel();
		sheet1=wb.getSheetAt(0);
		String data1= sheet1.getRow(row).getCell(column).getStringCellValue();
		return data1;
	}
	
	public static WebDriver startBrowser(String browserName, String url) {
		//reading configuration
		readConfig();
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", pro.getProperty("firefoxDriver"));
			driver=new FirefoxDriver();
		}
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", pro.getProperty("chromeDriver"));
			ChromeOptions co = new ChromeOptions();
			co.setBinary("CTFA");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(pro.getProperty(url));
		
		return driver;
	}

}
