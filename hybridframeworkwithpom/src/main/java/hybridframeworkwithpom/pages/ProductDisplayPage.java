package hybridframeworkwithpom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class ProductDisplayPage extends BasePage{
	
	public ProductDisplayPage(WebDriver driver, ExtentTest test) {
		super(driver,test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"product-160\"]/div[2]/form/button")
	private WebElement addToBasketButton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/a")
	private WebElement viewBasketButton;
	
	public BasketPage navigateToBasketPage()
	{
		addToBasketButton.click();
		viewBasketButton.click();
		
		BasketPage basketPage = new BasketPage(driver,test);
		return basketPage;
	}

}
