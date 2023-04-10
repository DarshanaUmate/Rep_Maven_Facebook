package BrowsersSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\INTEGRAL COMPUTER\\chromedriver_win32new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
//	public static WebDriver openFireFoxBrowser()
//	{
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\INTEGRAL COMPUTER\\Downloads\\geckodriver-v0.32.2-win-aarch64\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		return driver;
//	}
//	
//	public static WebDriver openMicrosoftEdge()
//	{
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\INTEGRAL COMPUTER\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
//		return driver;
//	}

	
}
