package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.PicoTestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class PreAndPostCondition {
	
	private WebDriver driver;
	
	public PreAndPostCondition(PicoTestContext picoTestContext) {
		driver = picoTestContext.getBrowserFactory().browserInstantiate();
	}
	
	@After
	public void quitBrowser() {
		driver.quit();
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", "screenFailed");
		}
	}

}
