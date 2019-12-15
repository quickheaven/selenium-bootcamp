package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.Csv;
import util.DriverFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {

    private WebDriver driver;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String password;
    private String country;
    private boolean weeklyEmail;
    private boolean monthlyEmail;
    private boolean occassionalEmail;

    public NewAccountDDT(
            String name,
            String email,
            String phone,
            String gender,
            String password,
            String country,
            String weeklyEmail,
            String monthlyEmail,
            String occassionalEmail
    ) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.country = country;
        this.weeklyEmail = convertStringToBoolean(weeklyEmail);
        this.monthlyEmail = convertStringToBoolean(monthlyEmail);
        this.occassionalEmail = convertStringToBoolean(occassionalEmail);
    }

    private static boolean convertStringToBoolean(String s) {
        return "true".equalsIgnoreCase(s);
    }

    @Parameters
    public static List<String[]> getData() {
        return Csv.get("src/test/resources/UserAccounts.csv");
    }

    @Before
    public void setUp() {
        driver = DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.partialLinkText("CREATE ACCOUNT")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void newAccountTest() {

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
        phoneElement.sendKeys(phone);
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

        String actual = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        String expected = "Customer information added successfully";

        assertEquals(expected, actual);

    }

}
