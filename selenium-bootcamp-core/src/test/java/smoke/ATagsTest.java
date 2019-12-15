package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.DriverFactory;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ATagsTest {

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
    public void checkPresenceOfAnchorTagsThenSuccess() {
        String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
        driver.get(webUrl);

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        assertTrue(elements.stream().filter(e -> e.getText().equalsIgnoreCase("CREATE ACCOUNT")).findFirst().isPresent());
    }
}
