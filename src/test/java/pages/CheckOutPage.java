package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage{

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private final static By ITEM_NAME_LINK = By.cssSelector(".inventory_item_name");
    private final static By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    private final static By CHECKOUT_BUTTON = By.xpath("//button[text()='Checkout']");
    private final static By FIRST_NAME = By.cssSelector("#first-Name");
    private final static By LAST_NAME = By.cssSelector("#last-Name");
    private final static By POSTAL_CODE = By.cssSelector("#postal-code");
    private final static By CONTINUE_BUTTON = By.cssSelector("#continue");
    private final static By CHECKOUT_SUMMERY = By.cssSelector("#checkout-summary-container");
    private final static By FINISH_BUTTON = By.cssSelector("#finish");
    private final static By CHECKOUT_COMPLETE = By.cssSelector("#checkout-complete-container");
    private final static By PONY_EXPRESS_IMAGE = By.cssSelector("//img[@class='pony_express'] ");
    private final static By BACK_HOME_BUTTON = By.cssSelector(".btn btn_primary btn_small");
    private final static By ERROR_MASSAGE_CONTAINER = By.cssSelector(".error-message-container");
    private final static By CANCEL_BUTTON = By.cssSelector("#cancel");


    public void clickItemNameLink() {
        driver.findElement(ITEM_NAME_LINK).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public void clickCheckOutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void setFirstName() {
        driver.findElement(FIRST_NAME).sendKeys("abc");
    }

    public void setLastName() {
        driver.findElement(LAST_NAME).sendKeys("efj");
    }

    public void setPostalCode() {
        driver.findElement(POSTAL_CODE).sendKeys("123654");
    }

    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void setCheckoutSummery() {
        driver.findElement(CHECKOUT_SUMMERY).click();
    }

    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void clickCheckoutComplete() {
        driver.findElement(CHECKOUT_COMPLETE).click();
    }

    public void clickPonyExpressImage() {
        driver.findElement(PONY_EXPRESS_IMAGE).click();
    }

    public void clickBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public boolean isErrorMessagePresent() {
        return driver.findElement(ERROR_MASSAGE_CONTAINER).isDisplayed();
    }
}