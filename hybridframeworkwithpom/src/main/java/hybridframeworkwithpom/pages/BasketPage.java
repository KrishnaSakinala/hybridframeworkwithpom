package hybridframeworkwithpom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class BasketPage extends BasePage{

	public BasketPage(WebDriver driver, ExtentTest test) {
		super(driver,test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "coupon_code")
	private WebElement couponCodeTextbox;
	
	@FindBy(name = "apply_coupon")
	private WebElement applyCouponButton;
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")
	private WebElement proceedToCheckoutButton;
	
	
	
	public CheckoutPage proceedToCheckout()
	{
		couponCodeTextbox.sendKeys("krishnasakinala");
		applyCouponButton.click();
		proceedToCheckoutButton.click();
		
		CheckoutPage checkoutPage = new CheckoutPage(driver,test);
		return checkoutPage;
		
	}
}
