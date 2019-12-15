package page.obj.model.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.obj.model.DashboardPage;
import page.obj.model.LoginPage;
import util.DriverFactory;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkLoginUsingPageObjModelThenSuccess() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUserName("jdoe@company.com");

        loginPage.setPassword("Password@123");

        loginPage.clickSubmit();

        DashboardPage dashboardPage = new DashboardPage(driver);

        String conf = dashboardPage.confirmationMessage();

        assertTrue(conf.indexOf("Logged in successfully") > -1);

    }
}
