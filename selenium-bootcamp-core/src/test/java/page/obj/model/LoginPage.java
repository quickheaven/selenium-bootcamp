package page.obj.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUserName(String userName) {
        getDriver().findElement(By.id("MainContent_txtUserName")).sendKeys(userName);
    }

    public void setPassword(String password) {
        getDriver().findElement(By.id("MainContent_txtPassword")).sendKeys(password);

    }

    public void clickSubmit() {
        getDriver().findElement(By.id("MainContent_btnLogin")).click();
    }
}
