package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private final static By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    private final static By ITEM_PRICE_TEXT = By.cssSelector(".inventory_item_price");
    private final static By ITEM_DESCRIPTION_DESC = By.cssSelector(".inventory_item_desc");
    private final static By ITEM_NAME_LINK = By.cssSelector(".inventory_item_name");
    private final static By ITEM_NAME = By.cssSelector(".inventory_item_name");
    private final static By MENU_BUTTON = By.cssSelector("#react-burger-menu-btn");
    private final static By LOGOUT_BUTTON = By.cssSelector("#logout_sidebar_link");
    private final static By SORTING_SORT_CONTAINER = By.cssSelector(".product_sort_container");
    private final static By REMOVE_BUTTON = By.cssSelector(".btn btn_secondary btn_small cart_button");


    private By getItemContainerByName(String itemName) {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }

    public ProductPage(WebDriver driver) {super(driver);}

    public boolean isShoppingCartButtonPresent() {
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }


    public String getItemName(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME).getText();
    }

    public String getItemPrice(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE_TEXT).getText();
    }

    public String getItemDescription(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION_DESC).getText();
    }

    public void clickItemNameLink(String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME_LINK).click();
    }

    public void clickShoppingCartButton() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }

    public void clickAddToCartButton(String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    public void clickMenuButton() {
        driver.findElement(MENU_BUTTON).click();
    }

    public void setSortingSortContainer() {
        driver.findElement(SORTING_SORT_CONTAINER).click();
    }

    public void clickRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

}

