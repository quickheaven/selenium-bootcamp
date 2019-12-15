package smoke;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageTitleJUnitTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.open("chrome");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void checkExpectedPageTitleThenSuccess() {
        String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
        driver.get(webUrl);

        String actualTitle = driver.getTitle();
        String expectedTitle = "SDET Training | Account Management";
        assertEquals(expectedTitle, actualTitle);
    }
}
