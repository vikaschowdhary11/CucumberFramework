package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[contains(text(),'Proceed to Checkout')]")
	private WebElement proceedToCheckoutBtn;
	
	public void click_ProceedToCheckout() {
		proceedToCheckoutBtn.click();
		try { Thread.sleep(5000);}
		catch (InterruptedException e) {}
	}

}
