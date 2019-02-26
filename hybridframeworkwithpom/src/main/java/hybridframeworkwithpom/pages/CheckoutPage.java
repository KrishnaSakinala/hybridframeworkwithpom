package hybridframeworkwithpom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver, ExtentTest test) {
		super(driver,test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"billing_first_name\"]")
    private WebElement firstNameTextbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"billing_last_name\"]")
    private WebElement lastNameTextbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"billing_email\"]")
    private WebElement eMailTextbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"billing_phone\"]")
    private WebElement phoneTextbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"select2-chosen-1\"]")
    private WebElement countryDropdown;

    @FindBy(how = How.XPATH, using = "//*[@id=\"billing_address_1\"]")
    private WebElement addressTextbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"billing_city\"]")
    private WebElement cityTextbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"select2-chosen-2\"]")
    private WebElement stateDropdown;

    @FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen2_search\"]")
    private WebElement stateSearchTextbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"billing_postcode\"]")
    private WebElement zipcodeTextbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"payment_method_cod\"]")
    private WebElement cashOnDeliveryRadioButton;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"payment_method_bacs\"]")
    private WebElement netBankingRadioButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"place_order\"]")
    private WebElement placeOrderButton;
    
    public void placeOrderByCOD()
    {
    	firstNameTextbox.sendKeys("firstName");
    	lastNameTextbox.sendKeys("lastName");
    	eMailTextbox.sendKeys("email@gmail.com");
    	addressTextbox.sendKeys("Address");
    	cityTextbox.sendKeys("City");
    	zipcodeTextbox.sendKeys("12345");
    	cashOnDeliveryRadioButton.click();
    	placeOrderButton.click();
    }
    
    public void placeOrderByNB()
    {
    	firstNameTextbox.sendKeys("firstName");
    	lastNameTextbox.sendKeys("lastName");
    	eMailTextbox.sendKeys("email@gmail.com");
    	addressTextbox.sendKeys("Address");
    	cityTextbox.sendKeys("City");
    	zipcodeTextbox.sendKeys("12345");
    	cashOnDeliveryRadioButton.click();
    	netBankingRadioButton.click();
    }
	
}
