
package com.ecommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.qa.base.TestBase;

public class LoginPage extends TestBase{

	//page Factory - Object Repository
	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@type='password' and @name='pwd']")
	WebElement passWord;

	@FindBy(xpath = "//a[@id='loginButton']")
	WebElement loginButton;
	
	@FindBy(xpath = "//input[@name='remember']")
	WebElement keepmeLoggedinCheckBox;

	@FindBy(xpath = "//a[@id='toPasswordRecoveryPageLink']")
	WebElement forgetYourPasswordLink;

	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement actiTimeLogo;

	//initialization
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//action methods
	public Boolean validateECommerceLogo(){
		return actiTimeLogo.isDisplayed();
	}

	public HomePage loging(String uName, String pword){
		userName.sendKeys(uName);
		passWord.sendKeys(pword);
		loginButton.click();
		return new HomePage();
	}


}