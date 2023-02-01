package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Positive Login Test", groups = {"Smoke"})
    public void positiveLoginTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productPage.isShoppingCartButtonPresent());
    }

    @Test(description = "Negative Login Test", groups = {"Regression"})
    public void negativeLoginTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("nbvcx123");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }

    @Test(description = "Logout Test", groups = {"Smoke"})
    public void logoutTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productPage.clickMenuButton();
        productPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isBotColumnPresent());
    }
}
