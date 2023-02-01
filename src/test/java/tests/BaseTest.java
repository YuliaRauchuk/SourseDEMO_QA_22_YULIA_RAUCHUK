package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.CheckOutPage;
import pages.InventoryItemPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ShoppingCartPage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CheckOutPage checkOutPage;
    protected InventoryItemPage inventoryItemPage;
    protected ShoppingCartPage shoppingCartPage;


    @Description("Starting a browser")
    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Incorrect browser name");
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        testContext.setAttribute("driver", driver);

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        inventoryItemPage = new InventoryItemPage(driver);

    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
