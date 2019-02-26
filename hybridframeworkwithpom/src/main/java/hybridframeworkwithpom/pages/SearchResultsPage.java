package hybridframeworkwithpom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class SearchResultsPage extends BasePage{
	
	public SearchResultsPage(WebDriver driver, ExtentTest test) {
		super(driver,test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title = 'Selenium Ruby']")
	private WebElement searchResultsBookTitle;
	
	public ProductDisplayPage clickSearchedBook()
	{
		searchResultsBookTitle.click();
		
		ProductDisplayPage productDisplayPage = new ProductDisplayPage(driver,test);
		
		return productDisplayPage;
		
	}

}
