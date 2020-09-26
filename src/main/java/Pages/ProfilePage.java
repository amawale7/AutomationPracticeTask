package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage 
{

	
WebDriver driver;
	
	
	@FindBy(how=How.XPATH,using="//a[@class=\"account\"]")
	WebElement account;
	
	
	@FindBy(how=How.XPATH,using="//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")
	WebElement orderHistory;
	
	
	public ProfilePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnAccount()
	{
		account.click();
	}
	
	public void verifyAmountOfOrder()
	{
		orderHistory.click();
		WebElement block=driver.findElement(By.xpath("//div[@id='center_column']"));
		List<WebElement> order=block.findElements(By.tagName("tr"));
		int noOfOrder=order.size();
		System.out.println("Total number of order in order history="+noOfOrder);
	}
	
}
