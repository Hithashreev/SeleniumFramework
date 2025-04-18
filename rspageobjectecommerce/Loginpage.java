package rspageobjectecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends BaseClass{
	
	public Loginpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginbtn;
	
	
public void useremail(String uemail) {
	email.sendKeys(uemail);
}

public void userpassword(String upass) {
password.sendKeys(upass);
}

public void loginbutton() {
loginbtn.click();
}

}
