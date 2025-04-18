package rspageobjectecommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OrderPlaced extends BaseClass{

	public OrderPlaced(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(xpath="//input[@placeholder='Select Country']")
WebElement selectcountry;
	
@FindBy(xpath="//button[@class='ta-item list-group-item ng-star-inserted']")
List<WebElement> countries;

@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
WebElement placeorderbtn;

@FindBy(xpath="//td[@class='box']")
WebElement confirmmsg;


public void country() throws InterruptedException {
	selectcountry.sendKeys("india");
	for(int i=0;i<countries.size();i++) {
		String actualcountry=countries.get(i).getText();
		if(actualcountry.equalsIgnoreCase("india")) {
			countries.get(i).click();
		}
		
	}
	
}

public void placeorderbutton() {
	placeorderbtn.click();
}

public void confirmmessage() {
	System.out.println(confirmmsg.getText());
}



	
	
}
