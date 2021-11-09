package com.ecommerce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.qa.base.TestBase;
import com.ecommerce.qa.pages.LoginPage;
import com.ecommerce.qa.pages.HomePage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void Test1(){
		boolean flag = loginPage.validateECommerceLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void Test2(){
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
	}

	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
