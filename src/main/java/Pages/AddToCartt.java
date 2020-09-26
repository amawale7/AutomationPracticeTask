package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddToCartt 
{
	static Logger log=Logger.getLogger(AddToCartt.class.getName());
	
	WebDriver driver;

	@FindBy(linkText = "Women" )
	WebElement womenSection;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
	WebElement quickView;
	
	@FindBy(how=How.XPATH,using="//i[@class=\"icon-plus\"]")
	WebElement quantity;
	
	@FindBy(how=How.XPATH,using="//button[@name=\"Submit\"]")
	WebElement addToCart;
	
	@FindBy(how=How.XPATH,using="//div[@class=\"layer_cart_row\"]/child :: span[contains(text(),'$35.02')]")
	WebElement costVerify;
	
	@FindBy(linkText = "Proceed to checkout" )
	WebElement checkout;
	
	@FindBy(how=How.XPATH,using="//button[@name=\"processAddress\"]")
	WebElement processAddress;
	
	@FindBy(how=How.XPATH,using="//button[@name=\"processCarrier\"]")
	WebElement processCarrier;
	
	@FindBy(id = "cgv" )
	WebElement checkbox;
	
	@FindBy(how=How.XPATH,using="//a[@title=\"Pay by bank wire\"]")
	WebElement paymentMode;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrder;
	
	public AddToCartt(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void addProductIntoCart()
	{		
		womenSection.click();
		quickView.click();
		quantity.click();
		addToCart.click();
		
		
	}
	public void verifyCost()
	{
		String text=costVerify.getText();
		log.debug("Actual cost of product="+text);
		if(text.equals("$35.02"))
		{
			log.info("Cost is Successfully Verified");
		}
	}
	
	
	public void paymentProcess()
	{
		checkout.click();
		checkout.click();
		processAddress.click();
		checkbox.click();
		processCarrier.click();
		paymentMode.click();
		confirmOrder.click();
		
	}
}
