package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{
	
	@BeforeClass
	public void setupRegistrationpage() {
		registrationPage = loginPage.goToRegisterPage();
	}
	
	public String getRandomEmail() {
		Random randomGenerator  = new Random();
		String email = "SeptAutomation" + randomGenerator.nextInt(1000) + "@gmail.com";
		return email;
	}
	
	@DataProvider
	public Object[][] getRegistrationData(){
		return ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
	}
	
	@Test(dataProvider = "getRegistrationData")
	public void userRegistartionTest(String firstName,String lastName,String telephone,String password,String subscribe) {
		Assert.assertTrue(registrationPage.accountRegistration(firstName, lastName, getRandomEmail(), telephone, password, subscribe));
	}

}
