package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver open(String browserType) {
        WebDriver driver;
        String driverPath;
        if ("chrome".equalsIgnoreCase(browserType)) {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                driverPath = "D:\\drivers\\chromedriver.exe";
            } else {
                driverPath = "/users/drivers/chromedriver";
            }
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserType)) {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                driverPath = "D:\\drivers\\geckodriver.exe";
            } else {
                driverPath = "/users/drivers/geckodriver";
            }
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
        } else {
            throw new UnsupportedOperationException("Unsupported browser for now.");
        }
        return driver;
    }


}
