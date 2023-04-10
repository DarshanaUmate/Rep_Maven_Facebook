package TestNgPack;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

import BrowsersSetup.Base;
import Module.SignUpPopUp;
import Page.LoginPage;

public class TestNgForSignUpPupup extends Base {
	
	WebDriver driver;
	SignUpPopUp signUpPopup;
	LoginPage loginPage;
	
	@BeforeSuite
	public void beforeSuit()
	{
		System.out.println("Before Suit");
	}
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName)
	{
		System.out.println("First lounch browser");
		
		if(browserName.equals("Chrome"))
		{
			
			driver = openChromeBrowser();
		}
		
//		if(browserName.equals("Firefox"))
//		{
//			
//			driver =openFireFoxBrowser();
//		}
//		
//		if(browserName.equals("MicrosoftEdge"))
//		{
//			
//			driver = openMicrosoftEdge();
//		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	
	}
	
	@BeforeClass
	public void createPOMObject()
	{
		loginPage=new LoginPage(driver);
		signUpPopup=new SignUpPopUp(driver);
	}
	
	
	@BeforeMethod
	public void goToSignUpPopup() throws InterruptedException
	{
		System.out.println("repeate code");
		driver.get("https://www.facebook.com/");
		loginPage.clickOnCreateNewAccount();
		Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	public void verifySignUpPopUpFunctionality() throws InterruptedException
	{
		System.out.println("Test 1");
		//loginPage.clickOnCreateNewAccount();
		signUpPopup=new SignUpPopUp(driver);
		signUpPopup.SendFirstName();
		signUpPopup.SendLastName();
		signUpPopup.SendRegMobAndEmail();
		Thread.sleep(1000);
		
		signUpPopup.sendReRnterRegMobAndEmail();
		signUpPopup.sendNewPassword();
		signUpPopup.selectDayDropDown();
		signUpPopup.selectMonthDropDown();
		signUpPopup.selectYearDropDown();
		signUpPopup.clickOnGender("Female");
		Thread.sleep(1000);
		signUpPopup.clickOnSignUpButton();
		
	}
	
//	@Test(priority = 1)
//	public void verifyLoginPage() throws InterruptedException
//	{
//		System.out.println("test2");
//		
//		loginPage.clickOnCaptcha();
		
//		loginPage.sendUserName();
//		loginPage.sendPassword();
//		
//		loginPage.clickOnLoginButton();
//		loginPage.clickOnContinueButton();
//		Thread.sleep(2000);
		
//		loginPage.clickOnLogout();
//		loginPage.clickOnLogoutButton();
	//}
	
	@Test(priority = 2 , invocationCount=1 )
	public void verifyCookiesPolicy()
	{
		System.out.println("cookies");
		signUpPopup.clickOnCookiesPolicy();
		//Assert.fail();
	}
	
	//@Test(priority = 2, dependsOnMethods="verifyCookiesPolicy")
	@Test(priority = 3)
	public void VerifyPrivacyPolicy()
	{
		System.out.println("privacy");
		signUpPopup.clickOnPrivacyPolicy();
	}
	
	@Test(priority = 4,dependsOnMethods="test4")
	public void test3()
	{
		System.out.println("Test 3 method");
		
		
	}
	
	
	@Test(priority = 5)
	public void test4()
	{
		System.out.println("Test 4 method");
		//Assert.fail();
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after method");
	}
	
	@AfterClass
	public void clearObjects()
	{
		System.out.println("after class");
		loginPage=null;
		signUpPopup=null;
		
		
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
