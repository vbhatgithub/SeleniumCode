package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	//1.declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//2. page constructor
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	//3. By Locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By RegisterLink = By.linkText("Register");
	private By ForgotPwdLink = By.linkText("Forgotten Password");
	//private By loginErrorMessage = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	private By loginErrorMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	private By registerLink = By.linkText("Register");

	//4. Page Actions
	@Step("getting login page title details....")
	public String getLoginPageTitle() {
		return eleUtil.doGetTitleWithFraction(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	@Step("getting login page url....")
	public boolean getLoginPageURL() {
		return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	@Step("forgot password link exists or not....")
	public boolean isForgotPwdLinkExist() {
		return eleUtil.doIsDisplayed(ForgotPwdLink);
	}
	
	@Step("register link exists or not....")
	public boolean isRegistertLinkExist() {
		return eleUtil.doIsDisplayed(RegisterLink);
	}
	
	@Step("do login with username:{0} and password:{1}")
	public AccountsPage doLogin(String userName,String pwd) {
		System.out.println("login with : " + userName + ": " + pwd);
		eleUtil.doSendKeys(emailId, userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
	@Step("do login with wrong username:{0} and wrong password:{1}")
	public boolean doLoginWithWrongCredentials(String userName,String pwd) {
		System.out.println("try to login with wrong credentials: " + userName + ": " + pwd);
		eleUtil.doSendKeys(emailId, userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		String errorMessage = eleUtil.doGetText(loginErrorMessage);
		System.out.println(errorMessage);
		if(errorMessage.contains(Constants.LOGIN_ERROR_MESSAGE)) {
			System.out.println("Login is not successful");
			return false;
		}
		return true;
	}
	
	public RegistrationPage goToRegisterPage() {
		 eleUtil.doClick(registerLink);
		 return new RegistrationPage(driver);
	}
}
