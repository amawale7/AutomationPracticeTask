package UtilityClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase 
{

	public static WebDriver driver;
	public static Properties prop=new Properties();
	
	
	public static WebDriver startBrowser() throws Exception
	{
		
		FileInputStream fis=new FileInputStream("E:\\SELENIUM\\AutomationPracticePageTesting\\src\\test\\resources\\log4j.properties");
		prop.load(fis);
		
		String browserr= prop.getProperty("browser");
		
		switch (browserr) 
		{
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"E:\\Selenium All Driver\\firfox\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"E:\\Selenium All Driver\\chrome new\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			System.setProperty("webdriver.ie.driver",
					"E:\\Selenium All Driver\\IEDriver\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	
	
}

	

