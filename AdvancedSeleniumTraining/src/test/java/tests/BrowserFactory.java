package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory 
{
	
	public WebDriver createBrowserInstance(String browser)
	{
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--incognito");
			driver=new ChromeDriver(options);		
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions=new FirefoxOptions();
			foptions.addArguments("-private");
			driver=new FirefoxDriver(foptions);		
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions ioptions=new InternetExplorerOptions();
			ioptions.addCommandSwitches("-private");
			driver=new InternetExplorerDriver(ioptions);		
		}
		
		return driver;
		
	}
	
	
	

}
