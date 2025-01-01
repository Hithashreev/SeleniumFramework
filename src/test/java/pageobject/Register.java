package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
	
	public WebDriver driver;
	public Register(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
@FindBy(id="input-firstname")
WebElement firstname;

@FindBy(id="input-lastname")
WebElement lastname;

@FindBy(id="input-email")
WebElement email;

@FindBy(id="input-telephone")
WebElement telephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement password;

@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmpassword;

@FindBy(xpath="//input[@type='checkbox'][@name='agree']")
WebElement privacypolicy;

@FindBy(xpath="//input[@type='submit'][@value='Continue']")
WebElement continuebutton;

public void setfirst(String fname) {
	firstname.sendKeys(fname);
}
public void setlast(String lname) {
	lastname.sendKeys(lname);	
}


public void setemail(String mail) {
	email.sendKeys(mail);
}

public void settelephone(String tele) {
	telephone.sendKeys(tele);
	
}


public void setpassword(String pass) {
	password.sendKeys(pass);
	
}


public void setconfirm(String passconfirm) {
	confirmpassword.sendKeys(passconfirm);
	
}

public void clickprivacy() {
	privacypolicy.click();
}
public void clickcontinue() {
	continuebutton.click();
}

}
