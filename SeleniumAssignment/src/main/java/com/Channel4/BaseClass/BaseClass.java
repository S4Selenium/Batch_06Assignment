package com.Channel4.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.Channel4.Actions.SeleniumActions;
import com.Channel4.PageObjects.Channel4HomePage;


public class BaseClass {
	public static Properties prop;
	public static SeleniumActions action;
	public static Channel4HomePage Hp;
	//Thread local driver
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();

	@BeforeSuite
	public void loadingfiles() {
		DOMConfigurator.configure("log4j.xml");
		 
	}
    @Parameters("Browser")
	@BeforeMethod
	public void launch(String Browser) {
    	launchApp(Browser);
    Hp=new Channel4HomePage();
		
	}

	@BeforeTest
	public void loadConfig() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configurations\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	

	public void launchApp(String browserName) {
	
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());

		}
		
		getDriver().manage().window().maximize();	
		action = new SeleniumActions();		
		action.implicitWait(getDriver(), 15);
		action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));

	}
	
	
	@AfterMethod
	public void user_logout() {
		
		getDriver().quit();
	}


	@AfterSuite
	public void Teardown() {

	}


}