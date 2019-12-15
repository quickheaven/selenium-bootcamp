package page.obj.model.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.obj.model.LoginPageFactory;
import util.DriverFactory;

public class LoginFactoryTest {

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
    public void checkLoginUsingPageObjModelFactoryThenSuccess() {

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);

        loginPageFactory.login("jdoe@company.com", "Password@123");

    }
}
