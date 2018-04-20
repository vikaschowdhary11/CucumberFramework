package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {
		
	public ProductListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".noo-product-inner")
	private List<WebElement> productList;
	
	@FindBy(xpath=".//*[@class='single_add_to_cart_button button alt']")
	private WebElement addToCardBtn;
	
	@FindBy(className="icon_bag_alt")
	private WebElement cartBagIcon;
	
	public void select_Product() {
		productList.get(0).click();
	}
	
	public void click_OnAddToCart(){
		addToCardBtn.click();
		try { Thread.sleep(5000);}
		catch (InterruptedException e) {}
		cartBagIcon.click();
	}
	
	public String getProductName(int index) {
		return productList.get(index).getText();
	}
}
