package TestPro1;

import java.util.concurrent.TimeUnit;

//import java.time.Duration;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;

import Module.SignUpPopUp;
import Page.ForgotPassword;
import Page.LoginPage;

public class TestClass {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\INTEGRAL COMPUTER\\chromedriver_win32new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		
		driver.get("https://www.facebook.com/");
		
		LoginPage login =new LoginPage(driver);
		login.sendUserName();
		login.sendPassword();
		//login.clickOnLoginButton();
//		login.clickOnForgatePassword();
//		ForgotPassword forget=new ForgotPassword(driver);
//		forget.clickCancelButton();
//		
		
		login.clickOnCreateNewAccount();
		//Thread.sleep(3000);
		
		SignUpPopUp signUpPopup=new SignUpPopUp(driver);
		signUpPopup.SendFirstName();
		signUpPopup.SendLastName();
		signUpPopup.SendRegMobAndEmail();
		signUpPopup.selectDayDropDown();
		signUpPopup.selectMonthDropDown();
		signUpPopup.selectYearDropDown();
		
		
		
		
		
	}
}
