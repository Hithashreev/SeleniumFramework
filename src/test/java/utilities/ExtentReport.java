package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import testbase.baseclass;

public class ExtentReport implements ITestListener{
	private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    String repName;
    @Override
    public void onStart(ITestContext testContext) {
        // Set up Extent Reports and Spark Reporter
    	
    	/*SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    	Date dt=new Date();
        String currentdatetimestamp =df.format(dt);*/
        
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        
        repName= "Test-Report-" + timestamp +".html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);        sparkReporter.config().setDocumentTitle("Test Execution Report");
        sparkReporter.config().setReportName("opencart functional testing");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "opencart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Hithashree V");
        
		String os= testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating system", os);
        
        String browser= testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);
    
    
   List<String> includeGroups= testContext.getCurrentXmlTest().getIncludedGroups();
   if(!includeGroups.isEmpty())
    extent.setSystemInfo("Groups", includeGroups.toString());
}



    @Override
    public void onTestSuccess(ITestResult result) {
        // Create a new test for each test method
        ExtentTest test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName()+"got successfully exceuted");
       
    }


    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure details
    	ExtentTest  test= extent.createTest(result.getTestClass().getName());
    	 test.assignCategory(result.getMethod().getGroups());
    	 
    	 test.log(Status.FAIL, result.getName()+"got failed");
    	 test.log(Status.INFO, result.getThrowable().getMessage());
    	 
    	 try {
    		 String impPath=new baseclass().captureScreen(result.getName());
    		 test.addScreenCaptureFromPath(impPath);
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log skipped test details
        ExtentTest test=extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP,result.getName()+"got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
        
    }

    @Override
    public void onFinish(ITestContext context) {
        // Write all logs to the report
        extent.flush();
        
    }

    }
