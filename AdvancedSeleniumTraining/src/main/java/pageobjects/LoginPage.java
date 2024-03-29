package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage
{
	public static WebDriver driver;
	@FindBy(name="email")
	public WebElement userName_textbox;
	
	@FindBy(xpath="//input[@id='pass']")
	public WebElement password_txtbox;
	
	@FindBy(name="login")
	public WebElement logInButton;
	
	@FindBy(linkText="Create New Account")
	public WebElement CreateNewAccountBtn;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//log into app
	public void login(String email,String password) throws InterruptedException
	{
		Thread.sleep(1000);
		//userName_textbox.sendKeys(email);
		
		//driver.findElement(By.id("email")).sendKeys(email);
		//password_txtbox.sendKeys(password);
		
		//logInButton.click();
		System.out.println("Login page executed");
		
	}
	
	public void createnewaccount()
	{
		
	}

}
