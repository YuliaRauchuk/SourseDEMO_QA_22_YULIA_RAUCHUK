package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ShoppingCartTest extends BaseTest {

    @Test(description = "Positive Shopping Cart Test", groups = {"Smoke"})
    public void positiveShoppingCartTest() {
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productPage.clickAddToCartButton(testItemName);
        productPage.clickShoppingCartButton();

        Assert.assertEquals(shoppingCartPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(shoppingCartPage.getItemDescription(testItemName), expectedItemDescription);
    }

    @Test(description = "Remove Test", groups = {"Smoke"})
    public void removeTest() {
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productPage.clickAddToCartButton(testItemName);
        productPage.clickShoppingCartButton();

        shoppingCartPage.clickRemoveButton();
        Assert.assertFalse(shoppingCartPage.addedItemIsPresent());
    }

}
