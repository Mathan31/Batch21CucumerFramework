package base;

import pages.PageObjectManager;

public class PicoTestContext {
	
	private BrowserFactory browserFactory;
	private PageObjectManager pageObjectManager;
	
	public PicoTestContext() {
		browserFactory = new BrowserFactory();
		pageObjectManager = new PageObjectManager(browserFactory.browserInstantiate());
	}

	public BrowserFactory getBrowserFactory() {
		return browserFactory;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}
