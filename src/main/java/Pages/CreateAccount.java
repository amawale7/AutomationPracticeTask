package Pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


public class CreateAccount
{
	static Logger log=Logger.getLogger(CreateAccount.class.getName());
	
	WebDriver driver;
	
	@FindBy(linkText = "Sign in" )
	WebElement singIn;
	
	@FindBy(id = "email_create" )
	WebElement EmailAddress;
	
	@FindBy(id = "SubmitCreate" )
	WebElement submit;
	
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Create an account')]")
	WebElement verifyPage;
	
	
	@FindBy(id = "id_gender1" )
	WebElement gender;
	
	@FindBy(id = "customer_firstname" )
	WebElement cusFirstname;
	
	@FindBy(id = "customer_lastname" )
	WebElement cusLastname;
	
	@FindBy(id = "passwd" )
	WebElement password;
	
	@FindBy(id = "days" )
	WebElement day;
	
	@FindBy(id = "months" )
	WebElement month;
	
	@FindBy(id = "years" )
	WebElement year;
	
	@FindBy(id = "optin" )
	WebElement offer;
	
	@FindBy(id = "firstname" )
	WebElement firstname;
	
	@FindBy(id = "lastname" )
	WebElement lastname;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='company']")
	WebElement company;
	
	@FindBy(name = "address1" )
	WebElement address1;
	
	@FindBy(name = "address2" )
	WebElement address2;
	
	@FindBy(how=How.XPATH,using="//input[@id=\"city\"]")
	WebElement city;
	
	@FindBy(how=How.XPATH,using="//select[@id=\"id_state\"]")
	WebElement state;
	
	@FindBy(id = "postcode" )
	WebElement postcode;
	
	@FindBy(id = "other" )
	WebElement addInfo;
	
	@FindBy(how=How.XPATH,using="//input[@id=\"phone\"]")
	WebElement homePhone;
	
	@FindBy(how=How.XPATH,using="//input[@id=\"phone_mobile\"]")
	WebElement mobilePhone;
	
	@FindBy(how=How.XPATH,using="//button[@id=\"submitAccount\"]")
	WebElement submitAccount;
	
	@FindBy(linkText = "Sign out" )
	WebElement Signout ;
	
	public CreateAccount(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickSignIn()
	{
		singIn.click();
	}
	public void CreateAc(String mail)
	{
		EmailAddress.sendKeys(mail);
		submit.click();
	}
	
	
	public void enterPersonalInformation() throws IOException
	{
		FileInputStream file=new FileInputStream("E:\\SELENIUM\\AutomationPracticePageTesting\\src\\main\\java\\testData\\Contoller.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		String fn=sheet.getRow(1).getCell(1).getStringCellValue();
		String ln=sheet.getRow(1).getCell(2).getStringCellValue();
		String ps=sheet.getRow(1).getCell(3).getStringCellValue();
		int dy=(int) sheet.getRow(1).getCell(4).getNumericCellValue();
		int mo=(int) sheet.getRow(1).getCell(5).getNumericCellValue();
		int yr=(int) sheet.getRow(1).getCell(6).getNumericCellValue();
		String comp=sheet.getRow(1).getCell(7).getStringCellValue();
		String addr1=sheet.getRow(1).getCell(8).getStringCellValue();
		String addr2=sheet.getRow(1).getCell(9).getStringCellValue();
		String ct=sheet.getRow(1).getCell(10).getStringCellValue();
		int st=(int) sheet.getRow(1).getCell(11).getNumericCellValue();
		int pcode=(int) sheet.getRow(1).getCell(12).getNumericCellValue();
		String info=sheet.getRow(1).getCell(13).getStringCellValue();
		int hnum=(int) sheet.getRow(1).getCell(14).getNumericCellValue();
		int mnum=(int) sheet.getRow(1).getCell(15).getNumericCellValue();
		
		
		String text=verifyPage.getText();
		log.info("verify the text of Accout Created Page="+text);
		if(text.equals("Create an account"))
			
		gender.click();
		cusFirstname.sendKeys(fn);
		cusLastname.sendKeys(ln);
		password.sendKeys(ps);
		
		Select sel1=new Select(day);
		sel1.selectByValue(String.valueOf(dy));
		
		Select sel2=new Select(month);
		sel2.selectByValue(String.valueOf(mo));
		
		Select sel3=new Select(year);
		sel3.selectByValue(String.valueOf(yr));
		
		offer.click();
		
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		company.sendKeys(comp);
		address1.sendKeys(addr1);
		address2.sendKeys(addr2);
		city.sendKeys(ct);
		
		Select se=new Select(state);
		se.selectByValue(String.valueOf(st));
		
		postcode.sendKeys(String.valueOf(pcode));
		addInfo.sendKeys(info);
		homePhone.sendKeys(String.valueOf(hnum));
		mobilePhone.sendKeys(String.valueOf(mnum));
		submitAccount.click();
		Signout.click();
		
		workbook.close();
		
	}
	
}
