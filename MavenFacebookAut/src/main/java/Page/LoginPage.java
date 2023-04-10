package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// Veriable Diclaration 
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//span[text()='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@role='presentation']")
	private WebElement captcha;
	
	@FindBy(xpath="//span//div//i")
	private WebElement logout;
	
	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logoutButton;
	
	
	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement forgatePasswordButton;
	
	@FindBy(xpath="//a[text()='Create new account']")
	private WebElement createNewAccount;
	
	// Initialization 
	public LoginPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);//driver for browser reference, this keyword represent WebElement reference object of same class uper wale sare findby
												//veriable weblement ko denote karega
	}
	
	// veriable use
	
	public void sendUserName() {
		userName.sendKeys("bhumi1234@gmail.com");
	}
	// get text of user name button
	public void getTextuserName() {
		String userText=userName.getAttribute("aria-label");
	}
	
	public void sendPassword() {
		password.sendKeys("Bhumi123@");
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	public void clickOnCaptcha() {
		captcha.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
	
	public void clickOnLogoutButton() {
		logoutButton.click();
	}
	
	
	
	
	public void clickOnForgatePassword() {
		forgatePasswordButton.click();
	}
	
	public void clickOnCreateNewAccount() {
		createNewAccount.click();
	}
	
	// or combine method create
	
	public void loginToApplication() {
		userName.sendKeys("darshana");
		password.sendKeys("1236547896");
		loginButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
