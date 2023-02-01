package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final static By USER_NAME_LOCATOR = By.cssSelector("#user-name");
    private By passwordInput = By.cssSelector("#password");
    private By loginButton = By.cssSelector("#login-button");
    private By errorMessageContainer = By.cssSelector(".error-message-container");
    private By BOT_COLUMN = By.cssSelector(".bot_column");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void setUsername(String username) {
        driver.findElement(USER_NAME_LOCATOR).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessageContainer).getText();
    }

    public boolean isErrorMessagePresent () {
        return driver.findElement(errorMessageContainer).isDisplayed();
    }

    public boolean isBotColumnPresent () {
        return driver.findElement(BOT_COLUMN).isDisplayed();
    }


}