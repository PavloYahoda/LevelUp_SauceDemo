package pyah.saucedemo;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SwabLabsPage extends BasePage{

    public SwabLabsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='app_logo']")
    WebElement logo;

    public boolean isLoggedIn(){
        try{
            return logo.isDisplayed();
        } catch (NoSuchElementException exception){
            return false;
        }
    }
}
