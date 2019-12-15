package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.DriverFactory;
import util.Excel;

import static org.testng.Assert.assertEquals;

public class LoginDDT {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.open("chrome");
        String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
        driver.get(webUrl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() {
        return Excel.get("src/test/resources/UserLogin.xls");
    }

    @Test(dataProvider = "getData")
    public void loginTest(String name, String email, String password) {

        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);

        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);

        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

        String actual = driver.findElement(By.id("conf_message")).getText();
        String expected = "Logged in successfully";

        assertEquals(expected, actual);
    }
}
