package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100:Design Open Cart App - Login Page")
@Story("US 101: Open Cart Login Design with multiple features")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest{
	
	@Description("login page Title tests")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		System.out.println("page title is: " + actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("login page URL tests")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void loginPageURLTest() {
		Assert.assertTrue(loginPage.getLoginPageURL());
	}
	
	@Description("forgot password link tests")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Description("Register link tests")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4, enabled = false)
	public void registerLinkTest() {
		Assert.assertTrue(loginPage.isRegistertLinkExist());
	}
	
	@Description("login test with correct credentials")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=5)
	public void loginTest() {
		accountsPage=loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		Assert.assertEquals(accountsPage.getAccountPageTitle(), Constants.ACCOUNTS_PAGE_TITLE);
	}

}
