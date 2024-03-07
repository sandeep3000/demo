package com_st_pages_test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com_st_TestBase.TestBase;
import com_st_pages.homepage;
import com_st_pages.loginpage;
import com_st_pages.ratelistpage;
import com_st_util.TestUitl;

public class homepagetest extends TestBase{

	public homepagetest() throws IOException {
		super();
		
	}
	 loginpage LoginPage;
	 homepage HomePage;
	 TestUitl testutil;
	 ratelistpage ratelinepagelist;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		LoginPage = new loginpage();
		HomePage = new homepage();
		ratelinepagelist = new ratelistpage();
		testutil = new TestUitl();
		HomePage = LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Login successfully");
		testutil.hardwait(1000);
	}
	
	@Test(priority =1)
	public void verifyHomePageTitleTest() {
		String Homepageurl = HomePage.varifyHomepageurl();
		Assert.assertEquals(Homepageurl, "https://qa.thespicetag.com/dashboard","HomePage not Open");
	}
	
	
	@Test(priority=2)
	public void clickOnRateLine() throws IOException, InterruptedException {
		HomePage.colorchange();
		ratelinepagelist =	HomePage.clicOnRateLineLink();
		testutil.hardwait(1000);
		
	}
	
//	
//	@AfterMethod
//	public void tearDown() 
//	{
//		driver.quit();
//	}

	
}
