package com.bsouza.lightcms.selenium;

public class ChromeDriver extends org.openqa.selenium.chrome.ChromeDriver {

	public ChromeDriver() {
		System.setProperty("webdriver.chrome.driver", this.getClass().getResource("/chromedriver.exe").getFile());
	}
	
}