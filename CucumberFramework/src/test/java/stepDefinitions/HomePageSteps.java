package stepDefinitions;

import org.openqa.selenium.Keys;
import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps {

	TestContext testContext;
	HomePage home;
	
	public HomePageSteps(TestContext context) {
		testContext=context;
		home=testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		home.navigate_ToHomePage();
	}
	
	
	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for_dress(String searchText) throws Throwable {
		home.click_Search();
		home.enter_SearchText(searchText+Keys.ENTER);
	}
}
