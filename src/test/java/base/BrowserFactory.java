package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public WebDriver driver;
	public int browserType = 1; // 1 - chrome, 2 - Edge, 3 - FF
	
	public WebDriver browserInstantiate() {
		if(driver == null) {
			switch (browserType) {
			case 1:
				System.out.println("User option is "+browserType+",So invoking chrome browser");
				driver = new ChromeDriver();
				break;
			case 2:
				System.out.println("User option is "+browserType+",So invoking edge browser");
				driver = new EdgeDriver();
				break;
			case 3:
				System.out.println("User option is "+browserType+",So invoking firefox browser");
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("User option is wrong "+browserType+",So invoking the default chrome browser");
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
		return driver;
	}

}
