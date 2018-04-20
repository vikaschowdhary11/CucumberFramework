package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.ProductListingPage;

public class ProductPageSteps {
	TestContext testContext;
	ProductListingPage product;
	
	public ProductPageSteps(TestContext context) {
		testContext=context;
		product=testContext.getPageObjectManager().getProductListingPage();
	}
	

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws Throwable {
		String productName=product.getProductName(0);
		testContext.getScenarioContext().setContext(Context.PRODUCT_NAME, productName);
		product.select_Product();
		product.click_OnAddToCart();
	}


}
