package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login
{	
	
	WebDriver driver;
	
	@FindBy(linkText = "Sign in" )
	WebElement singIn;
	
	@FindBy(how=How.XPATH,using="//input[@id=\"email\"]")
	WebElement email;
	
	@FindBy(how=How.XPATH,using="//input[@id=\"passwd\"]")
	WebElement passwd;
	
	@FindBy(how=How.XPATH,using="//button[@id=\"SubmitLogin\"]")
	WebElement signin;
	
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickSignIn()
	{
		singIn.click();
	}
	
	public void loginAccount(String mail,String pass) 
	{
		email.sendKeys(mail);
		passwd.sendKeys(pass);
		signin.click();
	}
	
}
