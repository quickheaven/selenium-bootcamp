package page.obj.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends Page {

    @FindBy(id = "MainContent_txtUserName")
    private WebElement txtUserName;

    @FindBy(id = "MainContent_txtPassword")
    private WebElement txtPassword;

    @FindBy(id = "MainContent_btnLogin")
    private WebElement btnLogin;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String userName) {
        txtUserName.sendKeys(userName);
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);

    }

    public void clickSubmit() {
        btnLogin.click();
    }

    public void login(String userName, String passsword) {
        setUserName(userName);
        setPassword(passsword);
        clickSubmit();
    }
}
