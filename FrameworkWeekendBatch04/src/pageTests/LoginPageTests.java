package pageTests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericActionsLibrary.Excel;
import genericActionsLibrary.Screenshot;
import pageActionsLibrary.LoginPageActions;
import testBaseLibrary.TestBase;

public class LoginPageTests extends TestBase
{
	public static final Logger log = Logger.getLogger(LoginPageTests.class.getName());
	String filepath = "./TestData/Credentials.xlsx";
	LoginPageActions loginPageActions;
	
	@BeforeMethod
	public void startTest()
	{
		testIntializer("chrome", "https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority=1)
	public void validateLoginPageTitle()
	{
		Screenshot.captureScreeshot(driver, "LoginPage");
		loginPageActions = new LoginPageActions(driver);
		String expTitle = "OrangeHRM";
		String actTitle = loginPageActions.getTitle(driver);
		log.info("Comparing the actual title: "+actTitle+ " with the expected title: "+expTitle);
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test(priority=2)
	public void loginWithValidCredentials()
	{
		loginPageActions = new LoginPageActions(driver);
		String un = Excel.readExcel(filepath, 0, 1, 0);
		String pswd = Excel.readExcel(filepath, 0, 1, 1);
		loginPageActions.login(un, pswd);
		Screenshot.captureScreeshot(driver, "HomePage");
		String expTitle = "OrangeHRM";
		String actTitle = loginPageActions.getTitle(driver);
		log.info("Comparing the actual title: "+actTitle+ " with the expected title: "+expTitle);
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test(priority=3)
	public void loginWithInvalidCredentials()
	{
		loginPageActions = new LoginPageActions(driver);
		String un = Excel.readExcel(filepath, 0, 2, 0);
		String pswd = Excel.readExcel(filepath, 0, 2, 1);
		loginPageActions.login(un, pswd);
		Screenshot.captureScreeshot(driver, "LoginErrorPage");
		String expError = "Invalid credentials";
		String actError = loginPageActions.getLoginError();
		log.info("Comparing the actual Error: "+actError+ " with the expected error: "+expError);
		Assert.assertEquals(actError, expError);
	}
	
	@AfterMethod
	public void endTest()
	{
		closeBrowser();
	}
}
