package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageobjects.LoginPage;

public class TitleTest extends TestBase
{
	public WebDriver driver;
	LoginPage lp=new LoginPage(driver);
	
	
	
	@Test
	public void TestCase2() throws Exception
	{
		ExtentTest test=extent.createTest("Test Case 2", "Failed test case");
		test.fail("fail");
		 
         Assert.fail("fail");
		
	}


}
