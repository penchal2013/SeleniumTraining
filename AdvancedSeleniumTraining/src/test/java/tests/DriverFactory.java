package tests;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	
	  //singleton design pattern, static means we will have one copy of variable
	   private DriverFactory()
	  {
	 
	  }
	  
	 private static DriverFactory instance=new DriverFactory(); 
	 
	 public static DriverFactory getInstance() 
	 { return instance; 
	 
	 }
	 
	
	// Factory Design Pattern--> going to create separate factory method for creating objects
	
	
	ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();// which provides thread local variable
	//Current thread 
	public WebDriver getDriver()  
	{
		return driver.get();
	}
	public void setDriver(WebDriver driverparam)
	{
		 driver.set(driverparam);
	}
	
	public void closeBrowser()
	{
		
		driver.get().quit();
		driver.remove(); //it will remove driver copy
	}

}
