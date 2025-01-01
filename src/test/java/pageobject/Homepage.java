package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//you can even add constructor in one page
public class Homepage {
	public WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

@FindBy(xpath="//a[@title='My Account']")
WebElement MyAccount;

@FindBy(xpath="//a[normalize-space()='Register']")
WebElement Register;

@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
WebElement login;


public void clickAccount() {
	MyAccount.click();
}

public void clickRegister() {
	Register.click();
}

public void clickLogin() {
	login.click();

}
}
