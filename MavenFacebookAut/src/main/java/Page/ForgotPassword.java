package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {

	// Veriable Diclaration 
	@FindBy(xpath="//table//div")  // relative xpath
	private WebElement textMessage;
	
	@FindBy(xpath="(//input[@name='email'])[2]")
	private WebElement emailOrPhoneNumber;
	
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchButton;
	
	// Initialization 
	
	public ForgotPassword(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// veriable use
	
	public String getTextMessage() {
		String text=textMessage.getText();
		return text;
	}
	
	public void sendEmailOrPhone() {
		emailOrPhoneNumber.sendKeys("darshana1236@gmail.com");
	}
	
	public void clickCancelButton() {
		cancelButton.click();
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
}

