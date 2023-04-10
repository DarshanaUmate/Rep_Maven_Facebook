package TestNgPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BrowsersSetup.Base;
import Page.LoginPage;

public class TestNgForLoginPage extends Base{
	
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeSuite
	public void beforeSuit()
	{
		System.out.println("Before Suit");
	}
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName)
	{
		
			System.out.println("First lounch browser");
			
			if(browserName.equals("Chrome"))
			{
				
				driver = openChromeBrowser();
			}
			
//			if(browserName.equals("Firefox"))
//			{
//				
//				driver =openFireFoxBrowser();
//			}
//			
//			if(browserName.equals("MicrosoftEdge"))
//			{
//				
//				driver = openMicrosoftEdge();
//			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		
	}
	
	@BeforeClass
	public void createPOMObject() {
		loginPage=new LoginPage(driver);
	}
	
	
	@BeforeMethod
	public void loginFunctionality()
	{
		System.out.println("repeate code here");
		driver.get("https://www.facebook.com/");
		
	}
	
	@Test
	public void VerifyLoginFunctionality() throws InterruptedException
	{
		System.out.println("test Script Of Login Page");
		loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickOnLoginButton();
		loginPage.clickOnContinueButton();
		//Thread.sleep(100000);
		//loginPage.clickOnCaptcha();
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method code");
	}
	
	@AfterClass
	public void clearObjects()
	{
		System.out.println("After Class");
		loginPage=null;
	}
	
	@AfterTest
	public void closedBrowser() {
		System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc();
	}
	
	@AfterSuite
	public void afterSuit() {
		System.out.println("After Suit");
	}
	

}
