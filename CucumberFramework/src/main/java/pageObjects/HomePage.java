package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath=".//*[@class='noo-search icon_search']")
	private WebElement searchIcon;
	
	@FindBy(name="s")
	private WebElement searchTbx;
	
	public void click_Search() {
		searchIcon.click();
	}
		
	public void enter_SearchText(String search) {
		searchTbx.sendKeys(search);
	}
	
	public void navigate_ToHomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

}
