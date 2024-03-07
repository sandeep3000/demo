package com_st_pages_test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_st_TestBase.TestBase;
import com_st_pages.homepage;
import com_st_pages.loginpage;

public class LoginPageTest extends TestBase{

	public LoginPageTest() throws IOException {
		super();
		
	}

	 loginpage LoginPage;
	 homepage HomePage;
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		LoginPage = new loginpage();
		//System.out.println("initialization methods is working fine");
	}
	
	@Test(priority =1)
	public void loginPageURLvalidation() throws IOException {
		String loginpageurl = LoginPage.validateloginPageurl();
		Assert.assertEquals(loginpageurl, "https://qa.thespicetag.com/login");
	}
	
	@Test(priority=2)
	public void logingpageImgLogoTest() throws IOException {
	 boolean flag =	LoginPage.validatelogo();
	 Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws IOException, InterruptedException {
		HomePage = 	LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
				//.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
	}
	
	
//	@AfterMethod
//	public void tearDown() 
//	{
//		driver.quit();
//	}

	
	
}
