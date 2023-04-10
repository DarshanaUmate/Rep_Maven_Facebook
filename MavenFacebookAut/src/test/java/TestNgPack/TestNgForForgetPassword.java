package TestNgPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
import org.testng.asserts.SoftAssert;

import BrowsersSetup.Base;
import Page.ForgotPassword;
import Page.LoginPage;

public class TestNgForForgetPassword extends Base {
	
	WebDriver driver;
	ForgotPassword forgetpassword;
	LoginPage loginPage;
	SoftAssert SoftAssert; // declare golabally
	
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
		forgetpassword=new ForgotPassword(driver);
	}
	
	
	@BeforeMethod
	public void goToForgetPasswordPage() throws InterruptedException{
		System.out.println("Before method");
		driver.get("https://www.facebook.com/");
		loginPage.clickOnForgatePassword();
		Thread.sleep(3000);
		SoftAssert = new SoftAssert();// initialization
		
	}
	
	@Test
	public void verifyMessageOnforgetPasswPage() throws InterruptedException{
		System.out.println("test");
		String actualtext=forgetpassword.getTextMessage();
		String expectedText="Please enter your email address or mobile number to search for your account.";
		//SoftAssert SoftAssert = new SoftAssert();
		
		SoftAssert.assertEquals(actualtext, expectedText,"Expected text failed");
		//SoftAssert.assertNotEquals(actualtext, expectedText);
		
		//Assert.assertEquals(actualtext, expectedText);
		
		System.out.println("Hello");
		
//		if(actualtext.equals(expectedText)){
//			System.out.println("passes");
//		}
//		else{
//			System.out.println("fail");
//		}
		Thread.sleep(3000);
		
		SoftAssert.assertAll();
	}
	
	@Test
	public void verifytheCancelButtonOnForgetPasswordPage()
	{
		System.out.println("test1");
		forgetpassword.clickCancelButton();
		String actualURL="https://www.facebook.com/login.php";
		String actualTitle="Log in to Facebook";
		String expectedURL=driver.getCurrentUrl();
		String expectedTitle=driver.getTitle();
		
		Assert.assertEquals(actualURL, expectedURL);
		Assert.assertEquals(actualTitle, expectedTitle,"Title is wrong");
		
//		SoftAssert.assertEquals(actualURL, expectedURL);
//		SoftAssert.assertEquals(actualTitle, expectedTitle);
		
		
		//If Else is replace with Assert 
//		if(expectedURL.equals(actualURL) && expectedTitle.equals(actualTitle))
//		{
//			System.out.println("Pass");
//			
//		}
//		else {
//			System.out.println("fail");
//		}
		
		//SoftAssert.assertAll();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after method");
	}

	@AfterClass
	public void clearObject()
	{
		System.out.println("after class");
		loginPage=null;
		forgetpassword=null;
		
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
