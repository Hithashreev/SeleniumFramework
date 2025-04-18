package rspageobjectecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BaseClass{

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
WebElement cartbtn;

@FindBy(xpath="//button[@class='btn btn-primary'][text()='Buy Now']")
WebElement buynowbtn;



public void cartbutton() {
	cartbtn.click();
}

public void buynowbutton() {
	buynowbtn.click();
	
	
}
}
