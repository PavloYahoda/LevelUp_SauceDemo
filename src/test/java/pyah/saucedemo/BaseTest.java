package pyah.saucedemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)


public class BaseTest{
    public static final String URL = "https://www.saucedemo.com/";
    public WebDriver driver = new ChromeDriver();;

    @BeforeAll
    public void setup(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @BeforeEach
    public void start(){
        driver.get(URL);
    }

    @AfterAll
    public void shutDown(){
        driver.close();
        driver.quit();
    }
}
