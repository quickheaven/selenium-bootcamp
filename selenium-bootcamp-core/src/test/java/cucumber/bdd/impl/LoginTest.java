package cucumber.bdd.impl;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.obj.model.DashboardPage;
import page.obj.model.LoginPage;
import util.DriverFactory;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page() {
        driver = DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }

    @When("^user enters correct username and correct password$")
    public void user_enters_correct_username_and_correct_password() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUserName("jdoe@company.com");

        loginPage.setPassword("Password@123");

        loginPage.clickSubmit();
    }

    @When("^user enters email (.*)$")
    public void user_enters_username(String username) {
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
    }

    @And("^user enters password (.*)$")
    public void user_enters_password(String password) {
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
    }

    @And("user clicks login button")
    public void user_clicks_login_button() {
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
    }

    @Then("^user gets confirmation$")
    public void user_gets_confirmation() {
        DashboardPage dashboardPage = new DashboardPage(driver);

        String conf = dashboardPage.confirmationMessage();

        assertTrue(conf.indexOf("Logged in successfully") > -1);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
