package pageActionsLibrary;

import org.openqa.selenium.WebDriver;

import pageObjectsLibrary.LoginPageObjects;

public class LoginPageActions extends LoginPageObjects
{
	public LoginPageActions(WebDriver driver) 
	{
		super(driver);
	}

	public void login(String un, String pswd)
	{
		txtUsername.sendKeys(un);
		txtPassword.sendKeys(pswd);
		btnLogin.click();
	}
	
	public String getLoginError()
	{
		return msgErroLogin.getText();
	}
	
	public String getTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
}
