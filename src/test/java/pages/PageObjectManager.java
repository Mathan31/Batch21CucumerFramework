package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	private WebDriver driver;
	private AmazonHomePage amazonHome;
	private EbayHomePage ebayHome;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public EbayHomePage getEbayPageObject() {
		if(ebayHome == null) {
			ebayHome = new EbayHomePage(driver);
		}else {
			return ebayHome;
		}
		return ebayHome;
	}
	
	public AmazonHomePage getAmazonPageObject() {
		if(amazonHome == null) {
			amazonHome = new AmazonHomePage(driver);
		}else {
			return amazonHome;
		}
		return amazonHome;
	}

}
