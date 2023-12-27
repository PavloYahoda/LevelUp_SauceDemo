package pyah.saucedemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waiter(WebElement element, int duration){
        Wait<WebDriver> waiter = new WebDriverWait(driver, Duration.ofSeconds(duration));
        waiter.until(ExpectedConditions.visibilityOf(element));
    }
}
