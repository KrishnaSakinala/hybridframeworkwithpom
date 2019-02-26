package hybridframeworkwithpom.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import repo.ExcelApiTest;

public class BaseTest {
	
	public WebDriver driver;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public FileInputStream fis = null;
	public Properties config = null;
	
	public ExcelApiTest eat = null;
	
	@BeforeSuite
	public void init() throws IOException
	{
		eat = new ExcelApiTest("/Users/krishnasakinala/eclipse-workspace/hybridframeworkwithpom/src/main/java/resources/TestData.xlsx");
		
		fis = new FileInputStream("/Users/krishnasakinala/eclipse-workspace/hybridframeworkwithpom/src/main/java/resources/config.properties");
		
		config = new Properties();
		config.load(fis);
		
		if(extent == null)
		{
			htmlReporter = new ExtentHtmlReporter("./test-output/MyOwnReport.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			extent.setSystemInfo("OS", "Mac");
			extent.setSystemInfo("HostName", "Selenium User");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Author", "Selenium Tester");
			
			htmlReporter.config().setDocumentTitle("Automation Report Demo");
			htmlReporter.config().setReportName("My Own Extent Report");
			htmlReporter.config().setTheme(Theme.DARK);
		}
		
		if(driver == null)
		{
			if(config.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "/KRISHNA VOLUME/Selenium/drivers/chromedriver");
				driver = new ChromeDriver();
			}
			else
			{
				System.setProperty("webdriver.gecko.driver", "/KRISHNA VOLUME/Selenium/drivers/geckodriver");
				driver = new FirefoxDriver();
			}
		}
		driver.get(config.getProperty("url"));
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.fail("Test Failed");
			test.fail(result.getThrowable());
			String path = capture(driver, "screenshot");
			test.fail("Find screenshot below: ",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.pass("Test Passed");
			
		}
		else
		{
			test.skip("Test Skipped");
			test.skip(result.getThrowable());
		}
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException
	{
		extent.flush();
		
		if(driver != null)
		{
			Thread.sleep(5000);
			
			driver.quit();
		}
	}
	
	public static String capture(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = "/Users/krishnasakinala/eclipse-workspace/hybridframeworkwithpom/src/test/resources/ErrorScreenshots/"+ screenshotName +".png";
		File destination = new File(dest);
		FileHandler.copy(source, destination);
		return dest;
	}

}
