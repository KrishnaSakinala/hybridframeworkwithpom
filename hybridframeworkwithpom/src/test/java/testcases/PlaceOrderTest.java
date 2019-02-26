package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import hybridframeworkwithpom.basetest.BaseTest;
import hybridframeworkwithpom.pages.BasketPage;
import hybridframeworkwithpom.pages.CheckoutPage;
import hybridframeworkwithpom.pages.HomePage;
import hybridframeworkwithpom.pages.ProductDisplayPage;
import hybridframeworkwithpom.pages.SearchResultsPage;
import repo.DataUtil;

public class PlaceOrderTest extends BaseTest {

	@Test
	public void placeOrderByCOD() {
		test = extent.createTest("placeOrderByCOD");

		if (DataUtil.isTestExecutable(eat, "TestCases", "placeOrderByCOD")) {

			HomePage homePage = new HomePage(driver,test);
			SearchResultsPage searchResultsPage = homePage.searchBook();
			Assert.assertTrue(homePage.getTitle().contains("selenium"));
			ProductDisplayPage productDisplayPage = searchResultsPage.clickSearchedBook();
			BasketPage basketPage = productDisplayPage.navigateToBasketPage();
			CheckoutPage checkoutPage = basketPage.proceedToCheckout();
			checkoutPage.placeOrderByCOD();
		}
		else
		{
			throw new SkipException("Skipping this test case as the run mode is N.");
		}
	}

	@Test
	public void placeOrderByNB() {
		test = extent.createTest("placeOrderByNB");
		
		if (DataUtil.isTestExecutable(eat, "TestCases", "placeOrderByNB")) {

			HomePage homePage = new HomePage(driver,test);
			SearchResultsPage searchResultsPage = homePage.searchBook();
			ProductDisplayPage productDisplayPage = searchResultsPage.clickSearchedBook();
			BasketPage basketPage = productDisplayPage.navigateToBasketPage();
			CheckoutPage checkoutPage = basketPage.proceedToCheckout();
			checkoutPage.placeOrderByNB();
		}
		else
		{
			throw new SkipException("Skipping this test case as the run mode is N.");
		}
	}

}
