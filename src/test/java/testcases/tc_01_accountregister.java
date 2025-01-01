package testcases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.Register;
import testbase.baseclass;

public class tc_01_accountregister extends baseclass{

	
@Test(groups={"regression"})
public void account_register() {
	
	
	logger.info("*****Starting registertest****");
	
	Homepage hp=new Homepage(driver);
	hp.clickAccount();
	logger.info("Clicked on my account link");
	hp.clickRegister();
	logger.info("Clicked on my register link");

	Register r=new Register(driver);
	logger.info("providing customer details");
	r.setfirst(randomeString().toUpperCase());
	r.setlast(randomeString().toUpperCase());
	r.setemail(randomeString()+"@gmail.com"); //randomly generate the email
	r.settelephone(randomeNumber());
	
	String password=randomAlphaNumeric();
	r.setpassword(password);
	r.setconfirm(password);
	r.clickprivacy();
	r.clickcontinue();
	logger.debug("debug logs");

	
	/*
	 * Logging-record all the events in the form of text
	 Log levels-ALL<Trace<Debug<info<Warn<Error<Fatal<Off
	 
	 Appenders-where to generate logs(Console/file)
	 Loggers-what type of logs generate(ALL<Trace<Debug<info<Warn<Error<Fatal<Off)
	 
	 go to google and type log4j2.xml
	 
	 in test/resource create log4j2.xml file(file name shd be same)
	 
	 //trace and debug is detail level of logs
	  
	  we mainly use info log
	  update base class under setup method
	  
	  //mostly we use debug or info log
	 
	 *
	 */
	
}


	
	





}
