package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import Pages.AddToCartt;
import Pages.CreateAccount;
import Pages.Login;
import Pages.ProfilePage;
import UtilityClass.TestBase;


public class TestCases extends TestBase
{

	static Logger log=Logger.getLogger(TestCases.class.getName());
	
	@BeforeSuite
		public void openBrowser() throws Exception
		{
			startBrowser();
		}
		
		@Test(priority = 1,enabled = false,description = "Create Account Under Sign in")
		public void accountCreateExcecution() throws Exception
		{
			CreateAccount ca=PageFactory.initElements(driver, CreateAccount.class);
			ca.clickSignIn();
			
			String title=driver.getTitle();
			
			log.info("Page title verify for the first test="+title);
			
			Assert.assertEquals(title, "Login - My Store");
			ca.CreateAc(prop.getProperty("email"));
			ca.enterPersonalInformation();
		}
		
		@Test(priority = 2,description = "Login with new user Credentials")
		public void loginTestExecution()
		{
			Login lt=PageFactory.initElements(driver, Login.class);
			lt.clickSignIn();
			
			String title=driver.getTitle();
			log.info("Page title verify for the second test="+title);
			Assert.assertEquals(title, "Login - My Store");
			
			lt.loginAccount(prop.getProperty("email"), prop.getProperty("password"));
		}
		
		
		@Test(priority = 3, description = "Add product to cart & Complete the payment process")
		public void addToCardTestExecution()
		{
			AddToCartt cart1=PageFactory.initElements(driver, AddToCartt.class);
			
			String title=driver.getTitle();
			log.info("Page title verify for the third test="+title);
			Assert.assertEquals(title, "My account - My Store");
			
			cart1.addProductIntoCart();
			cart1.verifyCost();                 //Verify the cost of product
			cart1.paymentProcess();             //Complete the payment process
			
			String pagetitle=driver.getTitle();
			log.info("Page title verify for another method in the third test="+title);
			Assert.assertEquals(pagetitle, "Order confirmation - My Store");
			
		}
		
		@Test(priority = 4, description = "Verifying the order History")
		public void verifyProfileOrder()
		{
			ProfilePage profile=PageFactory.initElements(driver, ProfilePage.class);
			profile.clickOnAccount();
			
			String ptitle=driver.getTitle();
			log.info("Page title verify for the fourth test="+ptitle);
			Assert.assertEquals(ptitle, "My account - My Store");
			profile.verifyAmountOfOrder();
			
		}
		
		@AfterMethod
		public void takeScreenShot() throws IOException
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFileToDirectory(src, new File("E:\\SELENIUM\\AutomationPracticePageTesting\\TestsScreenshots\\page.png"));
		
		}
		
		
		@AfterSuite
		public void closeBrowser()
		{
			driver.quit();
		}
	}
