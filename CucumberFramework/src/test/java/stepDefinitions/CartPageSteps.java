package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.CartPage;

public class CartPageSteps {
	
	TestContext testContext;
	CartPage cart;
	
	public CartPageSteps(TestContext context) {
		testContext=context;
		cart=testContext.getPageObjectManager().getCartPage();
	}
	
	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() throws Throwable {
		
		cart.click_ProceedToCheckout();
	}

}
