package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.DriverFactory;

public class NewAccount {

    public static void main(String[] args) {
        String name = "jane doe";
        String email = "jdoe@company.com";
        String password = "Password@123";
        String phoneNumber = "+1-416-1234";
        String country = "Germany";
        String browserType = "chrome";
        String gender = "Female";
        boolean weeklyEmail = true;
        boolean monthlyEmail = false;
        boolean occassionalEmail = false;

        WebDriver driver = DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        driver.findElement(By.partialLinkText("CREATE ACCOUNT")).click();

        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phoneElement = driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
        WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
        WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
        WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail"));
        WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));

        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phoneNumber);
        passwordElement.sendKeys(password);
        verifyPasswordElement.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);

        if (gender.equalsIgnoreCase("male")) {
            maleRadio.click();
        } else {
            femaleRadio.click();
        }

        if (weeklyEmail) {
            if (!weeklyCheckbox.isSelected()) {
                weeklyCheckbox.click();
            }
        } else {
            if (weeklyCheckbox.isSelected()) {
                weeklyCheckbox.click();
            }
        }

        submitButton.click();

        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        String expected = "Customer information added successfully";
        if (conf.equalsIgnoreCase(expected)) {
            System.out.println("Confirmation: " + conf);
        } else {
            System.out.println("Test failed.");
        }

        driver.close();
    }
}
