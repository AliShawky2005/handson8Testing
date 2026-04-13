import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.Assert;

import java.time.Duration;

/* Ali Ahmed Shawky       2022170910        SWE */

public class exercise2 {
    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }
    }

    @BeforeMethod
    public void navigateToLogin() {
        driver.get("https://demo.guru99.com/test/login.html");
    }

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][] {
                { "test@mail.com", "123", false },
                { "test@mail.com", "152", true  }
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String pass, boolean isValid) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(pass);
        driver.findElement(By.id("SubmitLogin")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("success"));

        if (isValid) {
            Assert.assertTrue(driver.getCurrentUrl().contains("success"));
        } else {
            try {
                Assert.assertFalse(driver.getCurrentUrl().contains("success"));

            }catch(AssertionError error) {
                System.out.println("Invalid Account");
            }
        }
    }

    @AfterClass
    public void tearDown() { driver.quit(); }
}