package rspageobjectecommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatelog extends BaseClass {
		
	public ProductCatelog(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='card']//div//h5")
	List<WebElement> items;
	
	@FindBy(xpath="//button[@class='btn w-10 rounded']")
	WebElement addtocart;
	


	public void allitems() {
		for (WebElement item : items) {
		    String itemname = item.getText();
			if(itemname.equalsIgnoreCase("ZARA COAT 3")) {
				addcartbtn();
			}
	}
	}
	public void addcartbtn() {
		addtocart.click();
	}



}

