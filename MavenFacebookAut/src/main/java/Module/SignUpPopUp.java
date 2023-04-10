package Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPopUp {
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	private WebElement regMobAndEmail;
	
	@FindBy(xpath="//input[@name='reg_email_confirmation__']")
	private WebElement reEnterRegMobAndEmail;
	
	
	
	@FindBy(xpath="//input[@id='password_step_input']")
	private WebElement newPassword;
	
	// Date of birth select 
	@FindBy(xpath="//select[@id='day']")
	private WebElement birthOfDay;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement birthOfMonth;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement birthOfYear;
	// Gender select 
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement femaleRadio;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	private WebElement maleRadio;
	
	@FindBy(xpath="(//input[@type='radio'])[3]")
	private WebElement customeRadio;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	private WebElement signUpButton;
	
	@FindBy(xpath="(//a[text()='Privacy Policy'])[2]")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//a[text()='Cookies Policy']")
	private WebElement cookiesPolicy;
	
	// veriable initialization
	public SignUpPopUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// veriable use
	public void SendFirstName() {
		firstName.sendKeys("Bhumeshvari");;
	}
	
	public void SendLastName() {
		lastName.sendKeys("Shende");
	}
	
	public void SendRegMobAndEmail() {
		regMobAndEmail.sendKeys("bhumi1234@gmail.com");
		
	}
	
	public void sendReRnterRegMobAndEmail() {
		//regMobAndEmail.click();
		reEnterRegMobAndEmail.sendKeys("bhumi1234@gmail.com");
	}
	
	
	public void sendNewPassword() {
		newPassword.sendKeys("Bhumi123@");
	}
	
	
	// birth drop down methods
	public void selectDayDropDown() {
		// Select date day month year drop down
		Select select=new Select(birthOfDay);
		select.selectByVisibleText("20");
	}
	
	public void selectMonthDropDown() {
		// Select date day month year drop down
		Select select=new Select(birthOfMonth);
		select.selectByVisibleText("Feb");
	}
	
	public void selectYearDropDown() {
		// Select date day month year drop down
		Select select=new Select(birthOfYear);
		select.selectByVisibleText("1996");
	}
	
	public void clickOnGender(String gender) {
		// code for radion button selection
		if(gender.equalsIgnoreCase("Female"))
		{
			femaleRadio.click();
		}
		else if(gender.equalsIgnoreCase("Male"))
		{
			maleRadio.click();
		}
		else if(gender.equalsIgnoreCase("Custome"))
		{
			customeRadio.click();
		}
		
	}
	
	public void clickOnSignUpButton() {
		signUpButton.click();
	}
	
	public void clickOnPrivacyPolicy()
	{
		privacyPolicy.click();
	}
	
	public void clickOnCookiesPolicy()
	{
		cookiesPolicy.click();
	}
	
	
	
	
	
	
	
	
	
	
	

}
