package hybridframeworkwithpom.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	// variables i.e. web elements
	@FindBy(id = "s") 
	private WebElement searchTextbox;
	
	//WebElement searchTextbox1 = driver.findElement(By.id("s"));
	
	// methods i.e. user actions.
	public SearchResultsPage searchBook()
	{
		searchTextbox.sendKeys("selenium");
		test.info("Entering selenium book as search term.");
		searchTextbox.sendKeys(Keys.ENTER);
		test.info("Hit Enter button to search the selenium book.");
		
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver,test);
		return searchResultsPage;
		
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
}
