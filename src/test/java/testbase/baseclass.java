package testbase;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.SystemProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class baseclass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	
	@BeforeClass(groups= {"sanity","regression"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		
		//Loading config.properties file
		
				FileReader file=new FileReader("./src//test//resources//config.properties");
				p=new Properties();
				p.load(file);
		
		logger=LogManager.getLogger(this.getClass()); //log4j2
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
            // Set Desired Capabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
          
            //os
            if(os.equalsIgnoreCase("windows")) {
        	   capabilities.setPlatform(Platform.WIN11);
           }
           else if (os.equalsIgnoreCase("mac")){
        		  capabilities.setPlatform(Platform.MAC); 
        		   
        	   }
           else {
        	   System.out.println("no matching os");
       return;
		} 
		
		
           

     //browser
		switch(br.toLowerCase()) {
		case "chrome": capabilities.setBrowserName("chrome");
		break;
		case "firefox":driver: capabilities.setBrowserName("firefox");
		break;
		case "edge":driver: capabilities.setBrowserName("edge");
		break;
		default: System.out.println("no matching browser");
		return;	
		}
		
		driver=new RemoteWebDriver(new URL(" http://192.168.0.107:4444"),capabilities);
		
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")){
			
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();
		break;
		case "firefox":driver=new FirefoxDriver();
		break;
		case "edge":driver=new EdgeDriver();
		break;
		default: System.out.println("Invalid browser name");
		return;	 //exit from the execution
			
			
		}
		
		
		}
		
		
	
		
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl")); //reading url from properties file
		

	}
	
	public String captureScreen(String tname) throws IOException{
		 String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        
		 TakesScreenshot ts = (TakesScreenshot) driver;
	        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
	        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\"+ tname+"_"+ timestamp+ ".png";
	        File targetFile=new File(targetFilePath);
	        
	        sourceFile.renameTo(targetFile);
	        
	        return targetFilePath;   
	}
	
	@AfterClass(groups= {"sanity","regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	public String randomeNumber() {
		// TODO Auto-generated method stub
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	public String randomAlphaNumeric() {
		// TODO Auto-generated method stub
		String generatednumber=RandomStringUtils.randomNumeric(3);
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		return(generatedstring+"@"+generatednumber);
		
	}

	public String randomeString() {
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
		

}






/*

Selenium grid

Hub/grid--main system where we started execution of testcases 

Node--remote machine where all browsers are installed

Through grid setup we need to attach node to hub 

Hub-->node 1, node2, node 3(attach all nodes to hub)(grid)

We will run testcases from the hub

In testcase we mention os and browser and hub will decide to send it to particular node


We can create virtual machine but it is also constly

So now docker came into market 

In docker we can download images (linex image , windows image)

download image(multiple we can create)->container(node)(multiple nodes we can create)-->container can be made as node



we shd have one node and hub to make grid setup

Standalone setup--with single system you can make same sytem as node and same system as hub


Distributed setup-one hub and multiple node 


 http://192.168.0.107:4444----grid url



//*****Docker******
 
 
Docker-->containerazation

We have docker hub repository(all the things in one single place)
-->it containes multiple images
 
its repository having multiple imgaes (windows, linux)
By using image we can create a container
 
 
--> one image can have multiple containers
 
 
 
 //from pom.xml if you want to run and compile the project
  * 
  * you have two ways
  * -->maven compiler plugin
  * -->maven surefire plugin
  * 
  * 
  * go to google search apache maven compiler plugin
  * 
  * <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.13.0</version>
        </plugin>
  * 
  * 
  * it shd be added before dependencies in pom.xml
  * 
  * 
  * run the file--using run as
  * 
  * 
  *  //install maven OS level
  *  
  *  google-download apache maven
  *  
  *  
  *  cmd prompt-- mvn -version
  *  
  *  cd  C:\Users\hithu\eclipse-workspace\Selenium_Framework
  *  
  *  mvn clean test
  *  
  *  
  */
 
 
 
 
 
 


