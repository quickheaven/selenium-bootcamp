package demo;

public class WebDriverManager {

    public static void chromeDriverSetup() {
        String chromeDriverPath;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            chromeDriverPath = "D:\\drivers\\chromedriver.exe";
        } else {
            chromeDriverPath = "/users/drivers/chromedriver";
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }

}
