package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.PropertiesOperations;

public class TestBase 
{
	BrowserFactory bfactory=new BrowserFactory(); 
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeSuite
	public void setup()
	{
		
		htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tittle of Report
		htmlReporter.config().setReportName("Extent Report V4"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Browser", "Chrome");
		
	}
	
	@BeforeTest
	public void launchApplication() throws Exception
	{
		//String browser=PropertiesOperations.getPropertyValueByKey("browser");
		//String url=PropertiesOperations.getPropertyValueByKey("url");
		
		DriverFactory.getInstance().setDriver(bfactory.createBrowserInstance("chrome"));
		
		WebDriver driver=DriverFactory.getInstance().getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to("https://www.facebook.com");
	}
	
	@AfterMethod
	public void teardown()
	{
		DriverFactory.getInstance().closeBrowser();
	}
	
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}

}
