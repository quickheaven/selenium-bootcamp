package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import util.DriverFactory;

public class CreateAccount {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.open("firefox");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.partialLinkText("CREATE ACCOUNT")).click(); // By.linkText works on the link text as you see it with your eyes on the website (after all CSS is applied)

        driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("jane doe");

        driver.findElement(By.id("MainContent_txtEmail")).sendKeys("jdoe@company.com");

        driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']")).sendKeys("Password@123");

        driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']")).sendKeys("Password@123");

        driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("Password@123");

        driver.findElement(By.id("MainContent_Female")).click();

        // dropdown
        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Germany");

        driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail")).click();

        driver.findElement(By.id("MainContent_btnSubmit")).click();

        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("Confirmation: " + conf);

        driver.close();
    }
}
