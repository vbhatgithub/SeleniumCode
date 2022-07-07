package com.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactoryStatic {
	
	public static WebDriver driver;
	
	public  void setDriver() {
		WebDriverManager.chromedriver().reset();
		driver = new ChromeDriver();
	}

}
