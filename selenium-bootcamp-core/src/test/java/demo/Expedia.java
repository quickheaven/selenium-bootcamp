package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

import java.util.concurrent.TimeUnit;

public class Expedia {

    private WebDriver driver;

    private String city = "New York, NY";
    private String checkIn = "10/02/2020";
    private String checkOut = "10/09/2020";

    @Before
    public void setUp() {
        driver = DriverFactory.open("chrome");
        driver.get("https://www.expedia.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void hotelReservation() {
        // 1. Search
        driver.findElement(By.id("tab-hotel-tab-hp")).click();
        driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
        driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);

        driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);

        driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);

        driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[12]/label/button")).click();

        // 2. Modify the search results page, give criteria
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[1]/main/div/div/div[1]/section/div[2]/form/fieldset[4]/div/div/div[4]")).click();

        // 3. Analyze search result and make selection
        // driver.findElement(By.xpath("")).click();

        // switch the window to the popup window recently opened.
        // List<String> windows = new ArrayList<>(driver.getWindowHandles());
        // driver.switchTo().window(windows.get(1));

        // 4. Book reservation

        // 5. Fill out contact / billing

        // 6. Get confirmation

    }
}
