package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigFileReader;
import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType enviornmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String IE_DRIVER_PROPERTY="webdriver.ie.driver";
	 
	public WebDriverManager() {
		driverType=FileReaderManager.getInstance().getConfigReader().getBrowser();
		enviornmentType=FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}
	
	public WebDriver getDriver() {
		if(driver==null)
			driver=createDriver();
		return driver;
	}
	
	private WebDriver createDriver() {
		switch(enviornmentType) {
		case LOCAL:
			driver=createLocalDriver();
			break;
		case REMOTE:
			driver=createRemoteDriver();
			break;
		}
		return driver;
	}
	
	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private WebDriver createLocalDriver() {
		ConfigFileReader config=FileReaderManager.getInstance().getConfigReader();
		switch(driverType) {
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, config.getDriverPath());
			driver=new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty(FIREFOX_DRIVER_PROPERTY, config.getDriverPath());
			driver=new FirefoxDriver();
			break;
		case INTERNETEXPLORER:
			System.setProperty(IE_DRIVER_PROPERTY, config.getDriverPath());
			driver=new InternetExplorerDriver();
			break;
		}
		
		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}
	
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
