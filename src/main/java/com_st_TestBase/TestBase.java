package com_st_TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com_st_util.TestUitl;
import com_st_util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
//	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() throws java.io.IOException
	{
	try{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\devendra.singh1\\eclipse-workspace\\NewJenkinspro1\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(fis);
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	}
}	

	public static void initialization() throws IOException {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\automation\\chrome driver\\chromedriver-win32\\chromedriver.exe");
			    
//		    	ChromeOptions chromeOptions = new ChromeOptions();
//			    chromeOptions.addArguments("--remote-allow-origins=*");
//				driver = new ChromeDriver(chromeOptions);
			      driver = new ChromeDriver();
		}
		else if(browserName.equals("IED"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\automation\\chrome driver\\chromedriver-win32\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
//			    ChromeOptions chromeOptions = new ChromeOptions();
//			    chromeOptions.addArguments("--remote-allow-origins=*");
			 //	driver = new ChromeDriver(chromeOptions);
			 	driver = new ChromeDriver();
		}

//		e_driver = new EventFiringWebDriver(driver);
//		// Now create object of eventListerHandler to register it with EventFiringwebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
//		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUitl.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUitl.IMPLICIT_WAIT));
		
		
		driver.get(prop.getProperty("url"));
				
	}	
	
	public static void screenshort(String testMethodName) throws InterruptedException {
		
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(scrfile, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\Spicetag_FrameWork"
					+ "\\Screenshots\\"+"failshot_"+testMethodName+".jpg"));
			System.out.println("screenshort function runing");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
