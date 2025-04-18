package rspageobjectecommerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ecommercetestcases{

WebDriver driver;
@BeforeTest
public void setup() {
driver=new ChromeDriver();
driver.get("https://rahulshettyacademy.com/client");	
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}


	//login
@Test(priority=1)
	public void login() {
	Loginpage lp=new Loginpage(driver);
	lp.useremail("hitha123@gmail.com");
	lp.userpassword("Hitha@123");
	lp.loginbutton();
	}

@Test(dependsOnMethods= {"login"},priority=2)
public void product() {
ProductCatelog pc=new ProductCatelog(driver);
pc.allitems();

}



@Test(dependsOnMethods= {"product"},priority=3)
public void cart() throws InterruptedException {
	Thread.sleep(3000);
	CartPage cp=new CartPage(driver);
	cp.cartbutton();
	cp.buynowbutton();
}


@Test(dependsOnMethods= {"cart"},priority=4)
public void placeorder() throws InterruptedException {
	OrderPlaced op=new OrderPlaced(driver);
	op.country();
	op.placeorderbutton();
	op.confirmmessage();
	
}


}
	


	

	

