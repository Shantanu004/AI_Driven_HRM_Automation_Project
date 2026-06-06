package allPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(name = "username")
	private WebElement UserNameTextBox;
	
	@FindBy(name = "password")
	private WebElement PasswordTextBox;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//h5[normalize-space()='Login']")
	private WebElement LoginPageTitle;

	@FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text') or contains(.,'Invalid')]")
	private WebElement LoginErrorMessage;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	}
	
	public void waitForElementToBeVisible(org.openqa.selenium.WebElement webElement) {
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void clickLoginButton() {
		waitForElementToBeVisible(LoginButton);
		LoginButton.click();
	}
	
	public void enterUsername(String username) {
		waitForElementToBeVisible(UserNameTextBox);
		UserNameTextBox.clear();
		UserNameTextBox.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		waitForElementToBeVisible(PasswordTextBox);
		PasswordTextBox.clear();
		PasswordTextBox.sendKeys(password);
	}
	
	public void loginWithCredentials(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}
	
	public String getLoginErrorMessage() {
		try {
			waitForElementToBeVisible(LoginErrorMessage);
			return LoginErrorMessage.getText();
		} catch (Exception e) {
			// If no explicit error element found, return empty string to let assertions handle it
			return "";
		}
	}
	
	public void whenUsernameAndPasswordFieldsAreEmpty() {
		waitForElementToBeVisible(UserNameTextBox);
		UserNameTextBox.clear();
		waitForElementToBeVisible(PasswordTextBox);
		PasswordTextBox.clear();
		waitForElementToBeVisible(LoginButton);
		LoginButton.click();
	}
	
	public String VerifyLoginPageTitleIsVisible() {
		waitForElementToBeVisible(LoginPageTitle);
		return LoginPageTitle.getText();
	}
	
}
