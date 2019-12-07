package demo;

import java.nio.file.Paths;

public class WebDriverManager {

    public static void chromeDriverSetup() {
        //String chromeDriverPath = Paths.get("/drivers/chromedriver").toAbsolutePath().toString();
        String chromeDriverPath = "D:\\x-20a\\repos-github\\selenium-bootcamp\\selenium-bootcamp-core\\src\\main\\resources\\drivers\\chromedriver";
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            chromeDriverPath += ".exe";
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }

}
