package Hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TutorialsNinjaHook {

    public static WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo");
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}