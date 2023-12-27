package pyah.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"user-name\"]");
    WebElement userNameField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"password\"]");
    WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login-button\"]");
    WebElement loginButton;

    public void login(String userName, String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }


}
