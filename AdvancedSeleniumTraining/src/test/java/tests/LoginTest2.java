package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class LoginTest2 extends TestBase
{
	public WebDriver driver;
	LoginPage lp=new LoginPage(driver);
	@Test
	public void loginTestCase() throws Exception
	{
		System.out.println("First Login test case");
		lp.login("penchal2013@gmail.com", "test123");
	}

}
