package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckoutPageSteps {
	
	TestContext testContext;
	CheckoutPage checkOut;
	
	public  CheckoutPageSteps(TestContext context) {
		testContext=context;
		checkOut=testContext.getPageObjectManager().getCheckoutPage();
	}
	
	@When("^enter \"([^\"]*)\"personal details on checkout page$")
	public void enter_personal_details_on_checkout_page(String customerName) throws Throwable {
		Customer customer=FileReaderManager.getInstance().getJsonDataReader().getCustomerByName(customerName);
		checkOut.fill_PersonalDetails(customer);
	}

	@When("^select same delivery address$")
	public void select_same_delivery_address() throws Throwable {
		
		checkOut.check_ShipToDifferentAddress(false);
	}

	@When("^select payment method as “check” payment$")
	public void select_payment_method_as_check_payment() throws Throwable {
	}

	@When("^place the order$")
	public void place_the_order() throws Throwable {
		try {
			Thread.sleep(5000);
		} catch ( Exception e) {
		}
		checkOut.check_TermsAndCondition(true);
		checkOut.click_OnPlaceOrder();
	}


}
