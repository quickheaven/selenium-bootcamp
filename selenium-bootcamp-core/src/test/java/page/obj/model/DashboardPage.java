package page.obj.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends Page {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String confirmationMessage() {
        return getDriver().findElement(By.id("conf_message")).getText();
    }

    public void changePassword() {
        getDriver().findElement(By.linkText("Change password")).click();
    }


}
