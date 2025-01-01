package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.baseclass;

public class loginpage {
	
	WebDriver driver;
	public loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	

	public void setemail(String mail) {
		email.sendKeys(mail);
	}
	public void setpassword(String pass) {
		password.sendKeys(pass);
	}
	public void clicklogin() {
		loginbtn.click();
	}
	
}
