package allPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	WebDriver driver;
	WebDriverWait wait;

	// Dashboard title - matches pattern used in LoginPage
	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	private WebElement DashboardTitle;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	}

	public void waitForElementToBeVisible(org.openqa.selenium.WebElement webElement) {
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public String getDashboardTitleText() {
		try {
			waitForElementToBeVisible(DashboardTitle);
			return DashboardTitle.getText();
		} catch (Exception e) {
			return "";
		}
	}

	public boolean isDashboardTitleVisible() {
		try {
			waitForElementToBeVisible(DashboardTitle);
			return DashboardTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
