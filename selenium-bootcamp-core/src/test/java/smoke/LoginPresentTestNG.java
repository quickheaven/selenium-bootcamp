package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.DriverFactory;

import static org.testng.Assert.assertTrue;

public class LoginPresentTestNG {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.open("chrome");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void loginElementsPresentTest() {
        String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
        driver.get(webUrl);

        boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
        boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();

        assertTrue(loginEmailBox);
        assertTrue(passwordBox);
    }
}
