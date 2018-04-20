package pageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.Wait;
import testDataTypes.Customer;

public class CheckoutPage {

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(name="billing_first_name")
	private WebElement firstNameTbx;
	
	@FindBy(name="billing_last_name")
	private WebElement lastNameTbx;
	
	@FindBy(name="billing_email")
	private WebElement emailTbx;

	@FindBy(name="billing_phone")
	private WebElement phoneTbx;
	
	@FindBy(css="#billing_country_field .select2-arrow")
	private WebElement countryArrowBtn;
	
	@FindBy(xpath=".//*[@class='select2-result-label']")
	private List<WebElement> countryLists;
	
	@FindBy(name="billing_address_1")
	private WebElement addressTbx;

	@FindBy(name="billing_city")
	private WebElement cityTbx;
	
	@FindBy(name="billing_state")
	private WebElement stateTbx;
	
	@FindBy(css="#billing_postcode")
	private WebElement pincodeTbx;
	
	@FindBy(name="ship_to_different_address")
	private WebElement shipToDiffAddressCheckbx;
	
	@FindBy(name="terms")
	private WebElement termsAgreementTbx;
	
	@FindBy(id="place_order")
	private WebElement placeOrderBtn;
	
	
	public void enter_FirstName(String name) {
		firstNameTbx.sendKeys(name);
	}
	
	public void enter_LastName(String last) {
		lastNameTbx.sendKeys(last);
	}
	
	public void enter_Email(String email) {
		emailTbx.sendKeys(email);
	}
	
	public void enter_Phone(String phone) {
		phoneTbx.sendKeys(phone);
	}
	
	public void enter_City(String city) {
		cityTbx.sendKeys(city);
	}
	
	public void enter_Address(String address) {
		addressTbx.sendKeys(address);
	}
	
	public void enter_PostCode(String postcode) {
		pincodeTbx.sendKeys(postcode);
	}
	
	public void enter_State(String state) {
		stateTbx.sendKeys(state);
	}
	
	public void check_ShipToDifferentAddress(boolean value) {
		if(!value)
			shipToDiffAddressCheckbx.click();
		
		Wait.untilJqueryIsDone(driver);
	}
	
	public void select_Country(String countryName) {
		
		countryArrowBtn.click();
		for(WebElement country:countryLists) {
			if(country.getText().equalsIgnoreCase(countryName)) {
				country.click();
				Wait.untilJqueryIsDone(driver);
				break;
			}
		}				
	}
	
	public void check_TermsAndCondition(boolean value) {
		if(value)
			termsAgreementTbx.click();
	}
	
	public void click_OnPlaceOrder() {
		placeOrderBtn.click();
		Wait.untilPageLoadComplete(driver);
	}
	
	public void fill_PersonalDetails(Customer customer) {
		enter_FirstName(customer.firstName);
		enter_LastName(customer.lastName);
		enter_Phone(customer.phoneNumber.mob);
		enter_Email(customer.emailAddress);
		select_Country(customer.address.country);
		enter_City(customer.address.city);
		enter_State(customer.address.state);
		enter_Address(customer.address.streetAddress);
		enter_PostCode(customer.address.postCode);
	}
}
