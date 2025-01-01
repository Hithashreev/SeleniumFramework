package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.baseclass;

public class Accountpage {

	WebDriver driver;
	public Accountpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@id='content']//h2[1]")
	WebElement msgHeading;
	
	public boolean isAccountpageExists() {
		try {
			return(msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
}
