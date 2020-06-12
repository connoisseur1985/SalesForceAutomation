package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;

public class TrialTestPage extends TestBase{
	
	public TrialTestPage() throws IOException{
		
		super();
		
	}

	@BeforeTest
	public void setup() {
		
		initialize();
	}
	
	@Test
	public void login() {
		
				
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("Login")).click();
		Assert.assertEquals(driver.getTitle(),"Home | Salesforce");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
