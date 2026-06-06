package allTestCasesOfPageWise;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
// ...existing imports...
import org.testng.annotations.Test;

import allPages.LoginPage;
import allPages.DashboardPage;
import base.BaseClass;

public class TestCasesOfLoginPage extends BaseClass {

	public WebDriver driver;

	LoginPage loginpage;

	@BeforeMethod
	public void SetUp() {
		loadPropertiesFileOfWebAPPS();
		driver = intilizeBrowserAndOpenApplicationURL(PropForBaseInfo.getProperty("browserName")); // Multiple Browser Setup to Parallel Test Case Execution in different browser
		driver.get(PropForBaseInfo.getProperty("url"));
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
	}

	@AfterMethod
	public void TearDown() {
		quitBrowser();
	}

	@Test(priority = 0)
	public void VerifyWhenUsernameAndPasswordFieldsAreEmpty() {
		loginpage.whenUsernameAndPasswordFieldsAreEmpty();
		Assert.assertEquals(loginpage.VerifyLoginPageTitleIsVisible(),
				PropForDataInfo.getProperty("ExpectedTitleOfLoginPage"), "Login Page Title is not visible");
	}

	@Test(priority = 1)
	public void VerifyLoginWithValidCredentials() {
		// Use page object login helper and assert dashboard title via DashboardPage
		loginpage.loginWithCredentials(PropForDataInfo.getProperty("ValidUsername"),
				PropForDataInfo.getProperty("ValidPassword"));
		DashboardPage dashboard = new DashboardPage(driver);
		Assert.assertEquals(dashboard.getDashboardTitleText(), PropForDataInfo.getProperty("ExpectedTitleOfDashboard"),
				"Dashboard title is not visible or does not match");
	}

	@Test(priority = 2)
	public void VerifyLoginWithInvalidUsername() {
		loginpage.loginWithCredentials(PropForDataInfo.getProperty("InvalidUsername"),
				PropForDataInfo.getProperty("ValidPassword"));
		String err = loginpage.getLoginErrorMessage();
		Assert.assertTrue(!err.isEmpty() || err.toLowerCase().contains("invalid"),
				"Expected an error message for invalid username");
	}

	@Test(priority = 3)
	public void VerifyLoginWithInvalidPassword() {
		loginpage.loginWithCredentials(PropForDataInfo.getProperty("ValidUsername"),
				PropForDataInfo.getProperty("InvalidPassword"));
		String err = loginpage.getLoginErrorMessage();
		Assert.assertTrue(!err.isEmpty() || err.toLowerCase().contains("invalid"),
				"Expected an error message for invalid password");
	}

	@Test(priority = 4)
	public void VerifyLoginWithBothInvalidCredentials() {
		loginpage.loginWithCredentials(PropForDataInfo.getProperty("InvalidUsername"),
				PropForDataInfo.getProperty("InvalidPassword"));
		String err = loginpage.getLoginErrorMessage();
		Assert.assertTrue(!err.isEmpty() || err.toLowerCase().contains("invalid"),
				"Expected an error message for invalid credentials");
	}

}
