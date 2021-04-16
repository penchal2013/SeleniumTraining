package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pageobjects.LoginPage;

public class LoginTest extends TestBase
{
	public WebDriver driver;
	LoginPage lp=new LoginPage(driver);
	
	
	@Test(priority=1)
	public void loginTestCase() throws Exception
	{
		 extent.createTest("Test Case 1", "PASSED test case");
		//test.log(Status.INFO, "Usage of log");
		
		
        Assert.assertTrue(true);
		System.out.println("First Login test case");
		lp.login("penchal2013@gmail.com", "test123");
		
		
		
	}

	@Test(priority=2)
	public void TestCase2() throws Exception
	{
		ExtentTest test=extent.createTest("Test Case 2", "Failed test case");
		test.fail("fail");
		 
         Assert.fail("fail");
		
	}
	
	
	
}
