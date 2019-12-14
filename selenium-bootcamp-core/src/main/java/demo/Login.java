package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class Login {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.open("chrome");

        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");

        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");

        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println("Confirmation: " + message);

        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        driver.close();
    }
}
