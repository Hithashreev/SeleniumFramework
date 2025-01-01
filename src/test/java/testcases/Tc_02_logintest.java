package testcases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Accountpage;
import pageobject.Homepage;
import pageobject.loginpage;
import testbase.baseclass;

public class Tc_02_logintest extends baseclass {
	
	@Test(groups={"sanity"})
	public void verify_login() {
		logger.info("******Starting tc_02 login test*******");
		try {
		Homepage hp=new Homepage(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		loginpage lp=new loginpage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clicklogin();
		
		
		Accountpage ap=new Accountpage(driver);
		boolean targerpage=ap.isAccountpageExists();
		
		//Assert.assertEquals(targerpage, true, "Login failed");
		Assert.assertTrue(targerpage);
		
		
	}
		catch(Exception e) {
			Assert.fail();
		}
		}
	
	

}
