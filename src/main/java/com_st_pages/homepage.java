package com_st_pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_st_TestBase.TestBase;




public class homepage extends TestBase {

	public homepage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	//---------------------------------------------------
	// For Rate Line page
	
		@FindBy(xpath="//span[contains(text(),'Devendra Singh')]")
		WebElement usernamelable;
		
	//--------------Home Page Tabs
		
//----Dashboard
		@FindBy(xpath="//span[contains(text(),' Dashboard ')]")
		WebElement Dashboard;
		
//---- Orders 
		@FindBy(xpath="//span[contains(text(),' Orders ')]")
		WebElement Orders;
		
//----  Scheduling  
		@FindBy(xpath="//span[contains(text(),' Scheduling ')]")
		WebElement Scheduling;
				
//----   Operation   
		@FindBy(xpath="//span[contains(text(),' Operation ')]")
		WebElement Operation;
				
//---- Accounting   
		@FindBy(xpath="//span[contains(text(),' Accounting ')]")
		WebElement Accounting;
		
//----Track/Audit  
		@FindBy(xpath="//span[contains(text(),'Track/Audit')]")
		WebElement  Track_Audit;
				
		
//---- Activities   
		@FindBy(xpath="//span[contains(text(),' Activities ')]")
		WebElement Activities;
				
//-------Organize
		@FindBy(xpath="//span[contains(text(),' Organize ')]")
		WebElement organize;
		
		@FindBy(xpath="//a[contains(text(),'Ratefiling ')]")
		WebElement Ratefilinglable;
		
		@FindBy(xpath="//a[@href='/customer/rateline/list']")
		WebElement ratelinelable;
		
		@FindBy(xpath="//span[contains(text(),' Rate List ')]")
		WebElement ratelist;
		
//------- Reports
		@FindBy(xpath="//span[contains(text(),' Reports ')]")
		WebElement Reports;
		
//------ Cold Chain
		@FindBy(xpath="//span[contains(text(),' Cold Chain ')]")
		WebElement Cold_Chain;
		
//------ Manual
		@FindBy(xpath="//span[contains(text(),' Manual ')]")
		WebElement Manual;

//------ Console
		@FindBy(xpath="//span[contains(text(),' Console ')]")
		WebElement Console;

//------ Rewards & Recognition 
		@FindBy(xpath="//span[contains(text(),'Rewards_Recognition')]")
		WebElement  Rewards_Recognition;
		
		@FindBy(xpath="//div[@class='slider round']")
		WebElement colorchange;
		
		//Actions
			
		public String varifyHomepageurl() {
			
			return driver.getCurrentUrl();
		}

		public void colorchange() {
			colorchange.click();	
		}

		public ratelistpage clicOnRateLineLink() throws IOException, InterruptedException {
			
			Thread.sleep(2000);
			//Click to RateLine Tab
			Actions action = new Actions(driver);
			action.moveToElement(organize).build().perform();
			action.moveToElement(Ratefilinglable).build().perform();
			ratelinelable.click();
			
			return new ratelistpage();
		}

	
}
