
package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.IRetryAnalyzer;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProductPageTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Positive Product Test", groups = {"Smoke"})
    public void positiveProductTest() {
        String testItemName = "Sauce Labs Onesie";
        String expectedItemPrice = "$7.99";
        String expectedItemDescription = "Rib snap infant onesie for the junior automation engineer in development. + Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();


        Assert.assertEquals(productPage.getItemPrice(testItemName), expectedItemPrice);

    }

    @DataProvider
    public Object[][] productTest() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},

                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},

                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},

                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},

                {"Sauce Labs Onesie", "$7.99", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},

                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."},

        };
    }

    @Test(dataProvider = "productTest", description = "Product Data Test", groups = {"Smoke"})
    public void productTest(String itemName, String itemPrice, String itemDescription) {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertEquals(productPage.getItemName(itemName), itemName);
        Assert.assertEquals(productPage.getItemPrice(itemName), itemPrice);
        Assert.assertEquals(productPage.getItemDescription(itemName), itemDescription);

    }
}

